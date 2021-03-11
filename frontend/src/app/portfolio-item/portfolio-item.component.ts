import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Portfolio } from '../models/portfolio';
import { PositionUpdate } from '../models/position-update';
import { CoinApiService } from '../services/coin-api.service';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolio-item',
  templateUrl: './portfolio-item.component.html',
  styleUrls: ['./portfolio-item.component.css']
})
export class PortfolioItemComponent implements OnInit {

  @Input() portfolio!: Portfolio;

  @Output() deletePortfolioEvent = new EventEmitter();

  totalValue: number = 0;
  includeSymbols: string[] = [];

  constructor(
    private coinApiService: CoinApiService,
    private portfolioService: PortfolioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.updateCoinsData();
  }

  updateCoinsData(): void {
    this.includeSymbols.splice(0);
    this.totalValue = 0;
    this.portfolio.positions.forEach(position => {
      const coinId = position.coinId;
      const amount = position.amount;
      this.coinApiService.getCoinById(coinId).subscribe(coinResult => {
        this.totalValue = this.totalValue + coinResult.market_data.current_price.eur * amount;
        this.includeSymbols.push(coinResult.symbol.toUpperCase());
      })
    });
  }

  // public get portfolio(): Portfolio {
  //   return this._portfolio;
  // }

  // public set portfolio(portfolio: Portfolio) {
  //   this._portfolio = portfolio;
  // }

  
  onDeletePortfolio(portfolio: Portfolio): void {
    this.deletePortfolioEvent.emit(portfolio.id);
    this.router.navigate(['portfolios']);
  }


}
