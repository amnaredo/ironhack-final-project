import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { CoinItem } from '../models/coin-item';
import { CoinApiService } from '../services/coin-api.service';
import { map, startWith } from 'rxjs/operators';
import { Coin } from '../models/coin';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {



  coinItemList: CoinItem[] = [];

  private _selectedCoinItem!: CoinItem;

  public get selectedCoinItem(): CoinItem {
    return this._selectedCoinItem;
  }
  public set selectedCoinItem(value: CoinItem) {
    this._selectedCoinItem = value;
  }


  constructor(
    private coinApiService: CoinApiService,
    private router: Router
  ) { }

  ngOnInit(): void {

    this.getCoinsList();
  }

  getCoinsList(): void {
    this.coinApiService.getCoinsList().subscribe( dataResult => {
      dataResult.forEach( result => {
        this.coinItemList.push(new CoinItem(result.id, result.symbol, result.name));
      })
    });
  }

  onChangeCoin(coinItem: CoinItem) {
    this.router.navigate(['/search/' + coinItem.id]);
  }
}
