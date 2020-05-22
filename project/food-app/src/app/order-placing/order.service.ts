import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from './order';
import { Observable } from 'rxjs';
import { IOrder } from './IOrder';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }
  orderUrl = 'http://localhost:8200/order/';
  orderUrl1 = 'http://localhost:8300/order/';

  createNewOrder(order: Order): Observable<string>{
    return this.http.post<string>(this.orderUrl+'new',order);
  }

  getAllOrder(){
    return this.http.get<IOrder>(this.orderUrl1+'getAll');
  }

  handleOrderError(type: string, order:Order){

  }
}
