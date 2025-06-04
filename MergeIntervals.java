package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];

        for(int i = 1; i <= n-1; i++){
            if(arr[i][0] <= end){
                end = Math.max(arr[i][1],end);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                op.add(list);
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        op.add(list);

        int[][] ans = new int[op.size()][2];

        for(int k = 0; k <= op.size()-1; k++){
            ans[k][0] = op.get(k).get(0);
            ans[k][1] = op.get(k).get(1);
        }
        return ans;
    }
}
