import java.util.Scanner;

public class String_to_Integer 
{
    public int myAtoi(String s) 
    {
        int sign = 1;
        int total = 0;
        boolean signFound = false;
        
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch==' '&& !signFound && total == 0)
                continue;

            if(ch=='-' && !signFound)
            {
                sign = -1;
                signFound = true;
            }
            else if(ch=='+' && !signFound)
            {
                signFound = true;
            }

            else if(ch<'0' || ch>'9')
                break;
            else
            {
                total = total * 10 + (ch - '0');
                signFound = true;
            }
        }
        return total * sign;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to convert to integer: ");
        String input = scanner.nextLine();
        
        String_to_Integer converter = new String_to_Integer();
        int result = converter.myAtoi(input);
        
        System.out.println("Converted integer: " + result);
        scanner.close();
    }
}
