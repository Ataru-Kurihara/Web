package ex11;

public class FreeStyle implements Decoratable{
	private String str;
	public FreeStyle(String str) {
		this.str = str;
	}
	public void decorate() {
		System.out.println("!"+"!");
		System.out.println("!"+str+"!");
		original();
		
	}
	public void original() {
		for(int i = 0; i<str.length(); i++) {
		System.out.print(" ");
		}
		for(int j = 0; j < 2; j++) {
		System.out.print("!");
		}
	}
}
