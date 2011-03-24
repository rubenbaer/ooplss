
syn match grammarDec "gunit [a-zA-Z]\+" 

syn keyword basicLanguageKeywords OK FAIL 

<<<<<<< HEAD
syn match ruleTest "^[a-zA-Z]\+:$" "TODO: do not consider whitespaces in front

"" syn match ruleStatement "\".*\""
syn region ruleStatement start="\"" end="\"" "TODO: ignore escaped ticks
syn region ruleStatement matchgroup=multilineStmt start="<<" end=">>"

syn match expectedInput "->"
=======
syn match ruleTest "^[a-zA-Z]\+:$"

"" syn match ruleStatement "\".*\""
syn region ruleStatement start="\"" end="\""
syn region ruleStatement matchgroup=multilineStmt start="<<" end=">>"

syn match expectedInput "->"
syn match multiline "<<"
syn match multiline ">>"
>>>>>>> Misc: gunit syntax file

syn match gunitComment "//.\{-}\(?>\|$\)\@="
syn region gunitComment start="/\*" end="\*/"

hi def link basicLanguageKeywords Structure
hi def link ruleTest Statement
hi def link ruleStatement String
hi def link grammarDec Include
hi def link gunitComment Comment
hi def link expectedInput Operator
<<<<<<< HEAD
hi def link multilineStmt Operator
=======
hi def link multiline Operator
>>>>>>> Misc: gunit syntax file
