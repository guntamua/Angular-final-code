import { Component, OnInit, Output} from '@angular/core';
import { EventEmitter } from '@angular/core';
//import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // @Output() featureSelected = new EventEmitter<string>();
  
  // onSelect(feature: string){
  //   this.featureSelected.emit(feature);
  // }
 //constructor(private loginService: AuthenticationService) { }
  constructor() { }


  ngOnInit() {
    
  }

}
