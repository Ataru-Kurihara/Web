package lesson04.sample3;

import java.awt.*;

public class Rectangle extends Shape
{
    public Rectangle(int x, int y)
    {
	super(x, y);
    }
    public void draw(Graphics g)
    {
	g.drawRect(getX(), getY(), 10, 10);
    }
}
