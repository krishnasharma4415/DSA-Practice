import java.util.Arrays;
import java.util.Scanner;

/* 
Input: intervals = [[1,3],
                    [2,6],
                    [8,10],
                    [15,18]]
Output: [[1,6],
        [8,10],
        [15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6]. 
*/

class Merge_Intervals
{
    int[][] merge(int intervals[][])
    {
        int n = intervals.length;
        int[][] merged = new int[n][2];
        int index = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        merged[index][0] = intervals[0][0];
        merged[index][1] = intervals[0][1];

        for(int i = 1; i < n; i++)
        {
            if(intervals[i][0] <= merged[index][1]) 
            {
                merged[index][1] = Math.max(merged[index][1], intervals[i][1]);
            }
            else
            {
                index++;
                merged[index][0] = intervals[i][0];
                merged[index][1] = intervals[i][1];
            }
        }

        int result[][] = new int[index + 1][2];
        for(int i = 0; i <= index; i++)
        {
            result[i][0] = merged[i][0];
            result[i][1] = merged[i][1];
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of intervals:");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        
        System.out.println("Enter the intervals:");
        for(int i=0; i<n; i++)
        {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        
        Merge_Intervals mi = new Merge_Intervals();
        int[][] mergedIntervals = mi.merge(intervals);
        
        System.out.println("Merged Intervals:");
        for(int[] interval : mergedIntervals)
        {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        
        sc.close();
    }
}