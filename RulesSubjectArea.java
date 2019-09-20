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
public class RulesSubjectArea {
	
	@Bean 
		ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "SUBJECT_AREA_NBR")
	private String SUBJECT_AREA_NBR;
	
	@Column(name = "SUBJECT_AREA_DESCR")
	private String SUBJECT_AREA_DESCR;
	

	public RulesSubjectArea() {
	}
	
	public void setSUBJECT_AREA_NBR( String SUBJECT_AREA_NBR) {
		this.SUBJECT_AREA_NBR= SUBJECT_AREA_NBR;
	}
	
	public String getSUBJECT_AREA_NBR() {
		return SUBJECT_AREA_NBR;
	}

	public void setSUBJECT_AREA_DESCR( String SUBJECT_AREA_DESCR) {
		this.SUBJECT_AREA_DESCR= SUBJECT_AREA_DESCR;
	}
	
	public String getSUBJECT_AREA_DESCR() {
		return SUBJECT_AREA_DESCR;
	}



}
