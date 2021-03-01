import { Component, OnInit } from '@angular/core';

declare function main(): void;

declare global {
  interface Window { question: (p: number) => string; }
}

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

  constructor() {
    main();
    this.currentPuzzle = this.generate();      
   }

  ngOnInit(): void {
  }

  select(event: Event): void {
    const value = (event.target as HTMLInputElement).value
    this.completed = true;
    this.selected = value;
    console.log("Completed.");
  }

  reset() : void {
    this.completed = false;
    this.selected = '';
    this.generateAsync();
  }

  generate() : PuzzleDescription {
    let puzzleJson = window.question(3);
    return JSON.parse(puzzleJson) as PuzzleDescription;    
  }

  async generateAsync() {
    this.generating = true;
    const myPromise = new Promise<PuzzleDescription>((resolve, reject) => {
      setTimeout(() => {
        resolve(this.generate());
      }, 100);
    });
    this.currentPuzzle = await myPromise;
    this.generating = false;   
  }

}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
  seed: number;
}