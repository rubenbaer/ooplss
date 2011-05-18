.PHONY: default clean distclean 
JOB := ooplss
JOBBOOK := ooplss-book
FINAL := final
DRAFT := draft
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,ooplss*mp,nlo,tdo,dvi

default: build

view: build
	$(VIEWER) $(JOB).pdf

build: draft

draft:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls 1> /dev/null
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

final: clean final-report-web final-report-print final-book
	rm -f ooplss.pdf

final-report-web:
	pdflatex -jobname $(JOB)-web -shell-escape -interaction=nonstopmode $(FINAL)-report-web 1> /dev/null
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls 1> /dev/null
	mpost $(JOB)-web 1> /dev/null
	bibtex $(JOB)-web 1> /dev/null
	pdflatex -jobname $(JOB)-web -shell-escape -interaction=nonstopmode $(FINAL)-report-web 1> /dev/null
	pdflatex -jobname $(JOB)-web -shell-escape -interaction=nonstopmode $(FINAL)-report-web 1> /dev/null

final-report-print:
	pdflatex -jobname $(JOB)-print -shell-escape -interaction=nonstopmode $(FINAL)-report-print 1> /dev/null
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls 1> /dev/null
	mpost $(JOB)-print 1> /dev/null
	bibtex $(JOB)-print 1> /dev/null
	pdflatex -jobname $(JOB)-print -shell-escape -interaction=nonstopmode $(FINAL)-report-print 1> /dev/null
	pdflatex -jobname $(JOB)-print -shell-escape -interaction=nonstopmode $(FINAL)-report-print 1> /dev/null

final-book:
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls 1> /dev/null
	mpost $(JOBBOOK) 1> /dev/null
	bibtex $(JOBBOOK) 1> /dev/null
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null

once:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

debug:
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)

full-debug: clean
	pdflatex -draftmode -jobname $(JOB) -shell-escape $(DRAFT)
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -draftmode -jobname $(JOB) -shell-escape $(DRAFT)
	pdflatex -draftmode -jobname $(JOB) -shell-escape $(DRAFT)

# cleans index, logs, temporary files etc. 
clean:
	rm -f *{$(CLEAN_EXT)}
	rm -f include/*{$(CLEAN_EXT)}
	rm -f dot/*.pdf
	rm -f [^ooplss]*.pdf

# also removes output documents
distclean: clean
	rm -f *.pdf
