/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 */

import React from 'react';
import {Link, Redirect, withRouter} from 'react-router-dom';

import {parse, stringify} from './queryString.es';

class BackLinkWrapper extends React.Component {
	render() {
		const {backPath, children, className} = this.props;

		return (
			<Link className={className} to={backPath}>
				{children}
			</Link>
		);
	}
}

class BackRedirectWrapper extends React.Component {
	render() {
		const {backPath} = this.props;

		return <Redirect to={backPath} />;
	}
}

class ChildLinkWrapper extends React.Component {
	render() {
		const {
			children,
			className,
			currentPath,
			query,
			to,
			...props
		} = this.props;

		const eventProps = getEventProps(props);

		return (
			<Link
				{...eventProps}
				className={className}
				to={{
					pathname: to,
					search: stringify({backPath: currentPath, ...query})
				}}
			>
				{children}
			</Link>
		);
	}
}

const withParams = Component =>
	withRouter(({location: {pathname, search}, match: {params}, ...props}) => (
		<Component
			{...params}
			{...parse(search)}
			{...props}
			currentPath={pathname + search}
		/>
	));

function getEventProps(props) {
	return Object.keys(props)
		.filter(key => key.startsWith('on'))
		.reduce((obj, key) => {
			obj[key] = props[key];

			return obj;
		}, {});
}

const BackLink = withParams(BackLinkWrapper);
const BackRedirect = withParams(BackRedirectWrapper);
const ChildLink = withParams(ChildLinkWrapper);

export {BackLink, BackRedirect, ChildLink};
