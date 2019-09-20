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
    @Table(name="RULES_MASTER_COL_XREF")
    public class RulesMasterColXref {

    	@Bean 
    	  ServletWebServerFactory servletWebServerFactory(){
    	  return new TomcatServletWebServerFactory();
    		}
    	public RulesMasterColXref() {
    		
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
    	
    	
    	@Column(name = "MASTER_SEQ_NBR")
    	private String MASTER_SEQ_NBR;
    	
    	public String getMASTER_SUB_SEQ_NBR() {
    				return MASTER_SEQ_NBR;
    		}
    		
       		public String getMASTER_SEQ_NBR() {
    			return MASTER_SEQ_NBR;
    		}
    	 
    	@Column(name = "ORDER_BY")
    	private Integer ORDER_BY;
    	
    	
    		public Integer getORDER_BY() {
    			return ORDER_BY;
    		}
    	
    		public void setORDER_BY(Integer ORDER_BY) {
    			this.ORDER_BY = ORDER_BY;
    		}
    		
		@Column(name = "GROUP_BY")
    	private Integer GROUP_BY;
    	
    	
    		public Integer getGROUP_BY() {
    			return GROUP_BY;
    		}
    	
    		public void setGROUP_BY(Integer GROUP_BY) {
    			this.GROUP_BY = GROUP_BY;
    		}
		
    	@Column(name = "COLUMN_SEQ_NBR")
    	private String COLUMN_SEQ_NBR;
    	
    	
    		public String getCOLUMN_SEQ_NBR() {
    			return COLUMN_SEQ_NBR;
    		}
    	
    		public void setCOLUMN_SEQ_NBR(String COLUMN_SEQ_NBR) {
    			this.COLUMN_SEQ_NBR = COLUMN_SEQ_NBR;
    		}
    		
		@Column(name = "TRANS_SEQ_NBR")
    	private String TRANS_SEQ_NBR;
    	
    	
    		public String getTRANS_SEQ_NBR() {
    			return TRANS_SEQ_NBR;
    		}
    	
    		public void setTRANS_SEQ_NBR(String TRANS_SEQ_NBR) {
    			this.TRANS_SEQ_NBR = TRANS_SEQ_NBR;
    		}
        		
		@Column(name = "COLUMN_ALIAS")
    	private String COLUMN_ALIAS;
    	
    	
    		public String getCOLUMN_ALIAS() {
    			return COLUMN_ALIAS;
    		}
    	
    		public void setCOLUMN_ALIAS(String COLUMN_ALIAS) {
    			this.COLUMN_ALIAS = COLUMN_ALIAS;
    		}
		@Column(name = "COLUMN_VAL_DATA_TYPE")
    	private String COLUMN_VAL_DATA_TYPE;
    	
    	
    		public String getCOLUMN_VAL_DATA_TYPE() {
    			return COLUMN_VAL_DATA_TYPE;
    		}
    	
    		public void setCOLUMN_VAL_DATA_TYPE(String COLUMN_VAL_DATA_TYPE) {
    			this.COLUMN_VAL_DATA_TYPE = COLUMN_VAL_DATA_TYPE;
    		}
		@Column(name = "COLUMN_ORDER")
    	private Integer COLUMN_ORDER;
    	
    	
    		public Integer getCOLUMN_ORDER() {
    			return COLUMN_ORDER;
    		}
    	
    		public void setCOLUMN_ORDER(Integer COLUMN_ORDER) {
    			this.COLUMN_ORDER = COLUMN_ORDER;
    		}
		@Column(name = "COLUMN_VALUE")
    	private String COLUMN_VALUE;
    	
    	
    		public String getCOLUMN_VALUE() {
    			return COLUMN_VALUE;
    		}
    	
    		public void setCOLUMN_VALUE(String COLUMN_VALUE) {
    			this.COLUMN_VALUE = COLUMN_VALUE;
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
