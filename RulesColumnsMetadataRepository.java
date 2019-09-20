package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cvs.rules.model.RulesColumnsMetadata;

@Service
	public interface RulesColumnsMetadataRepository extends JpaRepository<RulesColumnsMetadata, Long> {

	@Query(value="\r\n"+"select distinct owner from all_tab_cols", nativeQuery=true)
//	@Query(value="\r\n"+" select distinct owner from (select owner, table_name, column_name from all_tab_cols)", nativeQuery=true) 
		Collection<RulesColumnsMetadata> findOwners();
	
	
	@Query(value="\r\n"+"select distinct table_name from all_tab_cols where owner=?1", nativeQuery=true)
		Collection<RulesColumnsMetadata> findOwnersTables(String owner);

	@Query(value="\r\n"+"select column_name from all_tab_cols where owner=?1 and table_name=?2", nativeQuery=true)
		Collection<RulesColumnsMetadata> findOwnersTablesColumns(String owner, String table_owner);
	
}
