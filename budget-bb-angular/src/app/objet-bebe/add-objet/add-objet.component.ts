import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';

@Component({
  selector: 'app-add-objet',
  templateUrl: './add-objet.component.html',
  styleUrls: ['./add-objet.component.scss']
})
export class AddObjetComponent implements OnInit {

  public objetBebeAjout! : ObjetBebe;
  constructor(private objetBebeService : ObjetPourBebeService) { }

  ngOnInit(): void {
  }
  public ajoutObjet() : void{
    this.objetBebeService.AddObjetBebe(of(this.objetBebeAjout));
  }
}
