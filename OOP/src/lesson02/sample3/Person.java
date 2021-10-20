package lesson02.sample3;

public class Person
{
    private int age;
    private double weight;
    private double height;

    public Person(int age, double weight, double height)
    {
	this.age = age;
	this.weight = weight;
	this.height = height;
    }
    public void show()
    {
	System.out.println(
			   "年齢は" + age + "体重は" + weight +
			   "身長は" + height + "です。");
    }
}
