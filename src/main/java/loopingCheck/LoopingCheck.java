package loopingCheck;

import com.puppycrawl.tools.checkstyle.api.*;
import java.util.regex.Pattern;

public class LoopingCheck extends AbstractCheck{
	 
    private static final String CATCH_MSG = "Number of looping statements is: ";
 
    int loopingStatementCount = 0;
    @Override
    public int[] getDefaultTokens() {
    	return getRequiredTokens();
    }
    @Override
    public void visitToken(DetailAST aAST) {
    	loopingStatementCount++;
    }
 
    @Override
    public void beginTree(DetailAST aAST) {
    	loopingStatementCount = 0;
    }
 


	@Override
	public int[] getAcceptableTokens() {
		return getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		return new int[] {TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.DO_WHILE};
	}
	
	@Override
	public void finishTree(DetailAST rootAST) {
		log(0, CATCH_MSG + Integer.toString(loopingStatementCount) + " KAK");		
		loopingStatementCount = 0;
	}


 
}