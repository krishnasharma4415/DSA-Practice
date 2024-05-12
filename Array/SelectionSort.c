#include <stdio.h>
#include <stdlib.h>

// Function to swap two integers
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

// Function to perform Selection Sort
void SelectionSort(int A[], int n)
{
    int i, j, min;

    for (i = 0; i < n - 1; i++)
    {
        // Find the index of the minimum element in the unsorted part of the array
        min = i;
        for (j = i; j < n; j++)
        {
            if (A[j] < A[min])
                min = j;
        }
        // Swap the minimum element with the first element in the unsorted part
        swap(&A[i], &A[min]);
    }
}

int main()
{
    int n;
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int A[n];
    printf("Enter the elements of the array\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &A[i]);
    // Call the SelectionSort function to sort the array
    SelectionSort(A, n);
    // Print the sorted array
    for (int i = 0; i < n; i++)
        printf("%d ", A[i]);
    printf("\n");
    return 0;
}