import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CustomerPortfolioComponent} from './customer-portfolio/customer-portfolio.component';
import { BrokerComponent } from './broker/broker.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TradeComponent } from './trade/trade.component';
import { SecuritiesComponent } from './securities/securities.component';

const routes: Routes = [
  {path: 'dashboard', component: BrokerComponent},
  {path: 'portfolio', component: CustomerPortfolioComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'transaction', component: TradeComponent},
  {path: 'security-details', component: SecuritiesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
