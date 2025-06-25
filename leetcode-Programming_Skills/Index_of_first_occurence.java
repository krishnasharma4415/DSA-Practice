import java.util.Scanner;

public class Index_of_first_occurence 
{
    public int strStr(String haystack, String needle) 
    {   
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        if (needleLength > haystackLength) 
            return -1;
        
        for (int i = 0; i <= haystackLength - needleLength; i++) 
        {
            if (haystack.substring(i, i + needleLength).equals(needle)) 
                return i;
        }
        
        return -1;
    }   
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the haystack string:");
        String haystack = sc.nextLine();
        System.out.println("Enter the needle string:");
        String needle = sc.nextLine();
        
        Index_of_first_occurence obj = new Index_of_first_occurence();
        int result = obj.strStr(haystack, needle);
        
        if (result != -1)
            System.out.println("The first occurrence of '" + needle + "' in '" + haystack + "' is at index: " + result);
        else
            System.out.println("The string '" + needle + "' is not found in '" + haystack + "'.");
        
        sc.close();
    }
}
