import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { CustomerPortfolioComponent} from './customer-portfolio/customer-portfolio.component';
import { BrokerComponent } from './broker/broker.component';

const routes: Routes = [
  {path: 'dashboard', component: BrokerComponent},
  {path: 'portfolio', component: CustomerPortfolioComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
