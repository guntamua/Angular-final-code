package com.cvs.rules.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence. GenerationType;
import javax.persistence.Id;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;


@Entity
@Table(name="rules_table_definition")
public class PostMethod {

	@Bean 
	  ServletWebServerFactory servletWebServerFactory(){
	  return new TomcatServletWebServerFactory();
		}
	public PostMethod() {
		
		}
	
	public PostMethod( String[] table_cols) {
		this.table_owner= table_cols[0];
		this.table_desc = table_cols[1];
		this.table_size_cd = table_cols[2];
		this.table_prefix_name = table_cols[3];
		this.table_typ = table_cols[4];
		}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

		
	private Long table_seq_nbr;
		public Long gettable_seq_nbr() {
			return table_seq_nbr;
		}
	 
	@Column(name = "table_owner")
	private String table_owner;
	
	
		public String gettable_owner() {
			return table_owner;
		}
	
		public void settable_owner(String table_owner) {
			this.table_owner = table_owner;
		}
		
	@Column(name = "table_desc")
	private String table_desc;
	
		public String gettable_desc() {
			return table_desc;
		}

		public void settable_desc(String table_desc) {
			this.table_desc = table_desc;
		}
		
	@Column(name = "table_size_cd")
	private String table_size_cd;
	

		public String gettable_size_cd() {
			return table_size_cd;
		}
		
		public void settable_size_cd(String table_size_cd) {
			this.table_size_cd = table_size_cd;
		}
	
	@Column(name= "table_prefix_name")
	private String table_prefix_name;
	
		public String gettable_prefix_name() {
			return table_prefix_name;
		}
		
		public void settable_prefix_name(String table_prefix_name) {
			this.table_prefix_name = table_prefix_name;
		}
	
	@Column(name ="table_typ")
	private String table_typ;
	

		public String gettable_typ() {
			return table_typ;
		}
		
		public void settable_typ(String table_typ) {
			this.table_typ = table_typ;
		}
	
	@Column(name ="table_name")
	private String table_name;
	/*private String[] table_cols;*/
	
		
		public String gettable_name() {
			return table_name;
		}


		
//	@Override
//	public String toString() {
//        return "["+ table_owner +"," +table_name+","+table_desc+","+table_size_cd + ","+table_prefix_name + ","+ table_typ+"]";
//    }
//    public String toStringAllTables() {
//        return "["+ table_owner +"," +table_name+","+table_desc+","+table_size_cd + ","+table_prefix_name + ","+ table_typ+"]";
//    }
//    public String toStringTableNames() {
//      return "[{"+"\"table_seq_nbr\""+":"+ table_seq_nbr +","+"\"table_owner\""+":"+"\""+table_owner+"\","+"\"table_desc\""+":"+ "\""+table_desc +"\","+"\"table_size_cd\""+":"+ "\""+table_size_cd +"\","+"\"table_prefix_name\""+":"+ "\""+table_prefix_name +"\","+"\"table_typ\""+":"+"\""+ table_typ +"\","+"\"table_name\""+":"+ "\""+table_name +"\"}]"; 
//       //return "[{"+"\"table_owner\""+":"+"\""+table_owner+"\","+"\"table_desc\""+":"+ "\""+table_desc +"\","+"\"table_size_cd\""+":"+ "\""+table_size_cd +"\","+"\"table_prefix_name\""+":"+ "\""+table_prefix_name +"\","+"\"table_typ\""+":"+"\""+ table_typ +"\","+"\"table_name\""+":"+ "\""+table_name +"\"}]"; 
//       
//    }
//    

}


