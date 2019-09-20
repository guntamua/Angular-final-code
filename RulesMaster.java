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
@Table(name="rules_master")
public class RulesMaster {

	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
		}
	public RulesMaster() {
		
		}
	
	public RulesMaster( String[] table_cols) {
		this.description= table_cols[0];
		this.statement_typ = table_cols[1];
		this.target_table = table_cols[2];
		this.target_temp_ind = table_cols[3];
		
		}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private String master_seq_nbr;
		public String getmaster_seq_nbr() {
				return master_seq_nbr;
		}
//		
//	private Long table_seq_nbr;
//		public Long gettable_seq_nbr() {
//			return table_seq_nbr;
//		}
//	 
	@Column(name = "description")
	private String description;
	
	
		public String getdescription() {
			return description;
		}
	
		public void setdescription(String description) {
			this.description = description;
		}
		
	@Column(name = "statement_typ")
	private String statement_typ;
	
		public String getstatement_typ() {
			return statement_typ;
		}

		public void setstatement_typ(String statement_typ) {
			this.statement_typ = statement_typ;
		}
		
	@Column(name = "target_table")
	private String target_table;
	

		public String gettarget_table() {
			return target_table;
		}
		
		public void settarget_table(String target_table) {
			this.target_table = target_table;
		}
	
	@Column(name= "target_temp_ind")
	private String target_temp_ind;
	
		public String gettarget_temp_ind() {
			return target_temp_ind;
		}
		
		public void settarget_temp_ind(String target_temp_ind) {
			this.target_temp_ind = target_temp_ind;

		}
}


