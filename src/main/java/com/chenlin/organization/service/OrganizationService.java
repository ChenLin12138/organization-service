package com.chenlin.organization.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlin.organization.events.source.SimpleSourceBean;
import com.chenlin.organization.model.Organization;
import com.chenlin.organization.repository.OrganizationRepository;

import brave.Span;
import brave.Tracer;

/**
 * @author Chen Lin
 * @date 2019-08-31
 */

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository orgRepository;
	
	@Autowired
	private SimpleSourceBean simpleSourceBean;
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(OrganizationService.class);
	
	@Autowired
	Tracer tracer;
	
	public Organization getOrg(String organizationId) {
		// TODO Auto-generated method stub
		logger.debug("In the organizationService.getOrg() call");
		Span span = tracer.newTrace().name("getOrgDBCall");
		span.start();
		try {
			return orgRepository.findOrganizationById(organizationId);
		}finally {
			span.tag("peer,service", "mysql");
			span.finish();
		}
	}

	public void updateOrg(Organization org) {
		// TODO Auto-generated method stub
		orgRepository.save(org);
		simpleSourceBean.publishOrgChange("UPDATE", org.getId());
	}

	public void saveOrg(Organization org) {
		// TODO Auto-generated method stub
		org.setId(UUID.randomUUID().toString());
		orgRepository.save(org);
		simpleSourceBean.publishOrgChange("SAVE", org.getId());
	}

	public void deleteOrg(String orgId) {
		// TODO Auto-generated method stub
		orgRepository.deleteById(orgId);
		simpleSourceBean.publishOrgChange("DELETE", orgId);
		
	}

}
