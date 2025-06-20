import java.util.*;

public class Check_Palindrome 
{
    void checkPalindrome(int n)
    {
        int original = n;
        int rev = 0;
        while(n!=0)
        {
            int digit = n%10;
            rev = rev*10+digit;
            n = n/10;
        }
        if(original == rev)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is not a Palindrome");
    }    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        Check_Palindrome obj = new Check_Palindrome();
        obj.checkPalindrome(n);
    }
}
