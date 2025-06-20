import java.util.Scanner;

public class Armstrong_Numbers
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");    
        int n = sc.nextInt();
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) 
        {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        if(sum==original)
            System.out.println(original + " is an Armstrong number.");
        else
            System.out.println(original + " is not an Armstrong number.");
    }       
}
