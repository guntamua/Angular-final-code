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
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence. GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="rules_column_definition")
public class RulesColumns {
	
	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
	  }

	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
			
	    @Column(name = "column_seq_nbr")
	    private String column_seq_nbr;
		
		@Column(name ="column_name")
		private String column_name;
		
		@Column(name ="column_desc")
		private String column_desc;
		
		@Column(name ="column_data_type")
		private String column_data_type;
	
	
	public RulesColumns() {
	}
		public RulesColumns( String[] column_cols) {
		
		this.column_name= column_cols[0];
		this.column_desc = column_cols[1];
		this.column_data_type = column_cols[2];
		
		}
	
	public String getcolumn_seq_nbr() {
		return column_seq_nbr;
		}
	
	public String getcolumn_name() {
		return column_name;
		}
	
		public void setcolumn_name(String column_name) {
			this.column_name = column_name;
			}
	
	public String getcolumn_desc() {
		return column_desc;
		}
	
		public void setcolumn_desc(String column_desc) {
			this.column_desc = column_desc;
			}
			
	public String getcolumn_data_type() {
		return column_data_type;
		}
	
		public void setcolumn_data_type(String column_data_type) {
			this.column_data_type = column_data_type;
		}

		
		
		
public String toStringAllColumns() {
	       return "[{"+"\"column_seq_nbr\""+":"+ column_seq_nbr +","+"\"column_name\""+":"+"\""+column_name+"\","+"\"column_desc\""+":"+ "\""+column_desc +"\","+"\"column_data_type\""+":"+ "\""+column_data_type+"\"}]"; 
	   }


  }
    

