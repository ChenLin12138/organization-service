package com.lin.organization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lin.organization.model.Organization;

/**
 * @author Chen Lin
 * @date 2019-08-31
 */

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String> {

	public Organization findOrganizationById(String organizationId);

}
