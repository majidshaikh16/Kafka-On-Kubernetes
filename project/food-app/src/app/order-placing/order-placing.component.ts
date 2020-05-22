import { Component, OnInit } from '@angular/core';
import { Order } from './order';
import { HttpClient } from '@angular/common/http';
import { OrderService } from './order.service';
import { IOrder } from './IOrder';


@Component({
  selector: 'app-order-placing',
  templateUrl: './order-placing.component.html',
  styleUrls: ['./order-placing.component.css']
})
export class OrderPlacingComponent implements OnInit {

  constructor(private _orderService: OrderService) { }
  isErrorSubmitting = false;
  successMsg = "";
  ngOnInit(): void {
  }

  order = new Order("pizza", 1);
  


  submitOrder() {
    this.successMsg = '';
    this.isErrorSubmitting = false;
    this._orderService.createNewOrder(this.order).subscribe(data => {

      this.successMsg = data;
      console.log("data..." + data);

    }
      ,
      error => {
        console.log(error);
        if (error.status == 200) {
          this.isErrorSubmitting = false;
          this.successMsg = error.error.text
        } else
          this.isErrorSubmitting = true
      }
    );


  }
}
