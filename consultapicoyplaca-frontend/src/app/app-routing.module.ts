import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConsultaPicoPlacaComponent } from './consulta-pico-placa/consulta-pico-placa.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [
  {
    path: "",
    component: ConsultaPicoPlacaComponent,
  },
  {
    path: "error",
    component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
