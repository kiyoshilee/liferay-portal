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

package com.liferay.layout.internal.template.util;

import com.liferay.layout.util.template.LayoutColumn;
import com.liferay.layout.util.template.LayoutConverter;
import com.liferay.layout.util.template.LayoutData;
import com.liferay.layout.util.template.LayoutRow;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTemplate;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rubén Pulido
 */
@Component(
	immediate = true, property = "layout.template.id=default",
	service = LayoutConverter.class
)
public class DefaultLayoutConverter implements LayoutConverter {

	@Override
	public LayoutData convert(Layout layout) {
		if (!_isLayoutTemplateParseable(layout)) {
			return LayoutData.of(
				layout,
				layoutRow -> layoutRow.addLayoutColumns(
					layoutColumn -> layoutColumn.addAllPortlets()));
		}

		List<UnsafeConsumer<LayoutRow, Exception>> rowUnsafeConsumers =
			new ArrayList<>();

		Document layoutTemplateDocument = _getLayoutTemplateDocument(layout);

		for (Element rowElement :
				layoutTemplateDocument.select(".portlet-layout.row")) {

			List<UnsafeConsumer<LayoutColumn, Exception>>
				columnUnsafeConsumers = new ArrayList<>();

			for (Element columnElement :
					rowElement.getElementsByClass("portlet-column")) {

				UnsafeConsumer<LayoutColumn, Exception> columnUnsafeConsumer =
					layoutColumn -> {
						layoutColumn.addPortlets(columnElement.id());

						int columnSize = 12;

						for (String className : columnElement.classNames()) {
							if (className.startsWith(
									_CSS_CLASS_COLUMN_PREFIX)) {

								columnSize = GetterUtil.getInteger(
									className.substring(
										_CSS_CLASS_COLUMN_PREFIX.length()),
									12);

								break;
							}
						}

						layoutColumn.setSize(columnSize);
					};

				columnUnsafeConsumers.add(columnUnsafeConsumer);
			}

			UnsafeConsumer<LayoutRow, Exception> rowUnsafeConsumer =
				layoutRow -> layoutRow.addLayoutColumns(
					columnUnsafeConsumers.toArray(new UnsafeConsumer[0]));

			rowUnsafeConsumers.add(rowUnsafeConsumer);
		}

		return LayoutData.of(
			layout, rowUnsafeConsumers.toArray(new UnsafeConsumer[0]));
	}

	private Document _getLayoutTemplateDocument(Layout layout) {
		LayoutTypePortlet layoutTypePortlet =
			(LayoutTypePortlet)layout.getLayoutType();

		LayoutTemplate layoutTemplate = layoutTypePortlet.getLayoutTemplate();

		Document document = Jsoup.parseBodyFragment(
			layoutTemplate.getContent());

		Document.OutputSettings outputSettings = new Document.OutputSettings();

		outputSettings.prettyPrint(false);

		document.outputSettings(outputSettings);

		return document;
	}

	private boolean _isLayoutTemplateParseable(Layout layout) {
		Document layoutTemplateDocument = _getLayoutTemplateDocument(layout);

		Elements rowElements = layoutTemplateDocument.select(
			".portlet-layout.row");

		if (rowElements.isEmpty()) {
			return false;
		}

		for (Element rowElement : rowElements) {
			Elements columnElements = rowElement.getElementsByClass(
				"portlet-column");

			if (columnElements.isEmpty()) {
				return false;
			}

			for (Element columnElement : columnElements) {
				int columnSize = 0;

				for (String className : columnElement.classNames()) {
					if (className.startsWith(_CSS_CLASS_COLUMN_PREFIX)) {
						columnSize = GetterUtil.getInteger(
							className.substring(
								_CSS_CLASS_COLUMN_PREFIX.length()));

						break;
					}
				}

				if (columnSize == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private static final String _CSS_CLASS_COLUMN_PREFIX = "col-md-";

}