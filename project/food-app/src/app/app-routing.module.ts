import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrderPlacingComponent } from './order-placing/order-placing.component';
import { OrderListComponent } from './order-list/order-list.component';


const routes: Routes = [
  {path: 'addOrder',component: OrderPlacingComponent},
  {path: 'viewOrders', component: OrderListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const orderRoutingComponent= [OrderPlacingComponent,OrderListComponent];
