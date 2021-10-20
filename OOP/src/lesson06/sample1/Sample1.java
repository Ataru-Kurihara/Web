package lesson06.sample1;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

public class Sample1 extends JFrame
{
    private Vector<String> nl = new Vector<String>();
    private JList ls;

    public static void main(String args[])
    {
	Sample1 sm = new Sample1();
    }
    public Sample1()
    {
	super("サンプル");

	Section s1 = new Section("Company");
	Section s2 = new Section("Trade");
	Section s3 = new Section("Accounting");

	Person p1 = new Person("Sato");
	Person p2 = new Person("Takahashi");
	Person p3 = new Person("Suzuki");

	s1.add(s2);
	s1.add(s3);
	s2.add(p1);
	s2.add(p2);
	s3.add(p3);

	Node root = s1;

	walkTree(root);

	ls = new JList(nl);

	add(ls, BorderLayout.CENTER);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	setVisible(true);
    }
    public void walkTree(Node n)
    {
	Vector<Node> children = n.getChildren();
	if(children == null) return;
	Iterator<Node> it = children.iterator();
	while(it.hasNext()) {
	    Node nn = it.next();
	    nl.addElement(nn.toString());
	    walkTree(nn);
	}
    }
}
