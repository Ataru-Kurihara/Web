package lesson04.sample8;

import java.awt.*;

public class Line implements Shape
{
    private int x;
    private int y;

    public Line(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public void draw(Graphics g)
    {
	g.drawLine(getX(), getY(), getX()+10, getY()+10);
    }
}
