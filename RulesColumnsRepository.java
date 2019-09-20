package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cvs.rules.model.RulesColumns;

@Service
	public interface RulesColumnsRepository extends JpaRepository <RulesColumns, Long>  {	  
	  
	@Query(value="select column_seq_nbr, column_name, column_desc, column_data_type from C093854.rules_column_definition order by column_name", nativeQuery=true)
	List <RulesColumns> findAllColumns();
	
	@Query(value="\r\n" + 
			"	SELECT rules_column_definition.column_seq_nbr, rules_column_definition.column_name as column_name"+
			"	,rules_column_definition.column_desc, rules_column_definition.column_data_type\r\n" + 
			"	FROM rules_column_definition,  rules_table_definition  b, rules_table_column_xref c \r\n" + 
			"	where b.table_owner = ?1 and b.table_name = ?2 and b.table_seq_nbr = c.table_seq_nbr\r\n" + 
			"   and c.column_seq_nbr = rules_column_definition.column_seq_nbr ", nativeQuery=true)
	
	Collection <RulesColumns> findColumnsForTable(String owner, String table);
	
		
	@Query(value="\r\n" + 
			"	SELECT rules_column_definition.column_seq_nbr, b.table_name ||'.'||rules_column_definition.column_name as column_name"+
			"	,rules_column_definition.column_desc, rules_column_definition.column_data_type\r\n" + 
			"	FROM rules_column_definition,  rules_table_definition  b, rules_table_column_xref c \r\n" + 
			"	where b.table_seq_nbr = c.table_seq_nbr\r\n" + 
			"   and c.column_seq_nbr = rules_column_definition.column_seq_nbr ", nativeQuery=true)
			Collection <RulesColumns> findColumnsTable();

	
	@Query(value="\r\n" + 
			"	SELECT rules_column_definition.column_seq_nbr, rules_column_definition.column_name as column_name"+
			"	,rules_column_definition.column_desc, rules_column_definition.column_data_type\r\n" + 
			"	FROM rules_column_definition,  rules_table_definition  b, rules_table_column_xref c \r\n" + 
			"	where b.table_seq_nbr= ?1 and b.table_seq_nbr = c.table_seq_nbr\r\n" + 
			"   and c.column_seq_nbr = rules_column_definition.column_seq_nbr ", nativeQuery=true)

			Collection<RulesColumns> findColumnsbyTable(String tableSeqNbr);
	
//owner.table used in joins screen 	
	@Query(value="\r\n"+
			"	SELECT rules_column_definition.column_seq_nbr, rules_column_definition.column_name as column_name\r\n" + 
			" 	,rules_column_definition.column_desc, rules_column_definition.column_data_type\r\n" + 
			" 	FROM rules_column_definition,  rules_table_definition  b, rules_table_column_xref c \r\n" + 
			" 	where \r\n"+
			"   b.table_seq_nbr = c.table_seq_nbr\r\n" +
			" 	and b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 )\r\n" + 
			" 	and c.column_seq_nbr = rules_column_definition.column_seq_nbr order by column_name", nativeQuery=true) 
	
			Collection <RulesColumns> findColumnsForOwnerTable(String owner);
	
//duplicate owner.table used in joins screen 
	@Query(value="\r\n"+
			"	SELECT rules_column_definition.column_seq_nbr, rules_column_definition.column_name as column_name\r\n" + 
			" 	,rules_column_definition.column_desc, rules_column_definition.column_data_type\r\n" + 
			" 	FROM rules_column_definition,  rules_table_definition  b, rules_table_column_xref c \r\n" + 
			" 	where \r\n"+
			"   b.table_seq_nbr = c.table_seq_nbr\r\n" +
			" 	and b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 )\r\n" + 
			" 	and c.column_seq_nbr = rules_column_definition.column_seq_nbr order by column_name", nativeQuery=true) 
	
			Collection<RulesColumns> findColumnsForOwnerTable2(String owner);
	

}
