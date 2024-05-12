#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 100

int graph[MAX_VERTICES][MAX_VERTICES];
int visited[MAX_VERTICES];

// Queue structure for BFS
struct Queue
{
    int items[MAX_VERTICES];
    int front;
    int rear;
};

// Function to initialize the queue
void initializeQueue(struct Queue *q)
{
    q->front = -1;
    q->rear = -1;
}

// Function to check if the queue is empty
int isEmpty(struct Queue *q)
{
    return q->front == -1;
}

// Function to enqueue an item into the queue
void enqueue(struct Queue *q, int value)
{
    if (q->rear == MAX_VERTICES - 1)
    {
        printf("Queue is full.\n");
    }
    else
    {
        if (q->front == -1)
        {
            q->front = 0;
        }
        q->rear++;
        q->items[q->rear] = value;
    }
}

// Function to dequeue an item from the queue
int dequeue(struct Queue *q)
{
    int item;
    if (isEmpty(q))
    {
        printf("Queue is empty.\n");
        item = -1;
    }
    else
    {
        item = q->items[q->front];
        q->front++;
        if (q->front > q->rear)
        {
            q->front = q->rear = -1;
        }
    }
    return item;
}

// Depth-First Search (DFS)
void dfs(int vertex, int numVertices)
{
    printf("%d ", vertex);
    visited[vertex] = 1;

    for (int i = 0; i < numVertices; i++)
    {
        if (graph[vertex][i] && !visited[i])
        {
            dfs(i, numVertices);
        }
    }
}

// Breadth-First Search (BFS)
void bfs(int start, int numVertices)
{
    struct Queue q;
    initializeQueue(&q);

    printf("%d ", start);
    visited[start] = 1;
    enqueue(&q, start);

    while (!isEmpty(&q))
    {
        int current = dequeue(&q);

        for (int i = 0; i < numVertices; i++)
        {
            if (graph[current][i] && !visited[i])
            {
                printf("%d ", i);
                visited[i] = 1;
                enqueue(&q, i);
            }
        }
    }
}

int main()
{
    int numVertices, numEdges;

    // Input the number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    // Initialize the adjacency matrix
    for (int i = 0; i < numVertices; i++)
    {
        for (int j = 0; j < numVertices; j++)
        {
            graph[i][j] = 0;
        }
        visited[i] = 0;
    }

    // Input the edges
    printf("Enter the number of edges: ");
    scanf("%d", &numEdges);

    printf("Enter the edges (vertex1 vertex2):\n");
    for (int i = 0; i < numEdges; i++)
    {
        int vertex1, vertex2;
        scanf("%d %d", &vertex1, &vertex2);
        graph[vertex1][vertex2] = 1;
        graph[vertex2][vertex1] = 1; // Assuming an undirected graph
    }

    // Perform DFS
    printf("DFS: ");
    for (int i = 0; i < numVertices; i++)
    {
        if (!visited[i])
        {
            dfs(i, numVertices);
        }
    }
    printf("\n");

    // Reset visited array for BFS
    for (int i = 0; i < numVertices; i++)
    {
        visited[i] = 0;
    }

    // Perform BFS
    printf("BFS: ");
    for (int i = 0; i < numVertices; i++)
    {
        if (!visited[i])
        {
            bfs(i, numVertices);
        }
    }
    printf("\n");

    return 0;
}
