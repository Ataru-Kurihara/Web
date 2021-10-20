package lesson04.sample2;

import java.awt.*;

public class FilledCircle extends Circle
{
    public FilledCircle(int x, int y)
    {
	super(x, y);
    }
    public void draw(Graphics g) // このメソッドを上書き
    {
	g.fillOval(getX(), getY(), 10, 10); // 塗りつぶし●を描く
    }
}
