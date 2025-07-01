import java.util.Scanner;

public class Reverse_Words_in_String 
{
    public static String reverseWords(String s)
    {
        String words[] = s.trim().split("\\s+");
        String rev = "";
        for (int i = words.length - 1; i >= 0; i--) 
        {
            rev += words[i];
            if (i > 0) 
                rev += " ";
        }
        return rev;
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        String reversed = reverseWords(input);
        System.out.println("Reversed words: " + reversed);
        
        scanner.close();
    }    
}
