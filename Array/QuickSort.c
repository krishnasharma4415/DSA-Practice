#include <stdio.h>
#include <stdlib.h>

// Function to swap two integers
void swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;
}

// Function to partition the array
int partition(int A[], int l, int h)
{
    int pivot = A[l];
    int i = l, j = h;

    do
    {
        // Move the left pointer to the right until A[i] is greater than the pivot
        do
        {
            i++;
        } while (A[i] <= pivot);

        // Move the right pointer to the left until A[j] is less than or equal to the pivot
        do
        {
            j--;
        } while (A[j] > pivot);

        // If there are elements on the correct side of the pivot, swap them
        if (i < j)
            swap(&A[i], &A[j]);
    } while (i < j);

    // Place the pivot element in its correct position in the sorted array
    swap(&A[l], &A[j]);
    return j;
}

// Function to perform quicksort
void QuickSort(int A[], int l, int h)
{
    int j;

    if (l < h)
    {
        j = partition(A, l, h);
        // Recursively sort the left and right subarrays
        QuickSort(A, l, j);
        QuickSort(A, j + 1, h);
    }
}

int main()
{
    int A[] = {11, 13, 7, 12, 16, 9, 24, 5, 10, 3};
    int n = 10, i;

    QuickSort(A, 0, n - 1);

    // Print the sorted array
    for (i = 0; i < 10; i++)
        printf("%d ", A[i]);
    printf("\n");

    return 0;
}
