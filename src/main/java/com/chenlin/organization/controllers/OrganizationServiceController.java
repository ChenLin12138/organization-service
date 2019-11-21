package com.chenlin.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chenlin.organization.model.Organization;
import com.chenlin.organization.service.OrganizationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Chen Lin
 * @date 2019-08-31
 */

@RestController
@RequestMapping(value = "v1/organizations")
@Api(tags="Organization")
public class OrganizationServiceController {

	@Autowired
	private OrganizationService orgService;

	@ApiOperation(value = "查询Organization信息" ,  notes="通过organizationId获取指定的Organization信息")
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
		return orgService.getOrg(organizationId);
	}
	
	@ApiOperation(value = "更新Organization信息" ,  notes="通过organizationId更新指定的Organization信息")
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") String organizationId, @RequestBody Organization org) {
		orgService.updateOrg(org);
	}
	
	@ApiOperation(value = "添加Organization信息" ,  notes="添加Organization信息")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization org) {
		orgService.saveOrg(org);
	}
	
	@ApiOperation(value = "删除Organization信息" ,  notes="通过organizationId删除指定的Organization信息")
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") String orgId) {
		orgService.deleteOrg(orgId);
	}
	
}
