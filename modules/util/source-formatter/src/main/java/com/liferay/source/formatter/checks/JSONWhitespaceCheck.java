/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.source.formatter.checks;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncStringReader;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.tools.ToolsUtil;

import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hugo Huijser
 */
public class JSONWhitespaceCheck extends WhitespaceCheck {

	@Override
	protected String doProcess(
			String fileName, String absolutePath, String content)
		throws IOException {

		StringBundler sb = new StringBundler();

		try (UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new UnsyncStringReader(content))) {

			String line = null;

			while ((line = unsyncBufferedReader.readLine()) != null) {
				if (Validator.isNull(line)) {
					continue;
				}

				while (true) {
					Matcher matcher = _leadingSpacesPattern.matcher(line);

					if (!matcher.find()) {
						break;
					}

					line = matcher.replaceAll("$1\t$3");
				}

				if (line.startsWith(" \t")) {
					line = line.replaceFirst(" \t", "\t");
				}

				sb.append(line);

				sb.append("\n");
			}
		}

		if (isAllowTrailingEmptyLines(fileName, absolutePath) &&
			content.endsWith("\n")) {

			content = sb.toString();
		}
		else {
			content = sb.toString();

			if (content.endsWith("\n")) {
				content = content.substring(0, content.length() - 1);
			}
		}

		Matcher matcher = _missingWhitespacePattern.matcher(content);

		while (matcher.find()) {
			if (!ToolsUtil.isInsideQuotes(content, matcher.start())) {
				return StringUtil.insert(
					content, StringPool.SPACE, matcher.start() + 1);
			}
		}

		return super.doProcess(fileName, absolutePath, content);
	}

	@Override
	protected boolean isAllowTrailingEmptyLines(
		String fileName, String absolutePath) {

		if (fileName.endsWith("/package.json")) {
			return true;
		}

		return false;
	}

	private static final Pattern _leadingSpacesPattern = Pattern.compile(
		"(^[\t ]*)(  )([^ ])");
	private static final Pattern _missingWhitespacePattern = Pattern.compile(
		":\\S");

}