import java.util.Scanner;
public class main {
    public static void main(String []args) {
        boolean run = true;
        Triangle triangle = new Triangle();
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        while (run) {
            System.out.println("TO JEST PROGRAM DO OBLICZANIA PÓL LUB OBWODÓW TRÓJKĄTÓW, KÓŁ I PROSTOKĄTÓW");
            System.out.println("1. TRÓJKĄT");
            System.out.println("2. PROSTOKĄT");
            System.out.println("3. KOŁO");
            System.out.println("4. WYJDŹ");
            Scanner input = new Scanner(System.in);
            int figure_menu_handler = input.nextInt();
            if(figure_menu_handler != 4){
                System.out.println("1. POLE");
                System.out.println("2. OBWÓD");
                System.out.println("3. WYŚWIETLENIE WYNIKÓW");
                int action_menu_handler = input.nextInt();

                switch (figure_menu_handler) {
                    case 1://trójkąt
                        switch (action_menu_handler) {
                            case 1://pole
                                triangle.calculateArea();
                                break;
                            case 2://obwód
                                triangle.calculatePerimeter();
                                break;
                            case 3:
                                triangle.print();
                        }
                        break;
                    case 2://prostokąt
                        switch (action_menu_handler) {
                            case 1://pole
                                rectangle.calculateArea();
                                break;
                            case 2://obwód
                                rectangle.calculatePerimeter();
                                break;
                            case 3:
                                rectangle.print();
                        }
                        break;
                    case 3://koło
                        switch (action_menu_handler) {
                            case 1://pole
                                circle.calculateArea();
                                break;
                            case 2://obwód
                                circle.calculatePerimeter();
                                break;
                            case 3:
                                circle.print();
                        }
                        break;
                    default:
                        break;

                }
            }
            else
            {
                run = false;
            }
        }
    }
}
