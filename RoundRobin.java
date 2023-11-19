import java.util.*;
public class RoundRobin{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,i,temp,sq=0,count=0,qt;
        System.out.println("Enter no. of processes: ");
        n=sc.nextInt();
        int bt[]=new int[n];
        int wt[]=new int[n];
        int tt[]=new int[n];
        int rem_bt[]=new int[n];
        float avgtt=0,avgwt=0;
        System.out.println("Enter burst time of processes:\n");
        for(i=0;i<n;i++){
            System.out.print("Enter burst time for process "+(i+1)+": ");
            bt[i]=sc.nextInt();
            rem_bt[i]=bt[i];
        }
        System.out.println("Enter time quantum:");
        qt=sc.nextInt();
        while(true){
            for(i=0,count=0;i<n;i++){
                temp=qt;
                if(rem_bt[i]==0){
                    count++;
                    continue;
                }
                if(rem_bt[i]>qt){
                    rem_bt[i]=rem_bt[i]-qt;
                }
                else if(rem_bt[i]>=0){
                    temp=rem_bt[i];
                    rem_bt[i]=0;
                }
                sq=sq+temp;
                tt[i]=sq;
            }
            if(count==n)
                break;
        }
        for(i=0;i<n;i++){
            wt[i]=tt[i]-bt[i];
            avgtt+=tt[i];
            avgwt+=wt[i];
        }
        System.out.println("pid\tburst\tturn\twait");
        for(i=0;i<n;i++){
            System.out.println((i+1)+"\t"+bt[i]+"\t"+tt[i]+"\t"+wt[i]);
        }
        System.out.println("Average turnaround time: "+(avgtt/n));
        System.out.println("Average waiting time: "+(avgwt/n));
        sc.close();
    }
}