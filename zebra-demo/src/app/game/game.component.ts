import { Component, OnInit } from '@angular/core';

const PLAYERS = 4;

// TODO try to fix using https://stackoverflow.com/a/35961176/1551798
declare var require: any;

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent implements OnInit {
  currentPuzzle: PuzzleDescription;
  selected = '';

  generating = false;
  completed = false;
  zebra4j = require('zebra-puzzle');

  constructor() {
    const seed = window.location.hash;
    this.currentPuzzle = this.generate(seed);
    this.updateSeedInUrl();
   }

  ngOnInit(): void {
  }

  updateSeedInUrl(): void {
    window.location.hash = this.currentPuzzle.seed;
  }

  select(event: Event): void {
    const value = (event.target as HTMLInputElement).value
    this.completed = true;
    this.selected = value;
    console.log("Completed.");
  }

  reset() : void {
    this.completed = false;
    this.selected = "";
    this.generateAsync();
  }

  generate(seed: string) : PuzzleDescription {    
    let puzzleJson: string;
    puzzleJson = this.zebra4j.generateQuestionPuzzle(PLAYERS, seed.substring(1))
    return JSON.parse(puzzleJson) as PuzzleDescription;    
  }

  async generateAsync() {
    this.generating = true;
    const myPromise = new Promise<PuzzleDescription>((resolve, reject) => {
      setTimeout(() => {
        resolve(this.generate(""));
      }, 100);
    });
    this.currentPuzzle = await myPromise;
    this.generating = false;   
    this.updateSeedInUrl();
  }

}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
  seed: string;
}