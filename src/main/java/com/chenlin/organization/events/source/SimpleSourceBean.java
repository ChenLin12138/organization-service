package com.chenlin.organization.events.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.chenlin.organization.events.models.OrganizationChangeModel;
import com.chenlin.organization.utils.UserContextHolder;

/**
 * @author Chen Lin
 * @date 2019-10-21
 */

@Component
public class SimpleSourceBean {

	private Source source;
	private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);
	
	@Autowired
	public SimpleSourceBean(Source source) {
		this.source = source;
	}
	
	public void publishOrgChange(String action, String orgId) {
		logger.debug("Sending Kafka message {} for Organization Id: {}",action,orgId);
		OrganizationChangeModel change = new OrganizationChangeModel(
			OrganizationChangeModel.class.getTypeName(),
			action,
			orgId,
			UserContextHolder.getContext().getCorrelationId());
		
		source.output().send(MessageBuilder.withPayload(change).build());
	}
	
}
