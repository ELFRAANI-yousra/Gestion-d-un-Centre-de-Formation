import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormationDetailleComponent } from './formation/detaille-inscp/formation-detaille/formation-detaille.component';
import{FormationComponent} from './formation/formation.component'
import{DetailleInscpComponent} from './formation/detaille-inscp/detaille-inscp.component'
import{IndividuInscreptionComponent}from './formation/individu-inscreption/individu-inscreption.component'
import{FourmateurExterneComponent}from './formation/fourmateur-externe/fourmateur-externe.component'
import{LoginComponent}from './login/login.component'
import{FormateurComponent}from './formateur/formateur.component'
import{EntrepriseComponent }from './admin/entreprise/entreprise.component' 
import{AddmodalComponent}from './admin/formation/addmodal/addmodal.component' 
import{EvaluationComponent}from './formation/evaluation/evaluation.component'
import{AccesEvaluationComponent}from './formation/acces-evaluation/acces-evaluation.component'
import{PlanificationComponent}from './admin/planification/planification.component'
import{FormationComponent as FormationComponentAdmin}from './admin/formation/formation.component'
import{FourmateurComponent}from './admin/fourmateur/fourmateur.component'
import{FormateurExterneComponent}from './admin/formateur-externe/formateur-externe.component'
import{AssistantComponent}from './admin/assistant/assistant.component'
import{MenuAdminComponent}from './admin/menu-admin/menu-admin.component'
import{EvaluationComponent as EvaluationComponentAdmin}from'./admin/evaluation/evaluation.component'

const routes: Routes = [
{path: 'formation-detaille', component: FormationDetailleComponent},
{path: 'individu', component: IndividuInscreptionComponent},
{path: '', component: FormationComponent},
{path: 'individuDetail', component: DetailleInscpComponent},
{path: 'FourmateurExterne', component: FourmateurExterneComponent},
{path:  'admin/formateur', component:FourmateurComponent},
{path:  'assistant', component:AssistantComponent},
{path: 'menuAdmin', component:MenuAdminComponent},
{path: 'login', component: LoginComponent},
{path: 'formateur', component: FormateurComponent},
{path: 'admin/formation', component: FormationComponentAdmin},
{path: 'admin/formateurExterne', component: FormateurExterneComponent},
{path: 'test', component: AddmodalComponent},
{path: 'planification', component: PlanificationComponent},
{path: 'evaluation', component: EvaluationComponent},
{path: 'entreprise', component: EntrepriseComponent},
{path: 'access/evaluation', component: AccesEvaluationComponent},
{path:'admin/evaluation', component:EvaluationComponentAdmin},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }