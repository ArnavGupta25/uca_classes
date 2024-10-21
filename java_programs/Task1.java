// Interface for shapes
interface Shape {
    double Area();
    int NumberOfSides();
    String ShapeName();
}

//circle
class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double Area() {
        return Math.PI * radius * radius;
    }

    public int NumberOfSides() {
        return 0; 
    }

    public String ShapeName(){
        return "Circle";
    }
}

//Quadilateral
abstract class Quadrilateral implements Shape {


    public int NumberOfSides() {
        return 4; 
    }

    public String ShapeName() {
        return "Quadilateral";
    }

    public abstract double Area();

}

//Rectangle
class Rectangle extends Quadrilateral {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double Area() {
        return length * width;
    }

    public String ShapeName() {
        return "Rectangle";
    }
}

//Square
// class Square extends Quadrilateral {
//     double side;

//     Square(double side) {
//         this.side = side;
//     }

//     public double Area() {
//         return side * side;
//     }

//     public String ShapeName() {
//         return "Square";
//     }
// }

class Square extends Rectangle {
    double side;

    Square(double side) {
        super(side, side);
        this.side = side;
    }

    public String ShapeName() {
        return "Square";
    }
}


public class Task1 {
    public static void main(String[] args) {
        Shape shape = new Rectangle(4.0, 6.0);
        System.out.println(shape.ShapeName() + " area: " + shape.Area() + ", Sides: " + shape.NumberOfSides());
        Shape shape2 = new Square(4.0);
        System.out.println(shape2.ShapeName() + " area: " + shape2.Area() + ", Sides: " + shape2.NumberOfSides());
        Shape shape3 = new Circle(5.0);
        System.out.println(shape3.ShapeName() + " area: " + shape3.Area() + ", Sides: " + shape3.NumberOfSides());
    }
}
