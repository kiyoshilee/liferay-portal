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

package com.liferay.headless.admin.user.resource.v1_0.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.headless.admin.user.client.dto.v1_0.Organization;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.UserTestUtil;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Javier Gamarra
 */
@RunWith(Arquillian.class)
public class OrganizationResourceTest extends BaseOrganizationResourceTestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		_user = UserTestUtil.addGroupAdminUser(testGroup);
	}

	@After
	@Override
	public void tearDown() throws Exception {
		_deleteOrganizations(_childOrganizations);
		_deleteOrganizations(_organizations);
	}

	@Ignore
	@Override
	@Test
	public void testGetOrganizationOrganizationsPageWithSortString() {
	}

	@Ignore
	@Override
	@Test
	public void testGetOrganizationsPageWithSortString() {
	}

	@Ignore
	@Override
	@Test
	public void testGraphQLDeleteOrganization() {
	}

	@Override
	protected String[] getAdditionalAssertFieldNames() {
		return new String[] {"name"};
	}

	@Override
	protected Organization testDeleteOrganization_addOrganization()
		throws Exception {

		Organization organization = randomOrganization();

		return _toOrganization(
			OrganizationLocalServiceUtil.addOrganization(
				_user.getUserId(), 0, organization.getName(), true));
	}

	@Override
	protected Organization testGetOrganization_addOrganization()
		throws Exception {

		return _addUserOrganization(_user.getUserId(), randomOrganization());
	}

	@Override
	protected Organization testGetOrganizationOrganizationsPage_addOrganization(
			Long parentOrganizationId, Organization organization)
		throws Exception {

		return _toOrganization(
			_addOrganization(organization, parentOrganizationId));
	}

	@Override
	protected Long
			testGetOrganizationOrganizationsPage_getParentOrganizationId()
		throws Exception {

		com.liferay.portal.kernel.model.Organization organization =
			_addOrganization(randomOrganization(), 0);

		return organization.getOrganizationId();
	}

	@Override
	protected Organization testGetOrganizationsPage_addOrganization(
			Organization organization)
		throws Exception {

		return _addUserOrganization(_user.getUserId(), organization);
	}

	@Override
	protected Organization testGraphQLOrganization_addOrganization()
		throws Exception {

		return testGetOrganization_addOrganization();
	}

	@Override
	protected Organization testPostOrganization_addOrganization(
			Organization organization)
		throws Exception {

		return _addUserOrganization(_user.getUserId(), organization);
	}

	private com.liferay.portal.kernel.model.Organization _addOrganization(
			Organization organization, long parentOrganizationId)
		throws PortalException {

		com.liferay.portal.kernel.model.Organization
			serviceBuilderOrganization =
				OrganizationLocalServiceUtil.addOrganization(
					_user.getUserId(), parentOrganizationId,
					organization.getName(), true);

		if (parentOrganizationId == 0) {
			_organizations.add(serviceBuilderOrganization);
		}
		else {
			_childOrganizations.add(serviceBuilderOrganization);
		}

		return serviceBuilderOrganization;
	}

	private Organization _addUserOrganization(
			Long userAccountId, Organization organization)
		throws Exception {

		Organization parentOrganization = _toOrganization(
			_addOrganization(organization, 0));

		if (userAccountId != null) {
			UserLocalServiceUtil.addOrganizationUser(
				parentOrganization.getId(), userAccountId);
		}

		return parentOrganization;
	}

	private void _deleteOrganizations(
		List<com.liferay.portal.kernel.model.Organization> organizations) {

		for (com.liferay.portal.kernel.model.Organization organization :
				organizations) {

			try {
				OrganizationLocalServiceUtil.deleteUserOrganization(
					_user.getUserId(), organization);
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e, e);
				}
			}

			try {
				OrganizationLocalServiceUtil.deleteOrganization(
					organization.getOrganizationId());
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e, e);
				}
			}
		}
	}

	private Organization _toOrganization(
		com.liferay.portal.kernel.model.Organization organization) {

		return new Organization() {
			{
				dateCreated = organization.getCreateDate();
				dateModified = organization.getModifiedDate();
				id = organization.getOrganizationId();
				name = organization.getName();
			}
		};
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationResourceTest.class);

	private final List<com.liferay.portal.kernel.model.Organization>
		_childOrganizations = new ArrayList<>();
	private final List<com.liferay.portal.kernel.model.Organization>
		_organizations = new ArrayList<>();

	@DeleteAfterTestRun
	private User _user;

}