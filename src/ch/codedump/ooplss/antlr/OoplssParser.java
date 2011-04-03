// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-03-23 21:46:44

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class OoplssParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "COMMENT", "LINE_COMMENT", "LBRACE", "RBRACE", "CLASS", "VAR", "DEF", "EXTENDS", "IMPLEMENTS", "WS", "'inherits'", "','", "';'", "':'", "'('", "')'"
    };
    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int ID=4;
    public static final int COMMENT=5;
    public static final int LINE_COMMENT=6;
    public static final int LBRACE=7;
    public static final int RBRACE=8;
    public static final int CLASS=9;
    public static final int VAR=10;
    public static final int DEF=11;
    public static final int EXTENDS=12;
    public static final int IMPLEMENTS=13;
    public static final int WS=14;

    // delegates
    // delegators


        public OoplssParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OoplssParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OoplssParser.tokenNames; }
    public String getGrammarFileName() { return "/home/sh/gitty/private/ooplss/grammar/Ooplss.g"; }



    // $ANTLR start "prog"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:1: prog : ( classDec )+ ;
    public final void prog() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:7: ( ( classDec )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:10: ( classDec )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:10: ( classDec )+
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
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:10: classDec
            	    {
            	    pushFollow(FOLLOW_classDec_in_prog39);
            	    classDec();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prog"


    // $ANTLR start "classDec"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:18:1: classDec : 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? classBody ;
    public final void classDec() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:19:3: ( 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? classBody )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:19:5: 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? classBody
            {
            match(input,CLASS,FOLLOW_CLASS_in_classDec51); 
            match(input,ID,FOLLOW_ID_in_classDec53); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:20:4: ( 'extends' ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==EXTENDS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:20:6: 'extends' ID
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_classDec60); 
                    match(input,ID,FOLLOW_ID_in_classDec62); 

                    }
                    break;

            }

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:21:4: ( 'inherits' ID ( ',' ID )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:21:6: 'inherits' ID ( ',' ID )*
                    {
                    match(input,15,FOLLOW_15_in_classDec72); 
                    match(input,ID,FOLLOW_ID_in_classDec74); 
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:21:20: ( ',' ID )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:21:21: ',' ID
                    	    {
                    	    match(input,16,FOLLOW_16_in_classDec77); 
                    	    match(input,ID,FOLLOW_ID_in_classDec79); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            pushFollow(FOLLOW_classBody_in_classDec89);
            classBody();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "classDec"


    // $ANTLR start "classBody"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:25:1: classBody : '{' ( classDecl )* '}' ;
    public final void classBody() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:25:11: ( '{' ( classDecl )* '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:26:4: '{' ( classDecl )* '}'
            {
            match(input,LBRACE,FOLLOW_LBRACE_in_classBody105); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:27:4: ( classDecl )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=VAR && LA5_0<=DEF)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:27:4: classDecl
            	    {
            	    pushFollow(FOLLOW_classDecl_in_classBody110);
            	    classDecl();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,RBRACE,FOLLOW_RBRACE_in_classBody116); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "classBody"


    // $ANTLR start "classDecl"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:31:1: classDecl : ( fieldDef | methodDef );
    public final void classDecl() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:31:11: ( fieldDef | methodDef )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VAR) ) {
                alt6=1;
            }
            else if ( (LA6_0==DEF) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:31:13: fieldDef
                    {
                    pushFollow(FOLLOW_fieldDef_in_classDecl127);
                    fieldDef();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:31:24: methodDef
                    {
                    pushFollow(FOLLOW_methodDef_in_classDecl131);
                    methodDef();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "classDecl"


    // $ANTLR start "fieldDef"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:33:1: fieldDef : 'var' ID ( explicitVar | implicitVar ) ';' ;
    public final void fieldDef() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:33:10: ( 'var' ID ( explicitVar | implicitVar ) ';' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:33:12: 'var' ID ( explicitVar | implicitVar ) ';'
            {
            match(input,VAR,FOLLOW_VAR_in_fieldDef142); 
            match(input,ID,FOLLOW_ID_in_fieldDef144); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:33:21: ( explicitVar | implicitVar )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:34:5: explicitVar
                    {
                    pushFollow(FOLLOW_explicitVar_in_fieldDef152);
                    explicitVar();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:34:19: implicitVar
                    {
                    pushFollow(FOLLOW_implicitVar_in_fieldDef156);
                    implicitVar();

                    state._fsp--;


                    }
                    break;

            }

            match(input,17,FOLLOW_17_in_fieldDef170); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "fieldDef"


    // $ANTLR start "explicitVar"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:39:1: explicitVar : ':' ID ;
    public final void explicitVar() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:39:13: ( ':' ID )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:39:15: ':' ID
            {
            match(input,18,FOLLOW_18_in_explicitVar183); 
            match(input,ID,FOLLOW_ID_in_explicitVar185); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "explicitVar"


    // $ANTLR start "implicitVar"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:42:1: implicitVar : ;
    public final void implicitVar() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:42:13: ()
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:43:3: 
            {
            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "implicitVar"


    // $ANTLR start "methodDef"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:45:1: methodDef : 'def' ID '(' ')' ':' ID '{' '}' ;
    public final void methodDef() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:45:11: ( 'def' ID '(' ')' ':' ID '{' '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:45:14: 'def' ID '(' ')' ':' ID '{' '}'
            {
            match(input,DEF,FOLLOW_DEF_in_methodDef212); 
            match(input,ID,FOLLOW_ID_in_methodDef214); 
            match(input,19,FOLLOW_19_in_methodDef216); 
            match(input,20,FOLLOW_20_in_methodDef220); 
            match(input,18,FOLLOW_18_in_methodDef222); 
            match(input,ID,FOLLOW_ID_in_methodDef224); 
            match(input,LBRACE,FOLLOW_LBRACE_in_methodDef226); 
            match(input,RBRACE,FOLLOW_RBRACE_in_methodDef236); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "methodDef"


    // $ANTLR start "argumentList"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:1: argumentList : ;
    public final void argumentList() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:15: ()
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:50:17: 
            {
            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argumentList"


    // $ANTLR start "methodBody"
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:1: methodBody : ;
    public final void methodBody() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:13: ()
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:52:15: 
            {
            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "methodBody"

    // Delegated rules


 

    public static final BitSet FOLLOW_classDec_in_prog39 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_CLASS_in_classDec51 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec53 = new BitSet(new long[]{0x0000000000009080L});
    public static final BitSet FOLLOW_EXTENDS_in_classDec60 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec62 = new BitSet(new long[]{0x0000000000009080L});
    public static final BitSet FOLLOW_15_in_classDec72 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec74 = new BitSet(new long[]{0x0000000000019080L});
    public static final BitSet FOLLOW_16_in_classDec77 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec79 = new BitSet(new long[]{0x0000000000019080L});
    public static final BitSet FOLLOW_classBody_in_classDec89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACE_in_classBody105 = new BitSet(new long[]{0x0000000000000D00L});
    public static final BitSet FOLLOW_classDecl_in_classBody110 = new BitSet(new long[]{0x0000000000000D00L});
    public static final BitSet FOLLOW_RBRACE_in_classBody116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDef_in_classDecl127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDef_in_classDecl131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_fieldDef142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_fieldDef144 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_explicitVar_in_fieldDef152 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_implicitVar_in_fieldDef156 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_fieldDef170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_explicitVar183 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_explicitVar185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEF_in_methodDef212 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_methodDef214 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_methodDef216 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_methodDef220 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_methodDef222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_methodDef224 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LBRACE_in_methodDef226 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RBRACE_in_methodDef236 = new BitSet(new long[]{0x0000000000000002L});

}