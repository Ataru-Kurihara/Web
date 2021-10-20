package lesson05.sample3;

import java.awt.*;

public class Char implements Shape 
{
    private String c = "円";

    private int x;
    private int y;

    public Char(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public int getX() 
    {
	return x;
    };
    public int getY() 
    {
	return y;
    };
    public void draw(Graphics g)
    {
	g.setColor(Color.black);
	g.drawString(c, x, y);
    }
}
