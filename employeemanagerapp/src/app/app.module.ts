import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Pipe } from '@angular/core';


import { EmployeeService } from './employee.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
//import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { NavComponent } from 'src/nav/navbar.component';
import { FooterComponent } from 'src/footer/footer.component';

import { RouterModule } from '@angular/router';
import { appRoutes } from './routes';



@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    AdminComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    FormsModule, 
    RouterModule.forRoot(appRoutes)

  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
