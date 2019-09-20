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

import com.cvs.rules.model.RulesQualifier;
import com.cvs.rules.model.RulesTransformations;

	@Service
	public interface RulesQualifierRepository extends JpaRepository<RulesQualifier, Long>  {	  
		@Query(value="select QUALIFIER_SEQ_NBR, QUALIFIER_TXT from C093854.rules_qualifier order by QUALIFIER_SEQ_NBR", nativeQuery=true)
		List<RulesQualifier>findAllRulesQualifier();

	
	}
