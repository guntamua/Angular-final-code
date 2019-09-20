import {  Injectable } from '@angular/core';
import {  HttpClient } from '@angular/common/http';
import {  Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

// import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import {  HttpHeaders, HttpParams } from '@angular/common/http';

import {  User,               ListSchema,
          TableOwner,         ColumnsForTable, 
          ColumnsTable,       AllColumns,
          TableName,          OwnerTable,  
          ColumnTableSeq,     ColumnsbyTable,       
          AllJoins,           AllJoinXref,
          AllOwnersTables,    AllOwnersTablesColumns, 
          AllOwnerTablesList, ColumnsForOwnerTable2, 
          AllTransformations, AllRulesQualifier, 
          AllPredicates,      AllPredicatesList, 
          AllMasterRules,     AllRulesSubjectArea, 
          AllSuggestedJoins,  ColumnsForOwnerTable, 
          AllOwners          
          } from '../service/user';

@Injectable({ providedIn: 'root' })

export class UserService {
//tables
  private usersUrl: string; private listUrl: string;
  private columnsfortableUrl: string; private columnsTableUrl: string;
  private tableOwnerUrl: string; private columnslistUrl: string;
  private listschemaUrl: string; private tablenamelistUrl: string;
  private tablenameUrl: string;
//columns
  private columnsUrl: string; private columntableseqUrl: string;
  private ColumnsbyTableUrl : string; private ownertableUrl : string;
  private postcolRefreshUrl: string;
//joins
  private alljoinsUrl: string; private alljoinxrefUrl: string;
  private deleteJoinsXrefUrl: string; private allSuggestedJoinsUrl: string;
  private postJoinXrefEngineUrl: string;
//columns and tables
  private columnfortableownerUrl: string; private allOwnersUrl: string;
  private allOwnersTablesColumnsUrl: string; private allOwnersTablesUrl: string;
  private columnsforOwnerTableUrl: string; private columnforownertable2Url: string;
  private allOwnerTablesListUrl: string;
//transformations
  private allTransformationsUrl: string; private postTransformSchemaUrl: string;
  private postUpdTransformSchemaUrl: string;
//rules 
  private allRulesQualifierUrl: string; private allPredicatesListUrl: string;
  private allRulesSubjectAreaUrl: string;
//master rules
  private allMasterRulesUrl: string;
//post methods
  private postUrl: string; private postTableUrl: string;
  private postColumnUrl: string; private postjoinsUrl:  string;
  private savePredicatesUrl: string;
  // private deleteJoinXrefUrl: string;    

constructor( private http: HttpClient) {

//table screen  
  this.usersUrl                = 'http://localhost:8093/getTableNames';
  this.listschemaUrl           = 'http://localhost:8093/listSchema';
  this.tablenameUrl            = 'http://localhost:8093/getTableNamebyOwner';  //example http://localhost:8093/getTableForOwner/{owner}';
  this.tablenamelistUrl        = 'http://localhost:8093/TableNameList';

//columns screen
  this.columnslistUrl          = 'http://localhost:8093/getAllColumns'; //findColumnsbyTable
  this.columnsTableUrl         = 'http://localhost:8093/getAllColumnsTable'; //table.column
  this.columnsUrl              = 'http://localhost:8093/getAllColumnDetails'; //http://localhost:8093/getAllColumnDetails/C093854/DUMMY
  this.columntableseqUrl       = 'http://localhost:8093/getAllColumns'; 
  this.ColumnsbyTableUrl       = 'http://localhost:8093/getAllColumnsbytable'; //using table_seq_nbr

//joins screen 
  this.alljoinsUrl             = 'http://localhost:8093/getAllJoins'; // joins main table list
  this.alljoinxrefUrl          = 'http://localhost:8093/getAllJoinsXref'; //joins xref list
  this.allSuggestedJoinsUrl    = 'http://localhost:8093/getAllSuggestedJoins'; // display suggested joins table1_seq_nbr and table2_seq_nbr are inputs 
  this.postJoinXrefEngineUrl   = 'http://localhost:8093/saveJoinXref';
//table and columns
  this.ownertableUrl            = 'http://localhost:8093/getOwnerTable'; //ownertable owner.table call 
  this.allOwnerTablesListUrl    = 'http://localhost:8093/getAllOwnerTableList'; //owner.table along with table_seq_nbr 
  this.columnfortableownerUrl   = 'http://localhost:8093/getAllColumnsForTable' // Url for /getAllColumnsForTable/{owner} 
  this.allOwnersUrl             = 'http://localhost:8093/getAllOwners';
  this.allOwnersTablesUrl       = 'http://localhost:8093/getAllOwnersTables'; // /getAllOwnersTables/{owner}
  this.allOwnersTablesColumnsUrl= 'http://localhost:8093/getAllOwnersTablesColumns'; //getAllOwnersTablesColumns/{table_name}
  this.columnsforOwnerTableUrl  = 'http://localhost:8093/getAllColumnsForTable'; //http://localhost:8093/getAllColumnsForTable/PCI_VW.PCI_STORE
  this.columnforownertable2Url  = 'http://localhost:8093/getAllColumnsForTable2'; 
  this.postcolRefreshUrl        = 'http://localhost:8093/colRefresh'; //column refresh button 

//transformations acreen 
  this.allTransformationsUrl    = 'http://localhost:8093/getAllTransformations';
  this.postTransformSchemaUrl   = 'http://localhost:8093/saveTransforms';
  this.postUpdTransformSchemaUrl= 'http://localhost:8093/updTransforms';
//rules screen
  this.allRulesQualifierUrl     = 'http://localhost:8093/getAllRulesQualifier';
  this.allPredicatesListUrl     = 'http://localhost:8093/getAllPredicatesList';
  this.allRulesSubjectAreaUrl   = 'http://localhost:8093/getAllRulesSubjectArea';
//Master rules
  this.allMasterRulesUrl        = 'http://localhost:8093/getAllMasterRulesList'; //master rules screen //

//post methods
  this.postUrl                  = 'http://localhost:8093/saveTable';
  this.postjoinsUrl             = 'http://localhost:8093/saveJoins';
  this.savePredicatesUrl        = 'http://localhost:8093/savePredicates';
  this.deleteJoinsXrefUrl       = 'http://localhost:8093/deleteJoinXref';
}

//////////////////////////////////////////table screen Calls//////////////////////

public findAllTables(): Observable<User> {
  return this.http.get<User>(this.usersUrl);
  }
//schema list 
public findAllSchema(): Observable<ListSchema> {
  return this.http.get<ListSchema>(this.listschemaUrl);
  }
// owner.table service 
public findColumnsForOwnerTable(owner: string): Observable<any>{
  return this.http.get<ColumnsForOwnerTable>(`${this.columnsforOwnerTableUrl}/${owner}`);
  }

public findColumnsForOwnerTable2(owner: string): Observable<any>{
  return this.http.get<ColumnsForOwnerTable2>(`${this.columnforownertable2Url}/${owner}`);
  }

public findTableForOwner(table_owner: string): Observable<any> {
  return this.http.get(`${this.tablenameUrl}/${table_owner}`);
  }

//click tabel_seq_nbr to get related columns
public findColumnsbyTable(table_seq_nbr: string): Observable<any> {
  return this.http.get(`${this.ColumnsbyTableUrl}/${table_seq_nbr}`);
  }

///////////////////////////////////////////colums service calls/////////////////////

public findAllColumns(): Observable<AllColumns> {
  return this.http.get<AllColumns>(this.columnslistUrl);
  }
// gets all owners from metadata
public findallOwners(): Observable<AllOwners> {
  return this.http.get<AllOwners>(this.allOwnersUrl);
  }

public findallOwnersTables(owner: string): Observable<any>{
  return this.http.get(`${this.allOwnersTablesUrl}/${owner}`);
  }
// columns screen to display columns related to owner and table 
  public findColumnsForTable(owner: string, table: string): Observable<any> {
    let params = new HttpParams()
    .set('owner',owner)
    .set('table_name',table);
    console.log(params.get('owner'));
    console.log(params.get('table_name'));
    return this.http.get(this.columnsUrl, {params}) // Make the API call using the new parameters.
    }

/////////////////////////////////////////joins screen calls///////////////////////////

//owner.table along with table_seq_nbr 
public findAllOwnerTablesList(): Observable<AllOwnerTablesList>{
  return this.http.get<AllOwnerTablesList>(this.allOwnerTablesListUrl);
  }
public findallOwnersTablesColumns(table_name: string): Observable<any>{
  return this.http.get(`${this.allOwnersTablesColumnsUrl}/${table_name}`);
  }
// columns.tabel service //
public findColumnsTable(): Observable<ColumnsTable> {
  return this.http.get<ColumnsTable>(this.columnsTableUrl);
  }
// owner.table service //
public findOwnerTable(): Observable<OwnerTable>{
  return this.http.get<OwnerTable>(this.ownertableUrl);
  }
public findAllJoins(): Observable<AllJoins>{
  return this.http.get<AllJoins>(this.alljoinsUrl);
  }
public findAllJoinXref(): Observable<AllJoinXref>{
  return this.http.get<AllJoinXref>(this.alljoinxrefUrl);
  } 
//suggested joins 
// public findAllSuggestedjoins(): Observable<AllSuggestedJoins>{
//   return this.http.get<AllSuggestedJoins>(this.allSuggestedJoinsUrl);
//   }
public findAllSuggestedjoins(owner: string, owner2: string): Observable<any>
// public findAllSuggestedjoins(owner: string, owner2: string): Observable<AllSuggestedJoins> 
{
  let params = new HttpParams()
  .set('owner',owner)
  .set('owner2',owner2);

  console.log(params.get('owner'));
  console.log(params.get('owner2'));
  return this.http.get(this.allSuggestedJoinsUrl, {params}) 
  // Make the API call using the new parameters.
  }
//joins screen delete 
public deleteJoinXrefEngine(alljoins: AllJoins){
  return this.http.post<AllJoins>(this.deleteJoinsXrefUrl, alljoins);
  }

/////////////////////////////////////////////transformations ////////////////////////////// 
public findAllTransformations(): Observable<AllTransformations> {
    return this.http.get<AllTransformations>(this.allTransformationsUrl);
  }
 public findAllRulesSubjcetArea(): Observable<AllRulesSubjectArea>{
   return this.http.get<AllRulesSubjectArea>(this.allRulesSubjectAreaUrl);
   
  }

////////////////////////////////////////////////////rules screen///////////////////////////////////
 public findAllRulesQualifier(): Observable<AllRulesQualifier> {
   return this.http.get<AllRulesQualifier>(this.allRulesQualifierUrl);
  }
 public findAllPredicates(): Observable<AllPredicatesList> {
   return this.http.get<AllPredicatesList>(this.allPredicatesListUrl);
  }


//////////////////////////////////////////////////MasterRules screen///////////////////////////////
 public findAllMasterRules(): Observable<AllMasterRules>{
   return this.http.get<AllMasterRules>(this.allMasterRulesUrl);
 }

//////////////////////////////////////////////////Post methods///////////////////////////////////// 
//table
public postrulesEngine(user: User) {
  return this.http.post<User>(this.postUrl, user);
  }
//column
public postrulesColumns(allcolumns: AllColumns){
  return this.http.post<AllColumns>(this.postcolRefreshUrl, allcolumns);
  }
//joins
public postJoinEngine(alljoins: AllJoins) {
  return this.http.post<AllJoins>(this.postjoinsUrl, alljoins);
  } 
public postJoinXrefEngine(alljoins: AllJoins){
  return this.http.post<AllJoins>(this.postJoinXrefEngineUrl, alljoins);
}
//transformations
public postTransformSchema(allTransformations: AllTransformations){
  return this.http.post<AllTransformations>(this.postTransformSchemaUrl, allTransformations);
  }
public postUpdTransformSchema(allTransformations: AllTransformations){
  return this.http.post<AllTransformations>(this.postUpdTransformSchemaUrl, allTransformations);
  }
//rules
public postPredicatesSchema(allPredicatesList: AllPredicatesList) {
  return this.http.post<AllPredicatesList>(this.savePredicatesUrl, allPredicatesList);
  }

}





