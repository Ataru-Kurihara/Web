package lesson04.sample8;

import java.awt.*;

public interface Shape
{
    public static final int CIRCLE = 0;
    public static final int RECTANGLE = 1;
    public static final int LINE = 2;

    public int getX();
    public int getY();
    public abstract void draw(Graphics g); 
}
