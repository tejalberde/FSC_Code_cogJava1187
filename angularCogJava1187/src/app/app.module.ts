import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { SideMenuComponent } from './layout/side-menu/side-menu.component';
import { CompanyListComponent } from './module/company-list/company-list.component';
import { CompanyFormComponent } from './module/company-form/company-form.component';
import { CompanySearchEngineComponent } from './module/company-search-engine/company-search-engine.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CompanyViewComponent } from './module/company-view/company-view.component';
import { HomeComponent } from './module/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SideMenuComponent,
    CompanyListComponent,
    CompanyFormComponent,
    CompanySearchEngineComponent,
    CompanyViewComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
