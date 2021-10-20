package lesson05.sample7;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample7 extends JFrame
{
    private SamplePanel sp;

    public static void main(String args[])
    {
	Sample7 sm = new Sample7();
    }
    public Sample7()
    {
	super("サンプル");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize(300, 300);
	sp = new SamplePanel();
	add(sp, BorderLayout.CENTER);
	setVisible(true);
    }
    public class SamplePanel extends JPanel
    {
	private ArrayList<Circle> circlelist
	    = new ArrayList<Circle>();
	
	public SamplePanel()
	{
	    addMouseListener(new SampleMouseListener());
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
	    Iterator<Circle> it = circlelist.iterator();
	    while(it.hasNext()) {
		Circle c = it.next();
		c.draw(g); // 変更なし
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		circlelist.add(new Adapter(e.getX(), e.getY()));
		repaint();
	    }
	}
    }
}
