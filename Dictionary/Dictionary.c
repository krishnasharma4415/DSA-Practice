#include <stdio.h>
#include <string.h>
#define MAX_SIZE 100        // Maximum number of elements in the map
int size = 0;               // Current number of elements in the map
char keys[MAX_SIZE][100];   // Array to store the keys
char values[MAX_SIZE][100]; // Array to store the values
// Function to get the index of a key in the keys array
int getIndex(char key[])
{
    for (int i = 0; i < size; i++)
    {
        if (strcmp(keys[i], key) == 0)
        {
            return i;
        }
    }
    return -1; // Key not found
}
// Function to insert a key-value pair into the map
void insert(char key[], char value[])
{
    int index = getIndex(key);
    if (index == -1)
    { // Key not found
        strcpy(keys[size], key);
        strcpy(values[size], value);
        size++;
    }
    else
    { // Key found
        strcpy(values[index], value);
    }
}
// Function to get the value of a key in the map
char *get(char key[])
{
    int index = getIndex(key);
    if (index == -1)
    {
        return NULL;
    }
    else
    {
        return values[index];
    }
}
// Function to print the map
void printMap()
{
    for (int i = 0; i < size; i++)
    {
        printf("%s %s\n", keys[i], values[i]);
    }
}
int main()
{
    insert("Krishna", "Sharma");
    insert("Sashwat", "Mishra");
    insert("Mahekpreet", "Singh");
    insert("Dhiru", "Bhati");
    printf("Value of complete Map: \n");
    printMap();
    return 0;
}