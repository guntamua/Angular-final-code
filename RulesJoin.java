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
@Table(name="rules_rel_join")
public class RulesJoin {

	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
		}
	
	public RulesJoin() {
		
		}
	
	public RulesJoin( String[] table_cols) {
		this.table1_seq_nbr = table_cols[0];
		this.table2_seq_nbr = table_cols[1];
		this.join_typ = table_cols[2];
		this.col1_seq_nbr = table_cols[3];
		this.cols2_seq_nbr = table_cols[4];
		this.join_descr = table_cols[5];
		}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String join_seq_nbr;
	
		public String getjoin_seq_nbr() {
				return join_seq_nbr;
		}
	 
	@Column(name = "col1_seq_nbr")
	private String col1_seq_nbr;
	
	
		public String getcol1_seq_nbr() {
			return col1_seq_nbr;
		}
	
		public void setcol1_seq_nbr(String col1_seq_nbr) {
			this.col1_seq_nbr = col1_seq_nbr;
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
		
	@Column(name = "cols2_seq_nbr")
	private String cols2_seq_nbr;
	
		public String getcols2_seq_nbr() {
			return cols2_seq_nbr;
		}

		public void setcols2_seq_nbr(String cols2_seq_nbr) {
			this.cols2_seq_nbr = cols2_seq_nbr;
		}
		
		
		@Column(name = "column_name1")
		private String column_name1;
		
			public String getcolumn_name1() {
				return column_name1;
			}

			public void setcolumn_name1(String column_name1) {
				this.column_name1 = column_name1;
			}
			
		@Column(name = "column_name2")
		private String column_name2;
		
			public String getcolumn_name2() {
				return column_name2;
			}

			public void setcolumn_name2(String column_name2) {
				this.column_name2 = column_name2;
			}
		
			
	@Column(name = "join_descr")
	private String join_descr;
	

		public String getjoin_descr() {
			return join_descr;
		}
		
		public void setjoin_descr(String join_descr) {
			this.join_descr = join_descr;
		}
	

	@Column(name = "join_condition")
		private String join_condition;
		
	
			public String getjoin_condition() {
				return join_condition;
			}
			
			public void setjoin_condition(String join_condition) {
				this.join_condition= join_condition;
			}

	@Column(name= "join_typ")
	private String join_typ;
	
		public String getjoin_typ() {
			return join_typ;
		}
		
		public void setjoin_typ(String join_typ) {
			this.join_typ = join_typ;
		}

}