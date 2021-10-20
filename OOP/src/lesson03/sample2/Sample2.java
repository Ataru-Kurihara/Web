package lesson03.sample2;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Sample2 extends JFrame
{
    private Vector<String> list;
    private JList ls;

    public static void main(String args[])
    {
	Sample2 sm = new Sample2();
    }
    public Sample2()
    {
	super("サンプル");
	list = new Vector<String>();
	
	list.add("Circle");
	list.add("Rectangle");
	list.add("Line");

	ls = new JList(list);
	
	add(ls, BorderLayout.CENTER);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	setVisible(true);
    }
}
