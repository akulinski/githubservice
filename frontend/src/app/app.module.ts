import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {UserInfoComponent} from './user-info/user-info.component';
import {MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule, MatTableModule} from "@angular/material";
import {HttpClientModule} from "@angular/common/http";
import {FinderComponent} from './finder/finder.component';
import {FormsModule} from "@angular/forms";
import {StoreModule} from "@ngrx/store";
import {reducer} from "./app.reducer";

@NgModule({
  declarations: [
    AppComponent,
    UserInfoComponent,
    FinderComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    StoreModule.forRoot({
      githubData: reducer
    })
  ],
  providers: [],
  bootstrap: [AppComponent, UserInfoComponent]
})
export class AppModule {
}
