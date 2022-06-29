import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { ObjetBebe } from './entities/objet-pour-bebe';
import { ObjetPourBebeService } from './service/objet-pour-bebe.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'budget-bb-angular';

  public objetsBebes$!: Observable<ObjetBebe[]>;
  public objetBebeAjout! : ObjetBebe;
  constructor(private objetBebeService : ObjetPourBebeService) { }

  ngOnInit(): void {
    this.objetsBebes$ = this.objetBebeService.getAllObjetsBebe();
    this.objetBebeAjout;
    

  }

  public ajoutObjet() : void{
    this.objetBebeService.AddObjetBebe(of(this.objetBebeAjout));
  }
}
