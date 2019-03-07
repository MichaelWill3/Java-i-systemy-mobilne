import java.util.Scanner;
public class Rectangle extends Figure implements Print {
    double perimeter = 0;
    double area = 0;
    Scanner input = new Scanner(System.in);
    public void print()
    {
        System.out.println("POLE: " + this.area);
        System.out.println("OBWÓD: " + this.perimeter);
    }

    @Override
    double calculateArea() {
        System.out.println("PODAJ DŁUGOŚĆ PIERWSZEGO BOKU PROSTOKĄTA");
        double side1 = input.nextDouble();
        System.out.println("PODAJ DŁUGOŚĆ DRUGIEGO BOKU PROSTOKĄTA");
        double side2 = input.nextDouble();
        this.area = side1*side2;
        return this.area;
    }

    @Override
    double calculatePerimeter() {
        System.out.println("PODAJ DŁUGOŚĆ PIERWSZEGO BOKU PROSTOKĄTA");
        double side1 = input.nextDouble();
        System.out.println("PODAJ DŁUGOŚĆ DRUGIEGO BOKU PROSTOKĄTA");
        double side2 = input.nextDouble();
        this.perimeter = 2*(side1 + side2);
        return this.perimeter;
    }
}
