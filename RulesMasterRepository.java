package com.cvs.rules.repo;

import java.util.Collection;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cvs.rules.model.ListSchema;
import com.cvs.rules.model.RulesMaster;
import com.cvs.rules.model.RulesMasterTabXref;
import com.cvs.rules.model.RulesEngine;

	@Service
	public interface RulesMasterRepository extends JpaRepository<RulesMaster, Long>  {	
	
		@Query(value="select master_seq_nbr, description, statement_typ, target_table, target_temp_ind from C093854.rules_master order by target_table", nativeQuery=true)
			Collection<RulesMaster> findAllMasterRules();
		
		@Query(value="call SP_RULES_ADD_MASTER(?1,?2,?3,?4)", nativeQuery=true)
		void postRulesMasterSchema(String DESCRIPTION, String STATEMENT_TYP, String TARGET_TABLE, String TARGET_TEMP_IND);

	}
