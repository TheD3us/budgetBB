import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { AddObjetComponent } from "./add-objet/add-objet.component";
import { ListObjetComponent } from "./list-objet/list-objet.component";

const routes: Routes = [

      { path: 'add', component : AddObjetComponent},
      { path: 'list', component : ListObjetComponent},
      { path: '**', component: ListObjetComponent}
      

     ];
   
   @NgModule({
       imports: [RouterModule.forChild(routes)],
       exports: [RouterModule]
   })
   
   export class ObjetRoutingModule { }