// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/sh/gitty/private/ooplss/grammar/Ooplss.g 2011-03-22 21:54:18

package ch.codedump.ooplss.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class OoplssLexer extends Lexer {
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

    public OoplssLexer() {;} 
    public OoplssLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OoplssLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/sh/gitty/private/ooplss/grammar/Ooplss.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:6: ( 'class' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:7:8: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:6: ( 'extends' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:8:8: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:6: ( 'inherits' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:9:8: 'inherits'
            {
            match("inherits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:7: ( ',' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:10:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:7: ( '{' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:11:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:7: ( '}' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:12:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:25:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:25:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:25:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
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
            	    break loop1;
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

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:26:10: ( ( '\\r' )? '\\n' )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:26:12: ( '\\r' )? '\\n'
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:26:12: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:26:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:27:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:27:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:27:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
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
        // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | ID | NEWLINE | WS )
        int alt4=9;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:10: T__7
                {
                mT__7(); 

                }
                break;
            case 2 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:15: T__8
                {
                mT__8(); 

                }
                break;
            case 3 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:20: T__9
                {
                mT__9(); 

                }
                break;
            case 4 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:25: T__10
                {
                mT__10(); 

                }
                break;
            case 5 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:31: T__11
                {
                mT__11(); 

                }
                break;
            case 6 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:37: T__12
                {
                mT__12(); 

                }
                break;
            case 7 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:43: ID
                {
                mID(); 

                }
                break;
            case 8 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:46: NEWLINE
                {
                mNEWLINE(); 

                }
                break;
            case 9 :
                // /home/sh/gitty/private/ooplss/grammar/Ooplss.g:1:54: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\3\7\4\uffff\1\12\1\16\1\uffff\3\7\1\uffff\6\7\1\30\2\7"+
        "\1\uffff\2\7\1\35\1\7\1\uffff\1\37\1\uffff";
    static final String DFA4_eofS =
        "\40\uffff";
    static final String DFA4_minS =
        "\1\11\1\154\1\170\1\156\4\uffff\1\12\1\11\1\uffff\1\141\1\164\1"+
        "\150\1\uffff\1\163\2\145\1\163\1\156\1\162\1\60\1\144\1\151\1\uffff"+
        "\1\163\1\164\1\60\1\163\1\uffff\1\60\1\uffff";
    static final String DFA4_maxS =
        "\1\175\1\154\1\170\1\156\4\uffff\1\12\1\40\1\uffff\1\141\1\164\1"+
        "\150\1\uffff\1\163\2\145\1\163\1\156\1\162\1\172\1\144\1\151\1\uffff"+
        "\1\163\1\164\1\172\1\163\1\uffff\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\2\uffff\1\11\3\uffff\1\10\11\uffff\1\1"+
        "\4\uffff\1\2\1\uffff\1\3";
    static final String DFA4_specialS =
        "\40\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\12\1\11\2\uffff\1\10\22\uffff\1\12\13\uffff\1\4\24\uffff"+
            "\32\7\4\uffff\1\7\1\uffff\2\7\1\1\1\7\1\2\3\7\1\3\21\7\1\5\1"+
            "\uffff\1\6",
            "\1\13",
            "\1\14",
            "\1\15",
            "",
            "",
            "",
            "",
            "\1\11",
            "\2\12\2\uffff\1\12\22\uffff\1\12",
            "",
            "\1\17",
            "\1\20",
            "\1\21",
            "",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7",
            "\1\31",
            "\1\32",
            "",
            "\1\33",
            "\1\34",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7",
            "\1\36",
            "",
            "\12\7\7\uffff\32\7\4\uffff\1\7\1\uffff\32\7",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | ID | NEWLINE | WS );";
        }
    }
 

}