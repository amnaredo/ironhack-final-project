import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Portfolio } from '../models/portfolio';
import { Position } from '../models/position';
import { PositionUpdate } from '../models/position-update';
import { PortfolioService } from '../services/portfolio.service';

@Component({
  selector: 'app-portfolio-details',
  templateUrl: './portfolio-details.component.html',
  styleUrls: ['./portfolio-details.component.css']
})
export class PortfolioDetailsComponent implements OnInit {

  portfolio!: Portfolio;

  @Output() deletePortfolioEvent = new EventEmitter();

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
      portfolio => {
        this.portfolio = portfolio
      // error => this.router.navigate(['/portfolios'])
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

  
  onDeletePortfolio(portfolio: Portfolio): void {
    this.deletePortfolioEvent.emit(portfolio.id);
    this.router.navigate(['portfolios']);
  }

}
