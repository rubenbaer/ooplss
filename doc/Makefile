.PHONY: default clean distclean 
SOURCE := ooplss.tex
TARGET := ooplss.pdf
VIEWER := okular
SHELL := /bin/bash
CLEAN_EXT := aux,log,idx,out,glo,toc,lot,tex~,backup

default: build
	$(VIEWER) $(TARGET)

noview: build

build:
	if [[ -a "/usr/bin/rubber" ]]; then rubber -d $(SOURCE); else pdflatex -interaction=nonstopmode $(SOURCE) >/dev/null; pdflatex -interaction=nonstopmode $(SOURCE) >/dev/null; fi 

# cleans index, logs, temporary files etc. 
clean:
	rm -f *.{$(CLEAN_EXT)} includes/*.{$(CLEAN_EXT)}

# also removes output documents
distclean: clean
	rm -f *.{pdf,dvi}
