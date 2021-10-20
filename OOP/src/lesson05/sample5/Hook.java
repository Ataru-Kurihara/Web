package lesson05.sample5;

import java.awt.*;

public class Hook implements Shape
{
    public static final int MIN = 0;
    public static final int MAX = 2;

    static int state = 0;

    private Circle c;

    public Hook(int x, int y)
    {
	if(state == MAX) {
	    state = MIN;
	    c = new Circle(x+20, y+20);
	}
	else {
	    c = new Circle(x, y);
	    state++;
	}
    }
    public int getX() {return c.getX();}
    public int getY() {return c.getY();}
    public void draw(Graphics g)
    {
	c.draw(g);
    }
}
