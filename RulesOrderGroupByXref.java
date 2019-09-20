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
    @Table(name="RULE_ORDER_GROUP_BY_XREF")
    public class RulesOrderGroupByXref {

    	@Bean 
    	  ServletWebServerFactory servletWebServerFactory(){
    	  return new TomcatServletWebServerFactory();
    		}
    	public RulesOrderGroupByXref() {
    		
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
	
    		public String getMASTER_SEQ_NBR() {
    			return MASTER_SEQ_NBR;
    		}
    	 
    		public void setMASTER_SEQ_NBR(String MASTER_SEQ_NBR) {
    			this.MASTER_SEQ_NBR = MASTER_SEQ_NBR;
    		}
	    		
    	    	
    	/*@Override
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
