import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        //Create objects
        double l = 3.0, w = 4.0;
        double r = 2.0;
        double a = 6.0, b = 8.0, c = 10.0;
        double t = 5.0;

        Circle circle = new Circle(r);
        Rectangle rectangle = new Rectangle(l,w);
        Triangle triangle = new Triangle(a,b,c);
        Square square = new Square(t);

        //Test serialization
        System.out.println("-------serialization test--------");
        try {
            FileOutputStream fileOut = new FileOutputStream("circle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(circle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/circle.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("rectangle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rectangle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/rectangle.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("triangle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/triangle.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        try {
            FileOutputStream fileOut = new FileOutputStream("square.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(square);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/square.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }


        //Test deserialization
        System.out.println("-------deserialization test--------");
        Circle circle2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("circle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            circle2 = (Circle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException cc) {
            System.out.println("circle2 class not found");
            cc.printStackTrace();
            return;
        }
        System.out.println("Deserialized circle...");
        circle2.printInfo();

        Rectangle rectangle2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("rectangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            rectangle2 = (Rectangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException cc) {
            System.out.println("rectangle2 class not found");
            cc.printStackTrace();
            return;
        }
        System.out.println("Deserialized rectangle...");
        rectangle2.printInfo();

        Triangle triangle2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("triangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            triangle2 = (Triangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException cc) {
            System.out.println("triangle2 class not found");
            cc.printStackTrace();
            return;
        }
        System.out.println("Deserialized triangle...");
        triangle2.printInfo();

        Square square2= null;
        try {
            FileInputStream fileIn = new FileInputStream("square.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            square2 = (Square) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException cc) {
            System.out.println("square2 class not found");
            cc.printStackTrace();
            return;
        }
        System.out.println("Deserialized square...");
        square2.printInfo();
    }

}