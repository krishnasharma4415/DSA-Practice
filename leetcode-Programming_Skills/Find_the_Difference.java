import java.util.Scanner;

public class Find_the_Difference
{
    public char findTheDifference(String s, String t) 
    {
        int[] charCount = new int[26];
        
        for (char c : s.toCharArray()) 
            charCount[c - 'a']++;
        
        for (char c : t.toCharArray()) 
        {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) 
                return c;
        }
        
        return ' '; 
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = scanner.nextLine();
        System.out.print("Enter string t: ");
        String t = scanner.nextLine();
        
        Find_the_Difference finder = new Find_the_Difference();
        char result = finder.findTheDifference(s, t);
        
        System.out.println("The added character is: " + result);
        
        scanner.close();
    }
}