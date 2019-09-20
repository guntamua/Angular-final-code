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
import com.cvs.rules.model.RulesEngine;

@Service
public interface ListSchemaRepository extends JpaRepository<ListSchema, Long>  {	  
	@Query(value="select username from C093854.rules_all_users", nativeQuery=true)
	Collection<ListSchema>findAllSchema();

}
