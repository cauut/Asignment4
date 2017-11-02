import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule,Router } from '@angular/router';
import { AppComponent } from './app.component';
import { DataService } from './services/data.service';
import { DashboardComponent } from './dashboard/dashboard.component';
import {NgxPaginationModule } from 'ngx-pagination';
import { PersonalComponent } from './personal/personal.component';
import { ProjectComponent } from './project/project.component';
import { TimesheetsComponent } from './timesheets/timesheets.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PersonalComponent,
    ProjectComponent,
    TimesheetsComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      // {path:"adduser",component:AdduserComponent},
      {path:'',component : DashboardComponent},
      {path:'personal', component : PersonalComponent},
      {path: 'project', component: ProjectComponent},
      {path: 'timesheet', component: TimesheetsComponent}
    ]),
    NgxPaginationModule
  ],
  providers: [
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
