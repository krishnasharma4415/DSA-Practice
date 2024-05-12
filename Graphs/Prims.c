#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define V 100

// Function to find the vertex with the minimum key value
int minKey(int key[], int mstSet[], int numVertices)
{
    int min = INT_MAX, min_index;

    for (int v = 0; v < numVertices; v++)
    {
        if (mstSet[v] == 0 && key[v] < min)
        {
            min = key[v];
            min_index = v;
        }
    }

    return min_index;
}

// Function to print the edges of the minimum spanning tree
void printMST(int parent[], int graph[V][V], int numVertices)
{
    printf("Edges in the minimum spanning tree:\n");
    for (int i = 1; i < numVertices; i++)
    {
        printf("%d -- %d \tWeight: %d\n", parent[i], i, graph[i][parent[i]]);
    }
}

// Function to implement Prim's algorithm
void prim(int graph[V][V], int numVertices)
{
    int parent[V]; // Array to store the constructed MST
    int key[V];    // Key values used to pick the minimum weight edge
    int mstSet[V]; // To represent set of vertices included in MST

    // Initialize all keys as INFINITE
    // Set all vertices to not yet included in MST
    for (int i = 0; i < numVertices; i++)
    {
        key[i] = INT_MAX;
        mstSet[i] = 0;
    }

    // Always include the first vertex in MST
    key[0] = 0;
    parent[0] = -1;

    // The MST will have V vertices
    for (int count = 0; count < numVertices - 1; count++)
    {
        // Pick the minimum key vertex from the set of vertices not yet included in MST
        int u = minKey(key, mstSet, numVertices);

        // Add the picked vertex to the MST set
        mstSet[u] = 1;

        // Update key value and parent index of the adjacent vertices
        // of the picked vertex. Consider only those vertices which are not yet included in MST
        for (int v = 0; v < numVertices; v++)
        {
            if (graph[u][v] && mstSet[v] == 0 && graph[u][v] < key[v])
            {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    // Print the edges of the minimum spanning tree
    printMST(parent, graph, numVertices);
}

int main()
{
    int numVertices;

    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    int graph[V][V];

    // Input the adjacency matrix of the graph
    printf("Enter the adjacency matrix of the graph:\n");
    for (int i = 0; i < numVertices; i++)
    {
        for (int j = 0; j < numVertices; j++)
        {
            scanf("%d", &graph[i][j]);
        }
    }

    // Apply Prim's algorithm
    prim(graph, numVertices);

    return 0;
}
