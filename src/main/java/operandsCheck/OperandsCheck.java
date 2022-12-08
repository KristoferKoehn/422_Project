package operandsCheck;

import com.puppycrawl.tools.checkstyle.api.*;

public class OperandsCheck extends AbstractCheck{
	 
    private static final String CATCH_MSG = "Number of operands is: ";
 
    public int OperandsCount = 0;

    @Override
    public int[] getDefaultTokens() {
    	return getRequiredTokens();
    }
    @Override
    public void visitToken(DetailAST aAST) {
    	OperandsCount++;
    	
    }
 
    @Override
    public void beginTree(DetailAST aAST) {
    	OperandsCount = 0;
    }

	@Override
	public int[] getAcceptableTokens() {
		return getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[] { TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL,
				 TokenTypes.METHOD_CALL, TokenTypes.IDENT };
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(0, CATCH_MSG + Integer.toString(OperandsCount) + " KAK");		
		OperandsCount = 0;
		
	}
}
