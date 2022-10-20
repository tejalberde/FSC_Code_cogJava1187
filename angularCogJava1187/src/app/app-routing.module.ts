import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyFormComponent } from './module/company-form/company-form.component';
import { CompanyListComponent } from './module/company-list/company-list.component';
import { CompanySearchEngineComponent } from './module/company-search-engine/company-search-engine.component';
import { CompanyViewComponent } from './module/company-view/company-view.component';
import { HomeComponent } from './module/home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'company', component: CompanyListComponent },
  { path: 'company-form', component: CompanyFormComponent },
  { path: 'search-engine', component: CompanySearchEngineComponent },
  { path: 'company-view/:id', component: CompanyViewComponent },
  { path: '**', component: HomeComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
