.PHONY: default clean distclean 
SOURCE := ooplss#.tex
TARGET := ooplss.pdf
VIEWER := evince
SHELL := /bin/bash
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup,bbl,blg

default: build

view: build
	$(VIEWER) $(TARGET)

build:
	#if [[ -a "/usr/bin/rubber" ]]; then rubber -d $(SOURCE); else pdflatex -interaction=nonstopmode $(SOURCE) >/dev/null; pdflatex -interaction=nonstopmode $(SOURCE) >/dev/null; fi 
	pdflatex -interaction=nonstopmode $(SOURCE) > /dev/null
	mpost $(SOURCE) > /dev/null
	bibtex $(SOURCE) > /dev/null
	pdflatex -interaction=nonstopmode $(SOURCE) > /dev/null
	pdflatex -interaction=nonstopmode $(SOURCE) > /dev/null


# cleans index, logs, temporary files etc. 
clean:
	rm -f *.{$(CLEAN_EXT)} include/*.{$(CLEAN_EXT)}

# also removes output documents
distclean: clean
	rm -f *.{pdf,dvi}
