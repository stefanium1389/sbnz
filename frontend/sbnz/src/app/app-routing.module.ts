import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionaireComponent } from './questionaire/questionaire.component';
import { StatsComponent } from './stats/stats.component';

const routes: Routes = [
  {path: "", component: QuestionaireComponent},
  {path: "stats", component: StatsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
