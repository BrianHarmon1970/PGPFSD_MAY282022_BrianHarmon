import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Product } from './product'
import {Observable} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor( public http:HttpClient) { }

  //loadJsonData(): void 
  //{
  //  this.http.get( "./assets/product.json").subscribe({
  ///    next: (data:any)=>console.log(data),
  //    error: (error:any)=>console.log(error),
  //    complete: (complete:void)=>console.log("Task Complete!") 
  //  }) ;
  //}
  loadJsonData() : Observable<Product[]> {
    return this.http.get<Product[]>("./assets/product.json");
}
}
