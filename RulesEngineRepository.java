package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.cvs.rules.model.PostMethod;
import com.cvs.rules.model.RulesEngine;
//import com.cvs.rules.model.TableNameList;
import com.cvs.rules.model.RulesJoin;
import com.cvs.rules.model.TableName;

//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesEngineRepository extends JpaRepository<RulesEngine, Long>  {	
	//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{
	
	RulesEngine rulesEngine = new RulesEngine();
	PostMethod postMethod = new PostMethod();
		
		@Query(value="select table_seq_nbr, table_owner, table_desc, table_size_cd, table_prefix_name, table_typ, table_name from C093854.rules_table_definition order by table_owner", nativeQuery=true)
			List <RulesEngine> findAllTables();
		
		@Query(value="select table_seq_nbr, table_owner, table_owner||'.'|| table_name as table_name, table_desc, table_size_cd, table_prefix_name, table_typ from C093854.rules_table_definition order by table_name", nativeQuery=true)
		List <RulesEngine> findAllOwnerTablesList();
				
		@Query(value="select table_seq_nbr, table_owner, table_desc, table_size_cd, table_prefix_name, table_typ, table_name from rules_table_definition where table_owner= ?1", nativeQuery=true)
			List <RulesEngine> findAllTablesForOwner(String userName);
		
		@Query(value="select username from C093854.rules_all_users", nativeQuery=true)
			List <RulesEngine> findAllSchema();
		
		//String table_name= rulesEngine.gettable_name();
		String table_desc = rulesEngine.gettable_desc();
		String table_owner = rulesEngine.gettable_owner();
		String table_prefix = rulesEngine.gettable_prefix_name();
		String table_size_cd = rulesEngine.gettable_size_cd();
		String table_typ = rulesEngine.gettable_typ();
			
		@Query(value="call sp_rules_add_table(?1,?2,?3,?4,?5,?6)", nativeQuery=true)
		void postTabSchema(String table_name, String  table_desc,String  table_owner,String  table_size_cd, String  table_prefix, String  table_type);
	    
		@Query(value="call sp_rules_add_columns(?1,?2)", nativeQuery=true)
		String postColSchema(String table_owner,String  table_name);
		
		@Query(value="call sp_rules_add_tab_col_xref(?1,?2)", nativeQuery=true)
		String postXrefSchema(String table_owner,String  table_name);
		
		
		
		PostMethod save(PostMethod postmethod);
		
}