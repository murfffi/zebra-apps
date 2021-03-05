import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GameComponent } from './game.component';

describe('GameComponent', () => {
  let component: GameComponent;
  let fixture: ComponentFixture<GameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create valid puzzle', () => {
    expect(component).toBeTruthy();
    const puzzle = component.currentPuzzle;
    expect(puzzle).toBeTruthy();
    expect(puzzle.seed.length).toBeGreaterThan(0);
    expect(puzzle.answerOptions.length).toBeGreaterThan(0);
    expect(puzzle.facts.length).toBeGreaterThan(0);
  });
});
