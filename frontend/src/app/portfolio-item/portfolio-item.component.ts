import { Component, Input, OnInit } from '@angular/core';
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

  constructor(
    private portfolioService: PortfolioService,
  ) { }

  ngOnInit(): void {
  }

  // public get portfolio(): Portfolio {
  //   return this._portfolio;
  // }

  // public set portfolio(portfolio: Portfolio) {
  //   this._portfolio = portfolio;
  // }

  deletePosition(idPosition: number): void {

  }

  updatePosition(idPosition: number, update: {amount: number, description:string}): void {

  }

  deletePositionUpdate(idPositionUpdate: number): void {

  }


}
