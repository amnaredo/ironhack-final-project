import { Component, Input, OnInit } from '@angular/core';
import { Position } from '../models/position';

@Component({
  selector: 'app-position-details',
  templateUrl: './position-details.component.html',
  styleUrls: ['./position-details.component.css']
})
export class PositionDetailsComponent implements OnInit {

  @Input() position!: Position;

  showUpdates: boolean = false;
  
  constructor() { }

  ngOnInit(): void {
  }

  toggleShowUpdates(): void {
    this.showUpdates = !this.showUpdates;
  }
}
