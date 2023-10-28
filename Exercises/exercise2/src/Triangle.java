public class Triangle extends Shape{
    private double a,b,c;

    private String name = "Triangle";

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //Override
    public double calculateArea(){
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    //Override
    public double calculatePerimeter(){
        return a+b+c;
    }

    public void printInfo(){
        System.out.println("Object shape is "+this.name);
        System.out.println("Sides are "+a+" "+b+" "+c);
        System.out.println("Area is "+calculateArea());
        System.out.println("Perimeter is "+calculatePerimeter());
    }
}
