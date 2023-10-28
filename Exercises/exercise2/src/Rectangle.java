public class Rectangle extends Shape{
    double l, w;
    private String name = "Rectangle";
    public Rectangle(double l, double w){
        this.w=w;
        this.l=l;
    }
    //Override
    public double calculateArea(){
        return l*w;
    }
    //Override
    public double calculatePerimeter(){
        return 2.0*(l+w);
    }
    public void printInfo(){
        System.out.println("Object shape is "+this.name);
        System.out.println("Length is "+l+" and width is "+w);
        System.out.println("Area is "+calculateArea());
        System.out.println("Perimeter is "+calculatePerimeter());
    }
}
