package lesson04.sample5;

public class RacingCar extends Car
{
    private int raceID;

    public RacingCar(int num, int id)
    {
	super(num);
	raceID = id;
    }
    public void show()
    {
	super.show();
	System.out.println("競技IDは" + raceID + "です。");
    }
}
