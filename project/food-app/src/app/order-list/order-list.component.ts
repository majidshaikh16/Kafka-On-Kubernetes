import { Component, OnInit } from '@angular/core';
import { OrderService } from '../order-placing/order.service';
import { IOrder } from '../order-placing/IOrder';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  constructor(private _orderService: OrderService) { }

  ngOnInit(): void {
    this.geAllOrder();
  }
  allOrders: IOrder;
  geAllOrder() {
    this._orderService.getAllOrder()
      .subscribe(data => {
        console.log("All Orders",data)
        this.allOrders = data
      },error => console.log("Error getting all orders",error)
      )
  }
}
