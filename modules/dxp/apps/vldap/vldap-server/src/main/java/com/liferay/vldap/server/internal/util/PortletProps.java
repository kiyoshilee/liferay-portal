/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.vldap.server.internal.util;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * @author Jonathan McCann
 */
public class PortletProps {

	public static String get(String key) {
		return _portletProps._configuration.get(key);
	}

	public static String[] getArray(String key) {
		return _portletProps._configuration.getArray(key);
	}

	private PortletProps() {
		Class<?> clazz = getClass();

		_configuration = ConfigurationFactoryUtil.getConfiguration(
			clazz.getClassLoader(), "portlet");
	}

	private static final PortletProps _portletProps = new PortletProps();

	private final Configuration _configuration;

}