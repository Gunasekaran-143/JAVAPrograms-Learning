class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}

class Quadrilateral {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    
    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }
    
    public double calculateArea() {
        return 0;
    }
    
    public Point getPoint1() {
        return point1;
    }
    
    public Point getPoint2() {
        return point2;
    }
    
    public Point getPoint3() {
        return point3;
    }
    
    public Point getPoint4() {
        return point4;
    }
}

class Trapezoid extends Quadrilateral {
    public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    
    public double calculateArea() {
        double base1 = Math.abs(getPoint1().getX() - getPoint2().getX());
        double base2 = Math.abs(getPoint3().getX() - getPoint4().getX());
        double height = Math.abs(getPoint2().getY() - getPoint4().getY());
        
        return ((base1 + base2) / 2) * height;
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    
    public double calculateArea() {
        double base = Math.abs(getPoint1().getX() - getPoint2().getX());
        double height = Math.abs(getPoint2().getY() - getPoint4().getY());
        
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    
    public double calculateArea() {
        double length = Math.abs(getPoint1().getX() - getPoint2().getX());
        double width = Math.abs(getPoint2().getY() - getPoint4().getY());
        
        return length * width;
    }
}

class Square extends Rectangle {
    public Square(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    
    public double calculateArea() {
        double side = Math.abs(getPoint1().getX() - getPoint2().getX());
        
        return side * side;
    }
}

public class PointMain {
    public static void main(String[] args) {
        Point point1 = new Point(0, 10);
        Point point2 = new Point(10, 5);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(5, 10);
        
        Quadrilateral quadrilateral = new Quadrilateral(point1, point2, point3, point4);
        Trapezoid trapezoid = new Trapezoid(point1, point2, point3, point4);
        Parallelogram parallelogram = new Parallelogram(point1, point2, point3, point4);
        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
        Square square = new Square(point1, point2, point3, point4);
        
        System.out.println("Area of Quadrilateral: " + quadrilateral.calculateArea());
        System.out.println("Area of Trapezoid: " + trapezoid.calculateArea());
        System.out.println("Area of Parallelogram: " + parallelogram.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
        System.out.println("Area of Square: " + square.calculateArea());
    }
}
