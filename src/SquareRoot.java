import java.text.ParseException;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = readIntegerNumber(scanner);
            int square = calculateSyareRoot(number);
            System.out.println(square);
        }catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Good bye");
        }


    }

    public static int readIntegerNumber(Scanner scanner) {
        int number = 0;

        try {
            number = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex) {
            throw new NumberFormatException("Invalid number");
        }

        return number;
    }

    public static int calculateSyareRoot(int number) {
        return number * number;
    }

}
