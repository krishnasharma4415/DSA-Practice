#include<stdio.h>

struct Item
{
  float profit;
  float weight;
  float ratio;
};

int compare(const void *a, const void *b)
{
  struct Item *item1 = (struct Item *)a;
  struct Item *item2 = (struct Item *)b;
}

float fractionalKnapsack(struct Item items[], int n, float capacity)
{
  qsort(items,n,sizeof(struct Item),compare);

}

int main()
{
  int n;
  float capacity;

  printf("Enter the number of items: ");
  scanf("%f",&capacity);

  struct Item items[n];
  printf("Enter weight and profit for each item\n");
  
  float maxProfit = fractionalKnapsack(items,n,capacity);
}