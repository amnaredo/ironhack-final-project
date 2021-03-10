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
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    PortfoliosComponent,
    SearchComponent,
    PortfolioItemComponent,
    PortfolioDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
