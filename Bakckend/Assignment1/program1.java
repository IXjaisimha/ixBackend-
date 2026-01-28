package Assignment1;
import java.util.*;

public class program1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        if(n>0){
            if(n%2==0){
                System.out.println("The number is positive and even.");
            } else {
                System.out.println("The number is positive and odd.");

        }
    }
        else if(n<0){
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
        
        scanner.close();
    }
}
