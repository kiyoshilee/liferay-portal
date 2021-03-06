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

package com.liferay.layout.content.page.editor.web.internal.util;

import com.liferay.fragment.model.FragmentEntryLink;
import com.liferay.fragment.processor.PortletRegistry;
import com.liferay.fragment.service.FragmentEntryLinkServiceUtil;
import com.liferay.layout.service.LayoutClassedModelUsageLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.portlet.PortletIdCodec;
import com.liferay.portal.kernel.service.PortletLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

/**
 * @author Eudaldo Alonso
 */
public class FragmentEntryLinkUtil {

	public static void deleteFragmentEntryLink(
			long companyId, long fragmentEntryLinkId, long plid,
			PortletRegistry portletRegistry)
		throws PortalException {

		FragmentEntryLink fragmentEntryLink =
			FragmentEntryLinkServiceUtil.deleteFragmentEntryLink(
				fragmentEntryLinkId);

		if (fragmentEntryLink.getFragmentEntryId() == 0) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				fragmentEntryLink.getEditableValues());

			String portletId = jsonObject.getString(
				"portletId", StringPool.BLANK);

			if (Validator.isNotNull(portletId)) {
				String instanceId = jsonObject.getString(
					"instanceId", StringPool.BLANK);

				PortletLocalServiceUtil.deletePortlet(
					companyId, PortletIdCodec.encode(portletId, instanceId),
					plid);

				LayoutClassedModelUsageLocalServiceUtil.
					deleteLayoutClassedModelUsages(
						PortletIdCodec.encode(portletId, instanceId),
						PortalUtil.getClassNameId(Portlet.class), plid);
			}
		}

		List<String> portletIds =
			portletRegistry.getFragmentEntryLinkPortletIds(fragmentEntryLink);

		for (String portletId : portletIds) {
			PortletLocalServiceUtil.deletePortlet(companyId, portletId, plid);

			LayoutClassedModelUsageLocalServiceUtil.
				deleteLayoutClassedModelUsages(
					portletId, PortalUtil.getClassNameId(Portlet.class), plid);
		}

		LayoutClassedModelUsageLocalServiceUtil.deleteLayoutClassedModelUsages(
			String.valueOf(fragmentEntryLinkId),
			PortalUtil.getClassNameId(FragmentEntryLink.class), plid);
	}

}