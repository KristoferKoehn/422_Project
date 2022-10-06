package countingChecks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class CommentCountCheck extends AbstractCheck {
	
	private int commentCount = 0;
	
	
	@Override
	public boolean isCommentNodesRequired() {
		return true;
	}
	
	@Override
	public void visitToken(DetailAST aAST) {
		commentCount++;
	}

	@Override
	public void finishTree(DetailAST aAST) {
		reportStyleError(aAST, "found a total of " + commentCount + " comments");
    	commentCount = 0;
	}
	
	private void reportStyleError(DetailAST aAST, String variableName) {
	        log(aAST.getLineNo(), variableName + " KAK");
	}
	
	@Override
	public int[] getAcceptableTokens() {
		int[] tokens = {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		return tokens;
	}
	

	@Override
	public int[] getDefaultTokens() {
		return getRequiredTokens();
	}
	
	@Override
	public int[] getRequiredTokens() {
		int[] tokens = {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
		return tokens;
	}
}
