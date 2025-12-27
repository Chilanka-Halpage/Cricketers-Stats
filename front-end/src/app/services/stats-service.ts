import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class StatsService {
  baseUrl = 'http://localhost/api/stats'

  constructor(private http: HttpClient) {}

  getPlayerStats(playerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/players/${playerId}`);
  }
  
}
