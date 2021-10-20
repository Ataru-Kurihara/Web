package lesson02.sample2;

public class Car
{
    private int number;
    private double gas;
    
    public Car(int num, double g)
    {
	number = num;
	gas = g;
    }
    public void show()
    {
	System.out.println("ナンバーは" + number + "ガソリン量は" + gas + "です。");
    }
}
