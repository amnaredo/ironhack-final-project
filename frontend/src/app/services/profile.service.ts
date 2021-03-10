import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../models/profile';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(
    private http: HttpClient
  ) { }

  getProfiles(id: number): Observable<Profile[]> {
    return this.http.get<Profile[]>('http://localhost:8080/users');
  }

  getProfile(id: number): Observable<Profile> {
    return this.http.get<Profile>('http://localhost:8080/users/' + id);
  }

  addProfile(profile: Profile): Observable<Profile> {
    let body = JSON.stringify(profile);
    body = body.replace(/"_/g, '"');
    return this.http.post<Profile>('http://localhost:8080/users', body);
  }

  updateProfile(id: number, profile: Profile): Observable<{}> {
    let body = JSON.stringify(profile);
    body = body.replace(/"_/g, '"');
    console.log(body);
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
    return this.http.put('http://localhost:8080/users/' + id, body, httpOptions);
  }

  deleteProfile(id: number): Observable<{}> {
    return this.http.delete('http://localhost:8080/users/' + id);
  }

}
