package com.vgs.covid19.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vgs.covid19.common.SSLUtil;

@RestController
public class CovidConsumeServices {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/states")
	public Object getStatesSummary() throws Exception {
		SSLUtil.turnOffSslChecking();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);  
	    Object object = restTemplate.exchange("https://covidtracking.com/api/states", HttpMethod.GET, entity, String.class).getBody();
	    return object;
	}
	
	@GetMapping(value = "/hello")
    public String getHello() {
        return "Hi Sagar";
    }
}
