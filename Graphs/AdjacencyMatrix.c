#include <stdio.h>
#include <stdlib.h>

#define MAX_VERTICES 100

// Graph structure
struct Graph
{
    int numVertices;
    int adjMatrix[MAX_VERTICES][MAX_VERTICES];
};

// Function to initialize a graph
void initializeGraph(struct Graph *g, int numVertices)
{
    g->numVertices = numVertices;

    // Initialize the adjacency matrix with zeros
    for (int i = 0; i < numVertices; i++)
    {
        for (int j = 0; j < numVertices; j++)
        {
            g->adjMatrix[i][j] = 0;
        }
    }
}

// Function to add an edge to the graph
void addEdge(struct Graph *g, int start, int end)
{
    // Assuming an undirected graph
    g->adjMatrix[start][end] = 1;
    g->adjMatrix[end][start] = 1;
}

// Function to print the adjacency matrix of the graph
void printGraph(struct Graph *g)
{
    printf("Adjacency Matrix:\n");

    for (int i = 0; i < g->numVertices; i++)
    {
        for (int j = 0; j < g->numVertices; j++)
        {
            printf("%d ", g->adjMatrix[i][j]);
        }
        printf("\n");
    }
}

int main()
{
    struct Graph myGraph;
    int numVertices, numEdges;

    // Input the number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    // Initialize the graph
    initializeGraph(&myGraph, numVertices);

    // Input the edges
    printf("Enter the number of edges: ");
    scanf("%d", &numEdges);

    printf("Enter the edges (vertex1 vertex2):\n");
    for (int i = 0; i < numEdges; i++)
    {
        int vertex1, vertex2;
        scanf("%d %d", &vertex1, &vertex2);
        addEdge(&myGraph, vertex1, vertex2);
    }

    // Print the graph
    printGraph(&myGraph);

    return 0;
}
