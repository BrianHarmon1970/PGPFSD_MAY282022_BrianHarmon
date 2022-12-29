import {Component} from "@angular/core";

@Component({
  selector:'product-list',
  templateUrl: 'product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  pageTitle: string = "Product List Page" ;
  productList:Array<Product> = new Array<Product>() ;
  showImage:boolean = true ;
  imageWidth:number = 80 ;
  imageMargin:number = 10 ;

  constructor() {
    this.addProduct(this.p1) ;
    this.addProduct(this.p2) ;
    this.addProduct(this.p3) ;
    this.addProduct(this.p4) ;
    this.addProduct(this.p5) ;
  }
  toggleImage()
  {
    this.showImage = this.showImage==true ? false : true ;
  }


  p1:Product = new Product("Leaf Rake",
                                "GDN-0011",
                                      new Date("3/16/2019"),
                                  19.95,
                                  3.5,
        true,
    "./assets/images/5021919_2000x2000.jpg") ;
  p2:Product = new Product("Garden Cart",
      "GDN-0023",
          new Date("3/16/2019"),
      32.99,
      4.2,
    true,
    "./assets/images/yellow-wheelbarrow-isolated-white-background-3d-render_531308-741.jpg") ;

  p3:Product = new Product("Hammer",
      "TBX-0048",
            new Date("5/21/2019"),
      11.90,
      4.8,
      false,
    "./assets/images/hammer.jpg" ) ;

  p4:Product = new Product("Saw",
      "TBX-0022",
            new Date("5/15/2019"),
      8.56,
      3.7,
    false,
    "./assets/images/image_13172.jpg") ;
  p5:Product = new Product("Video Game Controller",
      "GMG-0042",
            new Date("10/15/2018"),
      35.95,
      4.6,
      true,
    "./assets/images/F310 Gamepad - Console Style - Logitech Gaming.png") ;
  addProduct( product:Product )
  {
    this.productList.push( product ) ;
  }
}
class Product
{

  public image:string ;
  public description:string | undefined ;
  public code:string | undefined ;
  public date_available: Date | undefined;
  public price:number  ;
  public rating:number | undefined ;
  public instock:boolean ;

  constructor( description:string,
           code:string,
           date_available:Date,
           price:number,
           rating:number ,
          instock:boolean,
               image:string )
  {

    this.description = description;
    this.code = code ;

    this.date_available = date_available ;
    this.price = price ;
    this.rating = rating ;
    this.instock = instock ;
    this.image = image ;
  }

}





