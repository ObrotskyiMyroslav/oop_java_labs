public class StringCalculator {
    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        }
        String[] numbers_array = numbers.split(",");
        for(String elements : numbers_array){
            if(elements.trim().isEmpty()){
                throw new IllegalArgumentException("Multiple delimiters not allowed.");
            }
        }
        if(numbers_array.length > 2){
            throw new IllegalArgumentException("Must be 2 or less numbers.");
        }
        int summury = 0;
        for (int i = 0; i < numbers_array.length; i++) {
            summury += Integer.parseInt(numbers_array[i]);
        }
        return summury;

    }
    public static void main (String[]args){
        String numbers = "1,2";
        try {
            System.out.println("The summury is: " + new StringCalculator().add(numbers));
        }catch(IllegalArgumentException error){
            System.err.println("Mistake: " + error.getMessage());

        }

    }
}