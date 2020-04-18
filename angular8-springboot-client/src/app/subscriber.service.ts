import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubscriberService {
  private baseUrl = 'http://localhost:8080/springboot-crud-rest/api/v1/subscribers';

  constructor(private http: HttpClient) { }

  getSubscriber(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createSubscriber(subscriber: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, subscriber);
  }

  updateSubscriber(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteSubscriber(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getSubscribersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}