package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.cvs.rules.model.RulesJoin;


//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesJoinRepository extends JpaRepository<RulesJoin, Long>  {	
	
	//@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, '1' as column_name1, '1' as column_name2, '1' as join_condition, '1' as table1_seq_nbr, '1' as table2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true) 
		List<RulesJoin> findAllJoins(); 

	
//	@Query(value="select join_seq_nbr, col1_seq_nbr, column_name1, cols2_seq_nbr, column_name2, table1_seq_nbr||'.'||column_name1||'='||table2_seq_nbr||'.'||column_name2 as join_condition, table1_seq_nbr, table2_seq_nbr, join_descr, join_typ from ("
//			+ "select rules_rel_join.join_seq_nbr, "
//			+ "(select table1_seq_nbr from rules_tab_rel_join_xref a where a.join_seq_nbr = rules_rel_join.join_seq_nbr and rownum=1) as table1_seq_nbr,  "
//			+ "(select table2_seq_nbr from rules_tab_rel_join_xref a where a.join_seq_nbr = rules_rel_join.join_seq_nbr and rownum=1) as table2_seq_nbr,"
//			+ "col1_seq_nbr, "
//			+ "(select column_name from rules_column_definition where column_seq_nbr = rules_rel_join.col1_seq_nbr) as column_name1, cols2_seq_nbr,"
//			+ "(select column_name from rules_column_definition where column_seq_nbr = cols2_seq_nbr) as column_name2,  join_descr, join_typ from rules_rel_join"
//			+ ") "
//			+ "where (table1_seq_nbr, table2_seq_nbr) in ((select table_seq_nbr from  rules_table_definitiion b where  "
//			+ "b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 )"
//			+ "union (select table_seq_nbr from  rules_table_definitiion b where "
//			+ "b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 )"
//			
//			, nativeQuery=true)
//			//List<RulesJoin> findAllSuggestedJoins( String table1_seq_nbr, String table2_seq_nbr);
	
	@Query(value="select join_seq_nbr, col1_seq_nbr, column_name1, cols2_seq_nbr, column_name2, table1_seq_nbr||'.'||column_name1||'='||table2_seq_nbr||'.'||column_name2 as join_condition,  "
			+ "table1_seq_nbr, table2_seq_nbr, join_descr, join_typ from (  "
			+ "select rules_rel_join.join_seq_nbr,"
			+ "(select table1_seq_nbr from rules_tab_rel_join_xref a where a.join_seq_nbr = rules_rel_join.join_seq_nbr and rownum=1) as table1_seq_nbr,"
			+ "(select table2_seq_nbr from rules_tab_rel_join_xref a where a.join_seq_nbr = rules_rel_join.join_seq_nbr and rownum=1) as table2_seq_nbr,"
			+ "col1_seq_nbr,"
			+ "(select column_name from rules_column_definition where column_seq_nbr = rules_rel_join.col1_seq_nbr) as column_name1, cols2_seq_nbr,"
			+ "(select column_name from rules_column_definition where column_seq_nbr = cols2_seq_nbr) as column_name2,  join_descr, join_typ from rules_rel_join"
			+ ") "
			+ "where "
            + "table1_seq_nbr in ("
            + "(select table_seq_nbr from  rules_table_definition b where "  
			+ "b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 ))" 
            + "union"
            + "(select table_seq_nbr from  rules_table_definition b where "
			+ "b.table_owner= substr(?2,1,(instr(?2,'.')-1)) and b.table_name = substr(?2, (instr(?2,'.'))+1, length(?2) -(instr(?2,'.')) + 1 ))"
			+ ")"
            + "and "
            + "table2_seq_nbr in ("
            + "(select table_seq_nbr from  rules_table_definition b where  "
			+ "b.table_owner= substr(?1,1,(instr(?1,'.')-1)) and b.table_name = substr(?1, (instr(?1,'.'))+1, length(?1) -(instr(?1,'.')) + 1 ))"
            + "union"
            + "(select table_seq_nbr from  rules_table_definition b where "
			+ "b.table_owner= substr(?2,1,(instr(?2,'.')-1)) and b.table_name = substr(?2, (instr(?2,'.'))+1, length(?2) -(instr(?2,'.')) + 1 )))"
			+ " or table1_seq_nbr is null or table2_seq_nbr is null"
			, nativeQuery=true)
	List<RulesJoin> findAllSuggestedJoins( String table1_seq_nbr, String table2_seq_nbr);

	@Query(value="call SP_RULES_ADD_NEW_JOIN_TAB(?1,?2,?3,?4,?5,?6)", nativeQuery=true)
		String postJoinSchema(String table1_seq_nbr,String  table2_seq_nbr,String  col1_seq_nbr,String  col2_seq_nbr, String join_descr, String join_typ);
	
			//List <RulesJoin> SaveJoins();
}
