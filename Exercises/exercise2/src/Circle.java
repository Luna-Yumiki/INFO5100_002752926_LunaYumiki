public class Circle extends Shape{
    private double r;
    private String name = "Circle";
    public Circle(double r){
        this.r=r;
    }
    //Override
    public double calculateArea(){
        return Math.PI * r * r;
    }
    //Override
    public double calculatePerimeter(){
        return 2.0*Math.PI*r;
    }
    public void printInfo(){
        System.out.println("Object shape is "+this.name);
        System.out.println("Radius is "+r);
        System.out.println("Area is "+calculateArea());
        System.out.println("Perimeter is "+calculatePerimeter());
    }
}
