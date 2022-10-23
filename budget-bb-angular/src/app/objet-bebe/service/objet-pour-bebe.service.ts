import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { catchError, Observable, throwError } from 'rxjs';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
@Injectable({
  providedIn: 'root'
})
export class ObjetPourBebeService {



  constructor(private http: HttpClient) { }


  public getAllObjetsBebe(): Observable<ObjetBebe[]> {
    return this.http.get<ObjetBebe[]>('http://localhost:8080/BudgetBB/rest/objetbebe');
  }

  public AddObjetBebe(objetbebe: ObjetBebe): Observable<ObjetBebe> {
    return this.http.post<ObjetBebe>(`http://localhost:8080/BudgetBB/rest/objetbebe`, objetbebe);
  }

  public SuppObjetBebe(id : number) : void {
    this.http.delete('http://localhost:8080/BudgetBB/rest/objetbebe/${id}').subscribe(a => {});
  }
}
