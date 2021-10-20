package lesson05.sample1;

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
    public int getX() {return x;};
    public int getY() {return y;};
    public void draw(Graphics g)
    {
	g.setColor(Color.black);
	g.drawOval(x, y, 10, 10);
    }
}
