import { Component, Input, OnInit } from '@angular/core';
import { Portfolio } from '../models/portfolio';

@Component({
  selector: 'app-portfolio-item',
  templateUrl: './portfolio-item.component.html',
  styleUrls: ['./portfolio-item.component.css']
})
export class PortfolioItemComponent implements OnInit {

  @Input() portfolio!: Portfolio;

  constructor() { }

  ngOnInit(): void {
  }

  // public get portfolio(): Portfolio {
  //   return this._portfolio;
  // }

  // public set portfolio(portfolio: Portfolio) {
  //   this._portfolio = portfolio;
  // }

}
