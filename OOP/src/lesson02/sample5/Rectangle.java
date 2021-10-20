package lesson02.sample5;

import java.awt.*;

public class Rectangle
{
    private int x;
    private int y;
    
    public Rectangle(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public void draw(Graphics g)
    {
	g.drawRect(x, y, 10, 10);
    }
}
