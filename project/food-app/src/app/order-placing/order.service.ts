import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from './order';
import { Observable } from 'rxjs';
import { IOrder } from './IOrder';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private prop;
  constructor(private http: HttpClient) {
    this.http.get('/food-app/assets/config.json').subscribe(data => {
      console.log(data);
      this.prop = data;
    });
  }

  createNewOrder(order: Order): Observable<string> {
    return this.http.post<string>(this.prop.producerUrl + 'new', order);
  }

  getAllOrder() {
    return this.http.get<IOrder>(this.prop.consumerUrl + 'getAll');
  }

  handleOrderError(type: string, order: Order) {

  }
}
