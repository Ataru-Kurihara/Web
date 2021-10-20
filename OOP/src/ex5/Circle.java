package ex5;

import java.awt.Color;
import java.awt.Graphics;

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
	g.setColor(Color.black);
	g.drawOval(x, y, 10, 10);
    }
}