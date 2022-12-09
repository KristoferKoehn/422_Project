package blackBoxTest;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import operatorsCheck.OperatorsCheck;
class operatorsBlackBoxTest {

	@Test
	void test() throws IOException, CheckstyleException {
		OperatorsCheck check = new OperatorsCheck();
		String filePath = "src/test/java/blackBoxTestFiles/MultipleOperators.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(23, check.operatorsCount);
	}

	@Test
	void nestedTest() throws IOException, CheckstyleException {
		OperatorsCheck check = new OperatorsCheck();
		String filePath = "src/test/java/blackBoxTestFiles/nestedOperators.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(60, check.operatorsCount);
	}
}
