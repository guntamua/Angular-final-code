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

import com.cvs.rules.model.RulesSubjectArea;


	@Service
	public interface RulesSubjectAreaRepository extends JpaRepository<RulesSubjectArea, Long>  {	  
		@Query(value="select SUBJECT_AREA_NBR, SUBJECT_AREA_DESCR from C093854.RULES_SUBJECT_AREA order by SUBJECT_AREA_DESCR", nativeQuery=true)
		List<RulesSubjectArea>findAllRulesSubjcetArea();


	
	}
