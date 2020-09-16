import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { TasksComponent } from './tasks/tasks.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { RegistrationComponent } from './registration/registration.component';
import { AdminComponent } from './admin/admin.component';
import { UpdateUserComponent } from './admin/update-user/update-user.component';
import { MainInterfaceComponent } from './admin/main-interface/main-interface.component';
import { UserComponent } from './user/user.component';
import { ChartsComponent } from './admin/charts/charts.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {path:'login' , component:LoginComponent},
  {path:'profile' ,component:UserComponent},
  {path:'admin' , component:AdminComponent , canActivate:[AuthGuard]},
  {path:'editUser/:id',component:UpdateUserComponent ,canActivate:[AuthGuard]},
  {path:'main-interface' ,component:MainInterfaceComponent , canActivate:[AuthGuard]},
  
  {path:'dashboard' , component:ChartsComponent,canActivate:[AuthGuard]},

  {path:'tasks' , component:TasksComponent, canActivate:[AuthGuard]},
  {path:'new-task', component:NewTaskComponent ,canActivate:[AuthGuard]},
  {path:'register', component:RegistrationComponent ,canActivate:[AuthGuard]},
  {path:'',redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
