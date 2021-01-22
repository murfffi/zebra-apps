import { Component, OnInit } from '@angular/core';

declare function main(): any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  ngOnInit(): void {
    main();
    console.log(window["question"](3))
  }

  title = 'zebra-demo';
}
