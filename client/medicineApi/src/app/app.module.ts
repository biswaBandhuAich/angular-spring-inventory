import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MedicineComponent } from './medicine/medicine.component';
import { HttpModule } from '@angular/http';
import { medicineService } from './medicine/medicine.service';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    MedicineComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [medicineService],
  bootstrap: [AppComponent]
})
export class AppModule { }
