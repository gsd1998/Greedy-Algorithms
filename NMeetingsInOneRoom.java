package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int n = 6;
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
    }

    private static void maxMeetings(int[] start, int[] end, int n) {
        ArrayList<Data> list = new ArrayList<>();
        for(int i = 0; i <= n-1; i++){
            list.add(new Data(start[i],end[i],i+1));
        }
        //sort the list based on end time
        Comp comp = new Comp();
        Collections.sort(list,comp);
        int endTime = list.get(0).end;
        ArrayList<Integer> posList = new ArrayList<>();
        posList.add(list.get(0).pos);

        for(int j = 1; j <= n-1; j++) {
            if (list.get(j).start > endTime) {
                posList.add(list.get(j).pos);
                endTime = list.get(j).end;
            }
        }
        for(int i : posList){
            System.out.print(i + " "); //1 2 4 5
        }
    }
}

class Comp implements Comparator<Data>{

    @Override
    public int compare(Data o1, Data o2) {

        if(o1.end < o2.end){
            return -1;
        }else if(o1.end > o2.end){
            return 1;
        }else if(o1.pos < o2.pos) {
            return -1;
        }
        return 1;
    }
}

class Data{
    int start;
    int end;
    int pos;

    Data (int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
