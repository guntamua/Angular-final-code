package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cvs.rules.model.ListSchema;
import com.cvs.rules.model.TableColumnXref;

//additional content 
@CrossOrigin(origins = "http://localhost:4200")
@Repository


@Service
public interface TableColumnXrefRepository extends JpaRepository<TableColumnXref, Long>  {	
	
	@Query(value="select column_seq_nbr from C093854.rules_table_column_xref", nativeQuery=true)
	Collection <TableColumnXref> findColumn_Seq_Nbr();
	
	@Query(value="select column_seq_nbr from C093854.rules_table_column_xref where table_seq_nbr =?1", nativeQuery=true)
	List <TableColumnXref>findTable_Seq_Nbr();

}