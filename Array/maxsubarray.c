#include <stdio.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

int maxCrossingSum(int arr[], int low, int mid, int high)
{
    int leftSum = 0 , rightSum = 0 , sum = 0;

    for (int i = mid; i >= low; i--)
    {
        sum += arr[i];
        leftSum = max(leftSum, sum);
    }

    sum = 0;
    for (int i = mid + 1; i <= high; i++)
    {
        sum += arr[i];
        rightSum = max(rightSum, sum);
    }

    return max(leftSum, max(rightSum, leftSum + rightSum));
}

int maxSubArraySum(int arr[], int low, int high)
{
    if (low == high)
    {
        return arr[low];
    }

    int mid = (low + high) / 2;

    int leftSum = maxSubArraySum(arr, low, mid);
    int rightSum = maxSubArraySum(arr, mid + 1, high);
    int crossingSum = maxCrossingSum(arr, low, mid, high);

    return max(leftSum, max(rightSum, crossingSum));
}

int main()
{
    int n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter the elements of the array: ");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    int maxSum = maxSubArraySum(arr, 0, n - 1);
    printf("Maximum subarray sum: %d\n", maxSum);

    return 0;
}
