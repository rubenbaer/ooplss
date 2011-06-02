.PHONY: default clean distclean 
JOB := ooplss
JOBBOOK := ooplss-book
FINAL := final
DRAFT := draft
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := nls,ilg,aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,ooplss*mp,nlo,tdo,dvi,lof,lol
NONSTOP := -interaction=nonstopmode
REDIRECT := 1> /dev/null
TEXINPUTS := ".:./latex"

default: build

view: build
	$(VIEWER) $(JOB).pdf

build: man draft

man:
	pdfroff -P-pa4 --no-toc --no-ref -man ../misc/ooplss.1 --pdf-output=manpage.pdf

draft:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

final: REDIRECT=
final: NONSTOP=
final: final-short

final-short: clean man final-report-web final-report-print final-book
	rm -f ooplss.pdf

final-report-web: man
	pdflatex -jobname $(JOB)-web -shell-escape $(NONSTOP) $(FINAL)-report-web $(REDIRECT)
	mpost $(JOB)-web $(REDIRECT)
	bibtex $(JOB)-web $(REDIRECT)
	pdflatex -jobname $(JOB)-web -shell-escape $(NONSTOP) $(FINAL)-report-web $(REDIRECT)
	makeindex $(JOB)-web.nlo -s nomencl.ist -o $(JOB)-web.nls $(REDIRECT)
	pdflatex -jobname $(JOB)-web -shell-escape $(NONSTOP) $(FINAL)-report-web $(REDIRECT)
	pdflatex -jobname $(JOB)-web -shell-escape $(NONSTOP) $(FINAL)-report-web $(REDIRECT)

final-report-print: man
	pdflatex -jobname $(JOB)-print -shell-escape $(NONSTOP) $(FINAL)-report-print $(REDIRECT)
	mpost $(JOB)-print $(REDIRECT)
	bibtex $(JOB)-print $(REDIRECT)
	pdflatex -jobname $(JOB)-print -shell-escape $(NONSTOP) $(FINAL)-report-print $(REDIRECT)
	makeindex $(JOB)-print.nlo -s nomencl.ist -o $(JOB)-print.nls $(REDIRECT)
	pdflatex -jobname $(JOB)-print -shell-escape $(NONSTOP) $(FINAL)-report-print $(REDIRECT)
	pdflatex -jobname $(JOB)-print -shell-escape $(NONSTOP) $(FINAL)-report-print $(REDIRECT)

final-book: man
	pdflatex -jobname $(JOBBOOK) -shell-escape $(NONSTOP) $(FINAL)-book $(REDIRECT)
	mpost $(JOBBOOK) $(REDIRECT)
	bibtex $(JOBBOOK) $(REDIRECT)
	pdflatex -jobname $(JOBBOOK) -shell-escape $(NONSTOP) $(FINAL)-book $(REDIRECT)
	makeindex $(JOBBOOK).nlo -s nomencl.ist -o $(JOBBOOK).nls $(REDIRECT)
	pdflatex -jobname $(JOBBOOK) -shell-escape $(NONSTOP) $(FINAL)-book $(REDIRECT)
	pdflatex -jobname $(JOBBOOK) -shell-escape $(NONSTOP) $(FINAL)-book $(REDIRECT)

once: man
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

mpost:
	mpost $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

debug: man
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)

full-debug: clean man
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)
	mpost $(JOB)
	bibtex $(JOB)
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)
	makeindex $(JOB).nlo -s nomencl.ist -o $(JOB).nls
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)
	pdflatex -jobname $(JOB) -shell-escape $(DRAFT)

# cleans index, logs, temporary files etc. 
clean:
	rm -f *{$(CLEAN_EXT)}
	rm -f include/*{$(CLEAN_EXT)}
	rm -f dot/*.pdf
	rm -f [^ooplss]*.pdf

# also removes output documents
distclean: clean
	rm -f *.pdf
