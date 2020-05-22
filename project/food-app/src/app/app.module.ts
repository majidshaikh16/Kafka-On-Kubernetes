import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule,orderRoutingComponent } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderComponent } from './order/order.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeService } from './employee-details/employee-service.service';
import { HttpClientModule } from '@angular/common/http';
import { OrderService } from './order/order.service';

@NgModule({
  declarations: [
    AppComponent,
    OrderComponent,
    EmployeeDetailsComponent,
    orderRoutingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [EmployeeService,OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
