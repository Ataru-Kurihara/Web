package lesson04.sample1;

import java.awt.*;

public class ShadeCircle extends Circle
{
    public ShadeCircle(int x, int y)
    {
	super(x, y);
    }
    public void drawShade(Graphics g)
    {
	g.setColor(Color.gray);
	g.drawOval(getX()+5, getY()+5, 10, 10);
    }
}
