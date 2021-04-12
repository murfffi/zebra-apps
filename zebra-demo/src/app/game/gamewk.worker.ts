/// <reference lib="webworker" />

const PLAYERS = 4;

addEventListener('message', ({ data }) => {
  const seed = data as string;
  let puzzleJson: string;
  if (seed.length <= 1) {
    puzzleJson = self.window.question(PLAYERS);
  } else {
    puzzleJson = self.window.zebra4jGenerateQuestionPuzzle(PLAYERS, seed.substring(1))
  } 
  postMessage(puzzleJson);
});
