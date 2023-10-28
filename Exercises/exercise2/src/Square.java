public class Square extends Shape{
    private double t;
    private String name = "Square";
    public Square(double t){
        this.t = t;
    }
    //Override
    public double calculateArea(){
        return t * t;
    }
    //Override
    public double calculatePerimeter(){
        return 4.0*t;
    }

    public void printInfo(){
        System.out.println("Object shape is "+this.name);
        System.out.println("Side is "+t);
        System.out.println("Area is "+calculateArea());
        System.out.println("Perimeter is "+calculatePerimeter());
    }
}
