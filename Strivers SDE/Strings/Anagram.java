import java.util.Scanner;

public class Anagram 
{
    public boolean isAnagram(String s, String t) 
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
        System.out.println("Enter the first string:");
        String s1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String s2 = scanner.nextLine();
        
        Anagram anagram = new Anagram();
        
        if (anagram.isAnagram(s1, s2))
            System.out.println("The strings are anagrams.");
        else
            System.out.println("The strings are not anagrams.");
        
        scanner.close();
    }
}
