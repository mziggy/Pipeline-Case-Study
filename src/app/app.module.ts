import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
// testing for service for loggging in
import { LoggingInService } from './login/logging-in.service';

import { CustomerPortfolioComponent } from './customer-portfolio/customer-portfolio.component';
import { LoginComponent } from './login/login.component';
import { BrokerComponent } from './broker/broker.component';
import { PositionComponent } from './position/position.component';
import { TradeComponent } from './trade/trade.component';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SecuritiesComponent } from './securities/securities.component';
import { CustomerComponent } from './customer/customer.component';
import { AllsecuritiesComponent } from './allsecurities/allsecurities.component';
@NgModule({
  declarations: [
    AppComponent,
    CustomerPortfolioComponent,
    LoginComponent,
    BrokerComponent,
    PositionComponent,
    TradeComponent,
    SecuritiesComponent,
    CustomerComponent,
    AllsecuritiesComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  entryComponents: [TradeComponent],
  providers: [LoggingInService],
  bootstrap: [AppComponent]
})
export class AppModule { }
