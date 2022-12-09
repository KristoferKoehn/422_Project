package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import operandsCheck.OperandsCheck;

class operandsBlackBoxTest {


	@Test
	void test() throws IOException, CheckstyleException {
		OperandsCheck check = new OperandsCheck();
		String filePath = "src/test/java/blackBoxTestFiles/minimumOperands.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(2, check.OperandsCount);
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		OperandsCheck check = new OperandsCheck();
		String filePath = "src/test/java/blackBoxTestFiles/MultipleOperands.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(8, check.OperandsCount);
	}

}
