package lesson05.sample7;

import java.awt.*;

public class LargeCircle
{
    private int x;
    private int y;
    
    public LargeCircle(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public void drawLargeCircle(Graphics g)
    {
	g.drawOval(x, y, 20, 20);
    }
}
