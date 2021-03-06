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

package com.liferay.data.engine.rest.resource.v2_0;

import com.liferay.data.engine.rest.dto.v2_0.DataModelPermission;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/data-engine/v2.0
 *
 * @author Jeyvison Nascimento
 * @generated
 */
@Generated("")
@ProviderType
public interface DataModelPermissionResource {

	public Page<DataModelPermission> getDataDefinitionDataModelPermissionsPage(
			Long dataDefinitionId, String roleNames)
		throws Exception;

	public void putDataDefinitionDataModelPermission(
			Long dataDefinitionId, DataModelPermission[] dataModelPermissions)
		throws Exception;

	public Page<DataModelPermission> getDataLayoutDataModelPermissionsPage(
			Long dataLayoutId, String roleNames)
		throws Exception;

	public void putDataLayoutDataModelPermission(
			Long dataLayoutId, DataModelPermission[] dataModelPermissions)
		throws Exception;

	public Page<DataModelPermission>
			getDataRecordCollectionDataModelPermissionsPage(
				Long dataRecordCollectionId, String roleNames)
		throws Exception;

	public void putDataRecordCollectionDataModelPermission(
			Long dataRecordCollectionId,
			DataModelPermission[] dataModelPermissions)
		throws Exception;

	public String getDataRecordCollectionDataModelPermissionByCurrentUser(
			Long dataRecordCollectionId)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

}