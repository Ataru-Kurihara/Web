package lesson06.sample2;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Sample2 extends JFrame
{
    private JTree tr;
    private Node root;

    public static void main(String args[])
    {
	Sample2 sm = new Sample2();
    }
    public Sample2()
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

	root = s1;

	tr = new JTree(new MyTreeModel());

	add(tr, BorderLayout.CENTER);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	setVisible(true);
    }
    public class MyTreeModel implements TreeModel
    {
	public MyTreeModel(){}
	public Object getRoot()
	{
	    return root;
	}
	public Object getChild(Object parent, int index)
	{
	    Node p = (Node) parent;
	    Vector<Node> children = p.getChildren();
	    return children.elementAt(index);
	}
	public int getChildCount(Object parent)
	{
	    Node p = (Node) parent;
	    Vector<Node> children = p.getChildren();
	    return children.size();
	}
	public int getIndexOfChild(Object parent, Object child)
	{
	    Node p = (Node) parent;
	    Vector<Node> children = p.getChildren();
	    Iterator<Node> it = children.iterator();

	    for (int i=0; it.hasNext(); i++) {
		Node nn = it.next();
		if (nn.equals(child)) {
		    return i;
		}
	    }
	    return -1;
	}
	public boolean isLeaf(Object node)
	{
	    if (node instanceof Person) {
		return true;
	    } else {
		return false;
	    }
	}
	public void addTreeModelListener(TreeModelListener l) {}
	public void removeTreeModelListener(TreeModelListener l) {}
	public void valueForPathChanged(TreePath path, Object newValue) {}
    }
}
