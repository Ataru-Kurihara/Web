package lesson05.sample6;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sample6 extends JFrame
{
    private SamplePanel sp;
    private int state; // 状態を表す変数を追加

    public static void main(String args[])
    {
	Sample6 sm = new Sample6();
    }
    public Sample6()
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
	private ArrayList<Shape> shapelist
	    = new ArrayList<Shape>();
	
	public SamplePanel()
	{
	    addMouseListener(new SampleMouseListener());
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
	    Iterator<Shape> it = shapelist.iterator();
	    while(it.hasNext()) {
		Shape sh = it.next();
		sh.draw(g);
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		if(state == Shape.CIRCLE) {
		    shapelist.add(new FrameMark(
			new Circle(e.getX(), e.getY())));
		    state = Shape.RECTANGLE;
		}
		else {
		    shapelist.add(new ShadeMark(
			new Rectangle(e.getX(), e.getY())));
		    state = Shape.CIRCLE;
		}
		repaint();
	    }
	}
    }
}
