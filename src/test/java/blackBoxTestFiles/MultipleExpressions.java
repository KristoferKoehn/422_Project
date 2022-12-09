package blackBoxTestFiles;

public class MultipleExpressions {
	public void manyExpressions() {
		int i = 5;
		int m = (i+8)/20;
		functionCallExpression((5+5)/20);
	}
	public int functionCallExpression(int t) {
		return t;
	}
}
