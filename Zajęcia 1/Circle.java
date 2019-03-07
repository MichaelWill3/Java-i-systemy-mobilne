import java.util.Scanner;
public class Circle extends Figure implements Print {
    double perimeter = 0;
    double area = 0;
    Scanner input = new Scanner(System.in);
    public void print()
    {
        System.out.println("POLE: " + this.area);
        System.out.println("OBWÓD: " + this.perimeter);
    }

    @Override
    double calculateArea()
    {
        System.out.println("PODAJ PROMIEŃ KOŁA");
        double radius = input.nextDouble();
        this.area = Math.PI*radius*radius;
        return this.area;
    }

    @Override
    double calculatePerimeter()
    {
        System.out.println("PODAJ PROMIEŃ KOŁA");
        double radius = input.nextDouble();
        this.perimeter = 2*Math.PI*radius;
        return this.perimeter;
    }
}
