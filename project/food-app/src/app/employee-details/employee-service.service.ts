import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {
    
   }

  getEmployees(){
   let empDetails = [
      {"name": "Majid", "age": 27, "gender": "Male"},
      {"name": "Alex", "age": 37, "gender": "Male"},
      {"name": "Maxo", "age": 47, "gender": "Male"}
    ];
    return empDetails;
  }
}
