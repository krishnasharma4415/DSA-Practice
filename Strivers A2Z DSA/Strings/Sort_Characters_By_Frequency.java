import java.util.Scanner;

public class Sort_Characters_By_Frequency 
{
    public String frequencySort(String s) 
    {
        int count[] = new int[256];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)]++;

        String result = "";
        while(true) 
        {
            int maxCount = 0;
            char maxChar = 0;

            for(int i=0;i<256;i++) 
            {
                if(count[i] > maxCount) 
                {
                    maxCount = count[i];
                    maxChar = (char)i;
                }
            }

            if(maxCount == 0) 
                break;

            for(int i=0;i<maxCount;i++) 
                result += maxChar;

            count[maxChar] = 0;
        }
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        Sort_Characters_By_Frequency sorter = new Sort_Characters_By_Frequency();
        String sortedString = sorter.frequencySort(input);
        
        System.out.println("Sorted by frequency: " + sortedString);
        scanner.close();
    }
}