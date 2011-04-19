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
\DeclareOption{a4paper}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{11pt}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{oneside}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{twoside}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{titlepage}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{numbers}{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\DeclareOption{todo}{\def \showtodo {showtodo}}
\DeclareOption*{\PassOptionsToClass{\CurrentOption}{scrreprt}}
\ExecuteOptions{a4paper,11pt,titlepage}
\ProcessOptions\relax

%% Load reprt class
\LoadClass[numbers=noenddot]{scrreprt} % report better for pdf 

\input{ooplssTemplate}

% even pages footer
\fancyfoot{}
\fancyfoot[EC]{\thepage}

% odd pages footer
\fancyfoot[OC]{\thepage}
