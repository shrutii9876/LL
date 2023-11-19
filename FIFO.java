import java.util.*;
public class FIFO{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int noframes,nopages,nohits=0,nofaults=0,curIndex=0;
        boolean pagehit;
        float hitratio,faultratio;
        System.out.println("Enter no. of frames: ");
        noframes=sc.nextInt();
        int frames[]=new int[noframes];
        System.out.println("Enter no of pages: ");
        nopages=sc.nextInt();
        int pages[]=new int[nopages];
        System.out.println("Enter page reference string: ");
        for(int i=0;i<nopages;i++){
            pages[i]=sc.nextInt();
        }
        Arrays.fill(frames, -1);
        for(int page:pages){
            pagehit=false;
            for(int frame:frames){
                if(page==frame){
                    nohits++;
                    pagehit=true;
                    break;
                }
            }
            if(!pagehit){
                frames[curIndex]=page;
                curIndex=(curIndex+1)%noframes;
                nofaults++;
            }  
            System.out.print("Frame: ");
            for(int frame:frames)
                System.out.print(frame+" ");
            System.err.println();
        }
        System.out.println("\nNo. of hits: "+nohits);
        System.out.println("No. of faults: "+nofaults);
        hitratio=(float) nohits/nopages;
        System.out.println("Hit ratio: "+hitratio);
        faultratio=(float) nofaults/nopages;
        System.out.println("Fault ratio: "+faultratio);
    }
}