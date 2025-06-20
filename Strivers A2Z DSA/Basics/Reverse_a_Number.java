import java.util.Scanner;
import java.util.*;

public class Reverse_a_Number 
{
    int reverse(int n)
    {
        int rev = 0;
        while(n!=0)
        {
            int digit = n%10;
            rev = rev*10 + digit;
            n = n/10;
        }
        return rev;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        Reverse_a_Number obj = new Reverse_a_Number();
        int rev = obj.reverse(n);
        System.out.println("Reversed Number: " + rev);
    }    
}
