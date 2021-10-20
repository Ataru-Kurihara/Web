package lesson05.sample6;

import java.awt.*;

public class FrameMark extends Mark
{
    public FrameMark(Shape s)
    {
	super(s);
    }
    public int getX() 
    {
	return shape.getX();
    }
    public int getY() 
    {
	return shape.getY();
    }
    public void draw(Graphics g)
    {
	shape.draw(g);
	g.setColor(Color.gray);
	g.drawRect(getX(), getY(), 10, 10);
    }
}
