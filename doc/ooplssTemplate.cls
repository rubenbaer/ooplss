%**********************************************************************************
%
% o   o   o   o          Berne University of Applied Sciences
%             :          Engineering and Information Technology
%             :......o   Computer Science Division
%
% TSTP - Type Systems: Theory and Practice
% Ruben Bär, Stefan Heinemann
%**********************************************************************************
\NeedsTeXFormat{LaTeX2e}\relax
\ProvidesClass{ooplssTemplate}[2011/03/03 Template for OOPLSS Documentation]

%% Load the book class with the following parameters:
%% a4 paper, 10pt, two side pages, titlepage
\DeclareOption{a4paper}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{11pt}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{oneside}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
%\DeclareOption{twoside}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{titlepage}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption*{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\ExecuteOptions{a4paper,11pt,titlepage}
\ProcessOptions\relax

%% Load book class
%\LoadClass{scrbook} % report better for pdf 
\LoadClass{scrreprt} % report better for pdf 

%% Since here we can modify the macros of the loaded class
%% (with \renewenvironment or \renewcommand!),
%% load other packets or define new environements (\newenvironment).
%\RequirePackage{remreset}

%
% Symbol Footnote without switch forth and back
%
\long\def\symbolfootnote[#1]#2{\begingroup%
\def\thefootnote{\fnsymbol{footnote}}\footnote[#1]{#2}\endgroup}

%
% Margin width
%
\usepackage[left=3cm, right=2.2cm, bottom=3.5cm]{geometry}

%
% Package for links (ref and cite), no box and blue
% 
\usepackage{hyperref}

% Capital letter for autoref labels
\def\subsectionautorefname{Subsection}
\def\sectionautorefname{Section}
\def\chapterautorefname{Chapter}

%
% Package for headers
%
\usepackage{fancyhdr}

\usepackage[utf8x]{inputenc}

%
% include graphics
%
\usepackage{graphicx}

%
% improved tabulars
%
\usepackage{array}
\usepackage{tabularx}

\usepackage{color}
\usepackage{url}
\usepackage{lastpage}

%
% Package for formatting Listings
%
\usepackage{listings}
\definecolor{lbcolor}{rgb}{0.90,0.90,0.90}
\definecolor{commentcolor}{rgb}{0.0,0.80,0.0}
\lstset{numbers=none,
	stepnumber=2,
	numbersep=5pt,
	numberstyle=\tiny,
	breaklines=true,
	breakautoindent=true,
	postbreak=\space,
	tabsize=2,
	basicstyle=\ttfamily\footnotesize,
	keywordstyle=\color{blue}\bfseries,
	identifierstyle=\color{black},
	commentstyle=\color{commentcolor},
	stringstyle=\color{red}\ttfamily,
	showspaces=false,
	showstringspaces=false,
	extendedchars=true,
	backgroundcolor=\color{lbcolor}}

\usepackage[intoc,refpage]{nomencl}
\renewcommand{\nomname}{Glossary}
\renewcommand{\nomlabel}[1]{\textbf{#1}}


%
% formatting the captions
%
\usepackage[hang,small,bf]{caption}

%
% for reference to last page
%
\usepackage{lastpage}

%
% for image floating
%
\usepackage{wrapfig}
\usepackage{float}
\usepackage{floatflt}

%
% font (sans serif)
%
%\usepackage{helvet}
%\renewcommand{\familydefault}{\sfdefault}
%\selectfont

%
% Remove paragraph indenting
%
%\setlength\parindent{0cm}

%
% Numbering style
%
\bibliographystyle{alpha}
\pagenumbering{arabic}

% numbering depth
\setcounter{secnumdepth}{2}

%
% Titlepage
%
\renewcommand{\maketitle} {
    \begin{titlepage}
    \begin{flushright}
    \vspace*{4cm}
    \includegraphics[height=4\baselineskip]{imgs/logo}\\
        \Huge \@title\\
        \huge \@subtitle\\
        \vspace{0.5cm}
        \normalsize 
        \sffamily{\bfseries{ \Huge \@title}}%\\
        %\vspace{0.2cm}
        %\huge \@subtitle}\\
        \vspace{0.6cm}
        \normalsize \\
        A Bachelor Thesis Presented to the Faculty of Engineering and Information Technology of the Bern University of Applied Sciences \\
        \vspace{0.5cm}
        \@author\\
        \@date
        \vspace{0.5cm}
    \hrule
    \end{flushright}
    \end{titlepage}
}

%
% Headers and footers
%
\pagestyle{fancy}
\fancyhf{}

% no numbers for sections and chapters in headers
\renewcommand{\chaptermark}[1]{\markboth{#1}{}}
\renewcommand{\sectionmark}[1]{\markright{#1}{}}

% even pages footer
\fancyfoot[EL]{\hrule\thepage}
\fancyfoot[ER]{\hrule}

% odd pages footer
\fancyfoot[OL]{\hrule}
\fancyfoot[OR]{\hrule\thepage}

% even pages header
\fancyhead[EC] {
    %chapter name
    \leftmark  
}
\fancyhead[EL] {
    \includegraphics[height=2\baselineskip]{imgs/logo}
}

% even pages header
\fancyhead[OC] {
    %chapter name
    \leftmark  
}

\fancyhead[OR]{
    \includegraphics[height=2\baselineskip]{imgs/logo}
}

% Table of content not contents
%\renewcommand\contentsname{Table of Contents}

%\addtolength{\headheight}{2\baselineskip}
%\addtolength{\headheight}{0.3pt}

%\renewcommand{\chaptermark}[1]{%
%\markboth{#1}{}}

%% second level list 1, 2, ...
\renewcommand{\labelenumii}{\arabic{enumii}.}

%% No number before subsection
%\renewcommand{\subsection}
%
%    % \@startsection{name}{level}{indent}{space before}{space after}{style}
%    \@startsection{subsection}
%    {2 }                           % level 6 = no number before
%    {0mm}                          % indent
%    {\baselineskip}                % space before title 
%    {0.75\baselineskip }           % space after title
%    {\normalfont\large\bfseries }  % normal font, large, bold
%}

%%--------------------------------------------------------------------------
%% New environements and commands specific to this template.
%%--------------------------------------------------------------------------

%% special list for alternate scenario in usecase *a, *b, ...
\newenvironment{usecasealt}
    {
        \renewcommand{\labelenumi}{*\alph{enumi}.}
        \begin{enumerate}
    }
    {
        \end{enumerate}
        \renewcommand{\labelenumi}{\arabic{enumi})}
    }

\newenvironment{letterenum}
    {
        \renewcommand{\labelenumi}{\alph{enumi})}
        \begin{enumerate}
    }
    {
        \end{enumerate}
        \renewcommand{\labelenumi}{\arabic{enumi})}
    }
\newenvironment{numberenum}
    {
        \renewcommand{\labelenumi}{\arabic{enumi})}
        \begin{enumerate}
    }
    {
        \end{enumerate}
        \renewcommand{\labelenumi}{\alph{enumi})}
    }

%% Highlight for method names and other code source excerpt
\newcommand{\srcpart}[1]{{\fontfamily{cmtt}\selectfont #1}}

\newcommand{\image}[2]{
  \begin{figure}[htb]
      \centering
      \includegraphics{#1}
      \caption{#2}
  \end{figure}
}

\usepackage{amsthm}
\usepackage{ucs}
\usepackage{amsmath}
\usepackage{amsfonts}
\usepackage{amssymb}
\usepackage{emp}

% this is apparently used for the metauml stuff
\ifx\pdftexversion\undefined
\usepackage[dvips]{graphicx}
\else
\usepackage{graphicx}
\DeclareGraphicsRule{*}{mps}{*}{}
\fi

\newtheorem{mydef}{Definition}
