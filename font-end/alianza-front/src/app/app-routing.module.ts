import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClienteComponent } from './clientes/cliente/cliente.component';

const routes: Routes = [
  { path : 'clientes' , component : ClienteComponent},
  {path : '' , component : ClienteComponent, pathMatch : 'full'},
  {path : '**',  redirectTo:'/', pathMatch : 'full'  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
