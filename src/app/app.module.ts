import { BrowserModule } from '@angular/platform-browser';

import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerPortfolioComponent } from './customer-portfolio/customer-portfolio.component';
import { LoginComponent } from './login/login.component';
import { BrokerComponent } from './broker/broker.component';
import { PositionComponent } from './position/position.component';
import { TradeComponent } from './trade/trade.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule, MatButtonModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SecuritiesComponent } from './components/securities/securities.component';
import { SecurityItemComponent } from './components/security-item/security-item.component';
import { HttpClientModule } from '@angular/common/http';
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
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  entryComponents: [TradeComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
