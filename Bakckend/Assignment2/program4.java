import java.util.*;
import java.util.logging.Logger;
class program4{
    private static final Logger logger = Logger.getLogger(program4.class.getName());
    public static void main(String args[]){
        System.out.println("Program 4 executed");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string of numbers separated by spaces: That can be both integers or floating point numbers");
        String input = scanner.nextLine();
        String[] numberStrings = input.split(" "); 

        List<Number> numbers = new ArrayList<>();
        for(String numStr : numberStrings){
            try{
                int num = Integer.parseInt(numStr);
                numbers.add(num);
            } catch(NumberFormatException e){
                logger.severe("Invalid integer format: " + numStr);
                try{
                    double dnum = Double.parseDouble(numStr);
                    numbers.add(dnum);
                } catch(NumberFormatException ex){
                    logger.severe("Invalid floating point format: " + numStr);
                }
                logger.info("Tried parsing number: The Number format is invalid" + numStr);
            }
        }
        int sumofIntegers = 0;
        double sumofDoubles = 0.0;
        int noOfDoubles = 0;
        for(Number number : numbers){
            if(number instanceof Integer){
                sumofIntegers += number.intValue();
            } else {
                sumofDoubles += number.doubleValue();
                noOfDoubles++;
            }
        }
        double averageOfDoubles = sumofDoubles / noOfDoubles; 

        System.out.println("Sum of integers: " + sumofIntegers);
        System.out.println("Average of floating point numbers: " + averageOfDoubles);

        System.out.println("Valid numbers: " + numbers);
        scanner.close();
    }
}