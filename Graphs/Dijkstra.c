#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define V 100

// Function to find the vertex with the minimum distance value
int minDistance(int dist[], int sptSet[], int numVertices)
{
    int min = INT_MAX, min_index;

    for (int v = 0; v < numVertices; v++)
    {
        if (sptSet[v] == 0 && dist[v] < min)
        {
            min = dist[v];
            min_index = v;
        }
    }

    return min_index;
}

// Function to print the constructed distance array
void printSolution(int dist[], int numVertices)
{
    printf("Vertex   Distance from Source\n");
    for (int i = 0; i < numVertices; i++)
    {
        printf("%d \t\t %d\n", i, dist[i]);
    }
}

// Function to implement Dijkstra's algorithm
void dijkstra(int graph[V][V], int src, int numVertices)
{
    int dist[V];   // The output array dist[i] holds the shortest distance from src to i
    int sptSet[V]; // sptSet[i] is true if vertex i is included in the shortest path tree or the shortest distance from src to i is finalized

    // Initialize all distances as INFINITE and sptSet[] as false
    for (int i = 0; i < numVertices; i++)
    {
        dist[i] = INT_MAX;
        sptSet[i] = 0;
    }

    // Distance from the source vertex to itself is always 0
    dist[src] = 0;

    // Find the shortest path for all vertices
    for (int count = 0; count < numVertices - 1; count++)
    {
        // Pick the minimum distance vertex from the set of vertices not yet processed.
        // u is always equal to src in the first iteration.
        int u = minDistance(dist, sptSet, numVertices);

        // Mark the picked vertex as processed
        sptSet[u] = 1;

        // Update dist value of the adjacent vertices of the picked vertex
        for (int v = 0; v < numVertices; v++)
        {
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
            {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }

    // Print the constructed distance array
    printSolution(dist, numVertices);
}

int main()
{
    int numVertices;

    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    int graph[V][V];

    // Input the adjacency matrix of the graph
    printf("Enter the adjacency matrix of the graph (use -1 for infinity):\n");
    for (int i = 0; i < numVertices; i++)
    {
        for (int j = 0; j < numVertices; j++)
        {
            scanf("%d", &graph[i][j]);
            if (graph[i][j] == -1)
            {
                graph[i][j] = INT_MAX; // Representing infinity with INT_MAX
            }
        }
    }

    int source;

    // Input the source vertex
    printf("Enter the source vertex: ");
    scanf("%d", &source);

    // Apply Dijkstra's algorithm
    dijkstra(graph, source, numVertices);

    return 0;
}
