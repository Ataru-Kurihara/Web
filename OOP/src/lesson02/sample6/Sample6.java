package lesson02.sample6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Sample6 extends JApplet
{
    private SamplePanel pn;
    
    public void init()
    {
	pn = new SamplePanel();
	add(pn);
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
		c.draw(g);
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		circlelist.add(new Circle(e.getX(), e.getY()));
		repaint();
	    }
	}
    }
}
