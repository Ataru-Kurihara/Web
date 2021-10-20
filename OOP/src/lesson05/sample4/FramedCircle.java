package lesson05.sample4;

import java.awt.*;

public class FramedCircle implements Shape 
{
    private Circle c;

    public FramedCircle(Circle c)
    {
	this.c = c;
    }
    public int getX() 
    {
	return c.getX();
    };
    public int getY() 
    {
	return c.getY();
    };
    public void draw(Graphics g)
    {
	c.draw(g);
	g.setColor(Color.black);
	g.drawRect(getX(), getY(), 10, 10);
    }
}
