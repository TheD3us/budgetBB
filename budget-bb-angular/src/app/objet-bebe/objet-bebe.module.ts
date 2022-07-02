import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListObjetComponent } from './list-objet/list-objet.component';
import { ObjetRoutingModule } from './objet-routing.module';
import { AddObjetComponent } from './add-objet/add-objet.component';



@NgModule({
  declarations: [
    ListObjetComponent,
    AddObjetComponent
  ],
  imports: [
    ObjetRoutingModule,
    CommonModule
  ]
})
export class ObjetBebeModule { }
