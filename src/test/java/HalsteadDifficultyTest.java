import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;


import difficultyCheck.DifficultyCheck;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

public class HalsteadDifficultyTest {
	
	int[] tokenTypes = {TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL,
		 TokenTypes.METHOD_CALL, TokenTypes.IDENT,TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.STAR,TokenTypes.DIV, TokenTypes.MOD, TokenTypes.DEC, TokenTypes.ASSIGN, TokenTypes.BNOT, TokenTypes.LNOT, TokenTypes.UNARY_PLUS, TokenTypes.UNARY_MINUS, TokenTypes.POST_INC
			,TokenTypes.POST_DEC,TokenTypes.STAR_ASSIGN, TokenTypes.DIV_ASSIGN, TokenTypes.MOD_ASSIGN,TokenTypes.PLUS_ASSIGN, TokenTypes.MINUS_ASSIGN,TokenTypes.SR_ASSIGN, TokenTypes.SL_ASSIGN, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR_ASSIGN, TokenTypes.BOR_ASSIGN, TokenTypes.BAND_ASSIGN, TokenTypes.BSR, TokenTypes.SR, TokenTypes.SL, TokenTypes.LAND, 
			TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.BAND, TokenTypes.LT, TokenTypes.GT, TokenTypes.LE, TokenTypes.GE,TokenTypes.EQUAL, TokenTypes.NOT_EQUAL, TokenTypes.LOR, TokenTypes.ENUM,TokenTypes.QUESTION, TokenTypes.LITERAL_ASSERT, TokenTypes.LITERAL_BREAK, TokenTypes.LITERAL_CASE, TokenTypes.LITERAL_CATCH, TokenTypes.LITERAL_CLASS, TokenTypes.LITERAL_CONTINUE, TokenTypes.LITERAL_DEFAULT, TokenTypes.LITERAL_DO, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_FALSE, TokenTypes.LITERAL_FINALLY, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_IF, 
			TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LITERAL_INTERFACE,  TokenTypes.LITERAL_NATIVE, TokenTypes.LITERAL_NEW, TokenTypes.LITERAL_NULL, TokenTypes.LITERAL_PRIVATE, TokenTypes.LITERAL_PROTECTED, TokenTypes.LITERAL_PUBLIC, TokenTypes.LITERAL_RECORD, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_STATIC, TokenTypes.LITERAL_SUPER, TokenTypes.LITERAL_SWITCH, TokenTypes.LITERAL_SYNCHRONIZED, TokenTypes.LITERAL_THIS, TokenTypes.LITERAL_THROW, TokenTypes.LITERAL_THROWS, TokenTypes.LITERAL_TRANSIENT, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_TRY, TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_VOLATILE, 
			TokenTypes.LITERAL_WHILE,TokenTypes.SEMI, TokenTypes.COLON, TokenTypes.DOUBLE_COLON, TokenTypes.COMMA, TokenTypes.ELLIPSIS, TokenTypes.LCURLY, TokenTypes.LPAREN, TokenTypes.LAMBDA, TokenTypes.DOT,TokenTypes.ARRAY_DECLARATOR, TokenTypes.IMPORT, TokenTypes.PACKAGE_DEF,  TokenTypes.ABSTRACT, TokenTypes.FINAL, TokenTypes.DO_WHILE, TokenTypes.SLIST};
	@Spy
	DifficultyCheck spyDifficulty = spy(DifficultyCheck.class);
	
	@Mock
	DifficultyCheck mockDifficulty = mock(DifficultyCheck.class);
	DifficultyCheck difficulty = new DifficultyCheck();
	DetailAST mockAST = mock(DetailAST.class);
	
	
	
	 @Test
	void beginTreeTest() {
		spyDifficulty.beginTree(mockAST);
		verify(spyDifficulty, atLeastOnce()).beginTree(mockAST);
		
	}
	
	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(difficulty.getDefaultTokens(), tokenTypes);
	}
	
	@Test
	void visitTokenBORTest() {
	        DifficultyCheck spyDiff = spy(new DifficultyCheck());
	        DetailAST mockAST = mock(DetailAST.class);
	        doReturn(TokenTypes.BOR).when(mockAST).getType();
	        spyDiff.visitToken(mockAST);
	        verify(spyDiff, atLeastOnce()).visitToken(mockAST);
	}
	   
	@Test
	void visitTokenDOUBLETest() {
		   DifficultyCheck spyDiff = spy(new DifficultyCheck());
	       DetailAST mockAST = mock(DetailAST.class);
	       doReturn(TokenTypes.NUM_DOUBLE).when(mockAST).getType();
	       spyDiff.visitToken(mockAST);
	       verify(spyDiff, atLeastOnce()).visitToken(mockAST);
	}
   
   @Test
   void getAcceptableTokensTest() {
		assertArrayEquals(difficulty.getAcceptableTokens(), tokenTypes);
   }
   
   @Test
   void getRequiredTokensTest() {
		assertArrayEquals(difficulty.getRequiredTokens(), tokenTypes);
   }
   
   @Test
   void finishTreeTest() {
   	String message = "Halstead Difficulty: 0 KAK";
		doNothing().when(spyDifficulty).log(0, message);
		spyDifficulty.finishTree(mockAST);
		verify(spyDifficulty).finishTree(mockAST);
   }
   
   @Test
   void calculateHalsteadDifficultyTest() {
	   difficulty.uniqueOperators = 12;
	   difficulty.totalOperands = 40;
	   difficulty.uniqueOperands = 10;
	   assertEquals(24, difficulty.calculateHalsteadDifficulty());
   }
}
