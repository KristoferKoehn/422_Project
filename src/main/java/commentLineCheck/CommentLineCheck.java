package commentLineCheck;

 
import com.puppycrawl.tools.checkstyle.api.*;
 
public class CommentLineCheck extends AbstractCheck {
 
    private static final String CATCH_MSG = "Total comment lines found: ";
    public int count = 0;
 
    @Override
    public int[] getDefaultTokens() {
        return new int[] {TokenTypes.COMMENT_CONTENT, TokenTypes.BLOCK_COMMENT_BEGIN};
    }
    
    @Override
    public void visitToken(DetailAST aAST) {
    	if (aAST.getType() == TokenTypes.BLOCK_COMMENT_BEGIN)
    	{
    		DetailAST end = aAST.findFirstToken(TokenTypes.BLOCK_COMMENT_END);
    		count += (end.getLineNo() - aAST.getLineNo())-1;
    	}
    	count ++;
    }
    
    @Override
    public void beginTree(DetailAST aAST) {
        count = 0;
    }
    
    @Override
    public void finishTree(DetailAST aAST) {
        log(aAST.getLineNo(), CATCH_MSG + count + " -LS");
    }

	@Override
	public int[] getAcceptableTokens() {
		// TODO Auto-generated method stub
		 return getRequiredTokens();
	}

	@Override
	public int[] getRequiredTokens() {
		// TODO Auto-generated method stub
		return getDefaultTokens();
	}
	
	@Override
	public boolean isCommentNodesRequired()
	{
		return true;
	}
}