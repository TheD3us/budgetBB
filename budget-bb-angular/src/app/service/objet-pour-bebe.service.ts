import { Injectable, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ObjetBebe } from '../entities/objet-pour-bebe';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ObjetPourBebeService{



  constructor(private http: HttpClient) { }

  public getAllObjetsBebe(): Observable<ObjetBebe[]> {
    return this.http.get<ObjetBebe[]>(
      'http://localhost:8080/BudgetBB/rest/objetbebe');
  }
  
  public AddObjetBebe( objetbebe : Observable<ObjetBebe>): void {
    this.http.post<ObjetBebe>(`http://localhost:8080/BudgetBB/rest/objetbebe`, objetbebe);

  }
  
  
}
