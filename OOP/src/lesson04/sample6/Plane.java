package lesson04.sample6;

public class Plane extends Vehicle
{
    private int seat;

    public Plane(int m)
    {
	meter = m;
	price = 200;
	seat = 1000;
    }
    public void calcFare()
    {
	fare = meter * price + seat;
	System.out.println("航空機の運賃は" + fare + "です。");
    }
}
