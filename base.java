
import java.util.*;
public class base{
    //  Access specifier , datatype , Name(parameters){}
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int age=sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        int [] nums= new int[age];
        for(int i=0;i<age;i++){
            nums[i]=sc.nextInt();
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(230);
        lis.add(340);
        System.out.println(lis);     
        System.out.println("Name of the user is: " +name+ " and the age of the user is: "+age);
        sc.close();
    }
}