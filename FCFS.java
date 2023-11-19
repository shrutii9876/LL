import java.util.*;
public class FCFS{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,i,j,temp;
        float avgwt=0,avgtt=0;
        System.out.println("Enter no. of processes: ");
        n=sc.nextInt();
        int at[]=new int[n];
        int wt[]=new int[n];
        int bt[]=new int[n];
        int tt[]=new int[n];
        int ct[]=new int[n];
        int pid[]=new int[n];
        System.out.println("Enter arrival time and burst time:");
        for(i=0;i<n;i++)
        {
            System.out.println("Enter arrival time of process "+(i+1));
            at[i]=sc.nextInt();
            System.out.println("Enter burst time of process "+(i+1));
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n-(i+1);j++)
            {
                if(at[j]>at[j+1])
                {
                    temp=at[j];
                    at[j]=at[j+1];
                    at[j+1]=temp;
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }
        for(i=0;i<n;i++)
        {
            if(i==0)
                ct[i]=at[i]+bt[i];
            else
            {
                if(at[i]>ct[i-1])
                    ct[i]=at[i]+bt[i];
                else
                    ct[i]=ct[i-1]+bt[i];
            }
            tt[i]=ct[i]-at[i];
            wt[i]=tt[i]-bt[i];
            avgtt+=tt[i];
            avgwt+=wt[i];
        }
        System.out.println("pid\tarrival\tburst\tturnaround\twaiting\tcompletion");
        for(i=0;i<n;i++)
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+tt[i]+"\t"+wt[i]+"\t"+ct[i]);
        System.out.println("Average waiting time: "+avgwt/n);
        System.out.println("Average turnaround time: "+avgtt/n);
        sc.close();
    }
}