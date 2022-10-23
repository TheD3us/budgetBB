import { Component, OnInit } from '@angular/core';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';

@Component({
  selector: 'app-delete-objet',
  templateUrl: './delete-objet.component.html',
  styleUrls: ['./delete-objet.component.scss']
})
export class DeleteObjetComponent implements OnInit {

  constructor(private objetBebeService : ObjetPourBebeService) {}

  ngOnInit(): void {
  }

  public deleteObjet(idsel : number): void {
    this.objetBebeService.SuppObjetBebe(idsel);
  }
}
