package com.sw300.swzuul.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
//Enable Swagger2
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("bokuk seo", "http://www.crossent.com", "bkseo@crossent.com");
	public static final ApiInfo DEFAUT_API_INFO = new ApiInfo(
			"SW300 Api Documentation", "SW300 Api Documentation", "1.0", "urn:tos",
	         DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
	         new ArrayList<VendorExtension>());
	
	private static final Set<String> DEFAUT_PRDUCES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json","application/xml"));
	

	//Bean-Docket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAUT_API_INFO)
				.produces(DEFAUT_PRDUCES_AND_CONSUMES)
				.consumes(DEFAUT_PRDUCES_AND_CONSUMES);
	}
	  //Swagger 2
	  //all the paths
	  //all the apis

}
