import { Component, OnInit, EventEmitter, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Observable, Subject } from 'rxjs';
import {  map } from 'rxjs/operators';
import { filter } from 'rxjs/operators/filter';
import { HttpClientModule } from '@angular/common/http';
import { HttpParams } from  "@angular/common/http";

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatSort, MatPaginator, MatTableDataSource } from '@angular/material';

import {SelectionModel} from '@angular/cdk/collections';

import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
//our root app component
import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';

import { User, ListSchema, TableOwner, TableName} from '../service/user';
import { UserService } from '../service/user-services.service';

 @Component({
  selector: 'app-searchtable',
  templateUrl: './searchtable.component.html',
  styleUrls: ['./searchtable.component.css']
})


export class SearchtableComponent {
//   displayedColumns = ['select', 'position', 'name', 'weight', 'symbol'];
  
//   dataSource = new MatTableDataSource<Element>(this.data);
//   selection = new SelectionModel<Element>(true, []);

//   @ViewChild(MatSort, {static: true}) sort: MatSort;
//   @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
//   users: User;

//   constructor(
//   private userService: UserService, 
//   private http: HttpClientModule) { 
//     }

//  ngAfterViewInit() {
//     this.dataSource.paginator = this.paginator;
//   }

//   /** Whether the number of selected elements matches the total number of rows. */
//   isAllSelected() {
//     const numSelected = this.selection.selected.length;
//     const numRows = this.dataSource.data.length;
//     return numSelected === numRows;
//   }

//   removeSelectedRows() {
//      this.selection.selected.forEach(item => {
//       let index: number = this.data.findIndex(d => d === item);
//       console.log(this.data.findIndex(d => d === item));
//       this.dataSource.data.splice(index,1);

//       this.dataSource = new MatTableDataSource<Element>(this.dataSource.data);
//     });
//     this.selection = new SelectionModel<Element>(true, []);
//   }

//   /** Selects all rows if they are not all selected; otherwise clear selection. */
//   masterToggle() {
//     this.isAllSelected() ?
//       this.selection.clear() :
//       this.dataSource.data.forEach(row => this.selection.select(row));
//   }
// }

// export interface Element {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
// }

// const ELEMENT_DATA: Element[] = [
//   { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
//   { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
//   { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
//   { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
//   { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
//   { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
//   { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
//   { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
//   { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
//   { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
//   { position: 11, name: 'Sodium', weight: 22.9897, symbol: 'Na' },
//   { position: 12, name: 'Magnesium', weight: 24.305, symbol: 'Mg' },
//   { position: 13, name: 'Aluminum', weight: 26.9815, symbol: 'Al' },
//   { position: 14, name: 'Silicon', weight: 28.0855, symbol: 'Si' },
//   { position: 15, name: 'Phosphorus', weight: 30.9738, symbol: 'P' },
//   { position: 16, name: 'Sulfur', weight: 32.065, symbol: 'S' },
//   { position: 17, name: 'Chlorine', weight: 35.453, symbol: 'Cl' },
//   { position: 18, name: 'Argon', weight: 39.948, symbol: 'Ar' },
//   { position: 19, name: 'Potassium', weight: 39.0983, symbol: 'K' },
//   { position: 20, name: 'Calcium', weight: 40.078, symbol: 'Ca' },
// ];
}