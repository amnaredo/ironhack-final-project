import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Portfolio } from '../models/portfolio';

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
}
