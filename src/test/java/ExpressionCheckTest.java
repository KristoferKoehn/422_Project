

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import expressionCheck.ExpressionCheck;
public class ExpressionCheckTest {

	 int[] tokenTypes =  {TokenTypes.EXPR};

	 @Mock
	 ExpressionCheck mockExpression = mock(ExpressionCheck.class);
	 ExpressionCheck spyExpression = spy(ExpressionCheck.class);
	 DetailAST mockAST = mock(DetailAST.class);
	 ExpressionCheck expression = new ExpressionCheck();
	 
	 @Test
	void beginTreeTest() {
			mockExpression.beginTree(mockAST);
			verify(mockExpression, atLeastOnce()).beginTree(mockAST);
			expression.beginTree(mockAST);
			assertEquals(0, expression.expressionsCount);
	}
	
	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(expression.getDefaultTokens(), tokenTypes);
	}
	
    @Test
    void visitTokenTest() {
		mockExpression.visitToken(mockAST);
		verify(mockExpression, atLeastOnce()).visitToken(mockAST);
		expression.visitToken(mockAST);
		assertEquals(1, expression.expressionsCount);
		
    }
    
    @Test
    void getAcceptableTokensTest() {
		assertArrayEquals(expression.getAcceptableTokens(), tokenTypes);
    }
    
    @Test
    void getRequiredTokensTest() {
		assertArrayEquals(expression.getRequiredTokens(), tokenTypes);
    }
    
    @Test
    void finishTreeTest() {
    	String message = "Number of expressions is: 0 KAK";
		doNothing().when(spyExpression).log(0, message);
		spyExpression.finishTree(mockAST);
		verify(spyExpression).finishTree(mockAST);
    }
 
}
