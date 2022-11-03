import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-app-two-way-data-binding',
  templateUrl: './app-two-way-data-binding.component.html',
  styleUrls: ['./app-two-way-data-binding.component.css']
})
export class AppTwoWayDataBindingComponent implements OnInit {
  salary:number=12000 ;
  age:number=21 ;
  constructor() { }

  ngOnInit(): void {
  }

}
