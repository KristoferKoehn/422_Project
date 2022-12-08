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

import operandsCheck.OperandsCheck;

public class OperandsCheckTest {

	 int[] tokenTypes =  { TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL,
			 TokenTypes.METHOD_CALL, TokenTypes.IDENT };

	 @Mock
	 OperandsCheck mockOperands = mock(OperandsCheck.class);
	 OperandsCheck spyOperands = spy(OperandsCheck.class);
	 DetailAST mockAST = mock(DetailAST.class);
	 OperandsCheck operands = new OperandsCheck();
	 
	 @Test
	void beginTreeTest() {
			mockOperands.beginTree(mockAST);
			verify(mockOperands, atLeastOnce()).beginTree(mockAST);
			operands.beginTree(mockAST);
			assertEquals(0, operands.OperandsCount);
	}
	
	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(operands.getDefaultTokens(), tokenTypes);
	}
	
   @Test
   void visitTokenTest() {
		mockOperands.visitToken(mockAST);
		verify(mockOperands, atLeastOnce()).visitToken(mockAST);
		operands.visitToken(mockAST);
		assertEquals(1, operands.OperandsCount);
		
   }
   
   @Test
   void getAcceptableTokensTest() {
		assertArrayEquals(operands.getAcceptableTokens(), tokenTypes);
   }
   
   @Test
   void getRequiredTokensTest() {
		assertArrayEquals(operands.getRequiredTokens(), tokenTypes);
   }
   
   @Test
   void finishTreeTest() {
   		String message = "Number of operands is: 0 KAK";
		doNothing().when(spyOperands).log(0, message);
		spyOperands.finishTree(mockAST);
		verify(spyOperands).finishTree(mockAST);
   }

}

