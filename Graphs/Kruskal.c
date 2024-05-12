#include <stdio.h>
#include <stdlib.h>

// Structure to represent an edge in the graph
struct Edge
{
    int src, dest, weight;
};

// Structure to represent a subset for union-find
struct Subset
{
    int parent;
    int rank;
};

// Function to initialize subsets for union-find
void makeSet(struct Subset subsets[], int vertex)
{
    subsets[vertex].parent = vertex;
    subsets[vertex].rank = 0;
}

// Function to find the set to which a vertex belongs
int find(struct Subset subsets[], int vertex)
{
    if (subsets[vertex].parent != vertex)
    {
        subsets[vertex].parent = find(subsets, subsets[vertex].parent);
    }
    return subsets[vertex].parent;
}

// Function to perform union of two sets
void unionSets(struct Subset subsets[], int x, int y)
{
    int rootX = find(subsets, x);
    int rootY = find(subsets, y);

    if (subsets[rootX].rank < subsets[rootY].rank)
    {
        subsets[rootX].parent = rootY;
    }
    else if (subsets[rootX].rank > subsets[rootY].rank)
    {
        subsets[rootY].parent = rootX;
    }
    else
    {
        subsets[rootX].parent = rootY;
        subsets[rootY].rank++;
    }
}

// Function to compare edges based on their weights
int compareEdges(const void *a, const void *b)
{
    return ((struct Edge *)a)->weight - ((struct Edge *)b)->weight;
}

// Function to implement Kruskal's algorithm
void kruskal(struct Edge edges[], int numVertices, int numEdges)
{
    // Allocate memory for the result (minimum spanning tree)
    struct Edge result[numVertices - 1];

    // Sort all edges in non-decreasing order of their weights
    qsort(edges, numEdges, sizeof(struct Edge), compareEdges);

    // Allocate memory for subsets for union-find
    struct Subset subsets[numVertices];
    for (int i = 0; i < numVertices; i++)
    {
        makeSet(subsets, i);
    }

    int resultIndex = 0;
    int edgeIndex = 0;

    // Construct the minimum spanning tree
    while (resultIndex < numVertices - 1 && edgeIndex < numEdges)
    {
        struct Edge nextEdge = edges[edgeIndex++];

        int x = find(subsets, nextEdge.src);
        int y = find(subsets, nextEdge.dest);

        // If including this edge doesn't cause a cycle, add it to the result
        if (x != y)
        {
            result[resultIndex++] = nextEdge;
            unionSets(subsets, x, y);
        }
    }

    // Print the result (minimum spanning tree)
    printf("Edges in the minimum spanning tree:\n");
    for (int i = 0; i < resultIndex; i++)
    {
        printf("%d -- %d\tWeight: %d\n", result[i].src, result[i].dest, result[i].weight);
    }
}

int main()
{
    int numVertices, numEdges;

    // Input the number of vertices and edges
    printf("Enter the number of vertices: ");
    scanf("%d", &numVertices);

    printf("Enter the number of edges: ");
    scanf("%d", &numEdges);

    struct Edge edges[numEdges];

    // Input the edges (source, destination, weight)
    printf("Enter the edges (source destination weight):\n");
    for (int i = 0; i < numEdges; i++)
    {
        scanf("%d %d %d", &edges[i].src, &edges[i].dest, &edges[i].weight);
    }

    // Apply Kruskal's algorithm
    kruskal(edges, numVertices, numEdges);

    return 0;
}
