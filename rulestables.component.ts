import { Component, OnInit, Input } from '@angular/core';
import { MatPaginator, MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { Observable, Subject } from 'rxjs';
import { map } from "rxjs/operators";
import { HttpClientModule } from '@angular/common/http';
import { HttpParams } from  "@angular/common/http";
import { MatTableDataSource} from '@angular/material';
import { MatSortModule} from '@angular/material/sort';
import { FormBuilder, FormGroup } from '@angular/forms';

import { ActivatedRoute } from '@angular/router';
import { User, ListSchema, TableOwner, TableName} from '../service/user';
import { UserService } from '../service/user-services.service';

import {MatSort} from '@angular/material/sort';


@Component({
  selector: 'app-rulestables',
  templateUrl: './rulestables.component.html',
  styleUrls: ['./rulestables.component.css']
})

export class RulestablesComponent {
 
 public searchString: string;

  users: User;
  owner: string;

  listschemas: ListSchema;
  tablename: TableName;

  user: User = new User();
  submitted = false;
  Form: FormGroup;

//pagination
  p: Number = 1;
  count: Number = 10;

  constructor(
    private userService: UserService, 
    private http: HttpClientModule, private route: ActivatedRoute) { }

ngOnInit(){
    this.userService.findAllSchema() .subscribe(data =>
      this.listschemas = data);

    this.userService.findAllTables().subscribe(data =>{
      this.users = data });
 }

 //lists tables       
  onClickMe(event){
    this.userService.findAllTables().subscribe(data =>{
      this.users = data });
  }

//search table by owner 
  private searchTableNamebyOwner() {
      this.userService.findTableForOwner(this.owner)
        .subscribe(data => this.tablename  = data);
    }
  onclickSearch() {
    this.searchTableNamebyOwner();
  }
 
  
//add tables to the database & click event for submit 
  newTable(): void {
    this.submitted = false;
      this.user = new User();
  }
  save() {
      this.userService.postrulesEngine(this.user)
        .subscribe(data => console.log(data), error => console.log(error));
        this.user = new User();
  }
  onSubmit() {
      this.submitted = true;
        this.save();
  }

public selectedtable: User;

public highlightRow(users){
  this.selectedtable = users;

}

}





 


