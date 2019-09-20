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
@Table(name="all_tab_cols")
public class RulesColumnsMetadata {

@Bean 
	ServletWebServerFactory servletWebServerFactory(){
	return new TomcatServletWebServerFactory();
}
	
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(strategy = GenerationType.AUTO)


@Column(name = "owner")
private String owner;

@Column(name = "table_name")
private String table_name;

@Column(name = "column_name")
private String column_name;
	
public RulesColumnsMetadata() {}
	
	public void setowner( String owner) {
		this.owner= owner; }
	public String getuser_name() {
		return owner;}
	
	public void settable_name( String table_name) {
		this.table_name= table_name; }
	public String gettable_name() {
		return table_name;}
	
	public void setcolumn_name( String column_name) {
		this.column_name= column_name; }
	public String getcolumn_name() {
		return column_name;}
	
}




