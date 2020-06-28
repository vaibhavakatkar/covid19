package com.vgs.covid19.common;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebServiceClient {

	@Autowired
	RestTemplate restTemplate;

	public Object getResponse(String serviceUrl, HttpMethod httpMethod) {
		Object response = null;
		try {
			SSLUtil.turnOffSslChecking();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			response = restTemplate.exchange(serviceUrl, httpMethod, entity, String.class).getBody();
		} catch (Exception e) {
			System.out.println("Exception in getResponse of WebServiceClient:-" + e.getMessage());
		}
		return response;
	}
}
