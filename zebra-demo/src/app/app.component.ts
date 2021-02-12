import { Component, OnInit } from '@angular/core';

declare function main(): any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  currentPuzzle: PuzzleDescription;

  ngOnInit(): void {
    main();
    let puzzleJson = window["question"](3) as string;
    this.currentPuzzle = JSON.parse(puzzleJson) as PuzzleDescription;
    console.log(this.currentPuzzle);
  }

  title = 'zebra-demo';

  select(): void {
    
  }
}

export interface PuzzleDescription {
  facts: Array<string>;
  question: string;
  answerOptions: Array<string>;
  answer: string;
}
