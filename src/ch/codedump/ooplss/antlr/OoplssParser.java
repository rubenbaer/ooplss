// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-03-22 21:54:17

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class OoplssParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "NEWLINE", "WS", "'class'", "'extends'", "'inherits'", "','", "'{'", "'}'"
    };
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int ID=4;
    public static final int NEWLINE=5;
    public static final int WS=6;

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
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:1: prog : ( classDec )+ ;
    public final void prog() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:7: ( ( classDec )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:10: ( classDec )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:10: ( classDec )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==7) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:10: classDec
            	    {
            	    pushFollow(FOLLOW_classDec_in_prog27);
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
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:13:1: classDec : 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? '{' classBody '}' ;
    public final void classDec() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:14:3: ( 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? '{' classBody '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:14:5: 'class' ID ( 'extends' ID )? ( 'inherits' ID ( ',' ID )* )? '{' classBody '}'
            {
            match(input,7,FOLLOW_7_in_classDec39); 
            match(input,ID,FOLLOW_ID_in_classDec41); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:15:4: ( 'extends' ID )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==8) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:15:6: 'extends' ID
                    {
                    match(input,8,FOLLOW_8_in_classDec48); 
                    match(input,ID,FOLLOW_ID_in_classDec50); 

                    }
                    break;

            }

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:4: ( 'inherits' ID ( ',' ID )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==9) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:6: 'inherits' ID ( ',' ID )*
                    {
                    match(input,9,FOLLOW_9_in_classDec60); 
                    match(input,ID,FOLLOW_ID_in_classDec62); 
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:20: ( ',' ID )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==10) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:16:21: ',' ID
                    	    {
                    	    match(input,10,FOLLOW_10_in_classDec65); 
                    	    match(input,ID,FOLLOW_ID_in_classDec67); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,11,FOLLOW_11_in_classDec77); 
            pushFollow(FOLLOW_classBody_in_classDec79);
            classBody();

            state._fsp--;

            match(input,12,FOLLOW_12_in_classDec81); 

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
    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:20:1: classBody : ;
    public final void classBody() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:21:3: ()
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:23:3: 
            {
            }

        }
        finally {
        }
        return ;
    }
    // $ANTLR end "classBody"

    // Delegated rules


 

    public static final BitSet FOLLOW_classDec_in_prog27 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_7_in_classDec39 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec41 = new BitSet(new long[]{0x0000000000000B00L});
    public static final BitSet FOLLOW_8_in_classDec48 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec50 = new BitSet(new long[]{0x0000000000000A00L});
    public static final BitSet FOLLOW_9_in_classDec60 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec62 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_10_in_classDec65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_classDec67 = new BitSet(new long[]{0x0000000000000C00L});
    public static final BitSet FOLLOW_11_in_classDec77 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_classBody_in_classDec79 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_classDec81 = new BitSet(new long[]{0x0000000000000002L});

}