// $ANTLR 3.3.1-SNAPSHOT Mar 23, 2011 24:00:34 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-04-06 16:09:02

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class OoplssParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "VARDEF", "CLASSDEF", "BLOCK", "CLASSBODY", "SUPERTYPE", "SUPERCLASSES", "METHODDEF", "RETURNTYPE", "VARACCESS", "ARRAYACCESS", "METHODCALL", "METHODARGS", "EXPR", "INT", "STRING", "CHAR", "BOOL", "SELF", "METHODS", "FIELDS", "ID", "INTLITERAL", "STRINGLITERAL", "CHARLITERAL", "BOOLLITERAL", "COMMENT", "LINE_COMMENT", "EscapeSequence", "EQOPERATOR", "CALLOPERATOR", "SEMICOLON", "PLUSOPERATOR", "MINUSOPERATOR", "TIMESOPERATOR", "DIVIDEOPERATOR", "ANDOPERATOR", "OROPERATOR", "LBRACE", "RBRACE", "LPARA", "RPARA", "LBRACK", "RBRACK", "CONSTRUCT", "CLASS", "VAR", "DEF", "RETURNSTMT", "SUBTYPE", "SUBCLASS", "IFSTMT", "WHILESTMT", "FORSTMT", "ELIF", "ELSE", "EQ", "WS", "','", "':'", "'!='", "'<'", "'<='", "'>'", "'>='"
    };
    public static final int EOF=-1;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int VARDEF=4;
    public static final int CLASSDEF=5;
    public static final int BLOCK=6;
    public static final int CLASSBODY=7;
    public static final int SUPERTYPE=8;
    public static final int SUPERCLASSES=9;
    public static final int METHODDEF=10;
    public static final int RETURNTYPE=11;
    public static final int VARACCESS=12;
    public static final int ARRAYACCESS=13;
    public static final int METHODCALL=14;
    public static final int METHODARGS=15;
    public static final int EXPR=16;
    public static final int INT=17;
    public static final int STRING=18;
    public static final int CHAR=19;
    public static final int BOOL=20;
    public static final int SELF=21;
    public static final int METHODS=22;
    public static final int FIELDS=23;
    public static final int ID=24;
    public static final int INTLITERAL=25;
    public static final int STRINGLITERAL=26;
    public static final int CHARLITERAL=27;
    public static final int BOOLLITERAL=28;
    public static final int COMMENT=29;
    public static final int LINE_COMMENT=30;
    public static final int EscapeSequence=31;
    public static final int EQOPERATOR=32;
    public static final int CALLOPERATOR=33;
    public static final int SEMICOLON=34;
    public static final int PLUSOPERATOR=35;
    public static final int MINUSOPERATOR=36;
    public static final int TIMESOPERATOR=37;
    public static final int DIVIDEOPERATOR=38;
    public static final int ANDOPERATOR=39;
    public static final int OROPERATOR=40;
    public static final int LBRACE=41;
    public static final int RBRACE=42;
    public static final int LPARA=43;
    public static final int RPARA=44;
    public static final int LBRACK=45;
    public static final int RBRACK=46;
    public static final int CONSTRUCT=47;
    public static final int CLASS=48;
    public static final int VAR=49;
    public static final int DEF=50;
    public static final int RETURNSTMT=51;
    public static final int SUBTYPE=52;
    public static final int SUBCLASS=53;
    public static final int IFSTMT=54;
    public static final int WHILESTMT=55;
    public static final int FORSTMT=56;
    public static final int ELIF=57;
    public static final int ELSE=58;
    public static final int EQ=59;
    public static final int WS=60;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators



        public OoplssParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OoplssParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return OoplssParser.tokenNames; }
    public String getGrammarFileName() { return "/home/sh/gitty/private/ooplss/grammar/Ooplss.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "prog"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:1: prog : ( classDec )+ ;
    public final OoplssParser.prog_return prog() throws RecognitionException {
        OoplssParser.prog_return retval = new OoplssParser.prog_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OoplssParser.classDec_return classDec1 = null;



        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:7: ( ( classDec )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:10: ( classDec )+
            {
            root_0 = (Object)adaptor.nil();

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:10: ( classDec )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==CLASS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:0:0: classDec
            	    {
            	    pushFollow(FOLLOW_classDec_in_prog137);
            	    classDec1=classDec();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, classDec1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class classDec_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classDec"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:1: classDec : 'class' classname= ID ( 'subtypeOf' supertype= ID )? ( 'subclassOf' subclass+= ID ( ',' subclass+= ID )* )? '{' ( varDef ';' | methodDef )* '}' -> ^( CLASSDEF $classname ( ^( SUPERTYPE $supertype) )? ( ^( SUPERCLASSES ( $subclass)+ ) )? ( ^( FIELDS ( varDef )+ ) )? ( ^( METHODS ( methodDef )+ ) )? ) ;
    public final OoplssParser.classDec_return classDec() throws RecognitionException {
        OoplssParser.classDec_return retval = new OoplssParser.classDec_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token classname=null;
        Token supertype=null;
        Token string_literal2=null;
        Token string_literal3=null;
        Token string_literal4=null;
        Token char_literal5=null;
        Token char_literal6=null;
        Token char_literal8=null;
        Token char_literal10=null;
        Token subclass=null;
        List list_subclass=null;
        OoplssParser.varDef_return varDef7 = null;

        OoplssParser.methodDef_return methodDef9 = null;


        Object classname_tree=null;
        Object supertype_tree=null;
        Object string_literal2_tree=null;
        Object string_literal3_tree=null;
        Object string_literal4_tree=null;
        Object char_literal5_tree=null;
        Object char_literal6_tree=null;
        Object char_literal8_tree=null;
        Object char_literal10_tree=null;
        Object subclass_tree=null;
        RewriteRuleTokenStream stream_SUBCLASS=new RewriteRuleTokenStream(adaptor,"token SUBCLASS");
        RewriteRuleTokenStream stream_CLASS=new RewriteRuleTokenStream(adaptor,"token CLASS");
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SUBTYPE=new RewriteRuleTokenStream(adaptor,"token SUBTYPE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_methodDef=new RewriteRuleSubtreeStream(adaptor,"rule methodDef");
        RewriteRuleSubtreeStream stream_varDef=new RewriteRuleSubtreeStream(adaptor,"rule varDef");
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:10: ( 'class' classname= ID ( 'subtypeOf' supertype= ID )? ( 'subclassOf' subclass+= ID ( ',' subclass+= ID )* )? '{' ( varDef ';' | methodDef )* '}' -> ^( CLASSDEF $classname ( ^( SUPERTYPE $supertype) )? ( ^( SUPERCLASSES ( $subclass)+ ) )? ( ^( FIELDS ( varDef )+ ) )? ( ^( METHODS ( methodDef )+ ) )? ) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:12: 'class' classname= ID ( 'subtypeOf' supertype= ID )? ( 'subclassOf' subclass+= ID ( ',' subclass+= ID )* )? '{' ( varDef ';' | methodDef )* '}'
            {
            string_literal2=(Token)match(input,CLASS,FOLLOW_CLASS_in_classDec146); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CLASS.add(string_literal2);

            classname=(Token)match(input,ID,FOLLOW_ID_in_classDec151); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(classname);

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:53:4: ( 'subtypeOf' supertype= ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==SUBTYPE) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:53:6: 'subtypeOf' supertype= ID
                    {
                    string_literal3=(Token)match(input,SUBTYPE,FOLLOW_SUBTYPE_in_classDec159); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBTYPE.add(string_literal3);

                    supertype=(Token)match(input,ID,FOLLOW_ID_in_classDec163); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(supertype);


                    }
                    break;

            }

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:54:4: ( 'subclassOf' subclass+= ID ( ',' subclass+= ID )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SUBCLASS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:54:6: 'subclassOf' subclass+= ID ( ',' subclass+= ID )*
                    {
                    string_literal4=(Token)match(input,SUBCLASS,FOLLOW_SUBCLASS_in_classDec173); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SUBCLASS.add(string_literal4);

                    subclass=(Token)match(input,ID,FOLLOW_ID_in_classDec177); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(subclass);

                    if (list_subclass==null) list_subclass=new ArrayList();
                    list_subclass.add(subclass);

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:54:32: ( ',' subclass+= ID )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==61) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:54:33: ',' subclass+= ID
                    	    {
                    	    char_literal5=(Token)match(input,61,FOLLOW_61_in_classDec180); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_61.add(char_literal5);

                    	    subclass=(Token)match(input,ID,FOLLOW_ID_in_classDec184); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(subclass);

                    	    if (list_subclass==null) list_subclass=new ArrayList();
                    	    list_subclass.add(subclass);


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal6=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_classDec194); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(char_literal6);

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:56:5: ( varDef ';' | methodDef )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==VAR) ) {
                    alt5=1;
                }
                else if ( (LA5_0==DEF) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:57:6: varDef ';'
            	    {
            	    pushFollow(FOLLOW_varDef_in_classDec207);
            	    varDef7=varDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_varDef.add(varDef7.getTree());
            	    char_literal8=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_classDec209); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_SEMICOLON.add(char_literal8);


            	    }
            	    break;
            	case 2 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:59:6: methodDef
            	    {
            	    pushFollow(FOLLOW_methodDef_in_classDec223);
            	    methodDef9=methodDef();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_methodDef.add(methodDef9.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            char_literal10=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_classDec235); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(char_literal10);



            // AST REWRITE
            // elements: methodDef, classname, supertype, varDef, subclass
            // token labels: classname, supertype
            // rule labels: retval
            // token list labels: subclass
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_classname=new RewriteRuleTokenStream(adaptor,"token classname",classname);
            RewriteRuleTokenStream stream_supertype=new RewriteRuleTokenStream(adaptor,"token supertype",supertype);
            RewriteRuleTokenStream stream_subclass=new RewriteRuleTokenStream(adaptor,"token subclass", list_subclass);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:4: -> ^( CLASSDEF $classname ( ^( SUPERTYPE $supertype) )? ( ^( SUPERCLASSES ( $subclass)+ ) )? ( ^( FIELDS ( varDef )+ ) )? ( ^( METHODS ( methodDef )+ ) )? )
            {
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:7: ^( CLASSDEF $classname ( ^( SUPERTYPE $supertype) )? ( ^( SUPERCLASSES ( $subclass)+ ) )? ( ^( FIELDS ( varDef )+ ) )? ( ^( METHODS ( methodDef )+ ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CLASSDEF, "CLASSDEF"), root_1);

                adaptor.addChild(root_1, stream_classname.nextNode());
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:29: ( ^( SUPERTYPE $supertype) )?
                if ( stream_supertype.hasNext() ) {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:29: ^( SUPERTYPE $supertype)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUPERTYPE, "SUPERTYPE"), root_2);

                    adaptor.addChild(root_2, stream_supertype.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_supertype.reset();
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:54: ( ^( SUPERCLASSES ( $subclass)+ ) )?
                if ( stream_subclass.hasNext() ) {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:54: ^( SUPERCLASSES ( $subclass)+ )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(SUPERCLASSES, "SUPERCLASSES"), root_2);

                    if ( !(stream_subclass.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_subclass.hasNext() ) {
                        adaptor.addChild(root_2, stream_subclass.nextNode());

                    }
                    stream_subclass.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_subclass.reset();
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:82: ( ^( FIELDS ( varDef )+ ) )?
                if ( stream_varDef.hasNext() ) {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:82: ^( FIELDS ( varDef )+ )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIELDS, "FIELDS"), root_2);

                    if ( !(stream_varDef.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_varDef.hasNext() ) {
                        adaptor.addChild(root_2, stream_varDef.nextTree());

                    }
                    stream_varDef.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_varDef.reset();
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:101: ( ^( METHODS ( methodDef )+ ) )?
                if ( stream_methodDef.hasNext() ) {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:62:101: ^( METHODS ( methodDef )+ )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODS, "METHODS"), root_2);

                    if ( !(stream_methodDef.hasNext()) ) {
                        throw new RewriteEarlyExitException();
                    }
                    while ( stream_methodDef.hasNext() ) {
                        adaptor.addChild(root_2, stream_methodDef.nextTree());

                    }
                    stream_methodDef.reset();

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_methodDef.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "classDec"

    public static class varDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDef"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:1: varDef : 'var' name= ID ':' type= ID -> ^( VARDEF $type $name) ;
    public final OoplssParser.varDef_return varDef() throws RecognitionException {
        OoplssParser.varDef_return retval = new OoplssParser.varDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token type=null;
        Token string_literal11=null;
        Token char_literal12=null;

        Object name_tree=null;
        Object type_tree=null;
        Object string_literal11_tree=null;
        Object char_literal12_tree=null;
        RewriteRuleTokenStream stream_VAR=new RewriteRuleTokenStream(adaptor,"token VAR");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:9: ( 'var' name= ID ':' type= ID -> ^( VARDEF $type $name) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:11: 'var' name= ID ':' type= ID
            {
            string_literal11=(Token)match(input,VAR,FOLLOW_VAR_in_varDef296); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_VAR.add(string_literal11);

            name=(Token)match(input,ID,FOLLOW_ID_in_varDef300); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(name);

            char_literal12=(Token)match(input,62,FOLLOW_62_in_varDef302); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(char_literal12);

            type=(Token)match(input,ID,FOLLOW_ID_in_varDef306); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(type);



            // AST REWRITE
            // elements: type, name
            // token labels: name, type
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleTokenStream stream_type=new RewriteRuleTokenStream(adaptor,"token type",type);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 66:37: -> ^( VARDEF $type $name)
            {
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:40: ^( VARDEF $type $name)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARDEF, "VARDEF"), root_1);

                adaptor.addChild(root_1, stream_type.nextNode());
                adaptor.addChild(root_1, stream_name.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "varDef"

    public static class methodDef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "methodDef"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:68:1: methodDef : 'def' ( (name= ID argumentDeclList ':' rettype= ID ) | (name= '__construct' argumentDeclList ) ) block -> ^( METHODDEF $name ( ^( RETURNTYPE $rettype) )? block ) ;
    public final OoplssParser.methodDef_return methodDef() throws RecognitionException {
        OoplssParser.methodDef_return retval = new OoplssParser.methodDef_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token name=null;
        Token rettype=null;
        Token string_literal13=null;
        Token char_literal15=null;
        OoplssParser.argumentDeclList_return argumentDeclList14 = null;

        OoplssParser.argumentDeclList_return argumentDeclList16 = null;

        OoplssParser.block_return block17 = null;


        Object name_tree=null;
        Object rettype_tree=null;
        Object string_literal13_tree=null;
        Object char_literal15_tree=null;
        RewriteRuleTokenStream stream_CONSTRUCT=new RewriteRuleTokenStream(adaptor,"token CONSTRUCT");
        RewriteRuleTokenStream stream_DEF=new RewriteRuleTokenStream(adaptor,"token DEF");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_argumentDeclList=new RewriteRuleSubtreeStream(adaptor,"rule argumentDeclList");
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:68:11: ( 'def' ( (name= ID argumentDeclList ':' rettype= ID ) | (name= '__construct' argumentDeclList ) ) block -> ^( METHODDEF $name ( ^( RETURNTYPE $rettype) )? block ) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:4: 'def' ( (name= ID argumentDeclList ':' rettype= ID ) | (name= '__construct' argumentDeclList ) ) block
            {
            string_literal13=(Token)match(input,DEF,FOLLOW_DEF_in_methodDef331); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEF.add(string_literal13);

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:10: ( (name= ID argumentDeclList ':' rettype= ID ) | (name= '__construct' argumentDeclList ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==CONSTRUCT) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:11: (name= ID argumentDeclList ':' rettype= ID )
                    {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:11: (name= ID argumentDeclList ':' rettype= ID )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:12: name= ID argumentDeclList ':' rettype= ID
                    {
                    name=(Token)match(input,ID,FOLLOW_ID_in_methodDef337); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(name);

                    pushFollow(FOLLOW_argumentDeclList_in_methodDef339);
                    argumentDeclList14=argumentDeclList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argumentDeclList.add(argumentDeclList14.getTree());
                    char_literal15=(Token)match(input,62,FOLLOW_62_in_methodDef341); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_62.add(char_literal15);

                    rettype=(Token)match(input,ID,FOLLOW_ID_in_methodDef345); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(rettype);


                    }


                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:55: (name= '__construct' argumentDeclList )
                    {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:55: (name= '__construct' argumentDeclList )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:69:56: name= '__construct' argumentDeclList
                    {
                    name=(Token)match(input,CONSTRUCT,FOLLOW_CONSTRUCT_in_methodDef353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONSTRUCT.add(name);

                    pushFollow(FOLLOW_argumentDeclList_in_methodDef355);
                    argumentDeclList16=argumentDeclList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argumentDeclList.add(argumentDeclList16.getTree());

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_methodDef362);
            block17=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_block.add(block17.getTree());


            // AST REWRITE
            // elements: block, rettype, name
            // token labels: name, rettype
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
            RewriteRuleTokenStream stream_rettype=new RewriteRuleTokenStream(adaptor,"token rettype",rettype);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 70:10: -> ^( METHODDEF $name ( ^( RETURNTYPE $rettype) )? block )
            {
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:13: ^( METHODDEF $name ( ^( RETURNTYPE $rettype) )? block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODDEF, "METHODDEF"), root_1);

                adaptor.addChild(root_1, stream_name.nextNode());
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:31: ( ^( RETURNTYPE $rettype) )?
                if ( stream_rettype.hasNext() ) {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:31: ^( RETURNTYPE $rettype)
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURNTYPE, "RETURNTYPE"), root_2);

                    adaptor.addChild(root_2, stream_rettype.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_rettype.reset();
                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "methodDef"

    public static class argumentDeclList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argumentDeclList"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:73:1: argumentDeclList : '(' ')' ;
    public final OoplssParser.argumentDeclList_return argumentDeclList() throws RecognitionException {
        OoplssParser.argumentDeclList_return retval = new OoplssParser.argumentDeclList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal18=null;
        Token char_literal19=null;

        Object char_literal18_tree=null;
        Object char_literal19_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:74:3: ( '(' ')' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:74:6: '(' ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal18=(Token)match(input,LPARA,FOLLOW_LPARA_in_argumentDeclList399); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal18_tree = (Object)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);
            }
            char_literal19=(Token)match(input,RPARA,FOLLOW_RPARA_in_argumentDeclList401); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal19_tree = (Object)adaptor.create(char_literal19);
            adaptor.addChild(root_0, char_literal19_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "argumentDeclList"

    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "block"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:76:1: block : '{' ( blockStatement )* '}' -> ^( BLOCK ( blockStatement )* ) ;
    public final OoplssParser.block_return block() throws RecognitionException {
        OoplssParser.block_return retval = new OoplssParser.block_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal20=null;
        Token char_literal22=null;
        OoplssParser.blockStatement_return blockStatement21 = null;


        Object char_literal20_tree=null;
        Object char_literal22_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_LBRACE=new RewriteRuleTokenStream(adaptor,"token LBRACE");
        RewriteRuleSubtreeStream stream_blockStatement=new RewriteRuleSubtreeStream(adaptor,"rule blockStatement");
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:76:9: ( '{' ( blockStatement )* '}' -> ^( BLOCK ( blockStatement )* ) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:76:12: '{' ( blockStatement )* '}'
            {
            char_literal20=(Token)match(input,LBRACE,FOLLOW_LBRACE_in_block412); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LBRACE.add(char_literal20);

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:77:4: ( blockStatement )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==SELF||(LA7_0>=ID && LA7_0<=BOOLLITERAL)||LA7_0==SEMICOLON||LA7_0==LBRACE||LA7_0==LPARA||LA7_0==VAR||LA7_0==RETURNSTMT||(LA7_0>=IFSTMT && LA7_0<=FORSTMT)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:77:5: blockStatement
            	    {
            	    pushFollow(FOLLOW_blockStatement_in_block418);
            	    blockStatement21=blockStatement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_blockStatement.add(blockStatement21.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            char_literal22=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_block425); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RBRACE.add(char_literal22);



            // AST REWRITE
            // elements: blockStatement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 78:8: -> ^( BLOCK ( blockStatement )* )
            {
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:78:11: ^( BLOCK ( blockStatement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOCK, "BLOCK"), root_1);

                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:78:19: ( blockStatement )*
                while ( stream_blockStatement.hasNext() ) {
                    adaptor.addChild(root_1, stream_blockStatement.nextTree());

                }
                stream_blockStatement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class blockStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "blockStatement"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:81:1: blockStatement options {k=2; backtrack=true; } : ( varDef ';' ! | statement ';' ! | assignment ';' ! | block | retStmt ';' ! | ifStmt | whileStmt | forStmt | ';' !);
    public final OoplssParser.blockStatement_return blockStatement() throws RecognitionException {
        OoplssParser.blockStatement_return retval = new OoplssParser.blockStatement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal24=null;
        Token char_literal26=null;
        Token char_literal28=null;
        Token char_literal31=null;
        Token char_literal35=null;
        OoplssParser.varDef_return varDef23 = null;

        OoplssParser.statement_return statement25 = null;

        OoplssParser.assignment_return assignment27 = null;

        OoplssParser.block_return block29 = null;

        OoplssParser.retStmt_return retStmt30 = null;

        OoplssParser.ifStmt_return ifStmt32 = null;

        OoplssParser.whileStmt_return whileStmt33 = null;

        OoplssParser.forStmt_return forStmt34 = null;


        Object char_literal24_tree=null;
        Object char_literal26_tree=null;
        Object char_literal28_tree=null;
        Object char_literal31_tree=null;
        Object char_literal35_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:85:4: ( varDef ';' ! | statement ';' ! | assignment ';' ! | block | retStmt ';' ! | ifStmt | whileStmt | forStmt | ';' !)
            int alt8=9;
            switch ( input.LA(1) ) {
            case VAR:
                {
                alt8=1;
                }
                break;
            case INTLITERAL:
            case STRINGLITERAL:
            case CHARLITERAL:
            case BOOLLITERAL:
            case LPARA:
                {
                alt8=2;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case LBRACK:
                    {
                    int LA8_15 = input.LA(3);

                    if ( (synpred10_Ooplss()) ) {
                        alt8=2;
                    }
                    else if ( (synpred11_Ooplss()) ) {
                        alt8=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 15, input);

                        throw nvae;
                    }
                    }
                    break;
                case CALLOPERATOR:
                    {
                    int LA8_16 = input.LA(3);

                    if ( (synpred10_Ooplss()) ) {
                        alt8=2;
                    }
                    else if ( (synpred11_Ooplss()) ) {
                        alt8=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 16, input);

                        throw nvae;
                    }
                    }
                    break;
                case SEMICOLON:
                case PLUSOPERATOR:
                case MINUSOPERATOR:
                case TIMESOPERATOR:
                case DIVIDEOPERATOR:
                case ANDOPERATOR:
                case OROPERATOR:
                case EQ:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    {
                    alt8=2;
                    }
                    break;
                case EQOPERATOR:
                    {
                    alt8=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 6, input);

                    throw nvae;
                }

                }
                break;
            case SELF:
                {
                int LA8_7 = input.LA(2);

                if ( (LA8_7==CALLOPERATOR) ) {
                    int LA8_26 = input.LA(3);

                    if ( (synpred10_Ooplss()) ) {
                        alt8=2;
                    }
                    else if ( (synpred11_Ooplss()) ) {
                        alt8=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 26, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 7, input);

                    throw nvae;
                }
                }
                break;
            case LBRACE:
                {
                alt8=4;
                }
                break;
            case RETURNSTMT:
                {
                alt8=5;
                }
                break;
            case IFSTMT:
                {
                alt8=6;
                }
                break;
            case WHILESTMT:
                {
                alt8=7;
                }
                break;
            case FORSTMT:
                {
                alt8=8;
                }
                break;
            case SEMICOLON:
                {
                alt8=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:85:6: varDef ';' !
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_varDef_in_blockStatement463);
                    varDef23=varDef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varDef23.getTree());
                    char_literal24=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_blockStatement465); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:86:5: statement ';' !
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_blockStatement472);
                    statement25=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement25.getTree());
                    char_literal26=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_blockStatement474); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:87:5: assignment ';' !
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assignment_in_blockStatement481);
                    assignment27=assignment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment27.getTree());
                    char_literal28=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_blockStatement483); if (state.failed) return retval;

                    }
                    break;
                case 4 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:88:5: block
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_block_in_blockStatement490);
                    block29=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block29.getTree());

                    }
                    break;
                case 5 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:89:5: retStmt ';' !
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_retStmt_in_blockStatement496);
                    retStmt30=retStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, retStmt30.getTree());
                    char_literal31=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_blockStatement498); if (state.failed) return retval;

                    }
                    break;
                case 6 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:90:5: ifStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_ifStmt_in_blockStatement505);
                    ifStmt32=ifStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStmt32.getTree());

                    }
                    break;
                case 7 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:91:5: whileStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_whileStmt_in_blockStatement511);
                    whileStmt33=whileStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStmt33.getTree());

                    }
                    break;
                case 8 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:92:5: forStmt
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_forStmt_in_blockStatement517);
                    forStmt34=forStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStmt34.getTree());

                    }
                    break;
                case 9 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:93:5: ';' !
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal35=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_blockStatement523); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blockStatement"

    public static class assignmentEntry_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentEntry"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:96:1: assignmentEntry : assignment EOF ;
    public final OoplssParser.assignmentEntry_return assignmentEntry() throws RecognitionException {
        OoplssParser.assignmentEntry_return retval = new OoplssParser.assignmentEntry_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF37=null;
        OoplssParser.assignment_return assignment36 = null;


        Object EOF37_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:96:17: ( assignment EOF )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:96:20: assignment EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_assignment_in_assignmentEntry538);
            assignment36=assignment();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment36.getTree());
            EOF37=(Token)match(input,EOF,FOLLOW_EOF_in_assignmentEntry540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF37_tree = (Object)adaptor.create(EOF37);
            adaptor.addChild(root_0, EOF37_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignmentEntry"

    public static class assignment_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:98:1: assignment options {k=*; backtrack=true; } : varAccess '=' statement -> ^( '=' varAccess statement ) ;
    public final OoplssParser.assignment_return assignment() throws RecognitionException {
        OoplssParser.assignment_return retval = new OoplssParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal39=null;
        OoplssParser.varAccess_return varAccess38 = null;

        OoplssParser.statement_return statement40 = null;


        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_EQOPERATOR=new RewriteRuleTokenStream(adaptor,"token EQOPERATOR");
        RewriteRuleSubtreeStream stream_varAccess=new RewriteRuleSubtreeStream(adaptor,"rule varAccess");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:102:4: ( varAccess '=' statement -> ^( '=' varAccess statement ) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:102:12: varAccess '=' statement
            {
            pushFollow(FOLLOW_varAccess_in_assignment577);
            varAccess38=varAccess();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_varAccess.add(varAccess38.getTree());
            char_literal39=(Token)match(input,EQOPERATOR,FOLLOW_EQOPERATOR_in_assignment579); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EQOPERATOR.add(char_literal39);

            pushFollow(FOLLOW_statement_in_assignment581);
            statement40=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement40.getTree());


            // AST REWRITE
            // elements: varAccess, statement, EQOPERATOR
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 103:4: -> ^( '=' varAccess statement )
            {
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:103:7: ^( '=' varAccess statement )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_EQOPERATOR.nextNode(), root_1);

                adaptor.addChild(root_1, stream_varAccess.nextTree());
                adaptor.addChild(root_1, stream_statement.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class varAccessEntry_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varAccessEntry"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:107:1: varAccessEntry : varAccess EOF ;
    public final OoplssParser.varAccessEntry_return varAccessEntry() throws RecognitionException {
        OoplssParser.varAccessEntry_return retval = new OoplssParser.varAccessEntry_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EOF42=null;
        OoplssParser.varAccess_return varAccess41 = null;


        Object EOF42_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:107:17: ( varAccess EOF )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:107:20: varAccess EOF
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_varAccess_in_varAccessEntry610);
            varAccess41=varAccess();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, varAccess41.getTree());
            EOF42=(Token)match(input,EOF,FOLLOW_EOF_in_varAccessEntry612); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF42_tree = (Object)adaptor.create(EOF42);
            adaptor.addChild(root_0, EOF42_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "varAccessEntry"

    public static class varAccess_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varAccess"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:109:1: varAccess : ( ID -> ^( VARACCESS ID ) | ID '[' statement ']' -> ^( ARRAYACCESS ID statement ) | 'self' '.' ID '[' statement ']' -> ^( '.' SELF ^( ARRAYACCESS ID statement ) ) | 'self' '.' ID -> ^( '.' SELF ^( VARACCESS ID ) ) ) ( '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')' -> ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) ) | '.' id= ID '[' statement ']' -> ^( '.' $varAccess ^( ARRAYACCESS $id statement ) ) | '.' id= ID -> ^( '.' $varAccess ^( VARACCESS $id) ) )* ;
    public final OoplssParser.varAccess_return varAccess() throws RecognitionException {
        OoplssParser.varAccess_return retval = new OoplssParser.varAccess_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token ID43=null;
        Token ID44=null;
        Token char_literal45=null;
        Token char_literal47=null;
        Token string_literal48=null;
        Token char_literal49=null;
        Token ID50=null;
        Token char_literal51=null;
        Token char_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token ID56=null;
        Token char_literal57=null;
        Token char_literal58=null;
        Token char_literal59=null;
        Token char_literal60=null;
        Token char_literal61=null;
        Token char_literal62=null;
        Token char_literal64=null;
        Token char_literal65=null;
        List list_arg=null;
        OoplssParser.statement_return statement46 = null;

        OoplssParser.statement_return statement52 = null;

        OoplssParser.statement_return statement63 = null;

        RuleReturnScope arg = null;
        Object id_tree=null;
        Object ID43_tree=null;
        Object ID44_tree=null;
        Object char_literal45_tree=null;
        Object char_literal47_tree=null;
        Object string_literal48_tree=null;
        Object char_literal49_tree=null;
        Object ID50_tree=null;
        Object char_literal51_tree=null;
        Object char_literal53_tree=null;
        Object string_literal54_tree=null;
        Object char_literal55_tree=null;
        Object ID56_tree=null;
        Object char_literal57_tree=null;
        Object char_literal58_tree=null;
        Object char_literal59_tree=null;
        Object char_literal60_tree=null;
        Object char_literal61_tree=null;
        Object char_literal62_tree=null;
        Object char_literal64_tree=null;
        Object char_literal65_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_LPARA=new RewriteRuleTokenStream(adaptor,"token LPARA");
        RewriteRuleTokenStream stream_SELF=new RewriteRuleTokenStream(adaptor,"token SELF");
        RewriteRuleTokenStream stream_RPARA=new RewriteRuleTokenStream(adaptor,"token RPARA");
        RewriteRuleTokenStream stream_CALLOPERATOR=new RewriteRuleTokenStream(adaptor,"token CALLOPERATOR");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:115:3: ( ( ID -> ^( VARACCESS ID ) | ID '[' statement ']' -> ^( ARRAYACCESS ID statement ) | 'self' '.' ID '[' statement ']' -> ^( '.' SELF ^( ARRAYACCESS ID statement ) ) | 'self' '.' ID -> ^( '.' SELF ^( VARACCESS ID ) ) ) ( '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')' -> ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) ) | '.' id= ID '[' statement ']' -> ^( '.' $varAccess ^( ARRAYACCESS $id statement ) ) | '.' id= ID -> ^( '.' $varAccess ^( VARACCESS $id) ) )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:116:3: ( ID -> ^( VARACCESS ID ) | ID '[' statement ']' -> ^( ARRAYACCESS ID statement ) | 'self' '.' ID '[' statement ']' -> ^( '.' SELF ^( ARRAYACCESS ID statement ) ) | 'self' '.' ID -> ^( '.' SELF ^( VARACCESS ID ) ) ) ( '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')' -> ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) ) | '.' id= ID '[' statement ']' -> ^( '.' $varAccess ^( ARRAYACCESS $id statement ) ) | '.' id= ID -> ^( '.' $varAccess ^( VARACCESS $id) ) )*
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:116:3: ( ID -> ^( VARACCESS ID ) | ID '[' statement ']' -> ^( ARRAYACCESS ID statement ) | 'self' '.' ID '[' statement ']' -> ^( '.' SELF ^( ARRAYACCESS ID statement ) ) | 'self' '.' ID -> ^( '.' SELF ^( VARACCESS ID ) ) )
            int alt9=4;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==LBRACK) ) {
                    alt9=2;
                }
                else if ( (LA9_1==EOF||(LA9_1>=EQOPERATOR && LA9_1<=OROPERATOR)||LA9_1==RPARA||LA9_1==RBRACK||LA9_1==EQ||LA9_1==61||(LA9_1>=63 && LA9_1<=67)) ) {
                    alt9=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==SELF) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==CALLOPERATOR) ) {
                    int LA9_18 = input.LA(3);

                    if ( (synpred19_Ooplss()) ) {
                        alt9=3;
                    }
                    else if ( (true) ) {
                        alt9=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 18, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:117:5: ID
                    {
                    ID43=(Token)match(input,ID,FOLLOW_ID_in_varAccess634); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID43);



                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 117:8: -> ^( VARACCESS ID )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:117:11: ^( VARACCESS ID )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARACCESS, "VARACCESS"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:119:5: ID '[' statement ']'
                    {
                    ID44=(Token)match(input,ID,FOLLOW_ID_in_varAccess653); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID44);

                    char_literal45=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_varAccess655); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACK.add(char_literal45);

                    pushFollow(FOLLOW_statement_in_varAccess657);
                    statement46=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement46.getTree());
                    char_literal47=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_varAccess659); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACK.add(char_literal47);



                    // AST REWRITE
                    // elements: statement, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 119:26: -> ^( ARRAYACCESS ID statement )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:119:29: ^( ARRAYACCESS ID statement )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAYACCESS, "ARRAYACCESS"), root_1);

                        adaptor.addChild(root_1, stream_ID.nextNode());
                        adaptor.addChild(root_1, stream_statement.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:121:5: 'self' '.' ID '[' statement ']'
                    {
                    string_literal48=(Token)match(input,SELF,FOLLOW_SELF_in_varAccess680); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SELF.add(string_literal48);

                    char_literal49=(Token)match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_varAccess682); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CALLOPERATOR.add(char_literal49);

                    ID50=(Token)match(input,ID,FOLLOW_ID_in_varAccess684); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID50);

                    char_literal51=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_varAccess686); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACK.add(char_literal51);

                    pushFollow(FOLLOW_statement_in_varAccess688);
                    statement52=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(statement52.getTree());
                    char_literal53=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_varAccess690); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACK.add(char_literal53);



                    // AST REWRITE
                    // elements: statement, ID, CALLOPERATOR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 121:37: -> ^( '.' SELF ^( ARRAYACCESS ID statement ) )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:121:40: ^( '.' SELF ^( ARRAYACCESS ID statement ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CALLOPERATOR.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(SELF, "SELF"));
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:121:51: ^( ARRAYACCESS ID statement )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAYACCESS, "ARRAYACCESS"), root_2);

                        adaptor.addChild(root_2, stream_ID.nextNode());
                        adaptor.addChild(root_2, stream_statement.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:123:5: 'self' '.' ID
                    {
                    string_literal54=(Token)match(input,SELF,FOLLOW_SELF_in_varAccess717); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SELF.add(string_literal54);

                    char_literal55=(Token)match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_varAccess719); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CALLOPERATOR.add(char_literal55);

                    ID56=(Token)match(input,ID,FOLLOW_ID_in_varAccess721); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID56);



                    // AST REWRITE
                    // elements: CALLOPERATOR, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 123:19: -> ^( '.' SELF ^( VARACCESS ID ) )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:123:22: ^( '.' SELF ^( VARACCESS ID ) )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_CALLOPERATOR.nextNode(), root_1);

                        adaptor.addChild(root_1, (Object)adaptor.create(SELF, "SELF"));
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:123:33: ^( VARACCESS ID )
                        {
                        Object root_2 = (Object)adaptor.nil();
                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARACCESS, "VARACCESS"), root_2);

                        adaptor.addChild(root_2, stream_ID.nextNode());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:125:3: ( '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')' -> ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) ) | '.' id= ID '[' statement ']' -> ^( '.' $varAccess ^( ARRAYACCESS $id statement ) ) | '.' id= ID -> ^( '.' $varAccess ^( VARACCESS $id) ) )*
            loop12:
            do {
                int alt12=4;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==CALLOPERATOR) ) {
                    int LA12_14 = input.LA(2);

                    if ( (LA12_14==ID) ) {
                        int LA12_15 = input.LA(3);

                        if ( (synpred22_Ooplss()) ) {
                            alt12=1;
                        }
                        else if ( (synpred23_Ooplss()) ) {
                            alt12=2;
                        }
                        else if ( (synpred24_Ooplss()) ) {
                            alt12=3;
                        }


                    }


                }


                switch (alt12) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:5: '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')'
            	    {
            	    char_literal57=(Token)match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_varAccess750); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CALLOPERATOR.add(char_literal57);

            	    id=(Token)match(input,ID,FOLLOW_ID_in_varAccess754); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(id);

            	    char_literal58=(Token)match(input,LPARA,FOLLOW_LPARA_in_varAccess756); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LPARA.add(char_literal58);

            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:19: (arg+= statement ( ',' arg+= statement )* )?
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==SELF||(LA11_0>=ID && LA11_0<=BOOLLITERAL)||LA11_0==LPARA) ) {
            	        alt11=1;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:20: arg+= statement ( ',' arg+= statement )*
            	            {
            	            pushFollow(FOLLOW_statement_in_varAccess761);
            	            arg=statement();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_statement.add(arg.getTree());
            	            if (list_arg==null) list_arg=new ArrayList();
            	            list_arg.add(arg.getTree());

            	            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:35: ( ',' arg+= statement )*
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==61) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:36: ',' arg+= statement
            	            	    {
            	            	    char_literal59=(Token)match(input,61,FOLLOW_61_in_varAccess764); if (state.failed) return retval; 
            	            	    if ( state.backtracking==0 ) stream_61.add(char_literal59);

            	            	    pushFollow(FOLLOW_statement_in_varAccess768);
            	            	    arg=statement();

            	            	    state._fsp--;
            	            	    if (state.failed) return retval;
            	            	    if ( state.backtracking==0 ) stream_statement.add(arg.getTree());
            	            	    if (list_arg==null) list_arg=new ArrayList();
            	            	    list_arg.add(arg.getTree());


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop10;
            	                }
            	            } while (true);


            	            }
            	            break;

            	    }

            	    char_literal60=(Token)match(input,RPARA,FOLLOW_RPARA_in_varAccess775); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RPARA.add(char_literal60);



            	    // AST REWRITE
            	    // elements: arg, id, CALLOPERATOR, varAccess
            	    // token labels: id
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: arg
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            	    RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"token arg",list_arg);
            	    root_0 = (Object)adaptor.nil();
            	    // 126:64: -> ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) )
            	    {
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:67: ^( '.' $varAccess ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? ) )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_CALLOPERATOR.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:84: ^( METHODCALL $id ( ^( METHODARGS ( $arg)+ ) )? )
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODCALL, "METHODCALL"), root_2);

            	        adaptor.addChild(root_2, stream_id.nextNode());
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:101: ( ^( METHODARGS ( $arg)+ ) )?
            	        if ( stream_arg.hasNext() ) {
            	            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:101: ^( METHODARGS ( $arg)+ )
            	            {
            	            Object root_3 = (Object)adaptor.nil();
            	            root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHODARGS, "METHODARGS"), root_3);

            	            if ( !(stream_arg.hasNext()) ) {
            	                throw new RewriteEarlyExitException();
            	            }
            	            while ( stream_arg.hasNext() ) {
            	                adaptor.addChild(root_3, stream_arg.nextTree());

            	            }
            	            stream_arg.reset();

            	            adaptor.addChild(root_2, root_3);
            	            }

            	        }
            	        stream_arg.reset();

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 2 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:128:5: '.' id= ID '[' statement ']'
            	    {
            	    char_literal61=(Token)match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_varAccess811); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CALLOPERATOR.add(char_literal61);

            	    id=(Token)match(input,ID,FOLLOW_ID_in_varAccess815); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(id);

            	    char_literal62=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_varAccess817); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_LBRACK.add(char_literal62);

            	    pushFollow(FOLLOW_statement_in_varAccess819);
            	    statement63=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(statement63.getTree());
            	    char_literal64=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_varAccess821); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_RBRACK.add(char_literal64);



            	    // AST REWRITE
            	    // elements: varAccess, id, CALLOPERATOR, statement
            	    // token labels: id
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 128:33: -> ^( '.' $varAccess ^( ARRAYACCESS $id statement ) )
            	    {
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:128:36: ^( '.' $varAccess ^( ARRAYACCESS $id statement ) )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_CALLOPERATOR.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:128:53: ^( ARRAYACCESS $id statement )
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAYACCESS, "ARRAYACCESS"), root_2);

            	        adaptor.addChild(root_2, stream_id.nextNode());
            	        adaptor.addChild(root_2, stream_statement.nextTree());

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;
            	case 3 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:130:5: '.' id= ID
            	    {
            	    char_literal65=(Token)match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_varAccess850); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_CALLOPERATOR.add(char_literal65);

            	    id=(Token)match(input,ID,FOLLOW_ID_in_varAccess854); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(id);



            	    // AST REWRITE
            	    // elements: id, varAccess, CALLOPERATOR
            	    // token labels: id
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {
            	    retval.tree = root_0;
            	    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 130:15: -> ^( '.' $varAccess ^( VARACCESS $id) )
            	    {
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:130:18: ^( '.' $varAccess ^( VARACCESS $id) )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        root_1 = (Object)adaptor.becomeRoot(stream_CALLOPERATOR.nextNode(), root_1);

            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:130:35: ^( VARACCESS $id)
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARACCESS, "VARACCESS"), root_2);

            	        adaptor.addChild(root_2, stream_id.nextNode());

            	        adaptor.addChild(root_1, root_2);
            	        }

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }

            	    retval.tree = root_0;}
            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "varAccess"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:138:1: statement : expression ;
    public final OoplssParser.statement_return statement() throws RecognitionException {
        OoplssParser.statement_return retval = new OoplssParser.statement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OoplssParser.expression_return expression66 = null;



        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:138:11: ( expression )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:139:4: expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expression_in_statement901);
            expression66=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression66.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class retStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "retStmt"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:142:1: retStmt : 'return' statement ;
    public final OoplssParser.retStmt_return retStmt() throws RecognitionException {
        OoplssParser.retStmt_return retval = new OoplssParser.retStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal67=null;
        OoplssParser.statement_return statement68 = null;


        Object string_literal67_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:142:10: ( 'return' statement )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:142:12: 'return' statement
            {
            root_0 = (Object)adaptor.nil();

            string_literal67=(Token)match(input,RETURNSTMT,FOLLOW_RETURNSTMT_in_retStmt915); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal67_tree = (Object)adaptor.create(string_literal67);
            adaptor.addChild(root_0, string_literal67_tree);
            }
            pushFollow(FOLLOW_statement_in_retStmt917);
            statement68=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement68.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "retStmt"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:144:1: expression : orExpr ;
    public final OoplssParser.expression_return expression() throws RecognitionException {
        OoplssParser.expression_return retval = new OoplssParser.expression_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OoplssParser.orExpr_return orExpr69 = null;



        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:144:12: ( orExpr )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:144:14: orExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expression928);
            orExpr69=orExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, orExpr69.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class orExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "orExpr"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:146:1: orExpr : andExpr ( '||' ^ andExpr )? ;
    public final OoplssParser.orExpr_return orExpr() throws RecognitionException {
        OoplssParser.orExpr_return retval = new OoplssParser.orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal71=null;
        OoplssParser.andExpr_return andExpr70 = null;

        OoplssParser.andExpr_return andExpr72 = null;


        Object string_literal71_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:146:9: ( andExpr ( '||' ^ andExpr )? )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:146:11: andExpr ( '||' ^ andExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpr_in_orExpr937);
            andExpr70=andExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr70.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:146:19: ( '||' ^ andExpr )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==OROPERATOR) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:146:20: '||' ^ andExpr
                    {
                    string_literal71=(Token)match(input,OROPERATOR,FOLLOW_OROPERATOR_in_orExpr940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (Object)adaptor.create(string_literal71);
                    root_0 = (Object)adaptor.becomeRoot(string_literal71_tree, root_0);
                    }
                    pushFollow(FOLLOW_andExpr_in_orExpr943);
                    andExpr72=andExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpr72.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "orExpr"

    public static class andExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpr"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:148:1: andExpr : equality ( '&&' ^ equality )? ;
    public final OoplssParser.andExpr_return andExpr() throws RecognitionException {
        OoplssParser.andExpr_return retval = new OoplssParser.andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal74=null;
        OoplssParser.equality_return equality73 = null;

        OoplssParser.equality_return equality75 = null;


        Object string_literal74_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:148:10: ( equality ( '&&' ^ equality )? )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:148:12: equality ( '&&' ^ equality )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equality_in_andExpr955);
            equality73=equality();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equality73.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:148:21: ( '&&' ^ equality )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ANDOPERATOR) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:148:22: '&&' ^ equality
                    {
                    string_literal74=(Token)match(input,ANDOPERATOR,FOLLOW_ANDOPERATOR_in_andExpr958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal74_tree = (Object)adaptor.create(string_literal74);
                    root_0 = (Object)adaptor.becomeRoot(string_literal74_tree, root_0);
                    }
                    pushFollow(FOLLOW_equality_in_andExpr961);
                    equality75=equality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, equality75.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "andExpr"

    public static class equality_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equality"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:150:1: equality : inequality ( ( '==' | '!=' ) ^ inequality )? ;
    public final OoplssParser.equality_return equality() throws RecognitionException {
        OoplssParser.equality_return retval = new OoplssParser.equality_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set77=null;
        OoplssParser.inequality_return inequality76 = null;

        OoplssParser.inequality_return inequality78 = null;


        Object set77_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:150:10: ( inequality ( ( '==' | '!=' ) ^ inequality )? )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:150:12: inequality ( ( '==' | '!=' ) ^ inequality )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inequality_in_equality972);
            inequality76=inequality();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inequality76.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:150:23: ( ( '==' | '!=' ) ^ inequality )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==EQ||LA15_0==63) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:150:24: ( '==' | '!=' ) ^ inequality
                    {
                    set77=(Token)input.LT(1);
                    set77=(Token)input.LT(1);
                    if ( input.LA(1)==EQ||input.LA(1)==63 ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set77), root_0);
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_inequality_in_equality982);
                    inequality78=inequality();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, inequality78.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "equality"

    public static class inequality_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inequality"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:152:1: inequality : dashExpr ( ( '<' | '<=' | '>' | '>=' ) ^ dashExpr )? ;
    public final OoplssParser.inequality_return inequality() throws RecognitionException {
        OoplssParser.inequality_return retval = new OoplssParser.inequality_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set80=null;
        OoplssParser.dashExpr_return dashExpr79 = null;

        OoplssParser.dashExpr_return dashExpr81 = null;


        Object set80_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:152:12: ( dashExpr ( ( '<' | '<=' | '>' | '>=' ) ^ dashExpr )? )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:152:14: dashExpr ( ( '<' | '<=' | '>' | '>=' ) ^ dashExpr )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_dashExpr_in_inequality992);
            dashExpr79=dashExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dashExpr79.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:152:23: ( ( '<' | '<=' | '>' | '>=' ) ^ dashExpr )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=64 && LA16_0<=67)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:152:24: ( '<' | '<=' | '>' | '>=' ) ^ dashExpr
                    {
                    set80=(Token)input.LT(1);
                    set80=(Token)input.LT(1);
                    if ( (input.LA(1)>=64 && input.LA(1)<=67) ) {
                        input.consume();
                        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set80), root_0);
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_dashExpr_in_inequality1006);
                    dashExpr81=dashExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dashExpr81.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inequality"

    public static class dashExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dashExpr"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:154:1: dashExpr : pointExpr ( ( '+' | '-' ) ^ pointExpr )* ;
    public final OoplssParser.dashExpr_return dashExpr() throws RecognitionException {
        OoplssParser.dashExpr_return retval = new OoplssParser.dashExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set83=null;
        OoplssParser.pointExpr_return pointExpr82 = null;

        OoplssParser.pointExpr_return pointExpr84 = null;


        Object set83_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:154:10: ( pointExpr ( ( '+' | '-' ) ^ pointExpr )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:154:12: pointExpr ( ( '+' | '-' ) ^ pointExpr )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_pointExpr_in_dashExpr1018);
            pointExpr82=pointExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, pointExpr82.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:154:22: ( ( '+' | '-' ) ^ pointExpr )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=PLUSOPERATOR && LA17_0<=MINUSOPERATOR)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:154:23: ( '+' | '-' ) ^ pointExpr
            	    {
            	    set83=(Token)input.LT(1);
            	    set83=(Token)input.LT(1);
            	    if ( (input.LA(1)>=PLUSOPERATOR && input.LA(1)<=MINUSOPERATOR) ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (Object)adaptor.becomeRoot((Object)adaptor.create(set83), root_0);
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_pointExpr_in_dashExpr1028);
            	    pointExpr84=pointExpr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, pointExpr84.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dashExpr"

    public static class pointExpr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pointExpr"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:1: pointExpr : atom ( ( '*' ^ | '/' ^) atom )* ;
    public final OoplssParser.pointExpr_return pointExpr() throws RecognitionException {
        OoplssParser.pointExpr_return retval = new OoplssParser.pointExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal86=null;
        Token char_literal87=null;
        OoplssParser.atom_return atom85 = null;

        OoplssParser.atom_return atom88 = null;


        Object char_literal86_tree=null;
        Object char_literal87_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:11: ( atom ( ( '*' ^ | '/' ^) atom )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:14: atom ( ( '*' ^ | '/' ^) atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_pointExpr1040);
            atom85=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom85.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:19: ( ( '*' ^ | '/' ^) atom )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=TIMESOPERATOR && LA19_0<=DIVIDEOPERATOR)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:20: ( '*' ^ | '/' ^) atom
            	    {
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:20: ( '*' ^ | '/' ^)
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==TIMESOPERATOR) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==DIVIDEOPERATOR) ) {
            	        alt18=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:21: '*' ^
            	            {
            	            char_literal86=(Token)match(input,TIMESOPERATOR,FOLLOW_TIMESOPERATOR_in_pointExpr1044); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal86_tree = (Object)adaptor.create(char_literal86);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal86_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:156:26: '/' ^
            	            {
            	            char_literal87=(Token)match(input,DIVIDEOPERATOR,FOLLOW_DIVIDEOPERATOR_in_pointExpr1047); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal87_tree = (Object)adaptor.create(char_literal87);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal87_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_pointExpr1051);
            	    atom88=atom();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, atom88.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pointExpr"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:158:1: atom : ( literal | varAccess | '(' ! expression ')' !);
    public final OoplssParser.atom_return atom() throws RecognitionException {
        OoplssParser.atom_return retval = new OoplssParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal91=null;
        Token char_literal93=null;
        OoplssParser.literal_return literal89 = null;

        OoplssParser.varAccess_return varAccess90 = null;

        OoplssParser.expression_return expression92 = null;


        Object char_literal91_tree=null;
        Object char_literal93_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:158:7: ( literal | varAccess | '(' ! expression ')' !)
            int alt20=3;
            switch ( input.LA(1) ) {
            case INTLITERAL:
            case STRINGLITERAL:
            case CHARLITERAL:
            case BOOLLITERAL:
                {
                alt20=1;
                }
                break;
            case SELF:
            case ID:
                {
                alt20=2;
                }
                break;
            case LPARA:
                {
                alt20=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:158:9: literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_atom1062);
                    literal89=literal();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, literal89.getTree());

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:159:5: varAccess
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_varAccess_in_atom1068);
                    varAccess90=varAccess();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varAccess90.getTree());

                    }
                    break;
                case 3 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:160:5: '(' ! expression ')' !
                    {
                    root_0 = (Object)adaptor.nil();

                    char_literal91=(Token)match(input,LPARA,FOLLOW_LPARA_in_atom1074); if (state.failed) return retval;
                    pushFollow(FOLLOW_expression_in_atom1078);
                    expression92=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression92.getTree());
                    char_literal93=(Token)match(input,RPARA,FOLLOW_RPARA_in_atom1080); if (state.failed) return retval;

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class arrayAccess_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayAccess"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:163:1: arrayAccess : '[' statement ']' ;
    public final OoplssParser.arrayAccess_return arrayAccess() throws RecognitionException {
        OoplssParser.arrayAccess_return retval = new OoplssParser.arrayAccess_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal94=null;
        Token char_literal96=null;
        OoplssParser.statement_return statement95 = null;


        Object char_literal94_tree=null;
        Object char_literal96_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:163:13: ( '[' statement ']' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:163:15: '[' statement ']'
            {
            root_0 = (Object)adaptor.nil();

            char_literal94=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayAccess1093); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal94_tree = (Object)adaptor.create(char_literal94);
            adaptor.addChild(root_0, char_literal94_tree);
            }
            pushFollow(FOLLOW_statement_in_arrayAccess1095);
            statement95=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement95.getTree());
            char_literal96=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayAccess1097); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal96_tree = (Object)adaptor.create(char_literal96);
            adaptor.addChild(root_0, char_literal96_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayAccess"

    public static class literal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:167:1: literal : (i= INTLITERAL -> ^( INT INTLITERAL ) | STRINGLITERAL -> ^( STRING STRINGLITERAL ) | CHARLITERAL -> ^( CHAR CHARLITERAL ) | BOOLLITERAL -> ^( BOOL BOOLLITERAL ) );
    public final OoplssParser.literal_return literal() throws RecognitionException {
        OoplssParser.literal_return retval = new OoplssParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token i=null;
        Token STRINGLITERAL97=null;
        Token CHARLITERAL98=null;
        Token BOOLLITERAL99=null;

        Object i_tree=null;
        Object STRINGLITERAL97_tree=null;
        Object CHARLITERAL98_tree=null;
        Object BOOLLITERAL99_tree=null;
        RewriteRuleTokenStream stream_BOOLLITERAL=new RewriteRuleTokenStream(adaptor,"token BOOLLITERAL");
        RewriteRuleTokenStream stream_INTLITERAL=new RewriteRuleTokenStream(adaptor,"token INTLITERAL");
        RewriteRuleTokenStream stream_STRINGLITERAL=new RewriteRuleTokenStream(adaptor,"token STRINGLITERAL");
        RewriteRuleTokenStream stream_CHARLITERAL=new RewriteRuleTokenStream(adaptor,"token CHARLITERAL");

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:167:10: (i= INTLITERAL -> ^( INT INTLITERAL ) | STRINGLITERAL -> ^( STRING STRINGLITERAL ) | CHARLITERAL -> ^( CHAR CHARLITERAL ) | BOOLLITERAL -> ^( BOOL BOOLLITERAL ) )
            int alt21=4;
            switch ( input.LA(1) ) {
            case INTLITERAL:
                {
                alt21=1;
                }
                break;
            case STRINGLITERAL:
                {
                alt21=2;
                }
                break;
            case CHARLITERAL:
                {
                alt21=3;
                }
                break;
            case BOOLLITERAL:
                {
                alt21=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:167:12: i= INTLITERAL
                    {
                    i=(Token)match(input,INTLITERAL,FOLLOW_INTLITERAL_in_literal1110); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTLITERAL.add(i);



                    // AST REWRITE
                    // elements: INTLITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 167:26: -> ^( INT INTLITERAL )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:167:29: ^( INT INTLITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INT, "INT"), root_1);

                        adaptor.addChild(root_1, stream_INTLITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:168:5: STRINGLITERAL
                    {
                    STRINGLITERAL97=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_literal1125); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STRINGLITERAL.add(STRINGLITERAL97);



                    // AST REWRITE
                    // elements: STRINGLITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 168:19: -> ^( STRING STRINGLITERAL )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:168:22: ^( STRING STRINGLITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_STRINGLITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:169:5: CHARLITERAL
                    {
                    CHARLITERAL98=(Token)match(input,CHARLITERAL,FOLLOW_CHARLITERAL_in_literal1139); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CHARLITERAL.add(CHARLITERAL98);



                    // AST REWRITE
                    // elements: CHARLITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 169:19: -> ^( CHAR CHARLITERAL )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:169:22: ^( CHAR CHARLITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CHAR, "CHAR"), root_1);

                        adaptor.addChild(root_1, stream_CHARLITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:170:5: BOOLLITERAL
                    {
                    BOOLLITERAL99=(Token)match(input,BOOLLITERAL,FOLLOW_BOOLLITERAL_in_literal1155); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BOOLLITERAL.add(BOOLLITERAL99);



                    // AST REWRITE
                    // elements: BOOLLITERAL
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 170:19: -> ^( BOOL BOOLLITERAL )
                    {
                        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:170:22: ^( BOOL BOOLLITERAL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOL, "BOOL"), root_1);

                        adaptor.addChild(root_1, stream_BOOLLITERAL.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class ifStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifStmt"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:174:1: ifStmt : 'if' '(' statement ')' block ( 'elseif' '(' statement ')' block )* ( 'else' block )? ;
    public final OoplssParser.ifStmt_return ifStmt() throws RecognitionException {
        OoplssParser.ifStmt_return retval = new OoplssParser.ifStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal100=null;
        Token char_literal101=null;
        Token char_literal103=null;
        Token string_literal105=null;
        Token char_literal106=null;
        Token char_literal108=null;
        Token string_literal110=null;
        OoplssParser.statement_return statement102 = null;

        OoplssParser.block_return block104 = null;

        OoplssParser.statement_return statement107 = null;

        OoplssParser.block_return block109 = null;

        OoplssParser.block_return block111 = null;


        Object string_literal100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        Object string_literal105_tree=null;
        Object char_literal106_tree=null;
        Object char_literal108_tree=null;
        Object string_literal110_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:174:9: ( 'if' '(' statement ')' block ( 'elseif' '(' statement ')' block )* ( 'else' block )? )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:174:11: 'if' '(' statement ')' block ( 'elseif' '(' statement ')' block )* ( 'else' block )?
            {
            root_0 = (Object)adaptor.nil();

            string_literal100=(Token)match(input,IFSTMT,FOLLOW_IFSTMT_in_ifStmt1182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal100_tree = (Object)adaptor.create(string_literal100);
            adaptor.addChild(root_0, string_literal100_tree);
            }
            char_literal101=(Token)match(input,LPARA,FOLLOW_LPARA_in_ifStmt1184); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal101_tree = (Object)adaptor.create(char_literal101);
            adaptor.addChild(root_0, char_literal101_tree);
            }
            pushFollow(FOLLOW_statement_in_ifStmt1186);
            statement102=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement102.getTree());
            char_literal103=(Token)match(input,RPARA,FOLLOW_RPARA_in_ifStmt1188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal103_tree = (Object)adaptor.create(char_literal103);
            adaptor.addChild(root_0, char_literal103_tree);
            }
            pushFollow(FOLLOW_block_in_ifStmt1190);
            block104=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block104.getTree());
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:175:4: ( 'elseif' '(' statement ')' block )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==ELIF) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:175:5: 'elseif' '(' statement ')' block
            	    {
            	    string_literal105=(Token)match(input,ELIF,FOLLOW_ELIF_in_ifStmt1196); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal105_tree = (Object)adaptor.create(string_literal105);
            	    adaptor.addChild(root_0, string_literal105_tree);
            	    }
            	    char_literal106=(Token)match(input,LPARA,FOLLOW_LPARA_in_ifStmt1198); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal106_tree = (Object)adaptor.create(char_literal106);
            	    adaptor.addChild(root_0, char_literal106_tree);
            	    }
            	    pushFollow(FOLLOW_statement_in_ifStmt1200);
            	    statement107=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement107.getTree());
            	    char_literal108=(Token)match(input,RPARA,FOLLOW_RPARA_in_ifStmt1202); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal108_tree = (Object)adaptor.create(char_literal108);
            	    adaptor.addChild(root_0, char_literal108_tree);
            	    }
            	    pushFollow(FOLLOW_block_in_ifStmt1204);
            	    block109=block();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, block109.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:176:4: ( 'else' block )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ELSE) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:176:5: 'else' block
                    {
                    string_literal110=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStmt1212); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal110_tree = (Object)adaptor.create(string_literal110);
                    adaptor.addChild(root_0, string_literal110_tree);
                    }
                    pushFollow(FOLLOW_block_in_ifStmt1214);
                    block111=block();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, block111.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifStmt"

    public static class whileStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whileStmt"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:178:1: whileStmt : 'while' '(' statement ')' block ;
    public final OoplssParser.whileStmt_return whileStmt() throws RecognitionException {
        OoplssParser.whileStmt_return retval = new OoplssParser.whileStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal112=null;
        Token char_literal113=null;
        Token char_literal115=null;
        OoplssParser.statement_return statement114 = null;

        OoplssParser.block_return block116 = null;


        Object string_literal112_tree=null;
        Object char_literal113_tree=null;
        Object char_literal115_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:178:11: ( 'while' '(' statement ')' block )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:178:14: 'while' '(' statement ')' block
            {
            root_0 = (Object)adaptor.nil();

            string_literal112=(Token)match(input,WHILESTMT,FOLLOW_WHILESTMT_in_whileStmt1228); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal112_tree = (Object)adaptor.create(string_literal112);
            adaptor.addChild(root_0, string_literal112_tree);
            }
            char_literal113=(Token)match(input,LPARA,FOLLOW_LPARA_in_whileStmt1230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal113_tree = (Object)adaptor.create(char_literal113);
            adaptor.addChild(root_0, char_literal113_tree);
            }
            pushFollow(FOLLOW_statement_in_whileStmt1232);
            statement114=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement114.getTree());
            char_literal115=(Token)match(input,RPARA,FOLLOW_RPARA_in_whileStmt1233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal115_tree = (Object)adaptor.create(char_literal115);
            adaptor.addChild(root_0, char_literal115_tree);
            }
            pushFollow(FOLLOW_block_in_whileStmt1235);
            block116=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block116.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whileStmt"

    public static class forStmt_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "forStmt"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:1: forStmt : 'for' '(' ( assignment ) ';' statement ';' ( stmtOrAssign ) ')' block ;
    public final OoplssParser.forStmt_return forStmt() throws RecognitionException {
        OoplssParser.forStmt_return retval = new OoplssParser.forStmt_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal117=null;
        Token char_literal118=null;
        Token char_literal120=null;
        Token char_literal122=null;
        Token char_literal124=null;
        OoplssParser.assignment_return assignment119 = null;

        OoplssParser.statement_return statement121 = null;

        OoplssParser.stmtOrAssign_return stmtOrAssign123 = null;

        OoplssParser.block_return block125 = null;


        Object string_literal117_tree=null;
        Object char_literal118_tree=null;
        Object char_literal120_tree=null;
        Object char_literal122_tree=null;
        Object char_literal124_tree=null;

        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:10: ( 'for' '(' ( assignment ) ';' statement ';' ( stmtOrAssign ) ')' block )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:12: 'for' '(' ( assignment ) ';' statement ';' ( stmtOrAssign ) ')' block
            {
            root_0 = (Object)adaptor.nil();

            string_literal117=(Token)match(input,FORSTMT,FOLLOW_FORSTMT_in_forStmt1244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal117_tree = (Object)adaptor.create(string_literal117);
            adaptor.addChild(root_0, string_literal117_tree);
            }
            char_literal118=(Token)match(input,LPARA,FOLLOW_LPARA_in_forStmt1246); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal118_tree = (Object)adaptor.create(char_literal118);
            adaptor.addChild(root_0, char_literal118_tree);
            }
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:22: ( assignment )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:23: assignment
            {
            pushFollow(FOLLOW_assignment_in_forStmt1249);
            assignment119=assignment();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment119.getTree());

            }

            char_literal120=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_forStmt1252); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal120_tree = (Object)adaptor.create(char_literal120);
            adaptor.addChild(root_0, char_literal120_tree);
            }
            pushFollow(FOLLOW_statement_in_forStmt1254);
            statement121=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, statement121.getTree());
            char_literal122=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_forStmt1256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal122_tree = (Object)adaptor.create(char_literal122);
            adaptor.addChild(root_0, char_literal122_tree);
            }
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:53: ( stmtOrAssign )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:180:54: stmtOrAssign
            {
            pushFollow(FOLLOW_stmtOrAssign_in_forStmt1259);
            stmtOrAssign123=stmtOrAssign();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, stmtOrAssign123.getTree());

            }

            char_literal124=(Token)match(input,RPARA,FOLLOW_RPARA_in_forStmt1262); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal124_tree = (Object)adaptor.create(char_literal124);
            adaptor.addChild(root_0, char_literal124_tree);
            }
            pushFollow(FOLLOW_block_in_forStmt1264);
            block125=block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block125.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "forStmt"

    public static class stmtOrAssign_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stmtOrAssign"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:182:1: stmtOrAssign options {k=2; backtrack=true; } : ( statement | assignment );
    public final OoplssParser.stmtOrAssign_return stmtOrAssign() throws RecognitionException {
        OoplssParser.stmtOrAssign_return retval = new OoplssParser.stmtOrAssign_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        OoplssParser.statement_return statement126 = null;

        OoplssParser.assignment_return assignment127 = null;



        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:187:1: ( statement | assignment )
            int alt24=2;
            switch ( input.LA(1) ) {
            case INTLITERAL:
            case STRINGLITERAL:
            case CHARLITERAL:
            case BOOLLITERAL:
            case LPARA:
                {
                alt24=1;
                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case LBRACK:
                    {
                    int LA24_8 = input.LA(3);

                    if ( (synpred44_Ooplss()) ) {
                        alt24=1;
                    }
                    else if ( (true) ) {
                        alt24=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 8, input);

                        throw nvae;
                    }
                    }
                    break;
                case CALLOPERATOR:
                    {
                    int LA24_9 = input.LA(3);

                    if ( (synpred44_Ooplss()) ) {
                        alt24=1;
                    }
                    else if ( (true) ) {
                        alt24=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 9, input);

                        throw nvae;
                    }
                    }
                    break;
                case PLUSOPERATOR:
                case MINUSOPERATOR:
                case TIMESOPERATOR:
                case DIVIDEOPERATOR:
                case ANDOPERATOR:
                case OROPERATOR:
                case RPARA:
                case EQ:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    {
                    alt24=1;
                    }
                    break;
                case EQOPERATOR:
                    {
                    alt24=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 5, input);

                    throw nvae;
                }

                }
                break;
            case SELF:
                {
                int LA24_6 = input.LA(2);

                if ( (LA24_6==CALLOPERATOR) ) {
                    int LA24_19 = input.LA(3);

                    if ( (synpred44_Ooplss()) ) {
                        alt24=1;
                    }
                    else if ( (true) ) {
                        alt24=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 24, 19, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 6, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:187:3: statement
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_statement_in_stmtOrAssign1290);
                    statement126=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, statement126.getTree());

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:187:13: assignment
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assignment_in_stmtOrAssign1292);
                    assignment127=assignment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment127.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stmtOrAssign"

    // $ANTLR start synpred10_Ooplss
    public final void synpred10_Ooplss_fragment() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:86:5: ( statement ';' )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:86:5: statement ';'
        {
        pushFollow(FOLLOW_statement_in_synpred10_Ooplss472);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred10_Ooplss474); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_Ooplss

    // $ANTLR start synpred11_Ooplss
    public final void synpred11_Ooplss_fragment() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:87:5: ( assignment ';' )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:87:5: assignment ';'
        {
        pushFollow(FOLLOW_assignment_in_synpred11_Ooplss481);
        assignment();

        state._fsp--;
        if (state.failed) return ;
        match(input,SEMICOLON,FOLLOW_SEMICOLON_in_synpred11_Ooplss483); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_Ooplss

    // $ANTLR start synpred19_Ooplss
    public final void synpred19_Ooplss_fragment() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:121:5: ( 'self' '.' ID '[' statement ']' )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:121:5: 'self' '.' ID '[' statement ']'
        {
        match(input,SELF,FOLLOW_SELF_in_synpred19_Ooplss680); if (state.failed) return ;
        match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_synpred19_Ooplss682); if (state.failed) return ;
        match(input,ID,FOLLOW_ID_in_synpred19_Ooplss684); if (state.failed) return ;
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred19_Ooplss686); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred19_Ooplss688);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred19_Ooplss690); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred19_Ooplss

    // $ANTLR start synpred22_Ooplss
    public final void synpred22_Ooplss_fragment() throws RecognitionException {
        Token id=null;
        List list_arg=null;
        RuleReturnScope arg = null;
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:5: ( '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')' )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:5: '.' id= ID '(' (arg+= statement ( ',' arg+= statement )* )? ')'
        {
        match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_synpred22_Ooplss750); if (state.failed) return ;
        id=(Token)match(input,ID,FOLLOW_ID_in_synpred22_Ooplss754); if (state.failed) return ;
        match(input,LPARA,FOLLOW_LPARA_in_synpred22_Ooplss756); if (state.failed) return ;
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:19: (arg+= statement ( ',' arg+= statement )* )?
        int alt28=2;
        int LA28_0 = input.LA(1);

        if ( (LA28_0==SELF||(LA28_0>=ID && LA28_0<=BOOLLITERAL)||LA28_0==LPARA) ) {
            alt28=1;
        }
        switch (alt28) {
            case 1 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:20: arg+= statement ( ',' arg+= statement )*
                {
                pushFollow(FOLLOW_statement_in_synpred22_Ooplss761);
                arg=statement();

                state._fsp--;
                if (state.failed) return ;
                if (list_arg==null) list_arg=new ArrayList();
                list_arg.add(arg);

                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:35: ( ',' arg+= statement )*
                loop27:
                do {
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==61) ) {
                        alt27=1;
                    }


                    switch (alt27) {
                	case 1 :
                	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:126:36: ',' arg+= statement
                	    {
                	    match(input,61,FOLLOW_61_in_synpred22_Ooplss764); if (state.failed) return ;
                	    pushFollow(FOLLOW_statement_in_synpred22_Ooplss768);
                	    arg=statement();

                	    state._fsp--;
                	    if (state.failed) return ;
                	    if (list_arg==null) list_arg=new ArrayList();
                	    list_arg.add(arg);


                	    }
                	    break;

                	default :
                	    break loop27;
                    }
                } while (true);


                }
                break;

        }

        match(input,RPARA,FOLLOW_RPARA_in_synpred22_Ooplss775); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_Ooplss

    // $ANTLR start synpred23_Ooplss
    public final void synpred23_Ooplss_fragment() throws RecognitionException {
        Token id=null;

        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:128:5: ( '.' id= ID '[' statement ']' )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:128:5: '.' id= ID '[' statement ']'
        {
        match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_synpred23_Ooplss811); if (state.failed) return ;
        id=(Token)match(input,ID,FOLLOW_ID_in_synpred23_Ooplss815); if (state.failed) return ;
        match(input,LBRACK,FOLLOW_LBRACK_in_synpred23_Ooplss817); if (state.failed) return ;
        pushFollow(FOLLOW_statement_in_synpred23_Ooplss819);
        statement();

        state._fsp--;
        if (state.failed) return ;
        match(input,RBRACK,FOLLOW_RBRACK_in_synpred23_Ooplss821); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_Ooplss

    // $ANTLR start synpred24_Ooplss
    public final void synpred24_Ooplss_fragment() throws RecognitionException {
        Token id=null;

        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:130:5: ( '.' id= ID )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:130:5: '.' id= ID
        {
        match(input,CALLOPERATOR,FOLLOW_CALLOPERATOR_in_synpred24_Ooplss850); if (state.failed) return ;
        id=(Token)match(input,ID,FOLLOW_ID_in_synpred24_Ooplss854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_Ooplss

    // $ANTLR start synpred44_Ooplss
    public final void synpred44_Ooplss_fragment() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:187:3: ( statement )
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:187:3: statement
        {
        pushFollow(FOLLOW_statement_in_synpred44_Ooplss1290);
        statement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_Ooplss

    // Delegated rules

    public final boolean synpred23_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred19_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred19_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_Ooplss() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Ooplss_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_classDec_in_prog137 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_CLASS_in_classDec146 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_classDec151 = new BitSet(new long[]{0x0030020000000000L});
    public static final BitSet FOLLOW_SUBTYPE_in_classDec159 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_classDec163 = new BitSet(new long[]{0x0020020000000000L});
    public static final BitSet FOLLOW_SUBCLASS_in_classDec173 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_classDec177 = new BitSet(new long[]{0x2000020000000000L});
    public static final BitSet FOLLOW_61_in_classDec180 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_classDec184 = new BitSet(new long[]{0x2000020000000000L});
    public static final BitSet FOLLOW_LBRACE_in_classDec194 = new BitSet(new long[]{0x0006040000000000L});
    public static final BitSet FOLLOW_varDef_in_classDec207 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_classDec209 = new BitSet(new long[]{0x0006040000000000L});
    public static final BitSet FOLLOW_methodDef_in_classDec223 = new BitSet(new long[]{0x0006040000000000L});
    public static final BitSet FOLLOW_RBRACE_in_classDec235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_varDef296 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varDef300 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_varDef302 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varDef306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_methodDef331 = new BitSet(new long[]{0x0000800001000000L});
    public static final BitSet FOLLOW_ID_in_methodDef337 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_argumentDeclList_in_methodDef339 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_methodDef341 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_methodDef345 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_CONSTRUCT_in_methodDef353 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_argumentDeclList_in_methodDef355 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_methodDef362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPARA_in_argumentDeclList399 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_argumentDeclList401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_block412 = new BitSet(new long[]{0x01CA0E041F200000L});
    public static final BitSet FOLLOW_blockStatement_in_block418 = new BitSet(new long[]{0x01CA0E041F200000L});
    public static final BitSet FOLLOW_RBRACE_in_block425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDef_in_blockStatement463 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_blockStatement465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_blockStatement472 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_blockStatement474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_blockStatement481 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_blockStatement483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_blockStatement490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retStmt_in_blockStatement496 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_blockStatement498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_blockStatement505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_blockStatement511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStmt_in_blockStatement517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_blockStatement523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_assignmentEntry538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_assignmentEntry540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAccess_in_assignment577 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_EQOPERATOR_in_assignment579 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_assignment581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAccess_in_varAccessEntry610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_varAccessEntry612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varAccess634 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ID_in_varAccess653 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACK_in_varAccess655 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_varAccess657 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_varAccess659 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_SELF_in_varAccess680 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_varAccess682 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varAccess684 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACK_in_varAccess686 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_varAccess688 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_varAccess690 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_SELF_in_varAccess717 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_varAccess719 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varAccess721 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_varAccess750 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varAccess754 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_varAccess756 = new BitSet(new long[]{0x000018001F200000L});
    public static final BitSet FOLLOW_statement_in_varAccess761 = new BitSet(new long[]{0x2000100000000000L});
    public static final BitSet FOLLOW_61_in_varAccess764 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_varAccess768 = new BitSet(new long[]{0x2000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_varAccess775 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_varAccess811 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varAccess815 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACK_in_varAccess817 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_varAccess819 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_varAccess821 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_varAccess850 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_varAccess854 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_expression_in_statement901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNSTMT_in_retStmt915 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_retStmt917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expression928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_andExpr_in_orExpr937 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_OROPERATOR_in_orExpr940 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_andExpr_in_orExpr943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_equality_in_andExpr955 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ANDOPERATOR_in_andExpr958 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_equality_in_andExpr961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inequality_in_equality972 = new BitSet(new long[]{0x8800000000000002L});
    public static final BitSet FOLLOW_set_in_equality975 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_inequality_in_equality982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dashExpr_in_inequality992 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000FL});
    public static final BitSet FOLLOW_set_in_inequality995 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_dashExpr_in_inequality1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointExpr_in_dashExpr1018 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_set_in_dashExpr1021 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_pointExpr_in_dashExpr1028 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_atom_in_pointExpr1040 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_TIMESOPERATOR_in_pointExpr1044 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_DIVIDEOPERATOR_in_pointExpr1047 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_atom_in_pointExpr1051 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_literal_in_atom1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varAccess_in_atom1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPARA_in_atom1074 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_expression_in_atom1078 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_atom1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_arrayAccess1093 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_arrayAccess1095 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_arrayAccess1097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTLITERAL_in_literal1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_literal1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARLITERAL_in_literal1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLLITERAL_in_literal1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IFSTMT_in_ifStmt1182 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_ifStmt1184 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_ifStmt1186 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_ifStmt1188 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_ifStmt1190 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ELIF_in_ifStmt1196 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_ifStmt1198 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_ifStmt1200 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_ifStmt1202 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_ifStmt1204 = new BitSet(new long[]{0x0600000000000002L});
    public static final BitSet FOLLOW_ELSE_in_ifStmt1212 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_ifStmt1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILESTMT_in_whileStmt1228 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_whileStmt1230 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_whileStmt1232 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_whileStmt1233 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_whileStmt1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORSTMT_in_forStmt1244 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_forStmt1246 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_assignment_in_forStmt1249 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_forStmt1252 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_forStmt1254 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_forStmt1256 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_stmtOrAssign_in_forStmt1259 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_forStmt1262 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_block_in_forStmt1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_stmtOrAssign1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_stmtOrAssign1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred10_Ooplss472 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred10_Ooplss474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_synpred11_Ooplss481 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_synpred11_Ooplss483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELF_in_synpred19_Ooplss680 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_synpred19_Ooplss682 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_synpred19_Ooplss684 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACK_in_synpred19_Ooplss686 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_synpred19_Ooplss688 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred19_Ooplss690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_synpred22_Ooplss750 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_synpred22_Ooplss754 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LPARA_in_synpred22_Ooplss756 = new BitSet(new long[]{0x000018001F200000L});
    public static final BitSet FOLLOW_statement_in_synpred22_Ooplss761 = new BitSet(new long[]{0x2000100000000000L});
    public static final BitSet FOLLOW_61_in_synpred22_Ooplss764 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_synpred22_Ooplss768 = new BitSet(new long[]{0x2000100000000000L});
    public static final BitSet FOLLOW_RPARA_in_synpred22_Ooplss775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_synpred23_Ooplss811 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_synpred23_Ooplss815 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LBRACK_in_synpred23_Ooplss817 = new BitSet(new long[]{0x000008001F200000L});
    public static final BitSet FOLLOW_statement_in_synpred23_Ooplss819 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_RBRACK_in_synpred23_Ooplss821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CALLOPERATOR_in_synpred24_Ooplss850 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ID_in_synpred24_Ooplss854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_synpred44_Ooplss1290 = new BitSet(new long[]{0x0000000000000002L});

}