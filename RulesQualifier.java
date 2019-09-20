package com.cvs.rules.model;
import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence. GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="rules_all_users")
public class RulesQualifier {
	
	@Bean 
		ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "QUALIFIER_SEQ_NBR")
	private String QUALIFIER_SEQ_NBR;
	
	@Column(name = "QUALIFIER_TXT")
	private String QUALIFIER_TXT;
	

	public RulesQualifier() {
	}
	
	public void setQUALIFIER_SEQ_NBR( String QUALIFIER_SEQ_NBR) {
		this.QUALIFIER_SEQ_NBR= QUALIFIER_SEQ_NBR;
	}
	
	public String getQUALIFIER_SEQ_NBR() {
		return QUALIFIER_SEQ_NBR;
	}

	public void setQUALIFIER_TXT( String QUALIFIER_TXT) {
		this.QUALIFIER_TXT= QUALIFIER_TXT;
	}
	
	public String getQUALIFIER_TXT() {
		return QUALIFIER_TXT;
	}



}
