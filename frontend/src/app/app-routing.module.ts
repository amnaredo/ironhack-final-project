import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoinDetailsComponent } from './coin-details/coin-details.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { PortfoliosComponent } from './portfolios/portfolios.component';
import { ProfileComponent } from './profile/profile.component';
import { SearchComponent } from './search/search.component';

const routes: Routes = [
  {path: 'search', component: SearchComponent},
  {path: 'search/:coinId', component: CoinDetailsComponent },
  {path: 'portfolios', component: PortfoliosComponent},
  {path: 'portfolios/:id', component: PortfolioDetailsComponent},
  {path: 'profile', component: ProfileComponent},
  {path: '', redirectTo: '/profile', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
