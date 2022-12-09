package blackBoxTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import loopingCheck.LoopingCheck;

class loopingStatementBlackBoxTest {

	@Test
	void oneLoopTest() throws Exception, CheckstyleException {
		LoopingCheck check = new LoopingCheck();
		String filePath = "src/test/java/blackBoxTestFiles/OneLoopingStatement.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(1, check.loopingStatementCount);

	}
	@Test
	void manyLoopTest() throws Exception, CheckstyleException {
		LoopingCheck check = new LoopingCheck();
		String filePath = "src/test/java/blackBoxTestFiles/MultipleLoopTypes.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(3, check.loopingStatementCount);

	}
	@Test
	void noLoopTest() throws Exception, CheckstyleException {
		LoopingCheck check = new LoopingCheck();
		String filePath = "src/test/java/blackBoxTestFiles/NoLoopsTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(0, check.loopingStatementCount);

	}
	@Test
	void nestedLoopTest() throws Exception, CheckstyleException {
		LoopingCheck check = new LoopingCheck();
		String filePath = "src/test/java/blackBoxTestFiles/nestedLoopStatements.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(4, check.loopingStatementCount);

	}
	
	
}
