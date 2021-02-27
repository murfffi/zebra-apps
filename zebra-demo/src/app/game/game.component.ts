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

  completed = false;

  constructor() { }

  ngOnInit(): void {
    main();
    let puzzleJson = window["question"](3) as string;
    this.currentPuzzle = JSON.parse(puzzleJson) as PuzzleDescription;    
  }

  select(value: string): void {
    this.completed = true;
    this.selected = value;
    console.log("Completed.");
    
  }

}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
  seed: number;
}