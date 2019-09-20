import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { RulestablesComponent } from './rulestables/rulestables.component';
import { RulesComponent } from './rules/rules.component';
import { MasterrulesComponent } from './masterrules/masterrules.component';
import { TablejoinsComponent } from './tablejoins/tablejoins.component';
import { TransformationsComponent } from './transformations/transformations.component';
import { RulescolumnsComponent} from './rulescolumns/rulescolumns.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LogoutComponent } from './logout/logout.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { SearchtableComponent } from './searchtable/searchtable.component';
import { MasterconfigComponent }from './masterconfig/masterconfig.component';
//const appRoutes: Routes 
const routes: Routes= [
  { path: ' ',   redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'rulestables', component: RulestablesComponent},
  { path: 'tablejoins', component: TablejoinsComponent},
  { path: 'rulescolumns', component: RulescolumnsComponent},
  { path: 'transformations', component: TransformationsComponent},
  { path: 'rules', component: RulesComponent},
  { path: 'masterrules', component: MasterrulesComponent},
  { path: 'logout', component: LogoutComponent},
  { path: 'masterconfig', component: MasterconfigComponent},
 
 { path: 'users', component: RulestablesComponent},
 { path: 'adduser', component: UserFormComponent},
 { path: 'columns', component: RulescolumnsComponent},
 { path: 'findbyowner', component: SearchtableComponent},
 { path: 'findbyowner', component: RulestablesComponent}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }