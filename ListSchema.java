package com.cvs.rules.model;
import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence. GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="rules_all_users")
public class ListSchema {
	
	@Bean 
		ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "username")
	private String username;
	

	public ListSchema() {
	}
	
	public void setuser_name( String username) {
		this.username= username;
	}
	
	public String getuser_name() {
		return username;
	}


}
