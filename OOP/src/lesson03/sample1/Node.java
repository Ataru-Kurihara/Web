package lesson03.sample1;

public class Node
{
    private String data;
    private Node next;

    public Node(String d)
    {
	data = d;
    }
    public void setNext(Node n)
    {
	next = n;
    }
    public Node getNext()
    {
	return next;
    }
    public String toString()
    {
	return data;
    }
}
