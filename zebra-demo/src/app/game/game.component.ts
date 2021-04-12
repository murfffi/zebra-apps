import { Component, OnInit } from '@angular/core';

const PLAYERS = 4;

declare function main(): void;

// TODO try to fix using https://stackoverflow.com/a/35961176/1551798
declare var require: any;

declare global {
  interface Window { 
    question: (p: number) => string; 
    zebra4jGenerateQuestionPuzzle: (players: number, seed: string) => string;
  }

  interface Math {
    seedrandom: (seed: string) => void;
  }
}

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent implements OnInit {
  currentPuzzle: PuzzleDescription = JSON.parse('{}') as PuzzleDescription;
  selected = '';

  generating = false;
  completed = false;

  constructor() {
    const seedrandom = require('seedrandom');
    window.Math.seedrandom = seedrandom;
    main();
    const seed = window.location.hash
    this.generateAsync(seed);
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
    this.generateAsync("");
  }

  generateAsync(seed: string) {
    this.generating = true;
    // Create a new
    const worker = new Worker('./gamewk.worker', { type: 'module' });
    worker.onmessage = ({ data }) => {
      this.currentPuzzle = JSON.parse(data) as PuzzleDescription;
      this.generating = false;   
      this.updateSeedInUrl();
    };
    worker.postMessage(seed);
  }

}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
  seed: string;
}