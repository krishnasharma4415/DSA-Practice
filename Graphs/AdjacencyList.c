#include <stdio.h>
#include <stdlib.h>

// Node structure for the adjacency list
struct Node
{
    int data;
    struct Node *next;
};

// Graph structure
struct Graph
{
    int numVertices;
    struct Node **adjList;
};

// Function to create a new node
struct Node *createNode(int data)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to initialize a graph
struct Graph *initializeGraph(int numVertices)
{
    struct Graph *graph = (struct Graph *)malloc(sizeof(struct Graph));
    graph->numVertices = numVertices;

    // Create an array of adjacency lists
    graph->adjList = (struct Node **)malloc(numVertices * sizeof(struct Node *));

    // Initialize each adjacency list as empty
    for (int i = 0; i < numVertices; i++)
    {
        graph->adjList[i] = NULL;
    }

    return graph;
}

// Function to add an edge to the graph
void addEdge(struct Graph *graph, int start, int end)
{
    // Add an edge from start to end
    struct Node *newNode = createNode(end);
    newNode->next = graph->adjList[start];
    graph->adjList[start] = newNode;

    // For an undirected graph, add an edge from end to start as well
    newNode = createNode(start);
    newNode->next = graph->adjList[end];
    graph->adjList[end] = newNode;
}

// Function to print the adjacency list of the graph
void printGraph(struct Graph *graph)
{
    printf("Adjacency List:\n");

    for (int i = 0; i < graph->numVertices; i++)
    {
        struct Node *current = graph->adjList[i];
        printf("Vertex %d: ", i);

        while (current != NULL)
        {
            printf("%d ", current->data);
            current = current->next;
        }

        printf("\n");
    }
}

int main()
{
    struct Graph *myGraph;
    int numVertices, numEdges;

    // Input the number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    // Initialize the graph
    myGraph = initializeGraph(numVertices);

    // Input the edges
    printf("Enter the number of edges: ");
    scanf("%d", &numEdges);

    printf("Enter the edges (vertex1 vertex2):\n");
    for (int i = 0; i < numEdges; i++)
    {
        int vertex1, vertex2;
        scanf("%d %d", &vertex1, &vertex2);
        addEdge(myGraph, vertex1, vertex2);
    }

    // Print the graph
    printGraph(myGraph);

    return 0;
}
