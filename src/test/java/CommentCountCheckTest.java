import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import commentCountCheck.CommentCountCheck;

public class CommentCountCheckTest {
	int[] tokenTypes =  {TokenTypes.SINGLE_LINE_COMMENT, TokenTypes.BLOCK_COMMENT_BEGIN};
@Spy 
 CommentCountCheck spyComments = spy(CommentCountCheck.class);
@Mock
	DetailAST mockAST = mock(DetailAST.class);
CommentCountCheck mockComments = mock(CommentCountCheck.class);
CommentCountCheck comments = new CommentCountCheck();

@Test
void beginTreeTest() { 
		spyComments.beginTree(mockAST);
		verify(spyComments, atLeastOnce()).beginTree(mockAST);
}
@Test
void getDefaultTokensTest() {
	assertArrayEquals(comments.getDefaultTokens(), tokenTypes);
}

@Test
void visitTokenSingleTest() {
	
	doReturn(TokenTypes.SINGLE_LINE_COMMENT).when(mockAST).getType();
	spyComments.visitToken(mockAST);
	verify(spyComments, atLeastOnce()).visitToken(mockAST);
}

@Test
void visitTokenBlockTest() {
	
	doReturn(TokenTypes.BLOCK_COMMENT_BEGIN).when(mockAST).getType();
	spyComments.visitToken(mockAST);
	verify(spyComments, atLeastOnce()).visitToken(mockAST);
}

@Test
void getAcceptableTokensTest() {
	assertArrayEquals(comments.getAcceptableTokens(), tokenTypes);
}

@Test
void getRequiredTokensTest() {
	assertArrayEquals(comments.getRequiredTokens(), tokenTypes);
}

@Test
void finishTreeTest() {
	String message = "Number of comments is: 0 KAK";
	doNothing().when(spyComments).log(0, message);
	spyComments.finishTree(mockAST);
	verify(spyComments).finishTree(mockAST);
}
@Test
void isCommentNodesRequiredTest() {
	assertTrue(comments.isCommentNodesRequired());
}
}
