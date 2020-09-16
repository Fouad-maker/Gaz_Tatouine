import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TasksComponent } from './tasks/tasks.component';
import { NewTaskComponent } from './new-task/new-task.component';
import { RegistrationComponent } from './registration/registration.component';
import { MainInterfaceComponent } from './admin/main-interface/main-interface.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { AdminComponent } from './admin/admin.component';
import { ChartsComponent } from './admin/charts/charts.component';
import { UserComponent } from './user/user.component';
import { UpdateUserComponent } from './admin/update-user/update-user.component';
import { MyFirstDirectiveDirective } from './Directive/my-first-directive.directive';
import { PopoverModule } from "ngx-smart-popover";
import { AuthGuard } from './auth.guard';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TasksComponent,
    NewTaskComponent,
    RegistrationComponent,
    MainInterfaceComponent,
    NavBarComponent,
    SideBarComponent,
    AdminComponent,
    ChartsComponent,
    UserComponent,
    UpdateUserComponent,
    MyFirstDirectiveDirective,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    PopoverModule,
    AppRoutingModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
