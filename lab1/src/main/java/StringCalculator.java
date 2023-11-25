import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {
            int delimiterStart = numbers.indexOf("[");
            int delimiterEnd = numbers.indexOf("]");
            if (delimiterStart != -1 && delimiterEnd != -1) {
                delimiter = numbers.substring(delimiterStart + 1, delimiterEnd);
                numbersWithoutDelimiter = numbers.substring(numbers.indexOf("\n") + 1);
            }
        }

        String[] numbersArray = numbersWithoutDelimiter.split("\\Q" + delimiter + "\\E|,|\n");

        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String element : numbersArray) {
            if(element.trim().isEmpty()) {
                throw new IllegalArgumentException("Multiple delimiters not allowed.");
            }
            if (!element.trim().isEmpty()) {
                int num = Integer.parseInt(element);

                if (num < 0) {
                    negativeNumbers.add(num);
                }
                if(num > 1000){
                    continue;
                }
                sum += num;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed. \nNegative numbers: " + negativeNumbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        String numbers = "//[***]\n1***2,3***4\n5";

        try {
            System.out.println("Result: " + new StringCalculator().add(numbers));
        } catch (IllegalArgumentException error) {
            System.err.println("Mistake: " + error.getMessage());
        }
    }
}