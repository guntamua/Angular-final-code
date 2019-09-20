package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.RulesMaster;
import com.cvs.rules.model.RulesMasterColXref;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesMasterColXrefRepository extends JpaRepository<RulesMasterColXref, Long>  {	
	
//			@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	@Query(value="select MASTER_SEQ_NBR   ,COLUMN_SEQ_NBR, COLUMN_VALUE, COLUMN_ALIAS, TRANS_SEQ_NBR, 1 as COLUMN_ORDER, 1 as group_ind,' ' as rule_col_seq_nbr "
			+ " from RULES_OUTPUT_COL_XREF", nativeQuery=true) 
		List<RulesMasterColXref> findAllRulesMasterColXref();
	
	@Query(value="call SP_RULES_ADD_MASTER_COL_XREF(?1,?2,?3,?4,$5,$6,$7)", nativeQuery=true)
		void postRulesMasterColXrefSchema(String MASTER_SEQ_NBR,String  ID,String  TXT,String  ALIAS, Integer ORDER_BY, Integer GROUP_BY, Integer COLUMN_ORDER
				);
	
	@Query(value="call SP_RULES_DEL_MASTER_COL_XREF(?1)", nativeQuery=true)
	void postDelMasterColXrefSchema(String MASTER_SEQ_NBR);

			//List <RulesJoin> SaveJoins();
}
