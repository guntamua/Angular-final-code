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
@Table(name="rules_all_tables")
public class TableName {

	@Bean 
		ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	public TableName() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "table_name")
	private String table_name;
	public String getTable_name() {
		return table_name;
	}
	
	
	@Column(name = "owner")
	private String owner;
	public String getOwner() {
		return owner;
	}
	
}





















	
//	@Column(name = "owner")
//	private String owner;
//	
//	
//	
//	@Column(name = "table_name")
//	private String table_name;
//	
//	public TableName() {
//	}
//	
//	
//	public String getowner() {
//		return owner;}
//	public void setowner( String owner) {
//		this.owner= owner;
//		}
//	
//	public String gettable_name() {
//		return table_name;}
//	public void settable_name( String table_name) {
//		this.table_name= table_name;
//		}
//@Override
//	
//	public String toString() {
//		return "[{"+"\"table_name\""+":"+"\""+table_name+"\"}]";
//	}
//	
//	public String toStringAllTableName() {
//	   return "[{"+"\"table_name\""+":"+"\""+table_name+","+"\"owner\""+":"+"\""+owner+"\"}]"; 
//	     
//	}
//	
	
	


