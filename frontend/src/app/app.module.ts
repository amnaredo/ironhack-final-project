import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileComponent } from './profile/profile.component';
import { PortfoliosComponent } from './portfolios/portfolios.component';
import { SearchComponent } from './search/search.component';
import { PortfolioItemComponent } from './portfolio-item/portfolio-item.component';
import { PortfolioDetailsComponent } from './portfolio-details/portfolio-details.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CoinDetailsComponent } from './coin-details/coin-details.component';
import { PositionDetailsComponent } from './position-details/position-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    PortfoliosComponent,
    SearchComponent,
    PortfolioItemComponent,
    PortfolioDetailsComponent,
    CoinDetailsComponent,
    PositionDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
