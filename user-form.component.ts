import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../service/user';
import { UserService } from '../service/user-services.service';


@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent {

  // user: User;
 
  // constructor(private route: ActivatedRoute, private router: Router, private tableService: UserService) {
  //   this.user = new User();
  // }
 
  // onSubmit() {
  //   this.tableService.save(this.user).subscribe(result => this.gotoUserList());
  // }
 
  // gotoUserList() {
  //   this.router.navigate(['/tables']);
  // }
}

