import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})

export class CorrentistaService {
  constructor(private http: HttpClient) { }

  list(): Observable<any> {
    return this.http.get(`${baseUrl}/correntistas`);
  }

 create(correntista:any): Observable<any> {
  return this.http.post(`${baseUrl}/correntistas`,correntista);
}

  update(correntista:any, id: string): Observable<any> {
    return this.http.put(`${baseUrl}/correntistas/${id}`,correntista);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/correntistas/${id}`);
  }
  
  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }
}
