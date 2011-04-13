.PHONY: default clean distclean 
SOURCE := ooplss#.tex
TARGET := ooplss.pdf
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg,1,2,3,4,5,6,7,8,9,10,dvi,mp,pdf,nlo,tdo,dot

default: build

view: build
	$(VIEWER) $(TARGET)

build:
	pdflatex -shell-escape -interaction=nonstopmode $(SOURCE) 1> /dev/null
	mpost $(SOURCE) 1> /dev/null
	bibtex $(SOURCE) 1> /dev/null
	pdflatex -shell-escape -interaction=nonstopmode $(SOURCE) 1> /dev/null
	pdflatex -shell-escape -interaction=nonstopmode $(SOURCE) 1> /dev/null

# cleans index, logs, temporary files etc. 
clean:
	rm -f *.{$(CLEAN_EXT)} include/*.{$(CLEAN_EXT)}

# also removes output documents
distclean: clean
	rm -f *.{pdf,dvi}
