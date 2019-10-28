import { BrowserModule } from '@angular/platform-browser';

import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerPortfolioComponent } from './customer-portfolio/customer-portfolio.component';
import { LoginComponent } from './login/login.component';
import { BrokerComponent } from './broker/broker.component';
import { PositionComponent } from './position/position.component';
import { TradeComponent } from './trade/trade.component';
import { SecuritiesComponent } from './components/securities/securities.component';
import { SecurityItemComponent } from './components/security-item/security-item.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerPortfolioComponent,
    LoginComponent,
    BrokerComponent,
    PositionComponent,
    TradeComponent,
    SecuritiesComponent,
    SecurityItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
