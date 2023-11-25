public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",";
        String numbersWithoutDelimiter = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = numbers.substring(2, delimiterIndex);
                numbersWithoutDelimiter = numbers.substring(delimiterIndex + 1);
            }
        }

        String[] numbersArray = numbersWithoutDelimiter.split("[," + delimiter + "\n]");

        int sum = 0;
        for (String element : numbersArray) {
            if (!element.trim().isEmpty()) {
                sum += Integer.parseInt(element);
            }
        }
        for(String elements : numbersArray){
            if(elements.trim().isEmpty()){
                throw new IllegalArgumentException("Multiple delimiters not allowed.");
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String numbers = "//[*]\n1,2*3,4\n5";

        try {
            System.out.println("Result: " + new StringCalculator().add(numbers));
        } catch (IllegalArgumentException error) {
            System.err.println("Mistake: " + error.getMessage());
        }
    }
}