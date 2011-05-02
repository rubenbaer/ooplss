.PHONY: default clean distclean 
JOB := ooplss
JOBBOOK := ooplss-book
FINAL := final
DRAFT := draft
TARGET := ooplss.pdf
VIEWER := evince
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,ooplss.mp,pdf,nlo,tdo,dot

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

final: clean final-report final-book

final-report:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL)-report 1> /dev/null
	mpost $(JOB) 1> /dev/null
	bibtex $(JOB) 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL)-report 1> /dev/null
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(FINAL)-report 1> /dev/null

final-book:
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null
	mpost $(JOBBOOK) 1> /dev/null
	bibtex $(JOBBOOK) 1> /dev/null
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null
	pdflatex -jobname $(JOBBOOK) -shell-escape -interaction=nonstopmode $(FINAL)-book 1> /dev/null

once:
	pdflatex -jobname $(JOB) -shell-escape -interaction=nonstopmode $(DRAFT) 1> /dev/null

# cleans index, logs, temporary files etc. 
clean:
	rm -f *{$(CLEAN_EXT)} include/*{$(CLEAN_EXT)}

# also removes output documents
distclean: clean
	rm -f *.{pdf,dvi}
