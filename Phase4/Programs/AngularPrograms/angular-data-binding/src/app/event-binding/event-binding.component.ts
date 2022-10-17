import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-binding',
  templateUrl: './event-binding.component.html',
  styleUrls: ['./event-binding.component.css']
})
export class EventBindingComponent implements OnInit {

  constructor() { }

  msg:string= "Hi" ;
  result:string = "" ;
  ngOnInit(): void {
  }
   fun():void {
    //document.write("Event Generated..." ) ;
    //alert("Event Generated..." ) ;
    this.msg = "Hello" ;
    
  }
  passValue( nameRef:any )
  {
    let name = nameRef.value ;
    alert( "Hello user "+ name ) ; 
  }
  add( n1:any, n2:any )
  {
    let sum = eval(n1.value) + eval(n2.value) ;
    this.result = "Sum is " + sum ;
    n1.value='' ;
    n2.value='' ;
  }
}
