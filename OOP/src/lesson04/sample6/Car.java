package lesson04.sample6;

public class Car extends Vehicle
{
    public Car(int m)
    {
	meter = m;
	price = 100;
    }
    public void calcFare()
    {
	fare = meter * price;
	System.out.println("車両の運賃は" + fare + "です。");
    }
}
