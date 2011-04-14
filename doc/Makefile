.PHONY: default clean distclean 
JOB := ooplss
FINAL := final
DRAFT := draft
TARGET := ooplss.pdf
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,mp,pdf,nlo,tdo,dot

default: build

view: build
	$(VIEWER) $(JOB).pdf

build: draft

draft:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

final: clean
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL) 1> /dev/null
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL) 1> /dev/null

once:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

# cleans index, logs, temporary files etc. 
clean:
	rm -f *.{$(CLEAN_EXT)} include/*.{$(CLEAN_EXT)}

# also removes output documents
distclean: clean
	rm -f *.{pdf,dvi}
