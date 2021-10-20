package lesson04.sample7;

import java.awt.*;

public abstract class Shape
{
    public static final int CIRCLE = 0;
    public static final int RECTANGLE = 1;
    public static final int LINE = 2;

    private int x;
    private int y;

    public Shape(int x, int y)
    {
	this.x = x;
	this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public abstract void draw(Graphics g); 
}
