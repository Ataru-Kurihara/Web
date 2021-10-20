package lesson05.sample6;

import java.awt.*;

public interface Shape
{
    public static final int CIRCLE = 0;
    public static final int RECTANGLE = 1;

    public int getX();
    public int getY();
    public void draw(Graphics g);
}
