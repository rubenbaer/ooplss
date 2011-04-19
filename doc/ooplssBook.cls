%**********************************************************************************
%
% o   o   o   o          Berne University of Applied Sciences
%             :          Engineering and Information Technology
%             :......o   Computer Science Division
%
% OOPLSS - Object-Oriented Programming Language with Subtyping and Subclassing
% Ruben Bär, Stefan Heinemann
%******************************************************************************
\NeedsTeXFormat{LaTeX2e}\relax
\ProvidesClass{ooplssTemplate}[2011/03/03 Template for OOPLSS Documentation]

%% Load the book class with the following parameters:
%% a4 paper, 10pt, two side pages, titlepage
\DeclareOption{a4paper}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{11pt}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{oneside}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{twoside}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{titlepage}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{numbers}{\PassOptionsToClass{\CurrentOption}{scrbook}}
\DeclareOption{todo}{\def \showtodo {showtodo}}
\DeclareOption*{\PassOptionsToClass{\CurrentOption}{scrbook}}
\ExecuteOptions{a4paper,11pt,titlepage}
\ProcessOptions\relax

%% Load book class
\LoadClass[numbers=noenddot]{scrbook} % report better for pdf 

\input{ooplssTemplate}

% even pages footer
\fancyfoot{}
\fancyfoot[EL]{\thepage}

% odd pages footer
\fancyfoot[OR]{\thepage}
