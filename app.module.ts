import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Injectable }  from '@angular/core';
import { BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { QueryBuilderModule } from '@syncfusion/ej2-angular-querybuilder';
import { JwPaginationComponent } from 'jw-angular-pagination';
import { NgxPaginationModule } from 'ngx-pagination';
import 'hammerjs';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent} from './register/register.component';
import { HeaderComponent } from './header/header.component';
import { RulestablesComponent } from './rulestables/rulestables.component';
import { RulescolumnsComponent} from './rulescolumns/rulescolumns.component';
import { TablejoinsComponent } from './tablejoins/tablejoins.component';
import { TransformationsComponent } from './transformations/transformations.component';
import { RulesComponent } from './rules/rules.component';
import { MasterrulesComponent } from './masterrules/masterrules.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { FooterComponent } from './footer/footer.component';
import { LogoutComponent } from './logout/logout.component';

import { RouterModule, Routes } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from  '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './service/user-services.service';
import { FilterPipe } from './filter/filter.pipe';
import {SelectModule} from 'ng2-select';


import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { CdkTableModule} from '@angular/cdk/table';
import { SampleTestComponent } from './sample-test/sample-test.component';
import { SearchtableComponent } from './searchtable/searchtable.component';
import { YourTableComponent } from './your-table/your-table.component';

import { DropDownListModule } from '@syncfusion/ej2-angular-dropdowns';
import { MasterconfigComponent } from './masterconfig/masterconfig.component';

@NgModule({
  declarations: [

    AppComponent, LoginComponent, RegisterComponent,
    HeaderComponent, RulestablesComponent, MasterrulesComponent, RulesComponent,
    TablejoinsComponent,TransformationsComponent, RulescolumnsComponent,PageNotFoundComponent,
    FooterComponent,LogoutComponent, UserListComponent, UserFormComponent, SampleTestComponent,
    FilterPipe, SearchtableComponent, JwPaginationComponent, YourTableComponent, MasterconfigComponent
  
   ],

  imports: [

    BrowserModule, HttpClientModule, 
    BrowserAnimationsModule,AppRoutingModule, 
    FormsModule, ReactiveFormsModule, 
    NgbModule.forRoot(), QueryBuilderModule, 
    NgxPaginationModule, MatTableModule, 
    MatPaginatorModule, MatCheckboxModule,
    MatFormFieldModule, CdkTableModule, MatSortModule, 
    DropDownListModule, SelectModule   
  ],

 exports: [
    
    MatTableModule,MatSortModule, 
    MatFormFieldModule, MatPaginatorModule
  ],
 
  providers: [UserService],
  bootstrap: [AppComponent]
})

export class AppModule {
  constructor(router: Router) {
  }

}
  
