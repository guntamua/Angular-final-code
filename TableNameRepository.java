package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.PostMethod;
import com.cvs.rules.model.RulesColumns;
import com.cvs.rules.model.RulesEngine;
//import com.cvs.rules.model.TableNameList;

import com.cvs.rules.model.TableName;

//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

@Service
public interface TableNameRepository extends JpaRepository<TableName, Long>  {	
	
	List<TableName> findByOwner(String owner_name);

//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{	
	@Query(value="select table_name from C093854.rules_all_tables", nativeQuery=true)
	
	Collection<TableName> findAllTableName();

	
	@Query(value="select distinct  owner, table_name from all_tables where "
			+ "owner=?1 order by table_name", nativeQuery=true)
	Collection<TableName> findTableForOwner(String owner);


//	@Query(value="\r\n" + 
//			"	SELECT distinct owner,  owner||'.'||table_name as table_name from C093854."
//			+ "rules_all_tables where table_name not like 'TMP%'", nativeQuery=true)
//	List <TableName> findOwnerTable();
//	
	@Query(value="\r\n" + 
			"	SELECT distinct owner,  owner||'.'||table_name as table_name from C093854."
			+ "rules_all_tables where table_name not like 'TMP%' order by table_name", nativeQuery=true)
	List <TableName> findOwnerTable();
	
	
}