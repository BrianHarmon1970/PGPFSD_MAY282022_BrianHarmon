import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent} from "./products/product-list.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatButtonModule} from "@angular/material/button";
import { ChangeColorDirective } from './ChangeColor.directive';
import { ConvertToSpacesPipe } from './convert-to-spaces.pipe';

@NgModule({
  declarations: [
    ChangeColorDirective,
    AppComponent,
    ProductListComponent,
    ConvertToSpacesPipe
    //ProductComponent,
    //MyUpperPipe,
    //DiscountPipe,
    //ProductSearch,
    //ProductDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    //SharedModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
