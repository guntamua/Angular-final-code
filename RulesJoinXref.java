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
@Table(name="rules_tab_rel_join_xref")
public class RulesJoinXref {

	

	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
		}
	public RulesJoinXref() {
		
		}
	
	public RulesJoinXref( String[] table_cols) {
		this.table1_seq_nbr = table_cols[0];
		this.table2_seq_nbr = table_cols[1];
		this.join_typ = table_cols[2];
		this.join_seq_nbr = table_cols[3];
		}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String join_seq_nbr;
	
		public String getjoin_seq_nbr() {
				return join_seq_nbr;
		}
	 
	@Column(name = "table1_seq_nbr")
	private String table1_seq_nbr;
	
	
		public String gettable1_seq_nbr() {
			return table1_seq_nbr;
		}
	
		public void settable1_seq_nbr(String table1_seq_nbr) {
			this.table1_seq_nbr = table1_seq_nbr;
		}
		
	@Column(name = "table2_seq_nbr")
	private String table2_seq_nbr;
	
		public String gettable2_seq_nbr() {
			return table2_seq_nbr;
		}

		public void settable2_seq_nbr(String table2_seq_nbr) {
			this.table2_seq_nbr = table2_seq_nbr;
		}
	
	@Column(name= "join_typ")
	private String join_typ;
	
		public String getjoin_typ() {
			return join_typ;
		}
		
		public void setjoin_typ(String join_typ) {
			this.join_typ = join_typ;
		}
	/*
	@Override
	public String toString() {
        return "["+ col1_seq_nbr +"," +cols2_seq_nbr+","+join_descr+","+join_typ + "]";
    }
    public String toStringJoins() {
        return "["+ col1_seq_nbr +"," +cols2_seq_nbr+","+join_descr+","+join_typ + "]";
    }
    public String toStringAllJoins() {
      return "[{"+"\"join_seq_nbr\""+":"+ join_seq_nbr +","+"\"col1_seq_nbr\""+":"+"\""+col1_seq_nbr+"\","+"\"cols2_seq_nbr\""+":"+ "\""+cols2_seq_nbr +"\","+"\"join_descr\""+":"+ "\""+join_descr +"\","+"\"join_typ\""+":"+ "\""+join_typ +"\"}]"; 
     
    }*/
    

}

