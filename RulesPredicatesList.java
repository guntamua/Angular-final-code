package com.cvs.rules.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Tuple;
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
    @Table(name="RULES_PREDICATE_COMPONENT")
    public class RulesPredicatesList {

    	@Bean 
    	  ServletWebServerFactory servletWebServerFactory(){
    	  return new TomcatServletWebServerFactory();
    		}
    	public RulesPredicatesList() {
    		
    		}
    	
    	/*public RulesPredicates( Tuple [] table_cols) {
    		this.MASTER_SUB_SEQ_NBR = table_cols[0];
    		this.COL1_SEQ_NBR  = table_cols[1];
    		this.COL2_SEQ_NBR  = table_cols[2];
    		this.OPERATOR_ID = table_cols[3];
    		this.COL2_VALUE_TXT = table_cols[4];
    		this.COL1_TRANS_SEQ_NBR = table_cols[5];
    		this.COL2_TRANS_SEQ_NBR  = table_cols[6];
    		this.DESCRIPTION  = table_cols[7];
    		this.COND_CODE  = table_cols[8];
    		
   		
    		}*/

    	@Id
    	@GeneratedValue(strategy = GenerationType.AUTO)
    	private String MASTER_SUB_SEQ_NBR;
    	
    		public String getMASTER_SUB_SEQ_NBR() {
    				return MASTER_SUB_SEQ_NBR;
    		}
    		
    	@Column(name = "COL1_SEQ_NBR")
    	private String COL1_SEQ_NBR;
    	
    	
    		public String getCOL1_SEQ_NBR() {
    			return COL1_SEQ_NBR;
    		}
    	
    		public void setCOL1_SEQ_NBR(String COL1_SEQ_NBR) {
    			this.COL1_SEQ_NBR = COL1_SEQ_NBR;
    		}
    		
    	@Column(name = "COL2_SEQ_NBR")
    	private String COL2_SEQ_NBR;
    	
    	
    		public String getCOL2_SEQ_NBR() {
    			return COL2_SEQ_NBR;
    		}
    	
    		public void setCOL2_SEQ_NBR(String COL2_SEQ_NBR) {
    			this.COL2_SEQ_NBR = COL2_SEQ_NBR;
    		}
    		
    	@Column(name = "OPERATOR_ID")
    	private Integer OPERATOR_ID;
    	
    		public Integer getOPERATOR_ID() {
    			return OPERATOR_ID;
    		}

    		public void setOPERATOR_ID(Integer OPERATOR_ID) {
    			this.OPERATOR_ID = OPERATOR_ID;
    		}
    		
		@Column(name = "COL2_VALUE_TXT")
		private String COL2_VALUE_TXT;
		

			public String getCOL2_VALUE_TXT() {
				return COL2_VALUE_TXT;
			}
			
			public void setCOL2_VALUE_TXT(String COL2_VALUE_TXT) {
				this.COL2_VALUE_TXT = COL2_VALUE_TXT;
			}
		

    	@Column(name = "COL1_TRANS_SEQ_NBR")
    	private String COL1_TRANS_SEQ_NBR;
    	

    		public String getCOL1_TRANS_SEQ_NBR() {
    			return COL1_TRANS_SEQ_NBR;
    		}
    		
    		public void setCOL1_TRANS_SEQ_NBR(String COL1_TRANS_SEQ_NBR) {
    			this.COL1_TRANS_SEQ_NBR = COL1_TRANS_SEQ_NBR;
    		}
    		
		@Column(name = "COL2_TRANS_SEQ_NBR")
    	private String COL2_TRANS_SEQ_NBR;
    	

    		public String getCOL2_TRANS_SEQ_NBR() {
    			return COL2_TRANS_SEQ_NBR;
    		}
    		
    		public void setCOL2_TRANS_SEQ_NBR(String COL2_TRANS_SEQ_NBR) {
    			this.COL2_TRANS_SEQ_NBR = COL2_TRANS_SEQ_NBR;
    		}
		
    	
//		@Column(name = "SUB_QUERY_RULE_SEQ_NBR")
//    	private String SUB_QUERY_RULE_SEQ_NBR;
//    	
//
//    		public String getSUB_QUERY_RULE_SEQ_NBR() {
//    			return SUB_QUERY_RULE_SEQ_NBR;
//    		}
//    		
//    		public void setSUB_QUERY_RULE_SEQ_NBR(String SUB_QUERY_RULE_SEQ_NBR) {
//    			this.SUB_QUERY_RULE_SEQ_NBR = SUB_QUERY_RULE_SEQ_NBR;
//    		}
//		
//		@Column(name = "SUBJECT_AREA_NBR")
//    	private String SUBJECT_AREA_NBR;
//    	
//
//    		public String getSUBJECT_AREA_NBR() {
//    			return SUBJECT_AREA_NBR;
//    		}
//    		
//    		public void setSUBJECT_AREA_NBR(String SUBJECT_AREA_NBR) {
//    			this.SUBJECT_AREA_NBR = SUBJECT_AREA_NBR;
//    		}
    	
    	@Column(name = "DESCRIPTION")
    	private String DESCRIPTION;
    	
    	
    		public String getDESCRIPTION() {
    			return DESCRIPTION;
    		}
    	
    		public void setDESCRIPTION(String DESCRIPTION) {
    			this.DESCRIPTION = DESCRIPTION;
    		}
    		
    	@Column(name = "COND_CODE")
    	private String COND_CODE;
    	

    		public String getCOND_CODE() {
    			return COND_CODE;
    		}
    		
    		public void setCOND_CODE(String COND_CODE) {
    			this.COND_CODE = COND_CODE;
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
