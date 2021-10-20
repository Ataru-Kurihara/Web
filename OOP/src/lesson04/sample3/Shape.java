package lesson04.sample3;

import java.awt.*;

public class Shape
{
    public static final int CIRCLE = 0;
    public static final int RECTANGLE = 1;

    private int x;
    private int y;

    public Shape(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public void draw(Graphics g) { }
}
