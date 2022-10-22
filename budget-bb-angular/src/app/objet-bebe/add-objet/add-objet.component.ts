import { Component, Input, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { Router } from '@angular/router';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';



@Component({
  selector: 'app-add-objet',
  templateUrl: './add-objet.component.html',
  styleUrls: ['./add-objet.component.scss']
})
export class AddObjetComponent implements OnInit {
  @Input()
  public tableauBebe! : ObjetBebe[];
  public objetBebeAjout!: ObjetBebe;
  constructor(private objetBebeService: ObjetPourBebeService, private router: Router) { }

  ngOnInit(): void {
    this.objetBebeAjout = {} as ObjetBebe;
  }
  public ajoutObjet(): void {
    this.objetBebeService.AddObjetBebe(this.objetBebeAjout).subscribe(objetbebe => this.tableauBebe.push(objetbebe));

  }
}
