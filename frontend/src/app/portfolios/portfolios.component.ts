import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Portfolio } from '../models/portfolio';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolios',
  templateUrl: './portfolios.component.html',
  styleUrls: ['./portfolios.component.css']
})
export class PortfoliosComponent implements OnInit {

  portfolios: Portfolio[] = [];

  form: FormGroup;

  nameField: FormControl;
  descriptionField: FormControl;
  
  constructor(
    private portfolioService: PortfolioService 
  ) {
    this.nameField = new FormControl('', [ Validators.required ]);
    this.descriptionField = new FormControl('', [ Validators.required ]);
 
    // Initialzie Form Group
    this.form = new FormGroup({
      name: this.nameField,
      description: this.descriptionField,
    });
   }

  ngOnInit(): void {
    this.getPortfolios(1);
  }


  getPortfolios(idUser: number): void {
    this.portfolioService.getUserPortfolios(idUser).subscribe( dataResult => {
      this.portfolios = dataResult;
    });
  }

  deletePortfolio(id: number): void {
    this.portfolioService.deletePortfolio(id).subscribe( dataResult => {
      this.getPortfolios(1);
    });
    
  }

  onAddPortfolio(): void {
    let newPortfolio = new Portfolio(0, this.nameField.value, this.descriptionField.value, 1, [])
    this.portfolioService.addPortfolio(1, newPortfolio).subscribe(dataResult => {
      alert('A portfolio has been added to your profile!');
      this.getPortfolios(1);
    });
  }
}
