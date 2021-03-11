import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Portfolio } from '../models/portfolio';
import { PositionUpdate } from '../models/position-update';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolio-item',
  templateUrl: './portfolio-item.component.html',
  styleUrls: ['./portfolio-item.component.css']
})
export class PortfolioItemComponent implements OnInit {

  @Input() portfolio!: Portfolio;

  @Output() deletePortfolioEvent = new EventEmitter();

  constructor(
    private portfolioService: PortfolioService,
    private router: Router
  ) { }

  ngOnInit(): void {
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
