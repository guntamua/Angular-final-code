package com.cvs.rules.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence. GenerationType;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestTemplate;


@Entity
@Table(name="rules_transform")
public class RulesTransformations {

	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
		}
	public RulesTransformations() {
		
		}
	
	public RulesTransformations( String[] table_cols) {
		this.TRANSFORM_SEQ_NBR = table_cols[0];
		this.SUBJECT_AREA_SEQ_NBR = table_cols[1];
		this.TRANSFORM_RAW_CODE = table_cols[2];
		this.TRANS_DATA_TYPE = table_cols[3];
		this.DESCRIPTION = table_cols[4];

		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String TRANSFORM_SEQ_NBR;
	
		public String getTRANSFORM_SEQ_NBR() {
				return TRANSFORM_SEQ_NBR;
		}
		
	@Column(name = "TRANS_DATA_TYPE")
	private String TRANS_DATA_TYPE;
	
		public String getTRANS_DATA_TYPE() {
			return TRANS_DATA_TYPE;
		}

		public void setTRANS_DATA_TYPE(String TRANS_DATA_TYPE) {
			this.TRANS_DATA_TYPE = TRANS_DATA_TYPE;
		}
	 	
	@Column(name = "DESCRIPTION")
	private String DESCRIPTION;
	
	
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
	
		public void setDESCRIPTION(String DESCRIPTION) {
			this.DESCRIPTION = DESCRIPTION;
		}
				
	@Column(name = "SUBJECT_AREA_SEQ_NBR")
	private String SUBJECT_AREA_SEQ_NBR;
	
	
		public String getSUBJECT_AREA_SEQ_NBR() {
			return SUBJECT_AREA_SEQ_NBR;
		}
	
		public void setSUBJECT_AREA_SEQ_NBR(String SUBJECT_AREA_SEQ_NBR) {
			this.SUBJECT_AREA_SEQ_NBR = SUBJECT_AREA_SEQ_NBR;
		}
	
	@Column(name = "TRANSFORM_RAW_CODE")
	private String TRANSFORM_RAW_CODE;
	

		public String getTRANSFORM_RAW_CODE() {
			return TRANSFORM_RAW_CODE;
		}
		
		public void setTRANSFORM_RAW_CODE(String TRANSFORM_RAW_CODE) {
			this.TRANSFORM_RAW_CODE = TRANSFORM_RAW_CODE;
		}
		
}
