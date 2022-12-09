package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import vocabularyCheck.VocabularyCheck;
class halsteadVocabularyBlackBox {
//n = n1 + n2
	@Test
	void standardTest() throws Exception, CheckstyleException {
		VocabularyCheck check = new VocabularyCheck();
		String filePath = "src/test/java/blackBoxTestFiles/halsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(28, check.getVocabulary());

	}
	@Test
	void onlyUnqueTest() throws Exception, CheckstyleException {
		VocabularyCheck check = new VocabularyCheck();
		String filePath = "src/test/java/blackBoxTestFiles/OnlyUniqueHalsteadVocabulary.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(14, check.getVocabulary());

	}

}
