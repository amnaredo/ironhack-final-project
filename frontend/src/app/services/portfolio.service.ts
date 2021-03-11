import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Portfolio } from '../models/portfolio';
import { Position } from '../models/position';
import { PositionUpdate } from '../models/position-update';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  constructor(
    private http: HttpClient
  ) { }

  getUserPortfolios(idUser: number): Observable<Portfolio[]> {
    return this.http.get<Portfolio[]>('http://localhost:8080/users/' + idUser + '/portfolios');
  }

  getPortfolio(id: number): Observable<Portfolio> {
    return this.http.get<Portfolio>('http://localhost:8080/portfolios/' + id);
  }

  deletePortfolio(id: number): Observable<{}> {
    return this.http.delete('http://localhost:8080/portfolios/' + id);
  }

  addPosition(id: number, position: Position): Observable<Position> {
    let body = JSON.stringify(position);
    body = body.replace(/"_/g, '"');
    console.log(body);
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    return this.http.post<Position>('http://localhost:8080/portfolios/' + id + '/positions', body, httpOptions);
    // return this.http.post<Position>('http://localhost:8080/portfolios/' + id + '/positions', body);
  }

  deletePosition(id: number): Observable<{}> {
    return this.http.delete('http://localhost:8080/positions/' + id);
  }

  updatePosition(id: number, updatePosition:PositionUpdate): Observable<PositionUpdate> {
    let body = JSON.stringify(updatePosition);
    body = body.replace(/"_/g, '"');
    console.log(body);
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    return this.http.post<PositionUpdate>('http://localhost:8080/positions/' + id + '/updates', body, httpOptions);
  }

  deletePositionUpdate(id: number): Observable<{}> {
    return this.http.delete('http://localhost:8080/updates/' + id);
  }


}
