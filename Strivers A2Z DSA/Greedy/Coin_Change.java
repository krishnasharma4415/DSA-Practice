public class Coin_Change 
{
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1;j++)
            {
                if(coins[j]<coins[j+1])
                {
                    int temp = coins[j];
                    coins[j] = coins[j+1];
                    coins[j+1] = temp;
                }
            }
        }

        int num = 0;
        int remaining = amount;
        for(int i=0;i<n;i++)
        {
            if(remaining/coins[i] > 0)
            {
                num += remaining/coins[i];
                remaining -= coins[i]*(remaining/coins[i]);
            }
        }

        if (remaining != 0) 
            return -1;
        return num;
    }    
}
