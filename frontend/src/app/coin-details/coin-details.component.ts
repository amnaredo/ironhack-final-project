import { Component, OnInit } from '@angular/core';
import { Coin } from '../models/coin';
import { CoinApiService } from '../services/coin-api.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-coin-details',
  templateUrl: './coin-details.component.html',
  styleUrls: ['./coin-details.component.css']
})
export class CoinDetailsComponent implements OnInit {

  coin: Coin | undefined;

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private coinApiService: CoinApiService
  ) { }

  ngOnInit(): void {
    this.getById();
  }


  getById(): void {

    const coinId: string = this.activatedRoute.snapshot.paramMap.get('coinId') || '';
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

}
