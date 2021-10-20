package lesson05.sample7;

import java.awt.*;

public class Adapter extends Circle
{
    private LargeCircle lc;

     public Adapter(int x, int y)
    {
	super(x, y);
	this.lc = new LargeCircle(x, y);
    }
    public void draw(Graphics g)
    {
	lc.drawLargeCircle(g);
    }
}
