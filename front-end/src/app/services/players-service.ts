import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PlayersService {
  baseUrl = 'http://localhost/api/players';

  constructor(private http: HttpClient){}

  getPlayers(country: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/country/${country}`);
  }
}
