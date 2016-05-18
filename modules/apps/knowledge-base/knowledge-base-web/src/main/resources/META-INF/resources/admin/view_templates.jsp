<%--
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
--%>

<%@ include file="/admin/init.jsp" %>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<portlet:renderURL var="viewTemplatesURL">
			<portlet:param name="mvcPath" value="/admin/view_templates.jsp" />
		</portlet:renderURL>

		<aui:nav-item
			href="<%= viewTemplatesURL %>"
			label="templates"
			selected="<%= true %>"
		/>
	</aui:nav>

	<aui:nav-bar-search>
		<liferay-portlet:renderURL varImpl="searchURL">
			<portlet:param name="mvcPath" value="/admin/view_templates.jsp" />
		</liferay-portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="get" name="fm2">
			<liferay-portlet:renderURLParams varImpl="searchURL" />

			<aui:nav-bar-search>
				<liferay-ui:input-search markupView="lexicon" />
			</aui:nav-bar-search>
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="mvcPath" value="/admin/view_templates.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input name="kbTemplateIds" type="hidden" />

	<aui:fieldset>
		<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="mvcPath" value="/admin/view_templates.jsp" />
		</liferay-portlet:renderURL>

		<liferay-ui:search-container
			id="kbTemplateAdminSearchContainer"
			rowChecker="<%= AdminPermission.contains(permissionChecker, scopeGroupId, KBActionKeys.DELETE_KB_TEMPLATES) ? new RowChecker(renderResponse) : null %>"
			searchContainer="<%= new KBTemplateSearch(renderRequest, iteratorURL) %>"
		>

			<%
			KBTemplateSearchTerms searchTerms = (KBTemplateSearchTerms)searchContainer.getSearchTerms();
			%>

			<%@ include file="/admin/template_search_results.jspf" %>

			<liferay-ui:search-container-row
				className="com.liferay.knowledge.base.model.KBTemplate"
				escapedModel="<%= true %>"
				keyProperty="kbTemplateId"
				modelVar="kbTemplate"
			>
				<liferay-ui:search-container-column-user
					cssClass="user-icon-lg"
					showDetails="<%= false %>"
					userId="<%= kbTemplate.getUserId() %>"
				/>

				<liferay-ui:search-container-column-text colspan="<%= 2 %>">

					<%
					Date modifiedDate = kbTemplate.getModifiedDate();

					String modifiedDateDescription = LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - modifiedDate.getTime(), true);
					%>

					<h5 class="text-default">
						<liferay-ui:message arguments="<%= new String[] {kbTemplate.getUserName(), modifiedDateDescription} %>" key="x-modified-x-ago" />
					</h5>

					<liferay-portlet:renderURL var="editURL">
						<portlet:param name="mvcPath" value='<%= templatePath + "edit_template.jsp" %>' />
						<portlet:param name="redirect" value="<%= currentURL %>" />
						<portlet:param name="kbTemplateId" value="<%= String.valueOf(kbTemplate.getKbTemplateId()) %>" />
					</liferay-portlet:renderURL>

					<h4>
						<aui:a href="<%= editURL.toString() %>">
							<%= kbTemplate.getTitle() %>
						</aui:a>
					</h4>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-jsp
					path="/admin/template_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="descriptive" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:fieldset>
</aui:form>

<c:if test="<%= AdminPermission.contains(permissionChecker, scopeGroupId, KBActionKeys.ADD_KB_TEMPLATE) %>">
	<liferay-portlet:renderURL var="addKBTemplateURL">
		<portlet:param name="mvcPath" value='<%= templatePath + "edit_template.jsp" %>' />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</liferay-portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "add-template") %>' url="<%= addKBTemplateURL %>" />
	</liferay-frontend:add-menu>
</c:if>

<aui:script use="aui-base,liferay-util-list-fields">
	var deleteKBTemplates = A.one('#<portlet:namespace />deleteKBTemplates');

	if (deleteKBTemplates) {
		deleteKBTemplates.on(
			'click',
			function() {
				if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-templates") %>')) {
					document.<portlet:namespace />fm.method = 'post';
					document.<portlet:namespace />fm.<portlet:namespace />kbTemplateIds.value = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

					submitForm(document.<portlet:namespace />fm, '<liferay-portlet:actionURL name="deleteKBTemplates"><portlet:param name="mvcPath" value="/admin/view_templates.jsp" /><portlet:param name="redirect" value="<%= redirect %>" /></liferay-portlet:actionURL>');
				}
			}
		);
	}

	A.one('#<portlet:namespace />kbTemplateAdminSearchContainer').delegate(
		'click',
		function() {
			var hide = (Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace /><%= RowChecker.ALL_ROW_IDS %>').length == 0);

			var deleteKBTemplates = A.one('#<portlet:namespace />deleteKBTemplates');

			if (deleteKBTemplates) {
				deleteKBTemplates.toggle(!hide);
			}
		},
		'input[type=checkbox]'
	);
</aui:script>