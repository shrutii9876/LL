import java.util.*;
public class Optimal{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,noframes,nopages,nofaults=0,nohits=0;
        float hitratio,faultratio;
        System.out.println("Enter no. of frames: ");
        noframes=sc.nextInt();
        System.out.println("Enter no. of pages: ");
        nopages=sc.nextInt();
        int pages[]=new int[nopages];
        ArrayList<Integer> frames=new ArrayList<>();
        System.out.println("Enter page reference string: ");
        for(i=0;i<nopages;i++){
            pages[i]=sc.nextInt();
        }
        i=0;
        for(int page:pages){
            if(!frames.contains(page)){
                nofaults++;
                if(frames.size()<noframes){
                    frames.add(page);
                }
                else{
                    int index=predictOptimal(frames,pages,i);
                    frames.set(index,page);
                }
            }
            else{
                nohits++;
            }
            i++;
            System.out.print("Frames: ");
            for(int frame:frames)
                System.out.print(frame+" ");
            System.out.println();
        }
        hitratio=(float)nohits/nopages;
        faultratio=(float)nofaults/nopages;
        System.out.println("No. of hits: "+nohits);
        System.out.println("No. of faults: "+nofaults);
        System.out.println("Hit ratio: "+hitratio);
        System.out.println("Fault rato: "+nofaults);
        sc.close();
    }
    public static int predictOptimal(ArrayList<Integer> frames,int[] pages,int curIndex) {
        int farthest=-1,index=-1,i=0,j;
        for(int frame:frames){
            for(j=curIndex;j<pages.length;j++){
                if(frame==pages[j]){
                    if(j>farthest){
                        farthest=j;
                        index=i;
                    }
                    break;
                }
            }
            if(j==pages.length){
                return i;
            }
            i++;
        }
        return index;
    }
}