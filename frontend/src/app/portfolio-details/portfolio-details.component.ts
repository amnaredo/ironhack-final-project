import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Portfolio } from '../models/portfolio';
import { PositionUpdate } from '../models/position-update';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.css']
})
export class PortfolioDetailsComponent implements OnInit {

  portfolio!: Portfolio;

  constructor(
    private portfolioService: PortfolioService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getById();
  }


  getById(): void {
    // const checkHasId: boolean = this.activatedRoute.snapshot.paramMap.has('id');
    // if (!checkHasId)
    //   this.router.navigate(['/portfolios'])

    const id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));
    this.portfolioService.getPortfolio(id).subscribe(
      portfolio => this.portfolio = portfolio,
      // error => this.router.navigate(['/portfolios'])
    )
  }


  deletePosition(idPosition: number): void {

  }

  updatePosition(idPosition: number, update: {amount: number, description:string}): void {
    this.portfolioService.updatePosition(idPosition, new PositionUpdate(update.amount, update.description, '')).subscribe(dataResult => {
      this.router.navigate(['portfolios/' + this.portfolio.id])
    });
  }

  deletePositionUpdate(idPositionUpdate: number): void {

  }


}
