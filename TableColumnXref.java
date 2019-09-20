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
@Table(name="rules_table_column_xref")
public class TableColumnXref {

	@Bean 
		ServletWebServerFactory servletWebServerFactory(){
		return new TomcatServletWebServerFactory();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 
	@Column(name = "table_seq_nbr")
	private String table_seq_nbr;
	
	@Column(name = "column_seq_nbr")
	private String column_seq_nbr;
	
	
public TableColumnXref() {
}

	public void settable_seq_nbr( String table_seq_nbr) {
		this.table_seq_nbr= table_seq_nbr;
		}
	public String gettable_seq_nbr() {
		return table_seq_nbr;}
	
	
	public void setcolumn_seq_nbr( String column_seq_nbr) {
		this.column_seq_nbr= column_seq_nbr;
		}
	public String getcolumn_seq_nbr() {
		return column_seq_nbr;}
	
//@Override
//	
//	public String toString() {
//		return "[{"+"\"table_seq_nbr\""+":"+"\""+table_seq_nbr+"\"column_seq_nbr\""+":"+"\""+column_seq_nbr+"\"}]";
//	}
	
//
//	public String toStringAllTable_Seq_Nbr() {
//	   return "[{"+"\"table_seq_nbr\""+":"+"\""+table_seq_nbr+"\"}]"; 
//	}
//	
//	public String toStringAllColumn_Seq_Nbr() {
//	   return "[{"+"\"column_seq_nbr\""+":"+"\""+column_seq_nbr+"\"}]"; 
//	}


}
