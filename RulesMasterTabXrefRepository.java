package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.RulesMasterTabXref;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesMasterTabXrefRepository extends JpaRepository<RulesMasterTabXref, Long>  {	
	
//			@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	
	@Query(value="select MASTER_SEQ_NBR   ,tab_seq_nbr, tab_order from rules_master_tab_xref", nativeQuery=true) 
		List<RulesMasterTabXref> findAllRulesMasterTabXref();
	
	@Query(value="call SP_RULES_ADD_MASTER_tab_xref(?1,?2,?3)", nativeQuery=true)
		void postRulesMasterTabXrefSchema(String MASTER_SEQ_NBR,String  TAB_SEQ_NBR ,Integer  TAB_ORDER );
	
	@Query(value="call SP_RULES_DEL_MASTER_TAB_XREF(?1)", nativeQuery=true)
	void postRulesMasterTabDelXrefSchema(String MASTER_SEQ_NBR);

			//List <RulesJoin> SaveJoins();
}
