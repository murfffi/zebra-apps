import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';

declare function main(): any;

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css'],
  //changeDetection: ChangeDetectionStrategy.OnPush
})
export class GameComponent implements OnInit {
  currentPuzzle: PuzzleDescription;

  constructor() { }

  ngOnInit(): void {
    main();
    let puzzleJson = window["question"](3) as string;
    this.currentPuzzle = JSON.parse(puzzleJson) as PuzzleDescription;    
  }

  select(): void {
    
  }

}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
}