if (typeof window === 'undefined') {
    global.performance = require('perf_hooks').performance
    const zebrajs = require('zebra-puzzle')
    console.log(zebrajs.generateQuestionPuzzle(4, '1'))
}