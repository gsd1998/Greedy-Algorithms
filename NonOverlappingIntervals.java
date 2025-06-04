package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        ArrayList<Data> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0; i <= n-1; i++){
            list.add(new Data(intervals[i][0],intervals[i][1],i+1));
        }
        Comp comp = new Comp();
        Collections.sort(list,comp);
        int endTime = list.get(0).end;
        int count = 0;

        for(int j = 1; j <= n-1; j++) {
            if (list.get(j).start >= endTime) {
                endTime = list.get(j).end;
            }else{
                count++;
            }
        }
        return count;
    }
}

