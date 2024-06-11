import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionaireComponent } from './questionaire/questionaire.component';

const routes: Routes = [
  {path: "", component: QuestionaireComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
