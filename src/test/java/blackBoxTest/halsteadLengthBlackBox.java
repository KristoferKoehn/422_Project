package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadLength.HalsteadLength;
class halsteadLengthBlackBox {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		HalsteadLength check = new HalsteadLength();
		String filePath = "src/test/java/blackBoxTestFiles/halsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(95, check.count);

	}
	@Test
	void minimumTest() throws Exception, CheckstyleException {
		HalsteadLength check = new HalsteadLength();
		String filePath = "src/test/java/blackBoxTestFiles/minimumHalsteadlength.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(7, check.count);

	}
}
