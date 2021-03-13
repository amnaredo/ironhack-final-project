import { Component, OnInit } from '@angular/core';
import { Coin } from '../models/coin';
import { CoinApiService } from '../services/coin-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PortfolioService } from '../services/portfolio.service';
import { Portfolio } from '../models/portfolio';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Position } from '../models/position';

@Component({
  selector: 'app-coin-details',
  templateUrl: './coin-details.component.html',
  styleUrls: ['./coin-details.component.css']
})
export class CoinDetailsComponent implements OnInit {

  coin!: Coin;

  portfolios!: Portfolio[];

  form: FormGroup;

  amountField: FormControl;
  portfolioField: FormControl;


  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private coinApiService: CoinApiService,
    private portfolioService: PortfolioService,
  ) {
    this.amountField = new FormControl('', [ Validators.required, Validators.min(0), Validators.max(999999999999.99999999) ]);
    this.portfolioField = new FormControl('', [ Validators.required ]);
 
    // Initialzie Form Group
    this.form = new FormGroup({
      amount: this.amountField,
      portfolio: this.portfolioField,
    });
   }

  ngOnInit(): void {
    this.getById();
    this.getPortfolios(1);
  }


  getById(): void {

    const coinId: string = this.activatedRoute.snapshot.paramMap.get('coinId') || 'bitcoin';
    this.coinApiService.getCoinById(coinId).subscribe(dataResult => {
      let newCoin: Coin = new Coin(
        dataResult.id,
        dataResult.symbol,
        dataResult.name,
        dataResult.description.en,
        dataResult.links.homepage[0],
        dataResult.image.large,
        dataResult.image.small,
        dataResult.image.thumb,
        dataResult.contract_address,
        dataResult.market_data.current_price.btc,
        dataResult.market_data.current_price.eur,
        dataResult.market_data.current_price.usd,
      )

      this.coin = newCoin;
    });
  }

  getPortfolios(idUser: number): void {
    this.portfolioService.getUserPortfolios(idUser).subscribe( dataResult => {
      this.portfolios = dataResult;
    });
  }

  onSubmit(): void {
    let newPosition = new Position(0, this.coin.id, this.amountField.value, [])
    this.portfolioService.addPosition(this.portfolioField.value.id, newPosition).subscribe(dataResult => {
      alert('A position has been added to your portfolio!');
    });
  }


}
