import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input('parentData') public appName;
  @Output('childData') public childEvent = new EventEmitter();

  public orderVal="";
  public qtyVal = 0;
  title = "Order-app-form";
  isOrderValid = false;
  public textStyles = {
    "color": "green",
    "fontStyle": "italic"
  };
  public inputType = "number";
  public buttonClass = {
    "button-show": this.isOrderValid,
    "button-hide": !this.isOrderValid
  };
  public textClass = {

    "text-success": this.isOrderValid,
    "text-danger": !this.isOrderValid
  }
  greetUser() {
    return "Hello @"
  }

  validateFields(order: String, orderqty: Number) {
    if (order.length > 4 && orderqty > 0) {
      this.isOrderValid = true;
      console.log("valid order");
    }

    else {
      this.isOrderValid = false;
      console.log("Invalid order");
    }

  }

  submitOrder(){
    this.childEvent.emit('Order submitted!')
  }

}
