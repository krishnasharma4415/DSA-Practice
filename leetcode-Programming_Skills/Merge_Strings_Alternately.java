import java.util.Scanner;

public class Merge_Strings_Alternately 
{
    public String mergeAlternately(String word1, String word2) 
    {
        String str = "";
        int count1 = word1.length();
        int count2 = word2.length();
        int i;
        for(i=0;i<Math.min(word1.length(),word2.length());i++)
        {
            str += word1.charAt(i);
            count1--;
            str += word2.charAt(i);
            count2--;
        }    
        while(count1>0)
        {
            str += word1.charAt(i);
            count1--;
            i++;
        }
        while(count2>0)
        {
            str += word2.charAt(i);
            count2--;
            i++;
        }
        return str;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String word1 = sc.nextLine();
        System.out.println("Enter second string:");
        String word2 = sc.nextLine();
        
        Merge_Strings_Alternately obj = new Merge_Strings_Alternately();
        String result = obj.mergeAlternately(word1, word2);
        
        System.out.println("Merged String: " + result);

        sc.close();
    }
}
