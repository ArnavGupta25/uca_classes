#include <stdio.h>
#include <limits.h>

void calculateTimes(int n, int bt[], int at[]) {
    int rem[n], ct[n], tat[n], wt[n];
    int total_wt = 0, total_tat = 0;
    int completed = 0, timer = 0, shortest = -1;
    int mini = INT_MAX;
    int done[n];

    for (int i = 0; i < n; i++) {
        rem[i] = bt[i];
        done[i] = 0;
    }

    while (completed != n) {
        for (int i = 0; i < n; i++) {
            if (at[i] <= timer && done[i] == 0 && rem[i] < mini) {
                mini = rem[i];
                shortest = i;
            }
        }

        if (shortest == -1) {
            timer++;
            continue;
        }

        rem[shortest]--;
        timer++;

        if (rem[shortest] == 0) {
            completed++;
            done[shortest] = 1;
            ct[shortest] = timer;
            tat[shortest] = ct[shortest] - at[shortest];
            wt[shortest] = tat[shortest] - bt[shortest];

            total_tat += tat[shortest];
            total_wt += wt[shortest];

            shortest = -1;
            mini = INT_MAX; 
        }
    }

    printf("\nAverage Turnaround Time: %.2f", (float)total_tat / n);
    printf("\nAverage Waiting Time: %.2f\n", (float)total_wt / n);
}

int main() {
    int n;

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    int bt[n], at[n];

    for (int i = 0; i < n; i++) {
        printf("Enter arrival time and burst time for process %d: ", i + 1);
        scanf("%d %d", &at[i], &bt[i]);
    }

    calculateTimes(n, bt, at);

    return 0;
}