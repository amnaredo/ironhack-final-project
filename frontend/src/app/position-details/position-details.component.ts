import { formattedError } from '@angular/compiler';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Position } from '../models/position';
import { PositionUpdate } from '../models/position-update';

@Component({
  selector: 'app-position-details',
  templateUrl: './position-details.component.html',
  styleUrls: ['./position-details.component.css']
})
export class PositionDetailsComponent implements OnInit {

  @Input() position!: Position;

  @Output() deletePositionEvent = new EventEmitter();
  @Output() updatePositionEvent = new EventEmitter();
  @Output() deletePositionUpdateEvent = new EventEmitter();

  showUpdates: boolean = false;

  form: FormGroup;

  amountField: FormControl;
  descriptionField: FormControl;
  
  
  constructor() {
    this.amountField = new FormControl('', [ Validators.required, Validators.min(0) ]);
    this.descriptionField = new FormControl('', [ Validators.required ]);

    this.form = new FormGroup({
      amount: this.amountField,
      description: this.descriptionField,
    });
   }

  ngOnInit(): void {
  }

  toggleShowUpdates(): void {
    this.showUpdates = !this.showUpdates;
  }

  onUpdatePosition(): void {
    const values = {
      amount: this.amountField.value,
      description: this.descriptionField.value,
    }
    this.updatePositionEvent.emit(values)
    // this.position.amount = values.amount;
    // this.position.updates.push(new PositionUpdate(0, values.amount, values.description, 'just now!'))
  }

  onDeletePosition(): void {
    this.deletePositionEvent.emit(this.position);
  }

  onDeletePositionUpdate(positionUpdate: PositionUpdate): void {
    // console.log(positionUpdate);
    this.deletePositionUpdateEvent.emit(positionUpdate);
  }
}
