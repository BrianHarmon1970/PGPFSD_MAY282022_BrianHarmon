import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MyChildComponent} from './child.component' ;


@NgModule({
  declarations: [
    AppComponent, MyChildComponent
  ],
  imports: [
    BrowserModule
  ],
  //providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
