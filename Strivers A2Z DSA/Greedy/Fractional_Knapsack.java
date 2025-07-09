import java.util.Scanner;

public class Fractional_Knapsack
{
    static double fractionalKnapsack(int W, int weight[], int value[], int n)
    {
        int item[] = new int[n];
        double ratio[] = new double[n];   
        for(int i=0;i<n;i++)
        {
            ratio[i] = (double)value[i]/weight[i];
            item[i] = i;
        }

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(ratio[j]<ratio[j+1])
                {
                    double temp = ratio[j];
                    ratio[j] = ratio[j+1];
                    ratio[j+1] = temp;

                    int t = item[j];
                    item[j] = item[j+1];
                    item[j+1] = t;
                }
            }
        }

        double maxValue = 0.0;
        int remaining = W;
        for(int i=0;i<n;i++)
        {
            if(weight[item[i]]<=remaining)
            {
                maxValue += value[item[i]];
                remaining -= weight[item[i]];
            }
            else
            {
                maxValue += remaining*ratio[i];
                break;
            }
        }

        return maxValue;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        System.out.println("Enter the weights:");
        int weight[] = new int[n];
        for(int i=0;i<n;i++)
            weight[i] = sc.nextInt();

        System.out.println("Enter the value:");
        int value[] = new int[n];
        for(int i=0;i<n;i++)
            value[i] = sc.nextInt();

        double result = fractionalKnapsack(W, weight, value, n);
        System.out.println("Maximum Value: "+result);

        sc.close();
    }
}