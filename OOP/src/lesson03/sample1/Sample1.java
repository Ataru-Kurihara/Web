package lesson03.sample1;

public class Sample1
{
    public static void main(String args[])
    {
	Node n1 = new Node("Line");
	n1.setNext(null);
	
	Node n2 = new Node("Rectangle");
	n2.setNext(n1);

	Node n3 = new Node("Circle");
	n3.setNext(n2);

	for(Node n = n3; n != null; n = n.getNext()) {
	    System.out.println(n);
	}
    }
}
