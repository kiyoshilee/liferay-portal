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

package com.liferay.portal.search.test.util.query;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.engine.adapter.SearchEngineAdapter;
import com.liferay.portal.search.engine.adapter.search.SearchSearchRequest;
import com.liferay.portal.search.engine.adapter.search.SearchSearchResponse;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.SimpleStringQuery;
import com.liferay.portal.search.test.util.indexing.BaseIndexingTestCase;
import com.liferay.portal.search.test.util.indexing.DocumentCreationHelpers;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public abstract class BaseSimpleStringQueryTestCase
	extends BaseIndexingTestCase {

	@Test
	public void testSimpleStringQuery() {
		for (int i = 0; i < 10; i++) {
			addDocument(
				DocumentCreationHelpers.singleKeyword(
					Field.USER_NAME, "SomeUser" + i));
			addDocument(
				DocumentCreationHelpers.singleKeyword(
					Field.USER_NAME, "OtherUser" + i));
			addDocument(
				DocumentCreationHelpers.singleKeyword(
					Field.USER_NAME, "Other" + i));
		}

		SimpleStringQuery simpleStringQuery = queries.simpleString(
			"(SomeUser* | OtherUser*)");

		simpleStringQuery.addField(Field.USER_NAME, 1.0F);

		assertSearch(
			indexingTestHelper -> {
				SearchEngineAdapter searchEngineAdapter =
					getSearchEngineAdapter();

				SearchSearchResponse searchSearchResponse =
					searchEngineAdapter.execute(
						new SearchSearchRequest() {
							{
								addSorts(sorts.field(Field.USER_NAME));
								setIndexNames("_all");
								setQuery(simpleStringQuery);
								setSize(30);
							}
						});

				SearchHits searchHits = searchSearchResponse.getSearchHits();

				Assert.assertEquals(
					"Total hits", 20, searchHits.getTotalHits());

				List<SearchHit> searchHitsList = searchHits.getSearchHits();

				Assert.assertEquals(
					"Retrieved hits", 20, searchHitsList.size());

				searchHitsList.forEach(
					searchHit -> {
						Document document = searchHit.getDocument();

						String userName = document.getString(Field.USER_NAME);

						Assert.assertTrue(
							userName.startsWith("OtherUser") ||
							userName.startsWith("SomeUser"));
					});
			});
	}

}