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

package com.liferay.portal.workflow.metrics.rest.internal.jaxrs.exception.mapper;

import com.liferay.portal.workflow.metrics.exception.WorkflowMetricsSLADefinitionStartNodeKeysException;
import com.liferay.portal.workflow.metrics.rest.dto.v1_0.GenericError;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.ext.ExceptionMapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author Rafael Praxedes
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=Liferay.Portal.Workflow.Metrics.REST)",
		"osgi.jaxrs.extension=true",
		"osgi.jaxrs.name=Liferay.Portal.Workflow.Metrics.REST.SLAStartNodeKeysExceptionMapper"
	},
	service = ExceptionMapper.class
)
public class SLAStartNodeKeysExceptionMapper
	extends BaseSLAExceptionMapper
		<WorkflowMetricsSLADefinitionStartNodeKeysException> {

	@Override
	public List<GenericError> toGenericErrors(
		WorkflowMetricsSLADefinitionStartNodeKeysException
			workflowMetricsSLADefinitionStartNodeKeysException) {

		return Collections.singletonList(
			new GenericError() {
				{
					fieldName = "startNodeKeys";
					message = SLAStartNodeKeysExceptionMapper.this.getMessage(
						"the-start-node-field-cannot-be-empty");
				}
			});
	}

}