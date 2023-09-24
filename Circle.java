class Circle1{
	private double radius;

	Circle1()
	{
		radius = 5;
	}

	Circle1(double r)
	{
		radius = r;
	}

	double getRadius()
	{
		 return radius; 
	}

	double findArea()
	{
		return Math.PI*radius * radius;
	}

}

class Circle{
public static void main(String[] args) {
	Circle1 c1 = new Circle1();
	System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.findArea());
	Circle1 c2 = new Circle1(15);
	System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.findArea());
}
}