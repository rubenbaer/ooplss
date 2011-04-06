// $ANTLR 3.3.1-SNAPSHOT Mar 23, 2011 24:00:34 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-04-06 16:09:02

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class OoplssLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public OoplssLexer() {} 
    public OoplssLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OoplssLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/sh/gitty/private/ooplss/grammar/Ooplss.g"; }

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:7: ( ',' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:7: ( ':' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:7: ( '!=' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:7: ( '<' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:7: ( '<=' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:7: ( '>' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:13:7: ( '>=' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:13:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:192:7: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:192:12: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:193:11: ( options {greedy=false; } : . )*
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
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:193:38: .
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:3: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:8: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' )
                    {
                    match("//"); 

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:13: (~ ( '\\n' | '\\r' ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:13: ~ ( '\\n' | '\\r' )
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

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:28: ( '\\r\\n' | '\\r' | '\\n' )
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
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:29: '\\r\\n'
                            {
                            match("\r\n"); 


                            }
                            break;
                        case 2 :
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:38: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:200:45: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    	                	skip();
                    	            	

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:204:5: '//' (~ ( '\\n' | '\\r' ) )*
                    {
                    match("//"); 

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:204:10: (~ ( '\\n' | '\\r' ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>='\u0000' && LA4_0<='\t')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:204:10: ~ ( '\\n' | '\\r' )
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "INTLITERAL"
    public final void mINTLITERAL() throws RecognitionException {
        try {
            int _type = INTLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:12: ( ( '-' )? ( '0' .. '9' )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:15: ( '-' )? ( '0' .. '9' )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:15: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:16: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:22: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:210:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTLITERAL"

    // $ANTLR start "STRINGLITERAL"
    public final void mSTRINGLITERAL() throws RecognitionException {
        try {
            int _type = STRINGLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:213:15: ( '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:213:20: '\"' ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:214:11: ( EscapeSequence | ~ ( '\\\\' | '\"' | '\\r' | '\\n' ) )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    alt8=1;
                }
                else if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='!')||(LA8_0>='#' && LA8_0<='[')||(LA8_0>=']' && LA8_0<='\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:214:15: EscapeSequence
            	    {
            	    mEscapeSequence(); 

            	    }
            	    break;
            	case 2 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:215:5: ~ ( '\\\\' | '\"' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRINGLITERAL"

    // $ANTLR start "CHARLITERAL"
    public final void mCHARLITERAL() throws RecognitionException {
        try {
            int _type = CHARLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:221:13: ( '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) ) '\\'' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:221:18: '\\'' ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) ) '\\''
            {
            match('\''); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:222:11: ( EscapeSequence | ~ ( '\\'' | '\\\\' | '\\r' | '\\n' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\\') ) {
                alt9=1;
            }
            else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='&')||(LA9_0>='(' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:222:15: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:223:15: ~ ( '\\'' | '\\\\' | '\\r' | '\\n' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARLITERAL"

    // $ANTLR start "BOOLLITERAL"
    public final void mBOOLLITERAL() throws RecognitionException {
        try {
            int _type = BOOLLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:227:13: ( 'true' | 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='t') ) {
                alt10=1;
            }
            else if ( (LA10_0=='f') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:227:15: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:227:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLLITERAL"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:231:17: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ) )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:231:22: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            {
            match('\\'); 
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:232:3: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) ( '0' .. '7' ) | ( '0' .. '7' ) )
            int alt11=11;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt11=1;
                }
                break;
            case 't':
                {
                alt11=2;
                }
                break;
            case 'n':
                {
                alt11=3;
                }
                break;
            case 'f':
                {
                alt11=4;
                }
                break;
            case 'r':
                {
                alt11=5;
                }
                break;
            case '\"':
                {
                alt11=6;
                }
                break;
            case '\'':
                {
                alt11=7;
                }
                break;
            case '\\':
                {
                alt11=8;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
                {
                int LA11_9 = input.LA(2);

                if ( ((LA11_9>='0' && LA11_9<='7')) ) {
                    int LA11_11 = input.LA(3);

                    if ( ((LA11_11>='0' && LA11_11<='7')) ) {
                        alt11=9;
                    }
                    else {
                        alt11=10;}
                }
                else {
                    alt11=11;}
                }
                break;
            case '4':
            case '5':
            case '6':
            case '7':
                {
                int LA11_10 = input.LA(2);

                if ( ((LA11_10>='0' && LA11_10<='7')) ) {
                    alt11=10;
                }
                else {
                    alt11=11;}
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:232:6: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 2 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:233:16: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 3 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:234:13: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 4 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:235:19: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 5 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:236:19: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 6 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:237:19: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 7 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:238:19: '\\''
                    {
                    match('\''); 

                    }
                    break;
                case 8 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:239:19: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 9 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:19: ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:19: ( '0' .. '3' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:20: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:30: ( '0' .. '7' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:31: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:41: ( '0' .. '7' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:240:42: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 10 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:241:19: ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:241:19: ( '0' .. '7' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:241:20: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:241:30: ( '0' .. '7' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:241:31: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 11 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:242:12: ( '0' .. '7' )
                    {
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:242:12: ( '0' .. '7' )
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:242:13: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }


            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "EQOPERATOR"
    public final void mEQOPERATOR() throws RecognitionException {
        try {
            int _type = EQOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:247:3: ( '=' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:247:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQOPERATOR"

    // $ANTLR start "CALLOPERATOR"
    public final void mCALLOPERATOR() throws RecognitionException {
        try {
            int _type = CALLOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:249:15: ( '.' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:249:17: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CALLOPERATOR"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:251:11: ( ';' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:251:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "PLUSOPERATOR"
    public final void mPLUSOPERATOR() throws RecognitionException {
        try {
            int _type = PLUSOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:253:14: ( '+' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:253:16: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUSOPERATOR"

    // $ANTLR start "MINUSOPERATOR"
    public final void mMINUSOPERATOR() throws RecognitionException {
        try {
            int _type = MINUSOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:255:15: ( '-' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:255:17: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUSOPERATOR"

    // $ANTLR start "TIMESOPERATOR"
    public final void mTIMESOPERATOR() throws RecognitionException {
        try {
            int _type = TIMESOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:257:15: ( '*' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:257:17: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TIMESOPERATOR"

    // $ANTLR start "DIVIDEOPERATOR"
    public final void mDIVIDEOPERATOR() throws RecognitionException {
        try {
            int _type = DIVIDEOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:259:16: ( '/' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:259:18: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIVIDEOPERATOR"

    // $ANTLR start "ANDOPERATOR"
    public final void mANDOPERATOR() throws RecognitionException {
        try {
            int _type = ANDOPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:261:13: ( '&&' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:261:15: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANDOPERATOR"

    // $ANTLR start "OROPERATOR"
    public final void mOROPERATOR() throws RecognitionException {
        try {
            int _type = OROPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:263:12: ( '||' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:263:15: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OROPERATOR"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:265:9: ( '{' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:265:11: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:267:9: ( '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:267:14: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "LPARA"
    public final void mLPARA() throws RecognitionException {
        try {
            int _type = LPARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:269:8: ( '(' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:269:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPARA"

    // $ANTLR start "RPARA"
    public final void mRPARA() throws RecognitionException {
        try {
            int _type = RPARA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:271:8: ( ')' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:271:11: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPARA"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:273:9: ( '[' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:273:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:275:9: ( ']' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:275:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "CONSTRUCT"
    public final void mCONSTRUCT() throws RecognitionException {
        try {
            int _type = CONSTRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:277:11: ( '__construct' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:277:14: '__construct'
            {
            match("__construct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTRUCT"

    // $ANTLR start "CLASS"
    public final void mCLASS() throws RecognitionException {
        try {
            int _type = CLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:279:8: ( 'class' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:279:11: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CLASS"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:281:6: ( 'var' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:281:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "DEF"
    public final void mDEF() throws RecognitionException {
        try {
            int _type = DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:283:6: ( 'def' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:283:9: 'def'
            {
            match("def"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEF"

    // $ANTLR start "RETURNSTMT"
    public final void mRETURNSTMT() throws RecognitionException {
        try {
            int _type = RETURNSTMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:285:12: ( 'return' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:285:14: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURNSTMT"

    // $ANTLR start "SUBTYPE"
    public final void mSUBTYPE() throws RecognitionException {
        try {
            int _type = SUBTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:287:10: ( 'subtypeOf' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:287:12: 'subtypeOf'
            {
            match("subtypeOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUBTYPE"

    // $ANTLR start "SUBCLASS"
    public final void mSUBCLASS() throws RecognitionException {
        try {
            int _type = SUBCLASS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:289:10: ( 'subclassOf' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:289:12: 'subclassOf'
            {
            match("subclassOf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SUBCLASS"

    // $ANTLR start "SELF"
    public final void mSELF() throws RecognitionException {
        try {
            int _type = SELF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:291:7: ( 'self' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:291:9: 'self'
            {
            match("self"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SELF"

    // $ANTLR start "IFSTMT"
    public final void mIFSTMT() throws RecognitionException {
        try {
            int _type = IFSTMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:293:9: ( 'if' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:293:12: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IFSTMT"

    // $ANTLR start "WHILESTMT"
    public final void mWHILESTMT() throws RecognitionException {
        try {
            int _type = WHILESTMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:295:11: ( 'while' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:295:13: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILESTMT"

    // $ANTLR start "FORSTMT"
    public final void mFORSTMT() throws RecognitionException {
        try {
            int _type = FORSTMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:297:10: ( 'for' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:297:12: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FORSTMT"

    // $ANTLR start "ELIF"
    public final void mELIF() throws RecognitionException {
        try {
            int _type = ELIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:299:7: ( 'elseif' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:299:9: 'elseif'
            {
            match("elseif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELIF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:301:7: ( 'else' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:301:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:303:5: ( '==' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:303:8: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:305:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '+' | '-' | '*' | '/' )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:305:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '+' | '-' | '*' | '/' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:305:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' | '+' | '-' | '*' | '/' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='*' && LA12_0<='+')||LA12_0=='-'||(LA12_0>='/' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:
            	    {
            	    if ( (input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:309:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:309:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:309:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:8: ( T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | COMMENT | LINE_COMMENT | INTLITERAL | STRINGLITERAL | CHARLITERAL | BOOLLITERAL | EQOPERATOR | CALLOPERATOR | SEMICOLON | PLUSOPERATOR | MINUSOPERATOR | TIMESOPERATOR | DIVIDEOPERATOR | ANDOPERATOR | OROPERATOR | LBRACE | RBRACE | LPARA | RPARA | LBRACK | RBRACK | CONSTRUCT | CLASS | VAR | DEF | RETURNSTMT | SUBTYPE | SUBCLASS | SELF | IFSTMT | WHILESTMT | FORSTMT | ELIF | ELSE | EQ | ID | WS )
        int alt14=44;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:10: T__61
                {
                mT__61(); 

                }
                break;
            case 2 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:16: T__62
                {
                mT__62(); 

                }
                break;
            case 3 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:22: T__63
                {
                mT__63(); 

                }
                break;
            case 4 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:28: T__64
                {
                mT__64(); 

                }
                break;
            case 5 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:34: T__65
                {
                mT__65(); 

                }
                break;
            case 6 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:40: T__66
                {
                mT__66(); 

                }
                break;
            case 7 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:46: T__67
                {
                mT__67(); 

                }
                break;
            case 8 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:52: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 9 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:60: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 10 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:73: INTLITERAL
                {
                mINTLITERAL(); 

                }
                break;
            case 11 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:84: STRINGLITERAL
                {
                mSTRINGLITERAL(); 

                }
                break;
            case 12 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:98: CHARLITERAL
                {
                mCHARLITERAL(); 

                }
                break;
            case 13 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:110: BOOLLITERAL
                {
                mBOOLLITERAL(); 

                }
                break;
            case 14 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:122: EQOPERATOR
                {
                mEQOPERATOR(); 

                }
                break;
            case 15 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:133: CALLOPERATOR
                {
                mCALLOPERATOR(); 

                }
                break;
            case 16 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:146: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 17 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:156: PLUSOPERATOR
                {
                mPLUSOPERATOR(); 

                }
                break;
            case 18 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:169: MINUSOPERATOR
                {
                mMINUSOPERATOR(); 

                }
                break;
            case 19 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:183: TIMESOPERATOR
                {
                mTIMESOPERATOR(); 

                }
                break;
            case 20 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:197: DIVIDEOPERATOR
                {
                mDIVIDEOPERATOR(); 

                }
                break;
            case 21 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:212: ANDOPERATOR
                {
                mANDOPERATOR(); 

                }
                break;
            case 22 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:224: OROPERATOR
                {
                mOROPERATOR(); 

                }
                break;
            case 23 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:235: LBRACE
                {
                mLBRACE(); 

                }
                break;
            case 24 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:242: RBRACE
                {
                mRBRACE(); 

                }
                break;
            case 25 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:249: LPARA
                {
                mLPARA(); 

                }
                break;
            case 26 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:255: RPARA
                {
                mRPARA(); 

                }
                break;
            case 27 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:261: LBRACK
                {
                mLBRACK(); 

                }
                break;
            case 28 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:268: RBRACK
                {
                mRBRACK(); 

                }
                break;
            case 29 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:275: CONSTRUCT
                {
                mCONSTRUCT(); 

                }
                break;
            case 30 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:285: CLASS
                {
                mCLASS(); 

                }
                break;
            case 31 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:291: VAR
                {
                mVAR(); 

                }
                break;
            case 32 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:295: DEF
                {
                mDEF(); 

                }
                break;
            case 33 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:299: RETURNSTMT
                {
                mRETURNSTMT(); 

                }
                break;
            case 34 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:310: SUBTYPE
                {
                mSUBTYPE(); 

                }
                break;
            case 35 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:318: SUBCLASS
                {
                mSUBCLASS(); 

                }
                break;
            case 36 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:327: SELF
                {
                mSELF(); 

                }
                break;
            case 37 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:332: IFSTMT
                {
                mIFSTMT(); 

                }
                break;
            case 38 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:339: WHILESTMT
                {
                mWHILESTMT(); 

                }
                break;
            case 39 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:349: FORSTMT
                {
                mFORSTMT(); 

                }
                break;
            case 40 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:357: ELIF
                {
                mELIF(); 

                }
                break;
            case 41 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:362: ELSE
                {
                mELSE(); 

                }
                break;
            case 42 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:367: EQ
                {
                mEQ(); 

                }
                break;
            case 43 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:370: ID
                {
                mID(); 

                }
                break;
            case 44 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:373: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA14 dfa14 = new DFA14(this);
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
        "\2\uffff\1\0\1\1\2\uffff}>";
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
            return "199:1: LINE_COMMENT : ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r\\n' | '\\r' | '\\n' ) | '//' (~ ( '\\n' | '\\r' ) )* );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_2 = input.LA(1);

                        s = -1;
                        if ( ((LA5_2>='\u0000' && LA5_2<='\t')||(LA5_2>='\u000B' && LA5_2<='\f')||(LA5_2>='\u000E' && LA5_2<='\uFFFF')) ) {s = 3;}

                        else if ( (LA5_2=='\n'||LA5_2=='\r') ) {s = 4;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_3 = input.LA(1);

                        s = -1;
                        if ( (LA5_3=='\n'||LA5_3=='\r') ) {s = 4;}

                        else if ( ((LA5_3>='\u0000' && LA5_3<='\t')||(LA5_3>='\u000B' && LA5_3<='\f')||(LA5_3>='\u000E' && LA5_3<='\uFFFF')) ) {s = 3;}

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
    static final String DFA14_eotS =
        "\4\uffff\1\46\1\50\1\53\1\54\3\uffff\2\43\1\61\14\uffff\11\43\12"+
        "\uffff\3\43\2\uffff\7\43\1\106\4\43\1\113\2\43\1\116\1\117\3\43"+
        "\1\uffff\2\43\1\126\1\43\1\uffff\2\43\2\uffff\3\43\1\135\1\43\1"+
        "\140\1\uffff\1\126\1\43\1\142\3\43\1\uffff\1\146\1\43\1\uffff\1"+
        "\43\1\uffff\1\151\2\43\1\uffff\1\154\1\43\1\uffff\2\43\1\uffff\4"+
        "\43\1\164\2\43\1\uffff\1\167\1\170\2\uffff";
    static final String DFA14_eofS =
        "\171\uffff";
    static final String DFA14_minS =
        "\1\11\3\uffff\2\75\1\52\1\60\3\uffff\1\162\1\141\1\75\14\uffff\1"+
        "\137\1\154\1\141\3\145\1\146\1\150\1\154\12\uffff\1\165\1\154\1"+
        "\162\2\uffff\1\143\1\141\1\162\1\146\1\164\1\142\1\154\1\52\1\151"+
        "\1\163\1\145\1\163\1\52\1\157\1\163\2\52\1\165\1\143\1\146\1\uffff"+
        "\1\154\1\145\1\52\1\145\1\uffff\1\156\1\163\2\uffff\1\162\1\171"+
        "\1\154\1\52\1\145\1\52\1\uffff\1\52\1\163\1\52\1\156\1\160\1\141"+
        "\1\uffff\1\52\1\146\1\uffff\1\164\1\uffff\1\52\1\145\1\163\1\uffff"+
        "\1\52\1\162\1\uffff\1\117\1\163\1\uffff\1\165\1\146\1\117\1\143"+
        "\1\52\1\146\1\164\1\uffff\2\52\2\uffff";
    static final String DFA14_maxS =
        "\1\175\3\uffff\2\75\1\57\1\71\3\uffff\1\162\1\157\1\75\14\uffff"+
        "\1\137\1\154\1\141\2\145\1\165\1\146\1\150\1\154\12\uffff\1\165"+
        "\1\154\1\162\2\uffff\1\143\1\141\1\162\1\146\1\164\1\142\1\154\1"+
        "\172\1\151\1\163\1\145\1\163\1\172\1\157\1\163\2\172\1\165\1\164"+
        "\1\146\1\uffff\1\154\1\145\1\172\1\145\1\uffff\1\156\1\163\2\uffff"+
        "\1\162\1\171\1\154\1\172\1\145\1\172\1\uffff\1\172\1\163\1\172\1"+
        "\156\1\160\1\141\1\uffff\1\172\1\146\1\uffff\1\164\1\uffff\1\172"+
        "\1\145\1\163\1\uffff\1\172\1\162\1\uffff\1\117\1\163\1\uffff\1\165"+
        "\1\146\1\117\1\143\1\172\1\146\1\164\1\uffff\2\172\2\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\1\3\4\uffff\1\12\1\13\1\14\3\uffff\1\17\1\20\1"+
        "\21\1\23\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\11\uffff\1\53\1"+
        "\54\1\5\1\4\1\7\1\6\1\10\1\11\1\24\1\22\3\uffff\1\52\1\16\24\uffff"+
        "\1\45\4\uffff\1\47\2\uffff\1\37\1\40\6\uffff\1\15\6\uffff\1\44\2"+
        "\uffff\1\51\1\uffff\1\36\3\uffff\1\46\2\uffff\1\41\2\uffff\1\50"+
        "\7\uffff\1\42\2\uffff\1\43\1\35";
    static final String DFA14_specialS =
        "\171\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\44\2\uffff\1\44\22\uffff\1\44\1\3\1\11\3\uffff\1\22\1\12"+
            "\1\26\1\27\1\21\1\20\1\1\1\7\1\16\1\6\12\10\1\2\1\17\1\4\1\15"+
            "\1\5\2\uffff\32\43\1\30\1\uffff\1\31\1\uffff\1\32\1\uffff\2"+
            "\43\1\33\1\35\1\42\1\14\2\43\1\40\10\43\1\36\1\37\1\13\1\43"+
            "\1\34\1\41\3\43\1\24\1\23\1\25",
            "",
            "",
            "",
            "\1\45",
            "\1\47",
            "\1\51\4\uffff\1\52",
            "\12\10",
            "",
            "",
            "",
            "\1\55",
            "\1\56\15\uffff\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\70\17\uffff\1\67",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\114",
            "\1\115",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\120",
            "\1\122\20\uffff\1\121",
            "\1\123",
            "",
            "\1\124",
            "\1\125",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\127",
            "",
            "\1\130",
            "\1\131",
            "",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\136",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\10\43\1\137\21\43",
            "",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\141",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\147",
            "",
            "\1\150",
            "",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\152",
            "\1\153",
            "",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\155",
            "",
            "\1\156",
            "\1\157",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\1\165",
            "\1\166",
            "",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "\2\43\1\uffff\1\43\1\uffff\13\43\7\uffff\32\43\4\uffff\1\43"+
            "\1\uffff\32\43",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | COMMENT | LINE_COMMENT | INTLITERAL | STRINGLITERAL | CHARLITERAL | BOOLLITERAL | EQOPERATOR | CALLOPERATOR | SEMICOLON | PLUSOPERATOR | MINUSOPERATOR | TIMESOPERATOR | DIVIDEOPERATOR | ANDOPERATOR | OROPERATOR | LBRACE | RBRACE | LPARA | RPARA | LBRACK | RBRACK | CONSTRUCT | CLASS | VAR | DEF | RETURNSTMT | SUBTYPE | SUBCLASS | SELF | IFSTMT | WHILESTMT | FORSTMT | ELIF | ELSE | EQ | ID | WS );";
        }
    }
 

}