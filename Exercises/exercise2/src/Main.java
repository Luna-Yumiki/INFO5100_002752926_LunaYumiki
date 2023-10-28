public class Main {
    public static void main(String[] args) {
        double l = 3.0, w = 4.0;
        double r = 2.0;
        double a = 6.0, b = 8.0, c = 10.0;
        double t = 5.0;

        Shape rectangle = new Rectangle(l,w);
        Shape circle = new Circle(r);
        Shape triangle = new Triangle(a,b,c);
        Shape square = new Square(t);

        rectangle.printInfo();
        circle.printInfo();
        triangle.printInfo();
        square.printInfo();
    }
}