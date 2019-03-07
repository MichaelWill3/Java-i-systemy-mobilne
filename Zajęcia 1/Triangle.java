import java.util.Scanner;
public class Triangle extends Figure implements Print {
    Scanner input = new Scanner(System.in);
    public void print()
    {
        System.out.println("POLE: " + this.area);
        System.out.println("OBWÓD: " + this.perimeter);
    }

    @Override
    double calculateArea()
    {

        System.out.println("PODAJ DŁUGOŚĆ BAZY TRÓJKĄTA");
        double base = input.nextInt();
        System.out.println("PODAJ WYSOKOŚĆ TRÓJKĄTA");
        double height = input.nextInt();
        this.area = base*height/2;
        return this.area;
    }

    @Override
    double calculatePerimeter()
    {
        System.out.println("PODAJ DŁUGOŚĆ PIERWSZEGO BOKU TRÓJKĄTA");
        double side1 = input.nextInt();
        System.out.println("PODAJ DŁUGOŚĆ DRUGIEGO BOKU TRÓJKĄTA");
        int side2 = input.nextInt();
        System.out.println("PODAJ DŁUGOŚĆ TRZECIEGO BOKU TRÓJKĄTA");
        double side3 = input.nextInt();
        this.perimeter = side1 + side2 + side3;
        return this.perimeter;
    }
}
