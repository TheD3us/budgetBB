import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';

@Component({
  selector: 'app-list-objet',
  templateUrl: './list-objet.component.html',
  styleUrls: ['./list-objet.component.scss']
})
export class ListObjetComponent implements OnInit {
  public objetsBebes$!: Observable<ObjetBebe[]>;
  
  constructor(private objetBebeService : ObjetPourBebeService) { }

  ngOnInit(): void {
    this.objetsBebes$ = this.objetBebeService.getAllObjetsBebe();
  }

  

}
