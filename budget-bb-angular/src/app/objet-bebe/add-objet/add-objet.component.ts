import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { Router } from '@angular/router';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';
import { FormGroup } from '@angular/forms';




@Component({
  selector: 'app-add-objet',
  templateUrl: './add-objet.component.html',
  styleUrls: ['./add-objet.component.scss']
})
export class AddObjetComponent implements OnInit {
  @Input()
  public tableauBebe! : ObjetBebe[];
  @Input()
  public objetDonne! : ObjetBebe;
  public objetBebeAjout!: ObjetBebe;
  formDonne!: FormGroup;
  
  constructor(private objetBebeService: ObjetPourBebeService, private router: Router) { }

  ngOnInit(): void {
    this.objetBebeAjout = {} as ObjetBebe;
    this.formDonne.patchValue({
      nom: this.objetDonne.nom,
      valeur:this.objetDonne.valeur
    })
  }
  public ajoutObjet(): void {
    this.objetBebeService.AddObjetBebe(this.objetBebeAjout).subscribe(objetbebe => this.tableauBebe.push(objetbebe));

  }


}
