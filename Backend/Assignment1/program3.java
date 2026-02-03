package Assignment1;
import java.util.*;

public class program3 {
    public int add(int a, int b) {
        return a + b;
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int isEven(int n){
        return n%2==0 ? 1 : 0;
    }

    public static void main(String[] args) {
        
        program3 obj = new program3();
        Scanner sc = new Scanner(System.in);
        System.out.println("==============================");
        System.out.print("Enter first number to add: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number to add: ");
        int num2 = sc.nextInt();
        int sum = obj.add(num1, num2);
        System.out.println("Sum: " + sum);
        System.out.println("==============================");
        System.out.print("Enter a number to find factorial: ");
        int factNum = sc.nextInt();
        int factResult = obj.factorial(factNum);
        System.out.println("Factorial of " + factNum + " is: " + factResult);
        System.out.println("==============================");
        System.out.print("Enter a number to check if it's even or odd: ");
        int evenOddNum = sc.nextInt();
        if(obj.isEven(evenOddNum) == 1){
            System.out.println(evenOddNum + " is even.");
        } else {
            System.out.println(evenOddNum + " is odd.");
        }

        sc.close();

    }
}
