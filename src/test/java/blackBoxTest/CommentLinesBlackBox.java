package blackBoxTest;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import commentLineCheck.CommentLineCheck;
class CommentLinesBlackBox {

	/*
	 * Assumptions: a multiline comment in this format is 3 lines of comments.
	 */
	@Test
	void noCommentTest() throws Exception, CheckstyleException {
		CommentLineCheck check = new CommentLineCheck();
		String filePath = "src/test/java/blackBoxTestFiles/NoCommentLinesTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(0, check.count);

	}
	
	@Test
	void oneCommentTest() throws Exception, CheckstyleException {
		CommentLineCheck check = new CommentLineCheck();
		String filePath = "src/test/java/blackBoxTestFiles/OneCommentTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(1, check.count);

	}
	@Test
	void manyCommentTest() throws Exception, CheckstyleException {
		CommentLineCheck check = new CommentLineCheck();
		String filePath = "src/test/java/blackBoxTestFiles/MultipleCommentLines.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(10, check.count);

	} 
	
	@Test
	void singleAndMultiCommentTest() throws Exception, CheckstyleException {
		CommentLineCheck check = new CommentLineCheck();
		String filePath = "src/test/java/blackBoxTestFiles/BothCommentTypeLineTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath,check);
		treeWalker.test();
		assertEquals(8, check.count);

	} 
}
