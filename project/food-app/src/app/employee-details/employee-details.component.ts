import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee-service.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
 
  constructor(private _empService:EmployeeService) { }
  public empDetails;
  ngOnInit(): void {
    this.empDetails = this._empService.getEmployees();
  }
  
}
