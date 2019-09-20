import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';

import { User, ColumnsForTable, 
        ColumnsTable, AllColumns, 
        AllTransformations, AllRulesQualifier, 
        AllPredicatesList } from '../service/user';
        
import { UserService } from '../service/user-services.service';

@Component({
  selector: 'app-rules',
  templateUrl: './rules.component.html',
  styleUrls: ['./rules.component.css']
})
export class RulesComponent {

  // Filter pipe
  public searchString: string;
  public searchString1: string;

  allPredicatesList: AllPredicatesList = new AllPredicatesList();
  submitted = false;

  // display data from tables in text box  
  selectedColumn: AllColumns;
  selectedTrans: AllTransformations;

  allcolumns: AllColumns;
  alltransformations: AllTransformations;
  allrulesqualifier: AllRulesQualifier;

  constructor( private userService: UserService) { }

  ngOnInit() {
    this.userService.findAllColumns() .subscribe(data =>{
      this.allcolumns = data; });
    
    this.userService.findAllTransformations() .subscribe(data =>{
      this.alltransformations = data; });

    this.userService.findAllRulesQualifier() .subscribe(data =>{
      this.allrulesqualifier = data; });
  }

 // display data from tables in text box  
  onSelect(column : AllColumns): void{
    this.selectedColumn = column;
    }
  onSelecttrans(trans : AllTransformations): void{
    this.selectedTrans = trans;
  }

//save inputs in database

  newTable(): void {
    this.submitted = false;
      this.allPredicatesList = new AllPredicatesList();
  }
  save() {
      this.userService.postPredicatesSchema(this.allPredicatesList)
        .subscribe(data => console.log(data), error => console.log(error));
        this.allPredicatesList = new AllPredicatesList();
  }
  onSubmit() {
      this.submitted = true;
        this.save();
  }


//   onSelect(column : AllColumns):void {
//   const selectedColumn = this.selectedColumn;
// // const selectedColumn = <FormArray>this.selectedColumn;
//   if(isChecked) {
//     selectedColumn.push(new FormControl(column));
//   } else {
//     let index = selectedColumn.controls.findIndex(x => x.value == column)
//     selectedColumn.removeAt(index);
//   }
// }

// onSelecttrans(trans : AllTransformations):void {
//   const selectedTrans = this.selectedTrans;
//   //  const selectedTrans = <FormArray>this.selectedTrans;

//   if(isChecked) {
//     selectedTrans.push(new FormControl(trans));
//   } else {
//     let index = selectedTrans.controls.findIndex(x => x.value == trans)
//     selectedTrans.removeAt(index);
//   }
// }


}
// $(function() {
//     $(".draggable").draggable({
//         revert: false,
//         helper: 'clone',
//         start: function(event, ui) {
//             $(this).fadeTo('fast', 0.5);
//         },
//         stop: function(event, ui) {
//             $(this).fadeTo(0, 1);
//         }
//     });
    
//     $("#droppable").droppable({
//         hoverClass: 'active',
//         drop: function(event, ui) {
//             this.value = $(ui.draggable).text();
//         }

//     });
// });