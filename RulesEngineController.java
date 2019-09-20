package com.cvs.rules.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cvs.rules.model.ListSchema;
import com.cvs.rules.model.RulesMaster;
import com.cvs.rules.model.PostMethod;
import com.cvs.rules.model.RulesColumns;
import com.cvs.rules.model.RulesColumnsMetadata;
import com.cvs.rules.model.RulesEngine;
import com.cvs.rules.model.RulesJoin;
import com.cvs.rules.model.RulesJoinXref;
import com.cvs.rules.model.RulesMasterColXref;
import com.cvs.rules.model.RulesMasterTabXref;
import com.cvs.rules.model.RulesOrderGroupByXref;
import com.cvs.rules.model.RulesPredicates;
import com.cvs.rules.model.RulesPredicatesList;
import com.cvs.rules.model.RulesQualifier;
import com.cvs.rules.model.RulesSubjectArea;
import com.cvs.rules.model.RulesTransformations;
import com.cvs.rules.model.TableColumnXref;
import com.cvs.rules.repo.ListSchemaRepository;
import com.cvs.rules.repo.RulesColumnsMetadataRepository;
import com.cvs.rules.repo.RulesColumnsRepository;
import com.cvs.rules.repo.RulesEngineRepository;
import com.cvs.rules.repo.RulesJoinRepository;
import com.cvs.rules.repo.RulesJoinXrefRepository;
import com.cvs.rules.repo.RulesMasterColXrefRepository;
import com.cvs.rules.repo.RulesMasterRepository;
import com.cvs.rules.repo.RulesMasterTabXrefRepository;
import com.cvs.rules.repo.RulesOrderGroupByXrefRepository;
import com.cvs.rules.repo.RulesPredicatesListRepository;
import com.cvs.rules.repo.RulesTransformRepository;
import com.cvs.rules.repo.TableColumnXrefRepository;
import com.cvs.rules.repo.TableNameRepository;
import com.cvs.rules.repo.RulesPredicatesRepository;
import com.cvs.rules.repo.RulesQualifierRepository;
import com.cvs.rules.repo.RulesSubjectAreaRepository;
import com.cvs.rules.model.TableName;


@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true", maxAge = 3600)
@RestController
//@RequestMapping({"/api"})

public class RulesEngineController implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/getTableNames")
        		.allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
              	.allowedOrigins("http:localhost:4200")
              	.allowedOrigins("http:localhost:51122")
        		.allowedHeaders("Content-Type")
        		.exposedHeaders("Content-Length")
        		.allowCredentials(true)
        		.maxAge(3600);
    }

//public class RulesEngineController {

	@Autowired
	RulesEngineRepository rulesEngineRepository;
	@Autowired
	RulesColumnsRepository rulesColumnsRepository;
	@Autowired
	ListSchemaRepository listSchemaRepository;
	@Autowired
	TableNameRepository tableNameRepository;
	@Autowired
	TableColumnXrefRepository tableColumnXrefRepository;
	@Autowired
	RulesJoinRepository rulesJoinRepository;
	@Autowired
	RulesColumnsMetadataRepository rulesColumnsMetadataRepository;
	@Autowired
	RulesJoinXrefRepository rulesJoinXrefRepository;
	@Autowired
	RulesTransformRepository rulesTransformRepository;
	@Autowired
	RulesPredicatesRepository rulesPredicatesRepository;
	@Autowired
	RulesPredicatesListRepository rulesPredicatesListRepository;
	@Autowired
	RulesQualifierRepository rulesQualifierRepository;
	@Autowired
	RulesMasterRepository rulesMasterRepository;
	@Autowired
	RulesMasterTabXrefRepository rulesMasterTabXrefRepository;
	@Autowired
	RulesMasterColXrefRepository rulesMasterColXrefRepository; 
	@Autowired
	RulesOrderGroupByXrefRepository rulesOrderGroupByXrefRepository;
	@Autowired 
	RulesSubjectAreaRepository rulesSubjectAreaRepository;
	
	
///////////////////////////////////////////////////////////services for the TABLE SCREEN //////////////////////////////////////////////////////////////
	
// table list form rules_table_definition	
	@GetMapping("/getTableNames")
	public List<RulesEngine> getTableNames() {
		Collection<RulesEngine> rulesengine = rulesEngineRepository.findAllTables();
				List<RulesEngine> rulesEngineList = new ArrayList<RulesEngine>();
				rulesEngineList.addAll(rulesengine);
				return rulesEngineList;
	}
	
//table list of owners
	@GetMapping("/listSchema")
	public List<ListSchema> getListSchema(){
		Collection<ListSchema> listschema = listSchemaRepository.findAllSchema();
			List<ListSchema> rulesListSchema = new ArrayList<ListSchema>();
				rulesListSchema.addAll(listschema);
				return rulesListSchema;
	}

//table name from rules_all_tables
	@GetMapping("/tableName")
	public List<TableName> getTableName(){
		System.out.println("Calling the tableName method");
		Collection<TableName> tablename = tableNameRepository.findAllTableName();
			List<TableName> rulestablename = new ArrayList<TableName>();
			rulestablename.addAll(tablename);
			return rulestablename;
	}
// sorts tables with given table owner 
	@GetMapping("/getTableNamebyOwner/{table_owner}")
	public List <TableName> getTableNamebyOwner( @PathVariable String table_owner){
		System.out.println("Calling the inside tableName method");
		Collection<TableName> tableowner = tableNameRepository.findTableForOwner(table_owner);
		//List<TableName> tableowner = tableNameRepository.findByOwner(table_owner);
		System.out.println("sgfs" +tableowner);
		List<TableName> rulestableowner = new ArrayList<TableName>();
		rulestableowner.addAll(tableowner);
		return rulestableowner;
	}



//////////////////////////////////////////////////////////COLUMNS SCREEN ////////////////////////////////////////////////////////

// calls owners data from metadata 	
	@GetMapping("/getAllOwners")
	public List <RulesColumnsMetadata> getallOwners() {
		Collection<RulesColumnsMetadata> rulesColumnsMetadata = rulesColumnsMetadataRepository.findOwners();
				List<RulesColumnsMetadata> rulesColumnsList = new ArrayList<RulesColumnsMetadata>();
				rulesColumnsList.addAll(rulesColumnsMetadata);
				return rulesColumnsList;
	}
// calls tables related to owner data from metadata	 not working
//	@GetMapping("/getAllOwnersTables/{owner}")
//	public List <RulesColumnsMetadata> getallOwnersTables(@PathVariable String owner) {
//		Collection<RulesColumnsMetadata> rulesColumnsMetadata = rulesColumnsMetadataRepository.findOwnersTables(owner);
//				List<RulesColumnsMetadata> rulesColumnsList = new ArrayList<RulesColumnsMetadata>();
//				rulesColumnsList.addAll(rulesColumnsMetadata);
//				return rulesColumnsList;
//	}
// calls columns related to tables from data from metadata	not working 
//	@GetMapping("/getAllOwnersTablesColumns/{owner}/{table_owner}")
//	public List <RulesColumnsMetadata> getallOwnersTablesColumns(@PathVariable String owner, String table_owner) {
//		Collection<RulesColumnsMetadata> rulesColumnsMetadata = rulesColumnsMetadataRepository.findOwnersTablesColumns(owner, table_owner);
//				List<RulesColumnsMetadata> rulesColumnsList = new ArrayList<RulesColumnsMetadata>();
//				rulesColumnsList.addAll(rulesColumnsMetadata);
//				return rulesColumnsList;
//	}

//will display rules_column_definition list
	@GetMapping("/getAllColumns")
	public List <RulesColumns> getColumns() {
		Collection<RulesColumns> rulesColumns = rulesColumnsRepository.findAllColumns();
				List<RulesColumns> rulesColumnsList = new ArrayList<RulesColumns>();
				rulesColumnsList.addAll(rulesColumns);
				return rulesColumnsList;
	}

//will display table.column list 
	@GetMapping("/getAllColumnsTable")
	public List <RulesColumns> getColumnsTable() {
		Collection<RulesColumns> rulesColumns = rulesColumnsRepository.findColumnsTable();
				List<RulesColumns> rulesColumnsList = new ArrayList<RulesColumns>();
				rulesColumnsList.addAll(rulesColumns);
				return rulesColumnsList;
	}

//will display columns list when a owner and table_name is given from rules_all_table using params 
	@GetMapping(path="/getAllColumnDetails")
	public List <RulesColumns> getColumnNames(@RequestParam String owner,@RequestParam String table_name) {
		Collection<RulesColumns> rulesColumns = rulesColumnsRepository.findColumnsForTable(owner, table_name);
		System.out.println("sgfs" +owner + table_name);
		List<RulesColumns> rulesColumnsList = new ArrayList<RulesColumns>();
		rulesColumnsList.addAll(rulesColumns);
		return rulesColumnsList;
	}  
	
//Columns screen refresh button 

	@PostMapping(value = "/colRefresh", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postrulesColumns(@RequestBody RulesEngine postmethod) {
		
		String table_owner =postmethod.gettable_owner();
		String table_name = postmethod.gettable_name();
		//String column_data_type = postmethod.getcolumn_data_type();	
			System.out.println("column refresh working");
			rulesEngineRepository.postColSchema(table_owner, table_name);
			return "done";
	}

//////////////////////////////////////////////////////////////////////JOINS SCREEN //////////////////////////////////////////////////////////////////////
	
//get joins table list 	
	@GetMapping(path="/getAllJoins", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<RulesJoin> getAllJoins() {
		Collection<RulesJoin> rulesjoin = rulesJoinRepository.findAllJoins();
				List<RulesJoin> rulesEngineList = new ArrayList<RulesJoin>();
				rulesEngineList.addAll(rulesjoin);
				return rulesEngineList;
	}
	
//get joins table Xref list 	
	@GetMapping(path="/getAllJoinsXref", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<RulesJoinXref> getAllJoinsXref() {
		Collection<RulesJoinXref> rulesjoin = rulesJoinXrefRepository.findAllJoinXref();
				List<RulesJoinXref> rulesEngineList = new ArrayList<RulesJoinXref>();
				rulesEngineList.addAll(rulesjoin);
				return rulesEngineList;
	}

// get suggested joins list params list 
	@GetMapping(path="/getAllSuggestedJoins")
	public List <RulesJoin> findAllSuggestedJoins(@RequestParam String owner, @RequestParam String owner2) {
		Collection<RulesJoin> rulesJoins = rulesJoinRepository.findAllSuggestedJoins(owner, owner2);
		System.out.println("sgfs" +rulesJoins);
		List<RulesJoin> rulesColumnsList = new ArrayList<RulesJoin>();
		rulesColumnsList.addAll(rulesJoins);
		return rulesColumnsList;
	}    

//will display columns list when a owner and table_name is given from rules_all_table  // display columns for owner.table	
	@GetMapping(path="/getAllColumnsForTable/{owner}")
	public List <RulesColumns> getColumnForTables(@PathVariable String owner) {
		Collection<RulesColumns> rulesColumns = rulesColumnsRepository.findColumnsForOwnerTable(owner);
		List<RulesColumns> rulesColumnsList = new ArrayList<RulesColumns>();
		rulesColumnsList.addAll(rulesColumns);
		return rulesColumnsList;
	} 
//duplicate used in joins screen to display columns for owner.table		
	@GetMapping(path="/getAllColumnsForTable2/{owner}")
	public List <RulesColumns> getColumnForTables2(@PathVariable String owner) {
		Collection<RulesColumns> rulesColumns = rulesColumnsRepository.findColumnsForOwnerTable2(owner);
		List<RulesColumns> rulesColumnsList = new ArrayList<RulesColumns>();
		rulesColumnsList.addAll(rulesColumns);
		return rulesColumnsList;
	} 
		
//will display owner.table list 
		@GetMapping("/getOwnerTable")
		public List <TableName> getOwnerTable( ){
			System.out.println("Calling the inside tableName method");
			List<TableName> tableowner = tableNameRepository.findOwnerTable();
			System.out.println("sgfs" +tableowner);
			List<TableName> rulestableowner = new ArrayList<TableName>();
			rulestableowner.addAll(tableowner);
			return tableowner;
		}
	
//will display owner.table, table_seq_nbr - called for Join screen table list - table_name, table_seq_nbr 
		@GetMapping("/getAllOwnerTableList")
		public List <RulesEngine> getAllOwnerTable( ){
			System.out.println("Calling the inside tableName method");
			List<RulesEngine> tableowner = rulesEngineRepository.findAllOwnerTablesList();
			System.out.println("sgfs" +tableowner);
			List<RulesEngine> rulestableowner = new ArrayList<RulesEngine>();
			rulestableowner.addAll(tableowner);
			return tableowner;
		}
		
///////////////////////////////////////////////////////////////////Transformations////////////////////////////////////////////////////////////////////////
		
		@GetMapping(value= "/getAllTransformations", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesTransformations> getAllTransformations() {
			Collection<RulesTransformations> rulestransformations = rulesTransformRepository.findAllTransformations();
					List<RulesTransformations> rulestransformationsList = new ArrayList<RulesTransformations>();
					rulestransformationsList.addAll(rulestransformations);
					return rulestransformationsList;
		}
		
// final page 
		
		@GetMapping(value= "/getTransformationsForColumns/{tableSeqNbr1}/{tableSeqNbr2}", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesTransformations> getTransformationsForColumns(@PathVariable String tableSeqNbr1, @PathVariable String tableSeqNbr2) {
			Collection<RulesTransformations> rulestransformations = rulesTransformRepository.findAllTransformationsForColumns(tableSeqNbr1, tableSeqNbr2);
					List<RulesTransformations> rulestransformationsList = new ArrayList<RulesTransformations>();
					rulestransformationsList.addAll(rulestransformations);
					return rulestransformationsList;
		}
		
		@GetMapping(value= "/getRulesForTables/{tableSeqNbr1}/{tableSeqNbr2}", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesPredicates> getRulesForTables(@PathVariable String tableSeqNbr1, @PathVariable String tableSeqNbr2) {
			Collection<RulesPredicates> rulespredicates = rulesPredicatesRepository.findPredicatesbyTables(tableSeqNbr1, tableSeqNbr2);
					List<RulesPredicates> rulestransformationsList = new ArrayList<RulesPredicates>();
					rulestransformationsList.addAll(rulespredicates);
					return rulestransformationsList;
		}
		
////////////////////////////////////////////////////////////////////Rules Screen///////////////////////////////////////////////////////////////////////////
		
		@GetMapping(value= "/getAllRulesSubjectArea", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesSubjectArea> getAllRulesSubjectArea() {
			Collection<RulesSubjectArea> rulessubjectarea = rulesSubjectAreaRepository.findAllRulesSubjcetArea();
					List<RulesSubjectArea> rulessubjectareaList = new ArrayList<RulesSubjectArea>();
					rulessubjectareaList.addAll(rulessubjectarea);
					return rulessubjectareaList;
		}
			
		@GetMapping(value= "/getAllRulesQualifier", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesQualifier> getAllRulesQualifier() {
			Collection<RulesQualifier> rulesqualifier = rulesQualifierRepository.findAllRulesQualifier();
					List<RulesQualifier> rulesqualifierList = new ArrayList<RulesQualifier>();
					rulesqualifierList.addAll(rulesqualifier);
					return rulesqualifierList;
		}
		
		@GetMapping(value= "/getAllPredicatesList", produces = {MediaType.APPLICATION_JSON_VALUE})
		public List<RulesPredicatesList> getAllPredicatesList() {
			Collection<RulesPredicatesList> rulespredictaes = rulesPredicatesListRepository.findAllPredicatesList();
					List<RulesPredicatesList> rulespredicatesList = new ArrayList<RulesPredicatesList>();
					rulespredicatesList.addAll(rulespredictaes);
					return rulespredicatesList;
		}

////////////////////////////////////////////////////////////////////RulesMaster Screen/////////////////////////////////////////////////////////////////////
		
		@GetMapping(value ="/getAllMasterRulesList", produces = {MediaType.APPLICATION_JSON_VALUE})
			public List<RulesMaster> getAllMasterRules(){
				Collection<RulesMaster> masterrules = rulesMasterRepository.findAllMasterRules();
					List<RulesMaster> masterrulesList = new ArrayList<RulesMaster>();
					masterrulesList.addAll(masterrules);
					return masterrulesList;
			
		}
		
/////////////////////////////////////////////////////////////////////////POSTMETHODS/////////////////////////////////////////////////////////////////////////////

//tables screen add data 
		
	@PostMapping(value = "/saveTable", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postrulesEngine(@RequestBody PostMethod postmethod) {
		
		String table_name =postmethod.gettable_name();
		String table_desc = postmethod.gettable_desc();
		String table_owner = postmethod.gettable_owner();	
		String table_size_cd = postmethod.gettable_size_cd();
		String table_alias = postmethod.gettable_prefix_name();
		String table_typ = postmethod.gettable_typ();
		
		System.out.println("save table working");
		rulesEngineRepository.postTabSchema(table_owner, table_name, table_desc, table_size_cd,  table_alias,  table_typ);
		rulesEngineRepository.postColSchema(table_owner, table_name);
		rulesEngineRepository.postXrefSchema(table_owner, table_name);
		return "done";
	    //return rulesEngineRepository.save(postmethod);
	    //return rulesEngineRepository.saveTable();
	}



// Join screen - called from Add Join for Xref
	@PostMapping(value = "/saveJoinXref", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postJoinXrefEngine(@RequestBody RulesJoinXref rulesjoinxref) {
		
		String table1_seq_nbr =rulesjoinxref.gettable1_seq_nbr();
		String table2_seq_nbr = rulesjoinxref.gettable2_seq_nbr();
		String join_seq_nbr = rulesjoinxref.getjoin_seq_nbr();	
		String join_typ = rulesjoinxref.getjoin_typ();
		
		System.out.println("save join xrefschema working");
		rulesJoinXrefRepository.postJoinXrefSchema(join_seq_nbr, table1_seq_nbr, table2_seq_nbr,  join_typ);
		return "done";
	}
	
// Join screen - called from delete Join for Xref
	
	//@PostMapping(value = "/deleteJoinXref", produces = {MediaType.APPLICATION_JSON_VALUE})
//	@PostMapping(value = "/deleteJoinXref")
//	public String deleteJoinXrefEngine(@RequestBody RulesJoinXref rulesjoinxref) {
//		
//		String table1_seq_nbr =rulesjoinxref.gettable1_seq_nbr();
//		String table2_seq_nbr = rulesjoinxref.gettable2_seq_nbr();
//		String join_seq_nbr = rulesjoinxref.getjoin_seq_nbr();
//		String join_typ = rulesjoinxref.getjoin_typ();
//		
//		System.out.println("delete join xrefschema working");
//		rulesJoinXrefRepository.deleteJoinXrefSchema( table1_seq_nbr, table2_seq_nbr, join_typ);
//		return "done";
//	}
	
	RulesJoin a = new RulesJoin();
	//@PostMapping(value = "/deleteJoinXref", produces = {MediaType.APPLICATION_JSON_VALUE})
		@PostMapping(value = "/deleteJoinXref")
		public String deleteJoinXrefEngine(@RequestBody  RulesJoin rulesjoinxref) {
			
			String table1_seq_nbr =rulesjoinxref.gettable1_seq_nbr();
			String table2_seq_nbr = rulesjoinxref.gettable2_seq_nbr();
			String join_seq_nbr = rulesjoinxref.getjoin_seq_nbr();
			String join_typ = rulesjoinxref.getjoin_typ();
			
			System.out.println("delete join xrefschema working" + table1_seq_nbr+table2_seq_nbr);
			rulesJoinXrefRepository.deleteJoinXrefSchema( table1_seq_nbr, table2_seq_nbr, join_typ);
			return "done";
		}
	
// Join screen - called from Add Join
	
	@PostMapping(value = "/saveJoins", produces = {MediaType.APPLICATION_JSON_VALUE})
	public void postJoinEngine(@RequestBody RulesJoin rulesjoin) {
		
		String table1_seq_nbr =rulesjoin.gettable1_seq_nbr();
		String table2_seq_nbr = rulesjoin.gettable2_seq_nbr();
		String col1_seq_nbr = rulesjoin.getcol1_seq_nbr();	
		String cols2_seq_nbr = rulesjoin.getcols2_seq_nbr();
		String join_descr = rulesjoin.getjoin_descr();
		String join_typ = rulesjoin.getjoin_typ();
		
		System.out.println(table1_seq_nbr +'|'+ table2_seq_nbr+'|'+col1_seq_nbr +'|'+ cols2_seq_nbr +'|'+ join_descr +'|'+ join_typ);
		rulesJoinRepository.postJoinSchema(table1_seq_nbr, table2_seq_nbr, col1_seq_nbr, cols2_seq_nbr,  join_descr,  join_typ);
//		return "done";
		
//		System.out.println(col1_seq_nbr +'|'+ cols2_seq_nbr +'|'+ join_descr +'|'+ join_typ);
//		rulesJoinRepository.postJoinSchema( col1_seq_nbr, cols2_seq_nbr,  join_descr,  join_typ);
//		return "done";
	}
	

		
// Transform screen - called from Add transformations
		
	@PostMapping(value = "/saveTransforms", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postTransformSchema(@RequestBody RulesTransformations rulestransformations) {
		
//		String TRANSFORM_CODE =rulestransformations.getTRANSFORM_CODE();
		String DESCRIPTION = rulestransformations.getDESCRIPTION();	
		String SUBJECT_AREA_SEQ_NBR = rulestransformations.getSUBJECT_AREA_SEQ_NBR();
		String TRANSFORM_RAW_CODE = rulestransformations.getTRANSFORM_RAW_CODE();
		String TRANS_DATA_TYPE = rulestransformations.getTRANS_DATA_TYPE();
				
		//rulesTransformRepository.postTransformSchema(TRANSFORM_CODE, TRANSFORM_RAW_CODE, DESCRIPTION, SUBJECT_AREA_SEQ_NBR,  TRANS_DATA_TYPE);
		rulesTransformRepository.postTransformSchema(TRANSFORM_RAW_CODE, DESCRIPTION , SUBJECT_AREA_SEQ_NBR, TRANS_DATA_TYPE );
		return "done";
	    
	}
		
	@PostMapping(value = "/updTransforms", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postUpdTransformSchema(@RequestBody RulesTransformations rulestransformations) {
		
		String TRANSFORM_SEQ_NBR=rulestransformations.getTRANSFORM_SEQ_NBR();
		String DESCRIPTION = rulestransformations.getDESCRIPTION();	
		String SUBJECT_AREA_SEQ_NBR = rulestransformations.getSUBJECT_AREA_SEQ_NBR();
		String TRANSFORM_RAW_CODE = rulestransformations.getTRANSFORM_RAW_CODE();
		String TRANS_DATA_TYPE = rulestransformations.getTRANS_DATA_TYPE();
		
		rulesTransformRepository.postUpdateTransformSchema(TRANSFORM_SEQ_NBR, TRANSFORM_RAW_CODE, DESCRIPTION, SUBJECT_AREA_SEQ_NBR,TRANS_DATA_TYPE);
		
		return "done";
	    
	}
	
	// nested transform 
//	@PostMapping(value="/nestedTransform", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public String postNestedTransform(@RequestBody RulesTransformations rulestransformations) {
//		
//		String TransSeqNbr = rulestransformations.getTransSeqNbr();
//		String Owner = rulestransformations.getOwner();
//		
//		rulesTransformRepository.postNestedTransform(TransSeqNbr, Owner);
//		return "done";
//	}

// Rules screen post methods  	
	@PostMapping(value = "/savePredicates", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postPredicatesSchema(@RequestBody RulesPredicates rulespredicates) {
		
		//String MASTER_SUB_SEQ_NBR =rulespredicates.getMASTER_SUB_SEQ_NBR();
		String COL1_SEQ_NBR = rulespredicates.getCOL1_SEQ_NBR();
		String DESCRIPTION = rulespredicates.getDESCRIPTION();	
		String COL2_SEQ_NBR = rulespredicates.getCOL2_SEQ_NBR();
		String OPERATOR_ID = rulespredicates.getOPERATOR_ID();
		String COL2_VALUE_TXT = rulespredicates.getCOL2_VALUE_TXT();
		String COL1_TRANS_SEQ_NBR = rulespredicates.getCOL1_TRANS_SEQ_NBR();
		String COL2_TRANS_SEQ_NBR = rulespredicates.getCOL2_TRANS_SEQ_NBR();
		String COND_CODE = rulespredicates.getCOND_CODE();
		
		rulesPredicatesRepository.postPredicatesSchema( COL1_SEQ_NBR,  COL1_TRANS_SEQ_NBR,  COL2_SEQ_NBR,  COL2_TRANS_SEQ_NBR, COL2_VALUE_TXT, OPERATOR_ID,  DESCRIPTION,  COND_CODE);
		return "done";
	    
	}
	
//rules screen post methods
	
	@PostMapping(value = "/updPredicates", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postPredicatesUpdSchema(@RequestBody RulesPredicates rulespredicates) {
		
		//String COMP_SEQ_NBR= rulespredicates.getCOMP_SEQ_NBR();
		String MASTER_SUB_SEQ_NBR =rulespredicates.getMASTER_SUB_SEQ_NBR();
		String COL1_SEQ_NBR = rulespredicates.getCOL1_SEQ_NBR();
		String DESCRIPTION = rulespredicates.getDESCRIPTION();	
		String COL2_SEQ_NBR = rulespredicates.getCOL2_SEQ_NBR();
		String OPERATOR_ID = rulespredicates.getOPERATOR_ID();
		String COL2_VALUE_TXT = rulespredicates.getCOL2_VALUE_TXT();
		String COL1_TRANS_SEQ_NBR = rulespredicates.getCOL1_TRANS_SEQ_NBR();
		String COL2_TRANS_SEQ_NBR = rulespredicates.getCOL2_TRANS_SEQ_NBR();
		String COND_CODE = rulespredicates.getCOND_CODE();
		
		rulesPredicatesRepository.postPredicatesUpdSchema( COL1_SEQ_NBR,  COL1_TRANS_SEQ_NBR,  COL2_SEQ_NBR,  COL2_TRANS_SEQ_NBR,   COL2_VALUE_TXT, OPERATOR_ID,  DESCRIPTION,   COND_CODE);
		return "done";
	    
	}
	
/////////////////////////////////////////////////////////////////Master rules screen ////////////////////////////////////////////////////////////////////////////
	
	@PostMapping(value = "/saveMaster", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postRulesMasterSchema(@RequestBody RulesMaster rulesmaster) {
		
		String TARGET_TEMP_IND =rulesmaster.gettarget_temp_ind();
		String TARGET_TABLE = rulesmaster.gettarget_table();
		String DESCRIPTION = rulesmaster.getdescription();	
		String STATEMENT_TYP = rulesmaster.getstatement_typ();
		
		rulesMasterRepository.postRulesMasterSchema(DESCRIPTION, STATEMENT_TYP, TARGET_TABLE, TARGET_TEMP_IND);
		return "done";
	    
	}
	
	@PostMapping(value = "/saveMasterTab", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postRulesAddMasterTabXrefSchema(@RequestBody RulesMasterTabXref rulesmastertabxref) {
		
		String MASTER_SEQ_NBR =rulesmastertabxref.getMASTER_SEQ_NBR();
		String TAB_SEQ_NBR = rulesmastertabxref.getTAB_SEQ_NBR();
		Integer TAB_ORDER = rulesmastertabxref.getTAB_ORDER();	
		
		rulesMasterTabXrefRepository.postRulesMasterTabXrefSchema(MASTER_SEQ_NBR, TAB_SEQ_NBR, TAB_ORDER);
		
		return "done";
	    
	}
	
	@PostMapping(value = "/delMasterTab", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postRulesMasterTabXrefSchema(@RequestBody RulesMasterTabXref rulesmastertabxref) {
		
		String MASTER_SEQ_NBR =rulesmastertabxref.getMASTER_SEQ_NBR();
		
		rulesMasterTabXrefRepository.postRulesMasterTabDelXrefSchema(MASTER_SEQ_NBR);
		
		return "done";
	    
	}
	
	@PostMapping(value = "/AddMasterCol", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postRulesMasterColXrefSchema(@RequestBody RulesMasterColXref rulesmastercolxref) {
		
		String MASTER_SEQ_NBR =rulesmastercolxref.getMASTER_SEQ_NBR();
		String COLUMN_VAL_DATA_TYPE =rulesmastercolxref.getCOLUMN_VAL_DATA_TYPE();
		String COLUMN_VALUE =rulesmastercolxref.getCOLUMN_VALUE();
		String COLUMN_ALIAS =rulesmastercolxref.getCOLUMN_ALIAS();
		Integer ORDER_BY =rulesmastercolxref.getORDER_BY();
		Integer GROUP_BY =rulesmastercolxref.getGROUP_BY();
		Integer COLUMN_ORDER =rulesmastercolxref.getCOLUMN_ORDER();
		
		rulesMasterColXrefRepository.postRulesMasterColXrefSchema(MASTER_SEQ_NBR, COLUMN_VAL_DATA_TYPE, COLUMN_VALUE, COLUMN_ALIAS, ORDER_BY, GROUP_BY, COLUMN_ORDER);
		
		return "done";
	}
	
	@PostMapping(value = "/DelMasterCol", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postRulesDelMasterColXrefSchema(@RequestBody RulesMasterColXref rulesmastercolxref) {
		
		String MASTER_SEQ_NBR =rulesmastercolxref.getMASTER_SEQ_NBR();
		
		rulesMasterColXrefRepository.postDelMasterColXrefSchema(MASTER_SEQ_NBR);
		
		return "done";
	}
	
	
	@PostMapping(value = "/DelOrderGroup", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String postDelRulesOrderGroupByXrefSchema(@RequestBody RulesOrderGroupByXref rulesordergroupbyxref) {
		
		String MASTER_SEQ_NBR =rulesordergroupbyxref.getMASTER_SEQ_NBR();
		
		rulesOrderGroupByXrefRepository.postDelRulesOrderGroupByXrefSchema(MASTER_SEQ_NBR);
		
		return "done";
	}
	
	@GetMapping(path="/postSchema/{table_owner}/{table_name}/{table_desc}/{table_size}/{table_alias}/{table_typ}")
		public void PostSchema(@PathVariable String table_owner, @PathVariable String table_name, @PathVariable String table_desc,
				@PathVariable String table_size, @PathVariable String table_alias, @PathVariable String table_typ) {
		rulesEngineRepository.postTabSchema(table_owner, table_name, table_desc, table_size,  table_alias,  table_typ);
		rulesEngineRepository.postColSchema(table_owner, table_name);
		rulesEngineRepository.postXrefSchema(table_owner, table_name);
	} 

}
