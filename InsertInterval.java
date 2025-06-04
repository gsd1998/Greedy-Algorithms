package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;

public class InsertInterval {

    public int[][] insert(int[][] interval, int[] newInterval) {
        int startTimeInt = newInterval[0];
        int endTimeInt = newInterval[1];
        int n = interval.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int i = 0;
        while(i < n && interval[i][1] < startTimeInt){
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(interval[i][0]);
            list1.add(interval[i][1]);
            arr.add(list1);
            i++;
        }

        while(i < n && interval[i][0] <= endTimeInt){
            startTimeInt = Math.min(startTimeInt, interval[i][0]);
            endTimeInt = Math.max(endTimeInt, interval[i][1]);
            i++;
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(startTimeInt);
        list2.add(endTimeInt);
        arr.add(list2);

        while(i < n){
            ArrayList<Integer> list3 = new ArrayList<>();
            list3.add(interval[i][0]);
            list3.add(interval[i][1]);
            arr.add(list3);
            i++;
        }

        int[][] output = new int[arr.size()][2];
        for(int k = 0; k <= arr.size()-1; k++){
            output[k][0] = arr.get(k).get(0);
            output[k][1] = arr.get(k).get(1);
        }
        return output;
    }
}

