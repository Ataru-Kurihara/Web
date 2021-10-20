package lesson04.sample1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample1 extends JFrame
{
    private SamplePanel sp;

    public static void main(String args[])
    {
	Sample1 sm = new Sample1();
    }
    public Sample1()
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
	private ArrayList<ShadeCircle> shadecirclelist
	    = new ArrayList<ShadeCircle>();

	public SamplePanel()
	{
	    addMouseListener(new SampleMouseListener());
	}
	public void paint(Graphics g)
	{
	    super.paint(g);
	    Iterator<ShadeCircle> it = shadecirclelist.iterator();
	    while(it.hasNext()) {
		ShadeCircle sc = it.next();
		sc.draw(g);
		sc.drawShade(g);
	    }
	}
	public class SampleMouseListener extends MouseAdapter
	{
	    public void mousePressed(MouseEvent e)
	    {
		shadecirclelist.add(new ShadeCircle(e.getX(), e.getY()));
		repaint();
	    }
	}
    }
}
