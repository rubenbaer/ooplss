Object-Oriented Programming Language with Subtyping and Subclassing
===================================================================

An object-oriented programming language providing subclassing and
subtyping.

This bachelor thesis is presented to the University of Applied Science in
Bern by Ruben Bär and Stefan Heinemann and was supervised by Professor
Olivier Biberstein, PhD.

It was written in the spring semester 2011 and is licensed under the
Creative Commons Attribution-ShareAlike 3.0 License.

The software is licensed under the conditions of the GPLv3

Directory Structure
-------------------

    articles/  -- A bunch of articles used for the project 2
                   and this thesis
              tstp/        -- Articles used in the project 2
                              (Type Systems: Theory and Practice)
              beo1/        -- Articles received from beo1 for project 2
              ooplss/      -- Some new articles for the thesis
              simons/      -- Serie of articles by Anthony J.H. Simons
                              in the Journal of Object Technology
    build/      -- Temporary directory for build output
    dist/       -- Temporary distribution directory for packing
              ooplss.jar  -- Executable JAR
							examples/   -- Some example codes
              html/       -- Source documentation by doxygen
              *.pdf       -- Project documentation
              README      -- README
    doc/        -- Documentation
    grammar/    -- OOPLSS's grammar definition and grammar gunit tests
    minutes/    -- Minutes of our meetings
    misc/       -- All stuff that is not in the other folders
    resources/  -- Property files and code generation templates
    src/        -- Source code
    test/       -- JUnit test code


A Very Short Introduction to Git
--------------------------------

### Create a local clone of the repository (Do only once)

    $ git clone git://github.com/rubenbaer/ooplss.git

### Update project directory (ooplss)

    $ cd ooplss
    $ git pull


Installation
------------

### Pre-Required Ubuntu packages

* git*
* texlive-*
* graphviz
* groff
* make

### Building documentation

### Building software
