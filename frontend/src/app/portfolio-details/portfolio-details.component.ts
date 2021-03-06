import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Portfolio } from '../models/portfolio';
import { Position } from '../models/position';
import { PositionUpdate } from '../models/position-update';
import { CoinApiService } from '../services/coin-api.service';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.css']
})
export class PortfolioDetailsComponent implements OnInit {

  portfolio: Portfolio = new Portfolio(0, '', '', 1, []);

  totalValue: number = 0;
  coinSymbols: string[] = [];
  coinLogosUrl: string[] = [];

  form: FormGroup;

  nameField: FormControl;
  descriptionField: FormControl;

  constructor(
    private coinApiService: CoinApiService,
    private portfolioService: PortfolioService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { 
    this.nameField = new FormControl('', [ Validators.required ]);
    this.descriptionField = new FormControl('', [Validators.required ]);

    this.form = new FormGroup({
      name: this.nameField,
      description: this.descriptionField,
    });
  }

  ngOnInit(): void {
    this.getById();
  }

  getById(): void {
    const id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.portfolioService.getPortfolio(id).subscribe(
      portfolio => {
        this.portfolio = portfolio;
        this.nameField.setValue(this.portfolio.name);
        this.descriptionField.setValue(this.portfolio.description);
        this.updateCoinsData();
      });
  }

  updateCoinsData(): void {
    this.coinLogosUrl.splice(0);
    this.coinSymbols.splice(0);
    this.totalValue = 0;
    this.portfolio.positions.forEach(position => {
      const coinId = position.coinId;
      const amount = position.amount;
      this.coinApiService.getCoinById(coinId).subscribe(coinResult => {
        this.totalValue = this.totalValue + coinResult.market_data.current_price.eur * amount;
        this.coinSymbols.push(coinResult.symbol.toUpperCase());
        this.coinLogosUrl.push(coinResult.image.small);
      })
    });
  }

  updatePortfolio(): void {
    this.portfolioService.updatePortfolio(this.portfolio.id, 
      new Portfolio(this.portfolio.id, this.nameField.value, this.descriptionField.value, 1, [])).subscribe(result => {
        this.getById();
      });
  }


  deletePosition(position: Position): void {
    this.portfolioService.deletePosition(position.id).subscribe( dataResult => {
      const index = this.portfolio.positions.indexOf(position, 0);
      if (index > -1) {
        this.portfolio.positions.splice(index, 1);
        this.getById();
      }
    });
  }

  updatePosition(position: Position, update: {amount: number, description:string}): void {
    this.portfolioService.updatePosition(position.id, new PositionUpdate(0, update.amount, update.description, '')).subscribe(dataResult => {
      const index = this.portfolio.positions.indexOf(position, 0);
      if (index > -1) {
        this.portfolio.positions[index].updates.push(dataResult);
        this.portfolio.positions[index].amount = dataResult.amount;
        this.getById();
      }
    });
  }

  deletePositionUpdate(position: Position, positionUpdate: PositionUpdate): void {
    this.portfolioService.deletePositionUpdate(positionUpdate.id).subscribe(dataResult => {
      const indexPosition = this.portfolio.positions.indexOf(position, 0);
      if (indexPosition > -1) {
        const indexUpdate = this.portfolio.positions[indexPosition].updates.indexOf(positionUpdate);
        if (indexUpdate > -1) {
          this.portfolio.positions[indexPosition].updates.splice(indexUpdate, 0);
          console.log("deleted");
          this.getById();
        }
      }
    });
  }


}
