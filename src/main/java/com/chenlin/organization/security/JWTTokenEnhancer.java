package com.chenlin.organization.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

/**
 * @author Chen Lin
 * @date 2019-10-17
 */

@Component
public class JWTTokenEnhancer implements TokenEnhancer{
	   private String getOrgId(String userName){
	        return "orgId123";
	    }

	    @Override
	    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	        Map<String, Object> additionalInfo = new HashMap<>();
	        String orgId =  getOrgId(authentication.getName());

	        additionalInfo.put("organizationId", orgId);

	        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
	        return accessToken;
	    }
}
