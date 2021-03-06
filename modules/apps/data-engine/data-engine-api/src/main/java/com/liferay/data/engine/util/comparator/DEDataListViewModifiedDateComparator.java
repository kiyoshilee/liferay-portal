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

package com.liferay.data.engine.util.comparator;

import com.liferay.data.engine.model.DEDataListView;
import com.liferay.exportimport.kernel.lar.StagedModelModifiedDateComparator;

/**
 * @author Gabriel Albuquerque
 */
public class DEDataListViewModifiedDateComparator
	extends StagedModelModifiedDateComparator<DEDataListView> {

	public DEDataListViewModifiedDateComparator() {
		this(false);
	}

	public DEDataListViewModifiedDateComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public String getOrderBy() {
		return "DEDataListView." + super.getOrderBy();
	}

}