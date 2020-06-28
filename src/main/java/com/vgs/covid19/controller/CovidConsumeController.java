package com.vgs.covid19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgs.covid19.common.WebServiceClient;

@RestController
public class CovidConsumeController {

	@Autowired
	private Environment environment;

	@Autowired
	private WebServiceClient webServiceClient;

	@GetMapping(value = "/test")
	public String getHello() {
		return "Hello Sagar";
	}

	@RequestMapping(value = "/states")
	public Object getStatesSummary() {
		Object object = null;
		try {
			object = webServiceClient.getResponse(environment.getRequiredProperty("service.url.states"), HttpMethod.GET);
		} catch (Exception e) {
			System.out.println("Exception in getStatesSummary of CovidConsumeServices:-" + e.getMessage());
		}
		return object;
	}
}
