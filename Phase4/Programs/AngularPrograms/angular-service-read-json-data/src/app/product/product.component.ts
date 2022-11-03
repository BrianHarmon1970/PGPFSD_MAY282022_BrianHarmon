import { Component, OnInit } from '@angular/core';
import { Product } from '../product'
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  productInfo:Array<Product>=[] ;
  constructor( public ps:ProductService) { }

  ngOnInit(): void {
  }
  
  loadProductInfo(): void 
  {
    //this.ps.loadJsonData() ;
    
    this.ps.loadJsonData().subscribe({
      next: (data:any)=>this.productInfo = data.product ,
     error: (error:any)=>console.log(error),
      complete: (complete:void)=>console.log("Task Complete!") 
    }) ;
  }
}
