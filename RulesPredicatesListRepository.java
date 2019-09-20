package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.RulesPredicatesList;

//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesPredicatesListRepository extends JpaRepository<RulesPredicatesList, Long>  {	
	
	
	@Query(value="select MASTER_SUB_SEQ_NBR, COL1_SEQ_NBR ,COL2_SEQ_NBR , OPERATOR_ID, COL2_VALUE_TXT, COL1_TRANS_SEQ_NBR, COL2_TRANS_SEQ_NBR, SUB_QUERY_RULE_SEQ_NBR, SUBJECT_AREA_NBR, DESCRIPTION , COND_CODE from C093854.rules_predicate_component order by MASTER_SUB_SEQ_NBR ", nativeQuery=true) 
		List<RulesPredicatesList> findAllPredicatesList();
}
