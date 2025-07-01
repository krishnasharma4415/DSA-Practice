import java.util.Scanner;

public class Largest_Odd_Number_in_String 
{
    public static String largestOddNumber(String num)
    {
        for(int i = num.length() - 1; i >= 0; i--)
        {
            char ch = num.charAt(i);
            int digit = ch - '0';
            
            if(digit >= 0 && digit <= 9 && digit % 2 == 1)
                return num.substring(0, i + 1);
        }
        return "";
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        String largestOddNumber = largestOddNumber(input);
        if (largestOddNumber.isEmpty()) {
            System.out.println("No odd number found in the string.");
        } else {
            System.out.println("Largest odd number: " + largestOddNumber);
        }
        
        scanner.close();
    }       
}
