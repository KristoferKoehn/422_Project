package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import difficultyCheck.DifficultyCheck;

class HalsteadDifficultyBlackBox {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		DifficultyCheck check = new DifficultyCheck();
		String filePath = "src/test/java/blackBoxTestFiles/halsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(24, check.calculateHalsteadDifficulty());

	}
	
	@Test
	void simpleTest() throws Exception, CheckstyleException {
		DifficultyCheck check = new DifficultyCheck();
		String filePath = "src/test/java/blackBoxTestFiles/halsteadDifficultyTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(10, check.calculateHalsteadDifficulty());

	}
	
	//can't get 100% in halstead difficulty because of the logic used to prevent divide by zero cases. CANT HAVE NO OPERANDS!!!!!
}
