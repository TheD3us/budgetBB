import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListObjetComponent } from "./list-objet/list-objet.component";

const routes: Routes = [

      { path: '**', component: ListObjetComponent}

     ];
   
   @NgModule({
       imports: [RouterModule.forChild(routes)],
       exports: [RouterModule]
   })
   
   export class ObjetRoutingModule { }