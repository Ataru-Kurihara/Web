package lesson02.sample1;

public class Circle
{
    private int x;
    private int y;

    public Circle(int x, int y)
    {
	System.out.println("円を作成しました。");
	this.x = x;
	this.y = y;
    }

    public void show()
    {
	System.out.println("円を(" + x + "," + y + ")に表示します。");
    }
}

