package expressionCheck;

import com.puppycrawl.tools.checkstyle.api.*;

public class ExpressionCheck extends AbstractCheck{
	 
    private static final String CATCH_MSG = "Number of expressions is: ";
 
   public int expressionsCount = 0;
    @Override
    public int[] getDefaultTokens() {
    	return getRequiredTokens();
    }
    @Override
    public void visitToken(DetailAST aAST) {
    	expressionsCount++;
    }
 
    @Override
    public void beginTree(DetailAST aAST) {
    	expressionsCount = 0;
    }

	@Override
	public int[] getAcceptableTokens() {
		return getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.EXPR};
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(0, CATCH_MSG + Integer.toString(expressionsCount) + " KAK");		
		expressionsCount = 0;
	}


 
}
