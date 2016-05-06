package com.bolatu.rest.client;

import org.springframework.web.client.RestTemplate;

public final class BolatuRestClient {
	
	private RestTemplate restTemplate;
	private String endPointUrl;
	
	public BolatuRestClient(RestTemplate restTemplate, String endPointUrl) {
		this.restTemplate = restTemplate;
		this.endPointUrl = endPointUrl;		
	}
	
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
    
    public String createUrl(String uri) {
        StringBuilder sb = new StringBuilder();
        sb.append(endPointUrl);
        
        if (endPointUrl.charAt(endPointUrl.length() - 1) == '/') {
        	if (uri.charAt(0) == '/') {
        		sb.append(uri.substring(1));
        	} else {
        		sb.append(uri);
        	}
        } else {
        	if (uri.charAt(0) == '/') {
        		sb.append(uri);
        	} else {
        		sb.append('/');
        		sb.append(uri);
        	}
        }
        
        return sb.toString();
    }
	

}
