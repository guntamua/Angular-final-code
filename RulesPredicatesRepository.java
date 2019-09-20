package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.cvs.rules.model.RulesPredicates;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesPredicatesRepository extends JpaRepository<RulesPredicates, Long>  {	
	
//	@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	
	@Query(value="select MASTER_SUB_SEQ_NBR,'1' as COMP_SEQ_NBR, COL1_SEQ_NBR ,COL2_SEQ_NBR , OPERATOR_ID , COL2_VALUE_TXT , COL1_TRANS_SEQ_NBR , COL2_TRANS_SEQ_NBR ,   DESCRIPTION , COND_CODE from rules_predicate_component", nativeQuery=true) 
		List<RulesPredicates> findAllPredicates();
	
	@Query(value="select cond_code \r\n" + 
			"     from rules_predicate_component a, \r\n" + 
			"          rules_predicate_cmp_xref b \r\n" + 
			"    where a.master_sub_seq_nbr = b.master_sub_seq_nbr \r\n" + 
			"      and ?1 in (table_seq_nbr, table_seq_nbr2)\r\n" + 
			"      and ?2 in (table_seq_nbr, table_seq_nbr2)", nativeQuery=true) 
	List<RulesPredicates> findPredicatesbyTables(String tableSeqNbr1, String tableSeqNbr2);
	
	
	@Query(value="call SP_RULES_ADD_PRED_COMP(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery=true)
		void postPredicatesSchema(String COL1_SEQ_NBR, String  COL1_TRANS_SEQ_NBR, String  COL2_SEQ_NBR, String  COL2_TRANS_SEQ_NBR, String  COL2_VALUE_TXT, String  OPERATOR_ID, String  DESCRIPTION, String  COND_CODE);
	
//	@Query(value="call SP_RULES_UPD_PRED_COMP(?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery=true)
//		void postPredicatesUpdSchema(String COMP_SEQ_NBR, String COL1_SEQ_NBR, String  COL1_TRANS_SEQ_NBR, String  COL2_SEQ_NBR,String  COL2_TRANS_SEQ_NBR, String  COL2_VALUE_TXT, Integer  OPERATOR_ID,String  DESCRIPTION, String  COND_CODE);

	@Query(value="call SP_RULES_UPD_PRED_COMP(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery=true)
	void postPredicatesUpdSchema(String COL1_SEQ_NBR, String  COL1_TRANS_SEQ_NBR, String  COL2_SEQ_NBR,String  COL2_TRANS_SEQ_NBR, String  COL2_VALUE_TXT, String  OPERATOR_ID,String  DESCRIPTION, String  COND_CODE);

			
}
