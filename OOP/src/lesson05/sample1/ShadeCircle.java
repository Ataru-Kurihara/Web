package lesson05.sample1;

import java.awt.*;

public class ShadeCircle 
{
    private Circle c;

    public ShadeCircle(Circle c)
    {
	this.c = c;
    }
    public void drawShade(Graphics g)
    {
	c.draw(g);
	g.setColor(Color.gray);
	g.drawOval(c.getX()+5, c.getY()+5, 10, 10);
    }
}
