import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user-services.service';
import { ColumnsForTable, ColumnsTable, 
         AllColumns, User, OwnerTable,
         AllJoins, AllJoinXref, ColumnsForOwnerTable,
         ColumnsForOwnerTable2, AllOwnerTablesList,
         AllSuggestedJoins
          } from '../service/user';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSort,MatPaginator,MatTableDataSource } from '@angular/material';
import {SelectionModel} from '@angular/cdk/collections';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { map, filter, scan } from 'rxjs/operators';
import 'rxjs/operator/filter';

import { QueryBuilderModule } from '@syncfusion/ej2-angular-querybuilder';
import { ViewChild, ViewEncapsulation } from '@angular/core';
import { RadioButtonComponent } from '@syncfusion/ej2-angular-buttons';
import { QueryBuilderComponent, TemplateColumn, ColumnsModel, RuleChangeEventArgs  } from '@syncfusion/ej2-angular-querybuilder';
import { getComponent, createElement, isNullOrUndefined } from '@syncfusion/ej2-base';
import { CheckBox } from '@syncfusion/ej2-buttons';
import { DropDownList } from '@syncfusion/ej2-dropdowns';
import { Slider } from '@syncfusion/ej2-inputs';
import { RuleModel } from '@syncfusion/ej2-querybuilder';
import { expenseData } from '../sample-test/expenseData';
import { enableRipple } from '@syncfusion/ej2-base';
import { DialogComponent } from '@syncfusion/ej2-angular-popups';

enableRipple(true);

@Component({
  selector: 'app-tablejoins',
  templateUrl: './tablejoins.component.html',
  styleUrls: ['./tablejoins.component.css']
})
export class TablejoinsComponent implements OnInit {

    // Filter pipe
    public searchString: string;
    public searchString1: string;

    columnsForTable: ColumnsForTable;
    columnstables: ColumnsTable;
    allcolumns: AllColumns;
    ownertable: OwnerTable;
    alljoinxref: AllJoinXref;
    allOwnerTableList: AllOwnerTablesList;
    columnforownertable: ColumnsForOwnerTable;
    columnforownertable2: ColumnsForOwnerTable2;
    allSuggestedJoins: AllSuggestedJoins;
   
   // alljoins: AllJoins;
    owner: string;
    owner2: string;
    table1_seq_nbr: string;
    table2_seq_nbr: string;

    selectedlist: string;
    joinsxref: string;

    alljoins: AllJoins = new AllJoins();
    allJoinXref: AllJoinXref = new AllJoinXref();

    submitted = false;
    loading = false;
    errorMessage = '';
    
  // display data from tables in text box  
  public selectedJoin: AllJoins;
  public highlightJoins: AllJoins;
  public currentJoin;
  selectedRow;

    //pagination
  p: Number = 1;
  count: Number = 10;
 

  constructor(
    private userService: UserService) { }

  ngOnInit() {
    // owner.table, table_seq_nbr 
    this.userService.findAllOwnerTablesList().subscribe(data =>{
      this.allOwnerTableList = data });
    //join screen
    this.userService.findAllJoins().subscribe(data =>{
      this.alljoins = data}); 
    // joins xref 
    this.userService.findAllJoinXref().subscribe(data =>{
      this.alljoinxref = data});
    }

//search colums by owner.table  line 1
    onclickSearch() {
      this.searchColumnsForOwnerTable();
    }

    private searchColumnsForOwnerTable() {
          this.userService.findColumnsForOwnerTable(this.owner)
            .subscribe(data => this.columnforownertable  = data);
      }

//search colums by owner.table  line 2

      onclickSearch2() {
        this.searchColumnsForOwnerTable2();
        this.AllSuggestedjoins();
      }
      private searchColumnsForOwnerTable2() {
          this.userService.findColumnsForOwnerTable2(this.owner2)
            .subscribe(data => this.columnforownertable2  = data);
      }

      private AllSuggestedjoins() {
        this.userService.findAllSuggestedjoins(this.owner, this.owner2)
          .subscribe(data =>{this.allSuggestedJoins = data; },
        (error) => {this.errorMessage = error.message; this.loading = false; },
        () => {this.loading = false;})
      }

onClkDelete(){
    this.deleteJoinXrefEngine();
    // this.AllSuggestedjoins();
  }

private deleteJoinXrefEngine(){
  this.userService.deleteJoinXrefEngine(this.alljoins).subscribe(data =>{  
    this.alljoins = data });
}

//add joins to the database & click event for submit 
    newTable(): void {
      this.submitted = false;
      this.alljoins = new AllJoins();
    }

    save() {
      this.userService.postJoinEngine(this.alljoins)
      .subscribe(data => console.log(data), error => console.log(error));
      this.alljoins = new AllJoins();
    }

    onSubmit() {
      this.submitted = true;
      this.save();
    }

onClkAdd(){
  this.submitted = true;

  this.userService.postJoinXrefEngine(this.alljoins)
  .subscribe(data => console.log(data), error => console.log(error));
  this.alljoins = new AllJoins();
}


deletejoin(){
  this.userService.deleteJoinXrefEngine(this.alljoins).subscribe(data =>{  
    this.alljoins = data });
}

//populate join condition upon selecting the table 
public selectedJoins: AllSuggestedJoins;
public highlightRow(join){
  this.selectedJoins = join;
}

public onSelectjoin(alljoins: AllJoins): void{
  this.selectedJoin = alljoins;
  }
// public highlightRow(alljoins: AllJoins): void{
//   this.highlightJoins = alljoins;
//   }

// onSelectjoin(alljoins: AllJoins): void{
//   this.selectedJoin = alljoins;
// }

// public highlightRow(alljoins): void{
//   this.highlightJoins = alljoins;
// }




}

