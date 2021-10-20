package lesson04.sample4;

import java.awt.*;

public class Line extends Shape
{
    public Line(int x, int y)
    {
	super(x, y);
    }
    public void draw(Graphics g)
    {
	g.drawLine(getX(), getY(), getX()+10, getY()+10);
    }
}
