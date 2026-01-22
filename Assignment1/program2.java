package Assignment1;
import java.util.*;
public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value N");

        int N = sc.nextInt();
        
        int sum = N * ( N +1 ) /2; 

        System.out.println("Natural numbers from 0 to N are:");
        for(int i=0;i<=N;i++){
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("Even numbers from 0 to N are:");
        for(int i=0;i<=N;i = i+2){
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("The sum of first N natural numbers is: " + sum);

        sc.close();
    }
}
