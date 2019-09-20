package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.RulesJoinXref;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesJoinXrefRepository extends JpaRepository<RulesJoinXref, Long>  {	
	
			@Query(value="select table1_seq_nbr, table2_seq_nbr, join_seq_nbr, join_typ from C093854.rules_tab_rel_join_xref order by table1_seq_nbr", nativeQuery=true)
				List<RulesJoinXref> findAllJoinXref();
			@Query(value="call SP_RULES_ADD_JOIN_TAB_XREF(?1,?2,?3,?4)", nativeQuery=true)
			void postJoinXrefSchema(String join_seq_nbr, String table1_seq_nbr,String  table2_seq_nbr, String  join_typ);
			@Query(value="call SP_RULES_DELETE_JOIN_TAB(?1,?2,?3)", nativeQuery=true)
			void deleteJoinXrefSchema(String table1_seq_nbr, String  table2_seq_nbr,String  join_typ);
			
			//List <RulesJoin> SaveJoins();
}