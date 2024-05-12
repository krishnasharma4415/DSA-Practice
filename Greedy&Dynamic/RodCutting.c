#include<stdio.h>

int max(int a, int b) {
    return (a > b) ? a : b;
}

int rodCutting(int price[], int n) {
    int i, j;
    int val[n + 1];
    val[0] = 0;

    // Build val[] array
    for (i = 1; i <= n; i++) {
        int max_val = -1;
        for (j = 0; j < i; j++) {
            max_val = max(max_val, price[j] + val[i - j - 1]);
        }
        val[i] = max_val;
    }

    return val[n];
}

int main() {
    int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
    int n = sizeof(price) / sizeof(price[0]);
    printf("Maximum value that can be obtained by cutting the rod is %d\n", rodCutting(price, n));
    return 0;
}
