import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { DeleteObjetComponent } from "./delete-objet/delete-objet.component";
import { ListObjetComponent } from "./list-objet/list-objet.component";

const routes: Routes = [
      { path: 'delete/:id', component: DeleteObjetComponent},
      { path: 'list', component : ListObjetComponent},
      { path: '**', component: ListObjetComponent}
      

     ];
   
   @NgModule({
       imports: [RouterModule.forChild(routes)],
       exports: [RouterModule]
   })
   
   export class ObjetRoutingModule { }