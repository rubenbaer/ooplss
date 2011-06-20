.PHONY: default clean distclean 
JOB := ooplss
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := nls,ilg,aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,emp*mp,ooplss*mp,nlo,tdo,dvi,lof,lol
NONSTOP := -interaction=nonstopmode
REDIRECT := 1> /dev/null

default: build

build: clean pdf

show:
	impressive -g 2048x768 -t none main.pdf

pdf:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode main 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode main 1> /dev/null

debug:
	pdflatex -jobname $(JOB) -shell-escape main
# cleans index, logs, temporary files etc.
clean:
	rm -f *{$(CLEAN_EXT)}
	rm -f include/*{$(CLEAN_EXT)}
	rm -f dot/*.pdf
	rm -f [^ooplss]*.pdf

# also removes output documents
distclean: clean
	rm -f *.pdf
