/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesvision2_0.mytestdatabase.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.salesvision2_0.mytestdatabase.Personnel;

/**
 * Service object for domain model class {@link Personnel}.
 */
public interface PersonnelService {

    /**
     * Creates a new Personnel. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Personnel if any.
     *
     * @param personnel Details of the Personnel to be created; value cannot be null.
     * @return The newly created Personnel.
     */
	Personnel create(Personnel personnel);


	/**
	 * Returns Personnel by given id if exists.
	 *
	 * @param personnelId The id of the Personnel to get; value cannot be null.
	 * @return Personnel associated with the given personnelId.
     * @throws EntityNotFoundException If no Personnel is found.
	 */
	Personnel getById(Integer personnelId) throws EntityNotFoundException;

    /**
	 * Find and return the Personnel by given id if exists, returns null otherwise.
	 *
	 * @param personnelId The id of the Personnel to get; value cannot be null.
	 * @return Personnel associated with the given personnelId.
	 */
	Personnel findById(Integer personnelId);


	/**
	 * Updates the details of an existing Personnel. It replaces all fields of the existing Personnel with the given personnel.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Personnel if any.
     *
	 * @param personnel The details of the Personnel to be updated; value cannot be null.
	 * @return The updated Personnel.
	 * @throws EntityNotFoundException if no Personnel is found with given input.
	 */
	Personnel update(Personnel personnel) throws EntityNotFoundException;

    /**
	 * Deletes an existing Personnel with the given id.
	 *
	 * @param personnelId The id of the Personnel to be deleted; value cannot be null.
	 * @return The deleted Personnel.
	 * @throws EntityNotFoundException if no Personnel found with the given id.
	 */
	Personnel delete(Integer personnelId) throws EntityNotFoundException;

	/**
	 * Find all Personnels matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Personnels.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Personnel> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Personnels matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Personnels.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Personnel> findAll(String query, Pageable pageable);

    /**
	 * Exports all Personnels matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Personnels in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Personnel.
	 */
	long count(String query);


}

