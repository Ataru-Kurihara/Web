package lesson05.sample6;

import java.awt.*;

public class ShadeMark extends Mark
{
    public ShadeMark(Shape s)
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
	g.drawOval(getX()+5, getY()+5, 10, 10);
    }
}
