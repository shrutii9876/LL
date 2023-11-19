import java.util.*;
public class priority
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,temp,n;
        float avgtt=0,avgwt=0;
        System.out.println("Enter no. of processes: ");
        n=sc.nextInt();
        int pid[]=new int[n];
        int bt[]=new int[n];
        int prty[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        System.out.println("Enter burst time and priority of processes\n");
        for(i=0;i<n;i++){
            System.out.println("Enter burst time of process "+(i+1));
            bt[i]=sc.nextInt();
            System.out.println("Enter priority of process "+(i+1));
            prty[i]=sc.nextInt();
            pid[i]=i+1;
        }
        for(i=0;i<n;i++){
            for(j=0;j<n-(i+1);j++){
                if(prty[j]>prty[j+1]){
                    temp=prty[j];
                    prty[j]=prty[j+1];
                    prty[j+1]=temp;
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }
        wt[0]=0;
        tt[0]=bt[0];
        for(i=1;i<n;i++){
            wt[i]=tt[i-1];
            tt[i]=wt[i]+bt[i];
            avgtt+=tt[i];
            avgwt+=wt[i];
        }
        System.out.println("pid\tburst\tpriority\twaiting\tturnaround");
        for(i=0;i<n;i++){
            System.out.println(pid[i]+"\t"+bt[i]+"\t"+prty[i]+"\t\t"+wt[i]+"\t"+tt[i]);
        }
        System.out.println("\nAverage waiting time: "+(avgwt/n));
        System.out.println("\nAvergae turnaround time: "+(avgtt/n));
        sc.close();
    }
}