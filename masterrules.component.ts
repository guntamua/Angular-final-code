import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user-services.service';

import { AllMasterRules, AllJoins } from '../service/user';

@Component({
  selector: 'app-masterrules',
  templateUrl: './masterrules.component.html',
  styleUrls: ['./masterrules.component.css']
})
export class MasterrulesComponent implements OnInit {

  constructor(private userService: UserService) { }

  selectedUser: string;
  allMasterRules: AllMasterRules = new AllMasterRules();

  submitted = false;

  //pagination
    p: Number = 1;
    count: Number = 10;

  ngOnInit() {
    this.userService.findAllMasterRules() .subscribe(data =>
      this.allMasterRules = data);
  }

  RowSelected(u:any){
    this.selectedUser=u;   // declare variable in component.
  }

  //add master rules to the database & click event for submit 
    // newTable(): void {
    //   this.submitted = false;
    //   this.alljoins = new AllJoins();
    // }

    // save() {
    //   this.userService.postJoinEngine(this.alljoins)
    //   .subscribe(data => console.log(data), error => console.log(error));
    //   this.alljoins = new AllJoins();
    // }

    // onSubmit() {
    //   this.submitted = true;
    //   this.save();
    // }

}
