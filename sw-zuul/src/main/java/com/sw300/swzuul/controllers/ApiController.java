package com.sw300.swzuul.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;



@Controller
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private RestTemplate apiClient;

	@Value("${vcap.application.uris:api-gateway}")
	String apigateway;

	@Value("${spring.application.name:api-gateway}")
	String applicationName;

	@Autowired
	private WebApplicationContext wac;

	@CrossOrigin
	@RequestMapping(value = "/swagger/{service}")
	@ResponseBody
	public Object swagger(Model model, @PathVariable String service) {
		//String obj = apiClient.getForObject(String.format("http://%s/v2/api-docs", service), String.class);
		ResponseEntity<String> response = apiClient.getForEntity(String.format("http://%s/v2/api-docs", service), String.class);
		Swagger swagger = new SwaggerParser().parse(response.getBody());
		try {
			swagger.setHost(apigateway);
			swagger.setBasePath("/proxy");

			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			return mapper.writeValueAsString(swagger);

		} catch (JsonProcessingException ex) {
			logger.error(ex.toString());
		}
		return response.getBody();
	}

	@CrossOrigin
	@RequestMapping(value = "/proxy/**")
	public ResponseEntity proxy(HttpEntity<?> requestEntity) throws Exception {

		return new ResponseEntity(requestEntity.getBody(), HttpStatus.OK);
	}


	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
