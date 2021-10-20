package ex11;

public class Box implements Decoratable {
	private String str;

	public Box(String str) {
		this.str = str;
	}

	public void decorate() {
		printLine();
		System.out.println("l" + str + "l");
		printLine();
	}

	private void printLine() {
		System.out.print("+");
		for (int i = 0; i<str.length(); i++) {
			if(String.valueOf(str).getBytes().length >= str.length()*2) {
			System.out.print("--");
		}
		else {
			System.out.print("-");
		}
	}
		System.out.println("+");
}
}
