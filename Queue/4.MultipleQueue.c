#include <stdio.h>
#include <malloc.h>

#define MAX_QUEUES 5
#define QUEUE_SIZE 10

int queues[MAX_QUEUES * QUEUE_SIZE]; // Use a single array to store multiple queues
int front[MAX_QUEUES];               // Array to store the front indices for each queue
int rear[MAX_QUEUES];                // Array to store the rear indices for each queue

void push(int queueNum, int val)
{
    int index = queueNum * QUEUE_SIZE + rear[queueNum];
    if (rear[queueNum] < QUEUE_SIZE)
    {
        queues[index] = val;
        rear[queueNum]++;
    }
    else
    {
        printf("\n QUEUE %d OVERFLOW", queueNum);
    }
}

int pop(int queueNum)
{
    int val;
    if (front[queueNum] < rear[queueNum])
    {
        val = queues[queueNum * QUEUE_SIZE + front[queueNum]];
        front[queueNum]++;
        return val;
    }
    else
    {
        printf("\n QUEUE %d UNDERFLOW", queueNum);
        return -1; // or any other appropriate value
    }
}

void display(int queueNum)
{
    if (front[queueNum] < rear[queueNum])
    {
        printf("\n Queue %d Elements: ", queueNum);
        for (int i = front[queueNum]; i < rear[queueNum]; i++)
        {
            printf("%d ", queues[queueNum * QUEUE_SIZE + i]);
        }
    }
    else
    {
        printf("\n Queue %d is Empty", queueNum);
    }
}

int main()
{
    for (int i = 0; i < MAX_QUEUES; i++)
    {
        front[i] = rear[i] = 0; // Initialize front and rear indices for each queue
    }

    int option, queueNum, val;
    do
    {
        printf("\n -----Menu----- ");
        printf("\n Enter 1 to ENQUEUE an element into a QUEUE");
        printf("\n Enter 2 to DEQUEUE an element from a QUEUE");
        printf("\n Enter 3 to display a QUEUE");
        printf("\n Enter 4 to exit");
        printf("\n Enter your choice: ");
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            printf("\n Enter the QUEUE number (0 to %d): ", MAX_QUEUES - 1);
            scanf("%d", &queueNum);
            if (queueNum >= 0 && queueNum < MAX_QUEUES)
            {
                printf("\n Enter a value to ENQUEUE: ");
                scanf("%d", &val);
                push(queueNum, val);
            }
            else
            {
                printf("\n Invalid QUEUE number.");
            }
            break;
        case 2:
            printf("\n Enter the QUEUE number (0 to %d): ", MAX_QUEUES - 1);
            scanf("%d", &queueNum);
            if (queueNum >= 0 && queueNum < MAX_QUEUES)
            {
                val = pop(queueNum);
                if (val != -1)
                {
                    printf("\n Dequeued value from QUEUE %d: %d", queueNum, val);
                }
            }
            else
            {
                printf("\n Invalid QUEUE number.");
            }
            break;
        case 3:
            printf("\n Enter the QUEUE number (0 to %d): ", MAX_QUEUES - 1);
            scanf("%d", &queueNum);
            if (queueNum >= 0 && queueNum < MAX_QUEUES)
            {
                display(queueNum);
            }
            else
            {
                printf("\n Invalid QUEUE number.");
            }
            break;
        }
    } while (option != 4);
    return 0;
}
