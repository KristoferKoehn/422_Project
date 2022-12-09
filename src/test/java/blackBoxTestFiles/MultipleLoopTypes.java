package blackBoxTestFiles;

public class MultipleLoopTypes {
	public void noComments() {
		for(int i = 0; i < 2; i++) {
			String test = "Test";
		}
		
		char grade = '0';
		while(grade == '0') {
			grade = 'A';
		}
		int i =0;
		do {
			i++;
		}while(i < 10);
	}
}
