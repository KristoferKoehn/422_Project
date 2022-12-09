package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import commentCountCheck.CommentCountCheck;

class CommentBlackBox {

	@Test
	void NoCommentTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/NoCommentTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(0, check.commentCount);

	}

	@Test
	void OneCommentTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/OneCommentTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(1, check.commentCount);

	}

	@Test
	void ManyCommentTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/ManyCommentsTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(3, check.commentCount);
	}

	@Test
	void BeginningOfFileTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/CommentBeforeImportTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(4, check.commentCount);
	}

	@Test
	void EndOfFileTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/CommentAtEndOfFileTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(4, check.commentCount);
	}

	@Test
	void multilineCommentTest() throws Exception, CheckstyleException {
		CommentCountCheck check = new CommentCountCheck();
		String filePath = "src/test/java/blackBoxTestFiles/BothTypesOfComments.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(4, check.commentCount);
	}
}
