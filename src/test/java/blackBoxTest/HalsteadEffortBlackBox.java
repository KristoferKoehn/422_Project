package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import effortCheck.EffortCheck;

class HalsteadEffortBlackBox {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		EffortCheck check = new EffortCheck();
		String filePath = "src/test/java/blackBoxTestFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();

		assertEquals(12908, check.getEffort());

	}

	@Test
	void effortTest() throws Exception, CheckstyleException {
		EffortCheck check = new EffortCheck();
		String filePath = "src/test/java/blackBoxTestFiles/HalsteadEffortTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(680, check.getEffort());
	}
}
