package lesson06.sample2;

import java.util.*;

public class Section implements Node
{
    private String nodeName;
    private Vector<Node> children;

    public Section(String s)
    {
	nodeName = s;
	children = new Vector<Node>();
    }
    public void add(Node n)
    {
	children.addElement(n);
    }
    public Vector<Node> getChildren()
    {
	return children;
    }
    public String toString()
    {
	return nodeName;
    }
}
