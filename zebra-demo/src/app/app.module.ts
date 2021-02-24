import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ClarityModule } from '@clr/angular';
import { RouterModule } from "@angular/router";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GameComponent } from './game/game.component';

@NgModule({
  declarations: [
    AppComponent,
    GameComponent,
  ],
  imports: [
    BrowserModule,
    ClarityModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      { path: "", component: GameComponent },
    ])    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
