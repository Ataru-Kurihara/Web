package lesson05.sample3;

import java.awt.*;

public class ShadeCircle implements Shape 
{
    private Shape s;

    public ShadeCircle(Shape s)
    {
	this.s = s;
    }
    public int getX() 
    {
	return s.getX();
    };
    public int getY() 
    {
	return s.getY();
    };
    public void draw(Graphics g)
    {
	s.draw(g);
	g.setColor(Color.gray);
	g.drawOval(getX()+5, getY()+5, 10, 10);
    }
}
