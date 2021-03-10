import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { CoinItem } from '../models/coin-item';
import { CoinApiService } from '../services/coin-api.service';
import { map, startWith } from 'rxjs/operators';
import { Coin } from '../models/coin';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

    //Form control necessary to the autocompletation
    myControl = new FormControl();
    //A string array with the Pokemon name filtered according the text input
    filteredOptions: Observable<string[]> | undefined;
    //The Pokemon List with the name and the url
    coinItemList: CoinItem[] = [];
    // //The id of the Pokémon selected
    // selectedPokediv: number | undefined;
    // //The id of the Pokémon hovered
    // hoveredPokediv: number | undefined;
    //The Pokémon selected
    selectedCoin: Coin | undefined;
    //A string array with the Pokemon names
    content: string[] = [];
    //The string of the search bar
    searchValue: string = '';

  constructor(
    private coinApiService: CoinApiService
  ) { }

  ngOnInit(): void {
    //We rebuild the Pokemon list filteres according the value of the search changes
    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );

    //Get all the Pokemon names when the page charges
    this.coinApiService.getCoinsList().subscribe(dataResult => {
      dataResult.forEach(result => {
        this.coinItemList.push(new CoinItem(result.id, result.symbol, result.name));
        this.content.push(result.id);
      })
    });
  }

  //An utility function for the autocompletion
  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.content.filter(option => option.toLowerCase().includes(filterValue));
  }

   //This function takes the name of the search bar to show the Pokemon details on the Details View
   selectCoin(coinId: string) {
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

      this.selectedCoin = newCoin;
    });
  }
}
