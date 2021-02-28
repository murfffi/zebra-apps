import { Component, OnInit } from '@angular/core';

declare function main(): any;

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
})
export class GameComponent implements OnInit {
  currentPuzzle: PuzzleDescription;
  selected: string;

  generating = false;
  completed = false;

  constructor() { }

  ngOnInit(): void {
    main();
    this.currentPuzzle = this.generate();  
  }

  select(value: string): void {
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
    let puzzleJson = window["question"](3) as string;
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