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

import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import classNames from 'classnames';
import React, {useContext} from 'react';

import {
	useHoverItem,
	useIsHovered,
	useIsSelected,
	useSelectItem
} from '../../../app/components/Controls';
import {ConfigContext} from '../../../app/config/index';
import {DispatchContext} from '../../../app/reducers/index';
import {StoreContext} from '../../../app/store/index';
import deleteItem from '../../../app/thunks/deleteItem';

const NameButton = ({id, name}) => {
	const isSelected = useIsSelected();

	return (
		<ClayButton
			className={classNames(
				'page-editor__page-structure__tree-node__name-button',
				{
					'page-editor__page-structure__tree-node__name-button--active': isSelected(
						id
					)
				}
			)}
			displayType="unstyled"
		>
			{name || Liferay.Language.get('element')}
		</ClayButton>
	);
};

const RemoveButton = ({id}) => {
	const config = useContext(ConfigContext);
	const dispatch = useContext(DispatchContext);
	const store = useContext(StoreContext);

	return (
		<ClayButton
			className="page-editor__page-structure__tree-node__remove-button"
			displayType="unstyled"
			onClick={event => {
				event.stopPropagation();
				dispatch(deleteItem({config, itemId: id, store}));
			}}
		>
			<ClayIcon symbol="times-circle" />
		</ClayButton>
	);
};

export default function StructureTreeNode({node}) {
	const hoverItem = useHoverItem();
	const isHovered = useIsHovered();
	const selectItem = useSelectItem();

	return (
		<div
			className="page-editor__page-structure__tree-node"
			onClick={event => {
				event.stopPropagation();

				selectItem(node.id);
			}}
			onMouseLeave={event => {
				event.stopPropagation();

				if (isHovered(node.id)) {
					hoverItem(null);
				}
			}}
			onMouseOver={event => {
				event.stopPropagation();
				hoverItem(node.id);
			}}
		>
			<NameButton id={node.id} name={node.name} />
			{node.removable && <RemoveButton id={node.id} />}
		</div>
	);
}
