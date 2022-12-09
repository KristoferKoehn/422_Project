package blackBoxTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import volumeCheck.VolumeCheck;

class HalsteadVolumeBlackBox {

	@Test
	void standardTest() throws Exception, CheckstyleException {
		VolumeCheck check = new VolumeCheck();
		String filePath = "src/test/java/blackBoxTestFiles/HalsteadLengthTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(423, check.calculateVolume());

	}

	@Test
	void volumeTest() throws IOException, CheckstyleException, ParseException {
		VolumeCheck check = new VolumeCheck();
		String filePath = "src/test/java/BlackBoxTestFiles/VolumeTest.java";
		TreeWalker treeWalker = new TreeWalker(filePath, check);
		treeWalker.test();
		assertEquals(217, check.calculateVolume());
	}
}
