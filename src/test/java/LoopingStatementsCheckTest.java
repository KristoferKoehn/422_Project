import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import loopingCheck.LoopingCheck;

public class LoopingStatementsCheckTest {
	
	int[] tokenTypes = {TokenTypes.LITERAL_WHILE, TokenTypes.LITERAL_FOR, TokenTypes.DO_WHILE};
	
	 @Spy
	 LoopingCheck spyLoopingStatements = spy(LoopingCheck.class);
	 
	 @Mock
	 LoopingCheck mockLoopingStatements = mock(LoopingCheck.class);
	 DetailAST mockAST = mock(DetailAST.class);
	 LoopingCheck loopingStatements = new LoopingCheck();
	 
	 @Test
	void beginTreeTest() {
			spyLoopingStatements.beginTree(mockAST);
			verify(spyLoopingStatements, atLeastOnce()).beginTree(mockAST);

	}
	
	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(loopingStatements.getDefaultTokens(), tokenTypes);
	}
	
  @Test
  void visitTokenTest() {
		spyLoopingStatements.visitToken(mockAST);
		verify(spyLoopingStatements, atLeastOnce()).visitToken(mockAST);
		
  }
  
  @Test
  void getAcceptableTokensTest() {
		assertArrayEquals(loopingStatements.getAcceptableTokens(), tokenTypes);
  }
  
  @Test
  void getRequiredTokensTest() {
		assertArrayEquals(loopingStatements.getRequiredTokens(), tokenTypes);
  }
  
  @Test
  void finishTreeTest() {
  		String message = "Number of looping statements is: 0 KAK";
		doNothing().when(spyLoopingStatements).log(0, message);
		spyLoopingStatements.finishTree(mockAST);
		verify(spyLoopingStatements).finishTree(mockAST);
  }
}
