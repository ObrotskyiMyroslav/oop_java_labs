import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringCalculator {

    public int add ( String numbers ) {
        if ( ! numbers.isEmpty ( ) && !(numbers == null)) {
            Matcher matcher;
            if ( numbers.startsWith ( "//[" ) ) {
                Pattern delimiter_standart = Pattern.compile ( "^(//(.|(\\[[^\\]]+\\])+)\\n)?(.|\\s)+$" );
                matcher = delimiter_standart.matcher ( numbers );
                matcher.matches ();
                if ( matcher.group ( 1 ) == null ) {
                    throw new IllegalArgumentException ( "Some unexpected error with delimiters" );
                }
                else{
                    numbers = custom_delim ( numbers );}
            }

            if ( numbers.startsWith ( "//" ) ) {

                matcher = Pattern.compile ( "//(.+)\\n(.+)" ).matcher ( numbers );
                if ( matcher.find ( ) ) {
                    int customDelimiterStart = numbers.lastIndexOf ( '/' ) + 1;
                    int end = numbers.indexOf ( '\n' );
                    String customDelimiter = numbers.substring ( customDelimiterStart , end );
                    numbers = numbers.substring ( end + 1 ).replace ( customDelimiter , "," );
                } else if ( !matcher.find ( ) ) {
                    //
                }
            }

            numbers = numbers.replace ( '\n' , ',' );

            if ( numbers.startsWith ( "," ) && numbers.endsWith ( "," ) ) {
                throw new IllegalArgumentException  ( "String starts or ends with delimiter" );
            }
            if ( numbers.contains ( ",," ) ) {
                throw new IllegalArgumentException  ( "Multiple delimiters not allowed." );
            }
            if ( numbers.contains ( ",\n" ) ) {
                throw new IllegalArgumentException  ( "Multiple delimiters not allowed." );
            }
            if ( numbers.contains ( "\n\n" ) ) {
                throw new IllegalArgumentException  ( "Multiple delimiters not allowed." );
            }
            if ( numbers.contains ( "\n," ) ) {
                throw new IllegalArgumentException  ( "Multiple delimiters not allowed." );
            }
            String[] nums = numbers.split ( "," );

            if ( ! numbers.matches ( "^(-?\\d+,?)+$" ) ) {
                throw new IllegalStateException ( "String has incorrect delimiter" );
            } else {
                int sum;
                List < Integer > negativeNumbers = new ArrayList <> ( );
                sum = 0;
                for ( String number : nums ) {
                    try {
                        int num = Integer.parseInt ( number );
                        if ( num < 0 ) {
                            negativeNumbers.add ( num );
                        }

                        if ( num <= 1000 ) {
                            sum += num;
                        }
                    } catch ( NumberFormatException e ) {
                        //Handle non-integer tokens
                    }
                }

                if ( ! negativeNumbers.isEmpty ( ) ) {
                    throw new IllegalArgumentException ( "Negatives not allowed: " + negativeNumbers );
                } else {
                    return sum;
                }

            }
        } else {
            return 0;
        }

    }
    public String custom_delim(String numbers) {

        Set<String> custom = new TreeSet<>(Comparator.reverseOrder());
        int delimiterEndIndex = numbers.indexOf("]\n");
        String[] delimiters = numbers.substring(3, delimiterEndIndex).split("]\\[");

        for (String delimiter : delimiters) {
            if (!delimiter.isEmpty()) {
                custom.add(delimiter);
            }
        }
        numbers = numbers.substring(delimiterEndIndex+ 2);
        custom.add("\n");
        for (String delimiter : custom) {
            numbers = numbers.replace(delimiter, ",");
        }

        return numbers;
    }


    public static void main ( String[] args ) {
        StringCalculator adder = new StringCalculator();
        try {
            System.out.println("Te summury is: " + adder.add("//[ab][abab]\n1ab2abab5ab6"));

        }catch(IllegalArgumentException error){
            System.err.println("Mistake: " + error.getMessage());
        }
    }
}