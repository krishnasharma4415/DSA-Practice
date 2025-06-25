import java.util.Scanner;

public class Valid_Anagram 
{
    boolean isAnagram(String s, String t) 
    {
        if (s.length() != t.length()) 
            return false;
        
        int[] count = new int[26];
        
        for (int i = 0; i < s.length(); i++) 
        {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int c= 0; c < count.length; c++) 
        {
            if (count[c] != 0) 
                return false;
        }
        
        return true;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s = scanner.nextLine();
        System.out.print("Enter second string: ");
        String t = scanner.nextLine();
        
        Valid_Anagram va = new Valid_Anagram();
        boolean result = va.isAnagram(s, t);
        
        if (result) 
            System.out.println("The strings are anagrams.");
        else 
            System.out.println("The strings are not anagrams.");
        
        scanner.close();
    }
}
