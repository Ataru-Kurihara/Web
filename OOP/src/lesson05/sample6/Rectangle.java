package lesson05.sample6;

import java.awt.*;

public class Rectangle implements Shape
{
    private int x;
    private int y;
    
    public Rectangle(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public int getX() {return x;};
    public int getY() {return y;};
    public void draw(Graphics g)
    {
	g.setColor(Color.black);
	g.drawRect(getX(), getY(), 10, 10);
    }
}
