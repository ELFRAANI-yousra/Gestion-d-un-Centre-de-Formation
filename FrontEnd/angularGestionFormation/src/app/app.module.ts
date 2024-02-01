import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormationDetailleComponent } from './formation/detaille-inscp/formation-detaille/formation-detaille.component';
import { FormationComponent } from './formation/formation.component';
import { MenuComponent } from './formation/menu/menu.component';
import { ListeFormationComponent } from './formation/liste-formation/liste-formation.component';
import { CategoriesMenuComponent } from './formation/categories-menu/categories-menu.component';
import{HttpClientModule} from '@angular/common/http';
import { IndividuInscreptionComponent } from './formation/individu-inscreption/individu-inscreption.component';
import { FourmateurExterneComponent } from './formation/fourmateur-externe/fourmateur-externe.component';
import { LoginComponent } from './login/login.component';
import { FormateurComponent } from './formateur/formateur.component';
import { AdminComponent } from './admin/admin.component'
import{FormationComponent as FormationComponentADmin} from './admin/formation/formation.component';
import { AddmodalComponent } from './admin/formation/addmodal/addmodal.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { NgxMatDatetimePickerModule, NgxMatTimepickerModule } from '@angular-material-components/datetime-picker';
import { AccesEvaluationComponent } from './formation/acces-evaluation/acces-evaluation.component';
import { EvaluationComponent } from './formation/evaluation/evaluation.component';
import { PlanificationComponent } from './admin/planification/planification.component';
import { EntrepriseComponent } from './admin/entreprise/entreprise.component';
import { FourmateurComponent } from './admin/fourmateur/fourmateur.component';
import { AssistantComponent } from './admin/assistant/assistant.component';
import { MenuAdminComponent } from './admin/menu-admin/menu-admin.component';
import { AdminMenuComponent } from './admin/admin-menu/admin-menu.component';
import { MatTableModule } from '@angular/material/table'; 
import { MatSortModule } from '@angular/material/sort'; 
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormateurExterneComponent } from './admin/formateur-externe/formateur-externe.component';
import{EvaluationComponent as EvaluationComponentAdmin}from'./admin/evaluation/evaluation.component'
import { MatMenuModule } from '@angular/material/menu';


@NgModule({
  declarations: [
    AppComponent,
    FormationComponent,
    MenuComponent,
    ListeFormationComponent,
    CategoriesMenuComponent,
    IndividuInscreptionComponent,
    FormationDetailleComponent,
    FourmateurExterneComponent,
    LoginComponent,
    FormateurComponent,
    AdminComponent,
    FormationComponentADmin,
    AddmodalComponent,
    AccesEvaluationComponent,
    EvaluationComponent,
    EvaluationComponentAdmin,
    PlanificationComponent,
    EntrepriseComponent,
    FourmateurComponent,
    AssistantComponent,
    MenuAdminComponent,
    AdminMenuComponent,
    FormateurExterneComponent
  ],
  imports: [
    MatMenuModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    FormsModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NgxMatDatetimePickerModule,
    NgxMatTimepickerModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
