import java.io.Serializable;

abstract class Shape implements Serializable {
    private static String color = "black";
    private static String name = "shape";
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void printInfo();


}
