import { Component, OnInit } from '@angular/core';
import { Portfolio } from '../models/portfolio';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolios',
  templateUrl: './portfolios.component.html',
  styleUrls: ['./portfolios.component.css']
})
export class PortfoliosComponent implements OnInit {

  portfolios: Portfolio[] = [];
  
  constructor(
    private portfolioService: PortfolioService 
  ) { }

  ngOnInit(): void {
    this.getPortfolios(1);
  }


  getPortfolios(idUser: number): void {
    this.portfolioService.getUserPortfolios(idUser).subscribe( dataResult => {
      this.portfolios = dataResult;
    });
  }

}
