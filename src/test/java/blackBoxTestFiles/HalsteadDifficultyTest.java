package blackBoxTestFiles;

public class HalsteadDifficultyTest {
	public void testFunction(int[] a) {
		int temp = a[0];
		a[0] = a[a.length-1];
		a[a.length-1] = temp;
	}
}
