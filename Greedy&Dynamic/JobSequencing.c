#include <stdio.h>
#include <stdlib.h>

// Structure to represent a job with its ID, profit, and deadline
struct Job {
    int id;
    int profit;
    int deadline;
};

// Function to compare jobs by profit in descending order (used for sorting)
int compareJobsByProfit(const void* a, const void* b) {
    const struct Job* job1 = (const struct Job*)a;
    const struct Job* job2 = (const struct Job*)b;
    return job2->profit - job1->profit;  // Descending order
}

// Function to find the maximum profit sequence for a set of jobs using the greedy approach
void findJobSequence(struct Job jobs[], int n) {
    // Sort jobs by profit in descending order (important for the greedy approach)
    qsort(jobs, n, sizeof(struct Job), compareJobsByProfit);

    // Initialize an array to store the scheduled jobs (initially empty)
    int schedule[n];
    for (int i = 0; i < n; i++) {
        schedule[i] = -1;  // -1 indicates no job assigned to that slot yet
    }

    // Iterate through sorted jobs and try to schedule them based on their deadline
    for (int i = 0; i < n; i++) {
        // Find the latest available slot for the current job (considering its deadline)
        int latestSlot = jobs[i].deadline - 1;  // Start from deadline-1
        while (latestSlot >= 0 && schedule[latestSlot] != -1) {  // Check for availability
            latestSlot--;  // Move to an earlier slot if necessary
        }

        // If a suitable slot is found, schedule the job
        if (latestSlot >= 0) {
            schedule[latestSlot] = jobs[i].id;
        }
    }

    // Print the schedule of jobs
    printf("Job Sequence:\n");
    for (int i = 0; i < n; i++) {
        if (schedule[i] != -1) {
            printf("Job %d ", schedule[i]);
        }
    }
    printf("\n");
}

int main() {
    struct Job jobs[] = {
        {1, 20, 2},
        {2, 5, 1},
        {3, 10, 2},
        {4, 1, 1},
    };
    int n = sizeof(jobs) / sizeof(jobs[0]);

    printf("Given Jobs:\n");
    printf("JobID\tProfit\tDeadline\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%d\t%d\n", jobs[i].id, jobs[i].profit, jobs[i].deadline);
    }

    findJobSequence(jobs, n);

    return 0;
}
