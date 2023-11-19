import java.util.*;
public class LRU{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int noframes,nopages,nohits=0,nofaults=0,i;
        float hitratio,faultratio;
        System.out.println("Enter no. of frames: ");
        noframes=sc.nextInt();
        System.out.println("Enter no of pages: ");
        nopages=sc.nextInt();
        LinkedList<Integer> frames=new LinkedList<>();
        int pages[]=new int[nopages];
        System.out.println("Enter page reference string: ");
        for(i=0;i<nopages;i++){
            pages[i]=sc.nextInt();
        }
        for(int page:pages){
            if(!frames.contains(page)){
                if(frames.size()>=noframes){
                    frames.removeFirst();
                }
                frames.addLast(page);
                nofaults++;
            }
            else{
                frames.remove(frames.indexOf(page));
                frames.addLast(page);
                nohits++;
            }
            System.out.print("Frame: ");
            for(int frame:frames)
                System.out.print(frame+" ");
            System.out.println();
        }
        System.out.println("No. of hits: "+nohits);
        System.out.println("No. of faults: "+nofaults);
        hitratio=(float)nohits/nopages;
        faultratio=(float)nofaults/nopages;
        System.out.println("Hit ratio: "+hitratio);
        System.out.println("Fault rtio: "+faultratio);
    }
}