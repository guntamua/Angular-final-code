import { Component, OnInit } from '@angular/core';
import { User } from '../service/user';
import { UserService } from '../service/user-services.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User;
  Tables: String;

 constructor(private userService: UserService) { }

  ngOnInit() {
    // this.userService.findAll().subscribe(data =>{
    // //  //this.users = (data);
    //  this.Tables=JSON.stringify(data);
    // });
  }

}
