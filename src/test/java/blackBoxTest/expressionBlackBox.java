package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import expressionCheck.ExpressionCheck;
class expressionBlackBox {

		@Test
		void noExpressionTest() throws Exception, CheckstyleException {
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "src/test/java/blackBoxTestFiles/NoExpressionTest.java";
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(0, check.expressionsCount);

		}
		@Test
		void oneExpressionTest() throws Exception, CheckstyleException {
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "src/test/java/blackBoxTestFiles/SingleExpression.java";
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(1, check.expressionsCount);

		}
		@Test
		void manyExpressionTest() throws Exception, CheckstyleException {
			ExpressionCheck check = new ExpressionCheck();
			String filePath = "src/test/java/blackBoxTestFiles/MultipleExpressions.java";
			TreeWalker treeWalker = new TreeWalker(filePath,check);
			treeWalker.test();
			assertEquals(5, check.expressionsCount);

		}

}
