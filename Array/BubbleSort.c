#include <stdio.h>
#include <stdlib.h>

// Function to swap two integers
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

// Function to perform Bubble Sort
void Bubble(int A[], int n)
{
    int flag = 0;

    // Outer loop for the number of passes
    for (int i = 0; i < n - 1; i++)
    {
        flag = 0;

        // Inner loop for each pass
        for (int j = 0; j < n - i - 1; j++)
        {
            // Compare adjacent elements and swap them if they are in the wrong order
            if (A[j] > A[j + 1])
            {
                swap(&A[j], &A[j + 1]);
                flag = 1;
            }
        }

        // If no two elements were swapped in the inner loop, the array is already sorted
        if (flag == 0)
            break;
    }
}

int main()
{
    int n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int A[n];
    printf("Enter the elements of the array:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i);

    // Call Bubble Sort to sort the array
    Bubble(A, n);

    printf("Sorted array:\n");
    for (int i = 0; i < n; i++)
        printf("%d ", A[i]);
    printf("\n");

    return 0;z
}
