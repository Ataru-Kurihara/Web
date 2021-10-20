package lesson02.sample5;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample5 extends JFrame
{
    private SamplePanel sp;

    public static void main(String args[])
    {
	Sample5 sm = new Sample5();
    }
    public Sample5()
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
	private ArrayList<Rectangle> rectlist
	    = new ArrayList<Rectangle>();

	public SamplePanel()
	{
	    addMouseListener(new SampleMouseListener());
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
	    Iterator<Rectangle> it = rectlist.iterator();
	    while(it.hasNext()) {
		Rectangle r = it.next();
		r.draw(g);
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		rectlist.add(new Rectangle(e.getX(), e.getY()));
		repaint();
	    }
	}
    }
}
