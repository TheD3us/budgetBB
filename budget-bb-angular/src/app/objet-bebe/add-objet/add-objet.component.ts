import { Component, OnInit } from '@angular/core';
import { of } from 'rxjs';
import { ObjetBebe } from 'src/app/entities/objet-pour-bebe';
import { Router } from '@angular/router';
import { ObjetPourBebeService } from '../service/objet-pour-bebe.service';
import { ObjetBebeModule } from '../objet-bebe.module';

@Component({
  selector: 'app-add-objet',
  templateUrl: './add-objet.component.html',
  styleUrls: ['./add-objet.component.scss']
})
export class AddObjetComponent implements OnInit {

  public objetBebeAjout!: ObjetBebe;
  constructor(private objetBebeService : ObjetPourBebeService, private router: Router) { }

  ngOnInit(): void {
    
  }
  public ajoutObjet() : void{
    
    this.objetBebeService.AddObjetBebe(of(this.objetBebeAjout));
    this.router.navigate(['list']);
  }
}
