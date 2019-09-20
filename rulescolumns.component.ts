import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { User, ListSchema, TableName, 
         ColumnsbyTable, ColumnsForTable, 
         ColumnsTable, AllColumns, 
         ColumnTableSeq, OwnerTable, 
         ColumnsForOwnerTable, AllOwnerTablesList } from '../service/user';

import { UserService } from '../service/user-services.service';
import { FilterPipe} from '../filter/filter.pipe';

import { HttpClient,HttpHeaders, HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-rulescolumns',
  templateUrl: './rulescolumns.component.html',
  styleUrls: ['./rulescolumns.component.css']
})
export class RulescolumnsComponent implements OnInit {

  users: User;
  // users: AllColumns;
  owner: string;
  table: string;
  parameters: string;
  allcolumns: AllColumns;
  columnsForTable: ColumnsForTable;
  columnforownertable: ColumnsForOwnerTable;
  allOwnerTableList: AllOwnerTablesList;

  listschemas: ListSchema;
  tablename: TableName;

  user: User = new User();
  //columnsForTable: columnsForTable = new columnsForTable();
  submitted = false;

  loading = false;
  errorMessage = '';

 //pagination
  p: Number = 1;
  count: Number = 10;
  
  constructor( private userService: UserService,
              private http: HttpClient) { }

ngOnInit(){
    this.userService.findAllSchema() .subscribe(data =>{
      this.listschemas = data});

    this.userService.findAllTables().subscribe(data =>{
      this.users = data });
  }

//search colums by owner.table  line 1
  private searchTableNamebyOwner() {
      this.userService.findTableForOwner(this.owner)
        .subscribe(data => this.tablename  = data);
    }
  onclickSearch() {
    this.searchTableNamebyOwner();
  }

//add tables to the database & click event for submit 

  onSubmit() {
      this.submitted = true;
      this.save();
      this.findColumnsForTable();
  }

  newTable(): void {
    this.submitted = false;
    this.user = new User();
  }

  save() {
      this.userService.postrulesColumns(this.user)
        .subscribe(data => console.log(data), error => console.log(error));
        this.user = new User();
  }

  findColumnsForTable(){
    this.loading = true;
    this.errorMessage = '';

    this.userService.findColumnsForTable(this.owner, this.table)
    .subscribe(data =>{this.columnsForTable = data; },

    (error) => {this.errorMessage = error.message; this.loading = false; },
                        () => {this.loading = false;})
    }

public selectedcolumn: AllColumns;
public highlightRow(column){
  this.selectedcolumn = column;

}

// OnClkRefresh(){
//   this.userService.findColumnsForTable(this.owner, this.table)
//     .subscribe(data => this.columnsForTable = data)
// }

}
