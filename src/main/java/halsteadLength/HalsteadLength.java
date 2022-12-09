package halsteadLength;

import com.puppycrawl.tools.checkstyle.api.*;

public class HalsteadLength extends AbstractCheck {

	    private static final String CATCH_MSG = "Halstead length: ";
	 
	   public int count = 0;
	    
	    // 
	    @Override
	    public int[] getDefaultTokens() {
	    	return getRequiredTokens();
	    }
	    
	    @Override
	    public void visitToken(DetailAST aAST) {
	    		count++;	    			    	
	    }

	    @Override
	    public void beginTree(DetailAST aAST) {
	    		count = 0;	    	    			    	
	    }

		@Override
		public int[] getAcceptableTokens() {
			return getDefaultTokens();
		}

		@Override
		public int[] getRequiredTokens() {
			return new int[] { TokenTypes.NOT_EQUAL, TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.STAR,TokenTypes.DIV, TokenTypes.MOD, TokenTypes.DEC, TokenTypes.ASSIGN, TokenTypes.BNOT, TokenTypes.LNOT, TokenTypes.UNARY_PLUS, TokenTypes.UNARY_MINUS, TokenTypes.POST_INC
					,TokenTypes.POST_DEC,TokenTypes.STAR_ASSIGN, TokenTypes.DIV_ASSIGN, TokenTypes.MOD_ASSIGN,TokenTypes.PLUS_ASSIGN, TokenTypes.MINUS_ASSIGN,TokenTypes.SR_ASSIGN, TokenTypes.SL_ASSIGN, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR_ASSIGN, TokenTypes.BOR_ASSIGN, TokenTypes.BAND_ASSIGN, TokenTypes.BSR, TokenTypes.SR, TokenTypes.SL, TokenTypes.LAND, 
					TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.BAND, TokenTypes.LT, TokenTypes.GT, TokenTypes.LE, TokenTypes.GE,TokenTypes.EQUAL, TokenTypes.LOR, TokenTypes.ENUM,TokenTypes.QUESTION, TokenTypes.LITERAL_ASSERT, TokenTypes.LITERAL_BOOLEAN, TokenTypes.LITERAL_BREAK, TokenTypes.LITERAL_BYTE, TokenTypes.LITERAL_CASE, TokenTypes.LITERAL_CATCH, TokenTypes.LITERAL_CHAR, TokenTypes.LITERAL_CLASS, TokenTypes.LITERAL_CONTINUE, TokenTypes.LITERAL_DEFAULT, TokenTypes.LITERAL_DO, TokenTypes.LITERAL_DOUBLE, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_FALSE, TokenTypes.LITERAL_FINALLY, TokenTypes.LITERAL_FLOAT, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_IF, 
					TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LITERAL_INT, TokenTypes.LITERAL_INTERFACE, TokenTypes.LITERAL_LONG, TokenTypes.LITERAL_NATIVE, TokenTypes.LITERAL_NEW, TokenTypes.LITERAL_NULL, TokenTypes.LITERAL_PRIVATE, TokenTypes.LITERAL_PROTECTED, TokenTypes.LITERAL_PUBLIC, TokenTypes.LITERAL_RECORD, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_SHORT, TokenTypes.LITERAL_STATIC, TokenTypes.LITERAL_SUPER, TokenTypes.LITERAL_SWITCH, TokenTypes.LITERAL_SYNCHRONIZED, TokenTypes.LITERAL_THIS, TokenTypes.LITERAL_THROW, TokenTypes.LITERAL_THROWS, TokenTypes.LITERAL_TRANSIENT, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_TRY, TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_VOLATILE, 
					TokenTypes.LITERAL_WHILE, TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL, TokenTypes.SEMI, TokenTypes.COLON, TokenTypes.DOUBLE_COLON, TokenTypes.COMMA, TokenTypes.ELLIPSIS, TokenTypes.LCURLY, TokenTypes.LPAREN, TokenTypes.LAMBDA, TokenTypes.DOT, TokenTypes.IDENT,TokenTypes.ARRAY_DECLARATOR, TokenTypes.IMPORT, TokenTypes.PACKAGE_DEF, TokenTypes.METHOD_CALL, TokenTypes.ABSTRACT, TokenTypes.FINAL, TokenTypes.DO_WHILE, TokenTypes.SLIST };
		}
	 
		@Override
		public void finishTree(DetailAST rootAST) {
			log(0, CATCH_MSG + Integer.toString(count) + " KAK");
		}
		
}
