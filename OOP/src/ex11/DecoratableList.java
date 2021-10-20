package ex11;

import java.util.ArrayList;

public class DecoratableList {
	public static void main(String[] args) {
		ArrayList<Decoratable> decoratablelist = new ArrayList<>();
		Star s1 = new Star("aaa");
		Box b1 = new Box("栗原");
		List l1 = new List("ccc",4);
		FreeStyle f1 = new FreeStyle("ddd");
		decoratablelist.add(s1);
		decoratablelist.add(b1);
		decoratablelist.add(l1);
		decoratablelist.add(f1);
		for (int i=0; i<decoratablelist.size(); i++) {
			decoratablelist.get(i).decorate();
		}
	}
}
