package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.cvs.rules.model.RulesTransformations;



//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository

//@Repository
//public interface RulesEngineRepository extends CrudRepository<RulesEngine, Long>{}

@Service
	public interface RulesTransformRepository extends JpaRepository<RulesTransformations, Long>  {	
	
//	@Query(value="select join_seq_nbr, col1_seq_nbr, cols2_seq_nbr, join_descr, join_typ from C093854.rules_rel_join", nativeQuery=true)
	
	
	@Query(value="select TRANSFORM_SEQ_NBR, SUBJECT_AREA_SEQ_NBR, TRANSFORM_RAW_CODE, TRANS_DATA_TYPE, DESCRIPTION from C093854.rules_transform order by TRANSFORM_SEQ_NBR", nativeQuery=true) 
		List<RulesTransformations> findAllTransformations();
	

	@Query(value="select \r\n" + 
			"       transform_raw_code,\r\n" + 
			"       subject_area_seq_nbr\r\n" + 
			"  from rules_transform a, \r\n" + 
			"       rules_transform_col_xref b \r\n" + 
			" where a.transform_seq_nbr = b.transform_seq_nbr\r\n" + 
			"   and b.col_seq_nbr in ( select column_seq_nbr from rules_table_col_xref where table_seq_nbr in (?1,?2))", nativeQuery=true) 
		List<RulesTransformations> findAllTransformationsForColumns(String tableSeqNbr1, String tableSeqNbr2);
	
	@Query(value="call SP_RULES_ADD_TRANSFORMATION(?1,?2,?3,?4)", nativeQuery=true)
		void postTransformSchema(String TRANSFORM_RAW_CODE, String DESCRIPTION, String SUBJECT_AREA_SEQ_NBR, String TRANS_DATA_TYPE );

	@Query(value="call SP_RULES_UPD_TRANSFORMATION1(?1,?2,?3,?4,?5)", nativeQuery=true)
	void postUpdateTransformSchema(String TRANSFORM_SEQ_NBR, String TRANSFORM_RAW_CODE, String DESCRIPTION,  String SUBJECT_AREA_SEQ_NBR, String TRANS_DATA_TYPE);

	@Query(value="call SP_Get_Full_SQL_Transform(?1,?2)", nativeQuery=true)
	void postNestedTransform(String TransSeqNbr, String Owner);
}

