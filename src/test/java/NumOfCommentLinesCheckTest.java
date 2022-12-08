
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import commentLineCheck.CommentLineCheck;




public class NumOfCommentLinesCheckTest {
	 int[] tokenTypes =  {TokenTypes.COMMENT_CONTENT, TokenTypes.BLOCK_COMMENT_BEGIN};
	 
	 @Test
	void beginTreeTest() {
		 CommentLineCheck spyCommentLines = spy(new CommentLineCheck());
		 DetailAST mockAST = mock(DetailAST.class);
			spyCommentLines.beginTree(mockAST);
			verify(spyCommentLines, atLeastOnce()).beginTree(mockAST);
	}
	 
	
	@Test
	void getDefaultTokensTest() {
		 CommentLineCheck commentLines = new CommentLineCheck();
		assertArrayEquals(commentLines.getDefaultTokens(), tokenTypes);
	}
	
	
   @Test
   void visitTokenSingleCommentTest() {
		 CommentLineCheck spyCommentLines = spy(new CommentLineCheck());
		 DetailAST mockAST = mock(DetailAST.class);
		 doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
		 spyCommentLines.visitToken(mockAST);
		 verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
		
		
   }
   
   @Test
   void visitTokenBlockCommentTest() {
		 CommentLineCheck spyCommentLines = spy(new CommentLineCheck());
		 DetailAST mockAST = mock(DetailAST.class);
		 doReturn("/*a*/").when(mockAST).getText();
		 doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();

		 doReturn(mockAST).when(mockAST).findFirstToken(TokenTypes.BLOCK_COMMENT_END);
		 doReturn(1).when(mockAST).getLineNo();
		 spyCommentLines.visitToken(mockAST);
		 verify(spyCommentLines, atLeastOnce()).visitToken(mockAST);
   }
   
   @Test
   void getAcceptableTokensTest() {
		 CommentLineCheck commentLines = new CommentLineCheck();
		assertArrayEquals(commentLines.getAcceptableTokens(), tokenTypes);
   }
   
   @Test
   void getRequiredTokensTest() {
		 CommentLineCheck commentLines = new CommentLineCheck();
		 assertArrayEquals(commentLines.getRequiredTokens(), tokenTypes);
   }
   
   
   @Test
   void finishTreeTest() {
		 CommentLineCheck spyCommentLines = spy(new CommentLineCheck());
		 DetailAST mockAST = mock(DetailAST.class);
		 String message = "Total comment lines found: 0 -LS";
		 doNothing().when(spyCommentLines).log(0, message);
		 spyCommentLines.finishTree(mockAST);
		 verify(spyCommentLines).finishTree(mockAST);
	
   }
   
   @Test
   void isCommentNodesRequiredTest() {
		 CommentLineCheck commentLines = new CommentLineCheck();
   	assertTrue(commentLines.isCommentNodesRequired());
   }
}