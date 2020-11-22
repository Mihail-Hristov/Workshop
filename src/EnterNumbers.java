import java.util.Scanner;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = 0;
        int endNumber = 0;

        boolean theNumbersAreValid = false;

        while (!theNumbersAreValid) {

            try {
                startNumber = readSingleIntegerNumber(scanner);
                validateNumber(startNumber);
                endNumber = readSingleIntegerNumber(scanner);
                validateNumber(endNumber);
                theNumbersAreValid = true;
            } catch (NumberOutOfRangeException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }

        printNumbers(startNumber, endNumber);

    }


    public static int readSingleIntegerNumber (Scanner scanner) {
        int number = 0;

        try {
            number = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException ex) {
            throw new NumberFormatException("You must entry only integer number");
        }
        return number;
    }

    public static void printNumbers (int startNumber, int endNumber) {
        for (int i = startNumber; i <= endNumber; i++) {
            System.out.println(i);
        }
    }

    public static void validateNumber (int number) throws NumberOutOfRangeException {
        if (number < 0 || number > 100) {
            throw new NumberOutOfRangeException("The number must be in the range [1...100]");
        }
    }

}
