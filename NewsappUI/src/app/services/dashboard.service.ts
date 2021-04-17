import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  baseUrl = 'http://localhost:8081/';
  favUrl = 'http://localhost:8082/';
  setFavUrl = 'http://localhost:8082/favourite'
  deleteFavUrl = 'http://localhost:8082/removefavourite'
  
  constructor(private http: HttpClient) { }

  getRecommendedArticles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/articles`);
  }

  getFavouriteArticles(): Observable<any> {
    return this.http.get(`${this.favUrl}/getAllFavourites`);
  }
 
  options = { headers: new HttpHeaders().set('Content-Type', 'application/json')}

  setFavourite(id: string): Observable<any> {
    return this.http.post<any>(`${this.setFavUrl}/${id}`, { 'id': id }, this.options);
  }

  deleteFavourite(id: string): Observable<any> {
    return this.http.post<any>(`${this.deleteFavUrl}/${id}`, { 'id': id }, this.options);
  }
}
