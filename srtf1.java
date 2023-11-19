import java.util.Scanner;

public class srtf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int at[] = new int[10];
        int bt[] = new int[10];
        int rt[] = new int[10];
        int completionTime, i, smallest = 0;
        int remain = 0, n, time, sum_wait = 0, sum_turn_around = 0;

        System.out.println("enter number of processes");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            System.out.println("Arrival time:");
            at[i] = sc.nextInt();
            System.out.println("Burst Time :");
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        System.out.println("\nPROCESS\tTURNAROUND TIME\tWAITING TIME\n");

        for (time = 0; remain != n; time++) {
            smallest = getSmallestJob(at, rt, n, time);

            rt[smallest]--;

            if (rt[smallest] == 0) {
                remain++;
                completionTime = 1 + time;
                System.out.println((smallest + 1) + "\t" + (completionTime - at[smallest]) + "\t"
                        + (completionTime - bt[smallest] - at[smallest]));
                sum_wait = sum_wait + completionTime - bt[smallest] - at[smallest];
                sum_turn_around = sum_turn_around + completionTime - at[smallest];
            }
        }

        System.out.println("\nAverage waiting time " + (float) sum_wait / n);
        System.out.println("\nAverage turnaround time " + (float) sum_turn_around / n);
    }

    // Helper method to find the process with the smallest remaining time at a given time
    private static int getSmallestJob(int at[], int rt[], int n, int time) {
        int smallest = -1;
        for (int i = 0; i < n; i++) {
            if (at[i] <= time && rt[i] != 0) {
                if (smallest == -1 || rt[i] < rt[smallest]) {
                    smallest = i;
                }
            }
        }
        return smallest;
    }
}
