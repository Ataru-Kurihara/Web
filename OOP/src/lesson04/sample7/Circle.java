package lesson04.sample7;

import java.awt.*;

public class Circle extends Shape
{
    public Circle(int x, int y)
    {
	super(x, y);
    }
    public void draw(Graphics g)
    {
	g.drawOval(getX(), getY(), 10, 10);
    }
}
