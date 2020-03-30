import java.util.ArrayList;
import java.util.List;

public class StringCalc {


    public static void main(String[] args)throws RuntimeException{
        String numbers="1\n2,3";


        System.out.println("your sum is: "+add((numbers)));

    }
    public static int add(final String numbers) {
        String delimiter = ",|n";

        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {

            int delimiterIndex = numbers.indexOf("//") + 2;

            delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);

            numbersWithoutDelimiter = numbers.substring(numbers.indexOf("n") + 1);
        }
        return add(numbersWithoutDelimiter, delimiter);
    }


    private static int add(final String numbers, final String delimiter) {
        int sum = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negNumbers = new ArrayList();

        for (String number : numbersArray) {

            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());

                if (numberInt < 0)
                {
                    negNumbers.add(numberInt);
                }
                else if (numberInt < 1001)
                {
                    sum += numberInt;
                }

            }
        }
        if (negNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negNumbers.toString());
        }
        return sum;
    }
}


