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
import classNames from 'classnames';
import React, {useContext} from 'react';

import {ConfigContext} from '../../app/config/index';

export default function ColorPalette({
	clearButton,
	label,
	onColorSelect,
	selectedColor
}) {
	const {themeColorsCssClasses} = useContext(ConfigContext);

	return (
		<>
			<label htmlFor="colorPalette">{label}</label>

			<div className="palette-container" id="colorPalette">
				<ul className="list-unstyled palette-items-container">
					{themeColorsCssClasses.map(color => (
						<li
							className={classNames('palette-item', {
								'palette-item-selected': color === selectedColor
							})}
							key={color}
						>
							<ClayButton
								block
								className={classNames(
									`bg-${color}`,
									'palette-item-inner',
									'p-1',
									'rounded-circle'
								)}
								displayType="unstyled"
								onClick={event => onColorSelect(color, event)}
								small
							/>
						</li>
					))}
				</ul>
			</div>

			{clearButton && (
				<ClayButton displayType="secondary" small>
					{Liferay.Language.get('clear')}
				</ClayButton>
			)}
		</>
	);
}
