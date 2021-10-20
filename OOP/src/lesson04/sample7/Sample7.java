package lesson04.sample7;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample7 extends JFrame
{
    private SamplePanel sp;
    private int state;

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
	state = Shape.CIRCLE;
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
		    shapelist.add(new Circle(e.getX(), e.getY()));
		    state = Shape.RECTANGLE;
		}
		else if(state == Shape.RECTANGLE) {
		    shapelist.add(new Rectangle(e.getX(), e.getY()));
		    state = Shape.LINE;
		}
		else {
		    shapelist.add(new Line(e.getX(), e.getY()));
		    state = Shape.CIRCLE;
		}
		repaint();
	    }
	}
    }
}
