package lesson06.sample1;

import java.util.*;

public class Person implements Node
{
    private String nodeName;

    public Person(String s)
    {
	nodeName = s;
    }
    public String toString() 
    {
	return "--member:" + nodeName;
    }
    public Vector<Node> getChildren()
    {
	return null;
    }
}
