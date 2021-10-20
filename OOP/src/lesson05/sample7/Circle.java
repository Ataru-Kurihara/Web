package lesson05.sample7;

import java.awt.*;

public class Circle
{
    private int x;
    private int y;
    
    public Circle(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public void draw(Graphics g)
    {
	g.drawOval(x, y, 10, 10);
    }
}
