import { Component, OnInit } from '@angular/core';

import { User, ListSchema, 
        TableOwner, AllRulesSubjectArea,
        ColumnsTable, AllColumns, 
        ColumnsForTable,AllTransformations } from '../service/user';
import { UserService } from '../service/user-services.service';

@Component({
  selector: 'app-transformations',
  templateUrl: './transformations.component.html',
  styleUrls: ['./transformations.component.css']
})

export class TransformationsComponent {
  
  user: User = new User();
  alltransformations: AllTransformations = new AllTransformations();

  submitted = false;
   public searchText : string;

  users: User;
  columnsForTable: ColumnsForTable;
  columnstables: ColumnsTable;
  allcolumns: AllColumns;
  allTransformations: AllTransformations;
  userservice: UserService;
  allRulesSubjectArea: AllRulesSubjectArea;

  constructor(private userService: UserService) { }
 
 //pagination
  p: Number = 1;
  count: Number = 10;

  ngOnInit(){

  this.userService.findAllColumns() .subscribe(data =>{
    this.allcolumns = data; });

  this.userService.findAllTransformations().subscribe(data =>{
    this.allTransformations = data;});

  this.userService.findAllRulesSubjcetArea().subscribe(data =>{
    this.allRulesSubjectArea = data;});
  }

  onClickMe(){
    this.userService.findAllTransformations().subscribe(data =>{
    this.allTransformations = data;});
  }

//add transformations to the database & click event for submit 
  
  newTable(): void {
    this.submitted = false;
      this.allTransformations = new AllTransformations();
    }
  save() {
    this.userService.postTransformSchema(this.allTransformations)
      .subscribe(data => console.log(data), error => console.log(error));
      this.allTransformations = new AllTransformations();
    }
  onSubmit(){
    this.submitted = true;
      this.save();
      
    }

//highlight the row when selected 
public selectedcolumn: AllColumns;
public highlight(column){
  this.selectedcolumn = column;
}

public selectedtrans: AllTransformations;
public highlightRow(trans){
  this.selectedtrans = trans;
}
  

}



