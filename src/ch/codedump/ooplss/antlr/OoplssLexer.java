// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-03-23 21:46:45

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class OoplssLexer extends Lexer {
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

    public OoplssLexer() {;} 
    public OoplssLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OoplssLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/sh/gitty/private/ooplss/grammar/Ooplss.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:7: ( 'inherits' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:9: 'inherits'
            {
            match("inherits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:7: ( ',' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:7: ( ';' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:7: ( ':' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:7: ( '(' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:7: ( ')' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;

            	        	boolean isJavaDoc = false;
            	       	
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:59:7: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:59:12: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:60:11: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:60:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("*/"); 

             skip();   

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:8: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' )
                    {
                    match("//"); 

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:13: (~ ( '\\n' | '\\r' ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:13: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:28: ( '\\r\\n' | '\\r' | '\\n' )
                    int alt3=3;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        int LA3_1 = input.LA(2);

                        if ( (LA3_1=='\n') ) {
                            alt3=1;
                        }
                        else {
                            alt3=2;}
                    }
                    else if ( (LA3_0=='\n') ) {
                        alt3=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:29: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:38: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:66:45: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    	                	skip();
                    	            	

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:5: '//' (~ ( '\\n' | '\\r' ) )*
                    {
                    match("//"); 

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:10: (~ ( '\\n' | '\\r' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:70:10: ~ ( '\\n' | '\\r' )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    	                	skip();
                    		        

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:76:9: ( '{' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:76:11: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:78:9: ( '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:78:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:80:8: ( 'class' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:80:11: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:82:6: ( 'var' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:82:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "DEF"
    public final void mDEF() throws RecognitionException {
        try {
            int _type = DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:84:6: ( 'def' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:84:9: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEF"

    // $ANTLR start "EXTENDS"
    public final void mEXTENDS() throws RecognitionException {
        try {
            int _type = EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:86:10: ( 'extends' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:86:12: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDS"

    // $ANTLR start "IMPLEMENTS"
    public final void mIMPLEMENTS() throws RecognitionException {
        try {
            int _type = IMPLEMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:88:12: ( 'implements' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:88:14: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLEMENTS"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:90:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:90:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:90:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:94:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:94:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:94:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | COMMENT | LINE_COMMENT | LBRACE | RBRACE | CLASS | VAR | DEF | EXTENDS | IMPLEMENTS | ID | WS )
        int alt8=17;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:46: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 8 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:54: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 9 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:67: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 10 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:74: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 11 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:81: CLASS
                {
                mCLASS(); 

                }
                break;
            case 12 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:87: VAR
                {
                mVAR(); 

                }
                break;
            case 13 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:91: DEF
                {
                mDEF(); 

                }
                break;
            case 14 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:95: EXTENDS
                {
                mEXTENDS(); 

                }
                break;
            case 15 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:103: IMPLEMENTS
                {
                mIMPLEMENTS(); 

                }
                break;
            case 16 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:114: ID
                {
                mID(); 

                }
                break;
            case 17 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:117: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA5_eotS =
        "\2\uffff\2\5\2\uffff";
    static final String DFA5_eofS =
        "\6\uffff";
    static final String DFA5_minS =
        "\2\57\2\0\2\uffff";
    static final String DFA5_maxS =
        "\2\57\2\uffff\2\uffff";
    static final String DFA5_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA5_specialS =
        "\2\uffff\1\1\1\0\2\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\2",
            "\12\3\1\4\2\3\1\4\ufff2\3",
            "\12\3\1\4\2\3\1\4\ufff2\3",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "65:1: LINE_COMMENT : ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_3 = input.LA(1);

                        s = -1;
                        if ( (LA5_3=='\n'||LA5_3=='\r') ) {s = 4;}

                        else if ( ((LA5_3>='\u0000' && LA5_3<='\t')||(LA5_3>='\u000B' && LA5_3<='\f')||(LA5_3>='\u000E' && LA5_3<='\uFFFF')) ) {s = 3;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_2 = input.LA(1);

                        s = -1;
                        if ( ((LA5_2>='\u0000' && LA5_2<='\t')||(LA5_2>='\u000B' && LA5_2<='\f')||(LA5_2>='\u000E' && LA5_2<='\uFFFF')) ) {s = 3;}

                        else if ( (LA5_2=='\n'||LA5_2=='\r') ) {s = 4;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA8_eotS =
        "\1\uffff\1\16\10\uffff\4\16\2\uffff\2\16\2\uffff\7\16\1\41\1\42"+
        "\4\16\2\uffff\3\16\1\52\3\16\1\uffff\3\16\1\61\1\62\1\16\2\uffff"+
        "\1\16\1\65\1\uffff";
    static final String DFA8_eofS =
        "\66\uffff";
    static final String DFA8_minS =
        "\1\11\1\155\5\uffff\1\52\2\uffff\1\154\1\141\1\145\1\170\2\uffff"+
        "\1\150\1\160\2\uffff\1\141\1\162\1\146\1\164\1\145\1\154\1\163\2"+
        "\60\1\145\1\162\1\145\1\163\2\uffff\1\156\1\151\1\155\1\60\1\144"+
        "\1\164\1\145\1\uffff\2\163\1\156\2\60\1\164\2\uffff\1\163\1\60\1"+
        "\uffff";
    static final String DFA8_maxS =
        "\1\175\1\156\5\uffff\1\57\2\uffff\1\154\1\141\1\145\1\170\2\uffff"+
        "\1\150\1\160\2\uffff\1\141\1\162\1\146\1\164\1\145\1\154\1\163\2"+
        "\172\1\145\1\162\1\145\1\163\2\uffff\1\156\1\151\1\155\1\172\1\144"+
        "\1\164\1\145\1\uffff\2\163\1\156\2\172\1\164\2\uffff\1\163\1\172"+
        "\1\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff\1\11\1\12\4\uffff\1\20\1\21"+
        "\2\uffff\1\7\1\10\15\uffff\1\14\1\15\7\uffff\1\13\6\uffff\1\16\1"+
        "\1\2\uffff\1\17";
    static final String DFA8_specialS =
        "\66\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\17\2\uffff\1\17\22\uffff\1\17\7\uffff\1\5\1\6\2\uffff\1\2"+
            "\2\uffff\1\7\12\uffff\1\4\1\3\5\uffff\32\16\4\uffff\1\16\1\uffff"+
            "\2\16\1\12\1\14\1\15\3\16\1\1\14\16\1\13\4\16\1\10\1\uffff\1"+
            "\11",
            "\1\21\1\20",
            "",
            "",
            "",
            "",
            "",
            "\1\22\4\uffff\1\23",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "",
            "",
            "\1\30",
            "\1\31",
            "",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            "\1\63",
            "",
            "",
            "\1\64",
            "\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | COMMENT | LINE_COMMENT | LBRACE | RBRACE | CLASS | VAR | DEF | EXTENDS | IMPLEMENTS | ID | WS );";
        }
    }
 

}