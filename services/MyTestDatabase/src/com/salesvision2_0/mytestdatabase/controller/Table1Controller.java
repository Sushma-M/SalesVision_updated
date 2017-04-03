/*Copyright (c) 2015-2016 wavemaker-com All Rights Reserved.This software is the confidential and proprietary information of wavemaker-com You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the source code license agreement you entered into with wavemaker-com*/
package com.salesvision2_0.mytestdatabase.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.salesvision2_0.mytestdatabase.Table1;
import com.salesvision2_0.mytestdatabase.service.Table1Service;


/**
 * Controller object for domain model class Table1.
 * @see Table1
 */
@RestController("MyTestDatabase.Table1Controller")
@Api(value = "Table1Controller", description = "Exposes APIs to work with Table1 resource.")
@RequestMapping("/MyTestDatabase/Table1")
public class Table1Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table1Controller.class);

    @Autowired
	@Qualifier("MyTestDatabase.Table1Service")
	private Table1Service table1Service;

	@ApiOperation(value = "Creates a new Table1 instance.")
	@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Table1 createTable1(@RequestBody Table1 table1) {
		LOGGER.debug("Create Table1 with information: {}" , table1);

		table1 = table1Service.create(table1);
		LOGGER.debug("Created Table1 with information: {}" , table1);

	    return table1;
	}


    @ApiOperation(value = "Returns the Table1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table1 getTable1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table1 with id: {}" , id);

        Table1 foundTable1 = table1Service.getById(id);
        LOGGER.debug("Table1 details with id: {}" , foundTable1);

        return foundTable1;
    }

    @ApiOperation(value = "Updates the Table1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Table1 editTable1(@PathVariable("id") Integer id, @RequestBody Table1 table1) throws EntityNotFoundException {
        LOGGER.debug("Editing Table1 with id: {}" , table1.getId());

        table1.setId(id);
        table1 = table1Service.update(table1);
        LOGGER.debug("Table1 details with id: {}" , table1);

        return table1;
    }

    @ApiOperation(value = "Deletes the Table1 instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTable1(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table1 with id: {}" , id);

        Table1 deletedTable1 = table1Service.delete(id);

        return deletedTable1 != null;
    }

    /**
     * @deprecated Use {@link #findTable1s(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Table1 instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table1> searchTable1sByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table1s list");
        return table1Service.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table1 instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table1> findTable1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table1s list");
        return table1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Table1 instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Table1> filterTable1s(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table1s list");
        return table1Service.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTable1s(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return table1Service.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Table1 instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTable1s( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Table1s");
		return table1Service.count(query);
	}


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table1Service instance
	 */
	protected void setTable1Service(Table1Service service) {
		this.table1Service = service;
	}

}

