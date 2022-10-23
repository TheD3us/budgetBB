import { Component, OnInit } from '@angular/core';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';


@Component({
  selector: 'app-list-objet',
  templateUrl: './list-objet.component.html',
  styleUrls: ['./list-objet.component.scss']
})
export class ListObjetComponent implements OnInit {
  public tableauBebe! : ObjetBebe[];
  
  constructor(private objetBebeService : ObjetPourBebeService) { }

  ngOnInit(): void {
    this.objetBebeService.getAllObjetsBebe().subscribe(tab => this.tableauBebe = tab);
  }
  
  

}
