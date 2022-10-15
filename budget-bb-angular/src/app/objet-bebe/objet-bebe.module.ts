import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListObjetComponent } from './list-objet/list-objet.component';
import { ObjetRoutingModule } from './objet-routing.module';
import { AddObjetComponent } from './add-objet/add-objet.component';
import { FormsModule } from '@angular/forms'; 



@NgModule({
  declarations: [
    ListObjetComponent,
    AddObjetComponent
  ],
  imports: [
    ObjetRoutingModule,
    CommonModule,
    FormsModule
  ]
})
export class ObjetBebeModule { }
