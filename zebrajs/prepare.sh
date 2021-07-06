#!/usr/bin/env sh
printf "
// Library for generating Zebra Puzzles - https://github.com/murfffi/zebra-apps/
// TeaVM generated code starts ...
" > ./zebrajs.js
cat target/generated/js/teavm/classes.js >> ./zebrajs.js
printf "
// End of TeaVM generated code
main()
" >> ./zebrajs.js
