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
import com.cvs.rules.model.RulesMasterTabXref;
import com.cvs.rules.model.RulesOrderGroupByXref;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesOrderGroupByXrefRepository extends JpaRepository<RulesOrderGroupByXref, Long>  {	
	
//			@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	
	@Query(value="select MASTER_SEQ_NBR   from RULE_ORDER_GROUP_BY_XREF", nativeQuery=true) 
		List<RulesOrderGroupByXref> findAllRulesOrderGroupByXref();
	
	@Query(value="call SP_RULES_DEL_MASTER_ORD_GRP_BY(?1)", nativeQuery=true)
		void postDelRulesOrderGroupByXrefSchema(String MASTER_SEQ_NBR);
	
	@Query(value="call SP_RULES_DEL_MASTER_TAB_XREF(?1)", nativeQuery=true)
	void postPredicatesUpdSchema(String MASTER_SEQ_NBR);

			//List <RulesJoin> SaveJoins();
}
