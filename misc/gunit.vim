
syn match grammarDec "gunit [a-zA-Z]\+" 

syn keyword basicLanguageKeywords OK FAIL 

syn match ruleTest "^[a-zA-Z]\+:$"

"" syn match ruleStatement "\".*\""
syn region ruleStatement start="\"" end="\""
syn region ruleStatement matchgroup=multilineStmt start="<<" end=">>"

syn match expectedInput "->"
syn match multiline "<<"
syn match multiline ">>"

syn match gunitComment "//.\{-}\(?>\|$\)\@="
syn region gunitComment start="/\*" end="\*/"

hi def link basicLanguageKeywords Structure
hi def link ruleTest Statement
hi def link ruleStatement String
hi def link grammarDec Include
hi def link gunitComment Comment
hi def link expectedInput Operator
hi def link multiline Operator
