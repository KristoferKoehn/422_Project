import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

import vocabularyCheck.VocabularyCheck;

public class HalsteadVocabularyCheckTest {
	
	int[] tokenTypes =  { TokenTypes.NUM_DOUBLE, TokenTypes.NUM_FLOAT, TokenTypes.NUM_INT, TokenTypes.NUM_LONG, TokenTypes.CHAR_LITERAL, TokenTypes.STRING_LITERAL,
			 TokenTypes.METHOD_CALL, TokenTypes.IDENT,TokenTypes.PLUS, TokenTypes.MINUS, TokenTypes.STAR,TokenTypes.DIV, TokenTypes.MOD, TokenTypes.DEC, TokenTypes.ASSIGN, TokenTypes.BNOT, TokenTypes.LNOT, TokenTypes.UNARY_PLUS, TokenTypes.UNARY_MINUS, TokenTypes.POST_INC
				,TokenTypes.POST_DEC,TokenTypes.STAR_ASSIGN, TokenTypes.DIV_ASSIGN, TokenTypes.MOD_ASSIGN,TokenTypes.PLUS_ASSIGN, TokenTypes.MINUS_ASSIGN,TokenTypes.SR_ASSIGN, TokenTypes.SL_ASSIGN, TokenTypes.BSR_ASSIGN, TokenTypes.BXOR_ASSIGN, TokenTypes.BOR_ASSIGN, TokenTypes.BAND_ASSIGN, TokenTypes.BSR, TokenTypes.SR, TokenTypes.SL, TokenTypes.LAND, 
				TokenTypes.BOR, TokenTypes.BXOR, TokenTypes.BAND, TokenTypes.LT, TokenTypes.GT, TokenTypes.LE, TokenTypes.GE,TokenTypes.EQUAL, TokenTypes.NOT_EQUAL, TokenTypes.LOR, TokenTypes.ENUM,TokenTypes.QUESTION, TokenTypes.LITERAL_ASSERT, TokenTypes.LITERAL_BREAK, TokenTypes.LITERAL_CASE, TokenTypes.LITERAL_CATCH, TokenTypes.LITERAL_CLASS, TokenTypes.LITERAL_CONTINUE, TokenTypes.LITERAL_DEFAULT, TokenTypes.LITERAL_DO, TokenTypes.LITERAL_ELSE, TokenTypes.LITERAL_FALSE, TokenTypes.LITERAL_FINALLY, TokenTypes.LITERAL_FOR, TokenTypes.LITERAL_IF, 
				TokenTypes.LITERAL_INSTANCEOF, TokenTypes.LITERAL_INTERFACE,  TokenTypes.LITERAL_NATIVE, TokenTypes.LITERAL_NEW, TokenTypes.LITERAL_NULL, TokenTypes.LITERAL_PRIVATE, TokenTypes.LITERAL_PROTECTED, TokenTypes.LITERAL_PUBLIC, TokenTypes.LITERAL_RECORD, TokenTypes.LITERAL_RETURN, TokenTypes.LITERAL_STATIC, TokenTypes.LITERAL_SUPER, TokenTypes.LITERAL_SWITCH, TokenTypes.LITERAL_SYNCHRONIZED, TokenTypes.LITERAL_THIS, TokenTypes.LITERAL_THROW, TokenTypes.LITERAL_THROWS, TokenTypes.LITERAL_TRANSIENT, TokenTypes.LITERAL_TRUE, TokenTypes.LITERAL_TRY, TokenTypes.LITERAL_VOID, TokenTypes.LITERAL_VOLATILE, 
				TokenTypes.LITERAL_WHILE,TokenTypes.SEMI, TokenTypes.COLON, TokenTypes.DOUBLE_COLON, TokenTypes.COMMA, TokenTypes.ELLIPSIS, TokenTypes.LCURLY, TokenTypes.LPAREN, TokenTypes.LAMBDA, TokenTypes.DOT,TokenTypes.ARRAY_DECLARATOR, TokenTypes.IMPORT, TokenTypes.PACKAGE_DEF,  TokenTypes.ABSTRACT, TokenTypes.FINAL, TokenTypes.DO_WHILE, TokenTypes.SLIST}; 
	 @Spy
	 VocabularyCheck spyVocabulary = spy(VocabularyCheck.class);
	 @Mock
	 VocabularyCheck mockVocabulary = mock(VocabularyCheck.class);
	 DetailAST mockAST = mock(DetailAST.class);
	 VocabularyCheck vocabulary = new VocabularyCheck();

	 
	 @Test
	void beginTreeTest() {
			spyVocabulary.beginTree(mockAST);
			verify(spyVocabulary, atLeastOnce()).beginTree(mockAST);
	}
	
	@Test
	void getDefaultTokensTest() {
		assertArrayEquals(vocabulary.getDefaultTokens(), tokenTypes);
	}
	
  @Test
  void visitTokenTest() {
	    
	  
	  	doReturn(true).when(spyVocabulary).checkIfOperand(TokenTypes.NUM_DOUBLE);
	  	doReturn(TokenTypes.NUM_DOUBLE).when(mockAST).getType();
	  	spyVocabulary.visitToken(mockAST);
	  	verify(spyVocabulary, atLeastOnce()).visitToken(mockAST);
	  	
	  	doReturn(false).when(spyVocabulary).checkIfOperand(TokenTypes.NUM_DOUBLE);
	  	doReturn(TokenTypes.NUM_DOUBLE).when(mockAST).getType();
	  	spyVocabulary.visitToken(mockAST);
	  	verify(spyVocabulary, atLeastOnce()).visitToken(mockAST);
	  	
	  	
	  	doReturn(false).when(spyVocabulary).checkIfOperand(TokenTypes.BOR);
	  	doReturn(TokenTypes.BOR).when(mockAST).getType();
	  	spyVocabulary.visitToken(mockAST);
	  	verify(spyVocabulary, atLeastOnce()).visitToken(mockAST);
		
	  	doReturn(false).when(spyVocabulary).checkIfOperand(TokenTypes.BOR);
	  	doReturn(TokenTypes.BOR).when(mockAST).getType();
	  	spyVocabulary.visitToken(mockAST);
	  	verify(spyVocabulary, atLeastOnce()).visitToken(mockAST);
  }
  
  @Test
  void getAcceptableTokensTest() {
		assertArrayEquals(vocabulary.getAcceptableTokens(), tokenTypes);
  }
  
  @Test
  void getRequiredTokensTest() {
		assertArrayEquals(vocabulary.getRequiredTokens(), tokenTypes);
  }
  
  @Test
  void finishTreeTest() {
  		String message = "Halstead Vocabulary: 0 KAK";
		doNothing().when(spyVocabulary).log(0, message);
		spyVocabulary.finishTree(mockAST);
		verify(spyVocabulary).finishTree(mockAST);
  }

  @Test
  void checkIfOperandTest() {
	  assertTrue(vocabulary.checkIfOperand(TokenTypes.NUM_DOUBLE));
	  assertFalse(vocabulary.checkIfOperand(TokenTypes.BAND));
  }
  
  @Test
  void getVocabularyTest() {
	  vocabulary.uniqueOperands = 50;
	  vocabulary.uniqueOperators = 50;
	  assertEquals(100, vocabulary.getVocabulary());
  }
}
