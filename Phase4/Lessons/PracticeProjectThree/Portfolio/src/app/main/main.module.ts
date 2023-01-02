import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainOrdersComponent } from './main-orders/main-orders.component';
import { MainInvoiceComponent } from './main-invoice/main-invoice.component';
import { MainProductsComponent } from './main-products/main-products.component';
import { MainContactComponent } from './main-contact/main-contact.component';
import { MainPortfolioComponent } from './main-portfolio/main-portfolio.component';
import { SecurityLogoutComponent } from '../security/security-logout/security-logout.component';
import { MainNavbarComponent } from './main-navbar/main-navbar.component';
import { MainComponent } from './main.component';
import { MainRoutingRoutingModule } from '../main-routing/main-routing-routing.module';
import { SecurityModule } from '../security/security.module';



@NgModule({
  declarations: [
    MainOrdersComponent,
    MainInvoiceComponent,
    MainProductsComponent,
    MainContactComponent,
    MainPortfolioComponent,
    MainNavbarComponent,
    MainComponent
  ],
  imports: [
    CommonModule,
    MainRoutingRoutingModule,
    SecurityModule
  ],
  exports: [ MainNavbarComponent,MainComponent ]
})
export class MainModule { } ;

