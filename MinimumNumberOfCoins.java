package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;

public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int v = 49;
        ArrayList<Integer> ans = findMinNoOfCoins(arr,v);
        System.out.println(ans);
        System.out.println(ans.size());
    }

    public static ArrayList<Integer> findMinNoOfCoins(int[] arr, int v){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        for(int i = n-1; i >= 0; i--){
            while(v >= arr[i]){
                v = v - arr[i];
                ans.add(arr[i]);
            }
            if(v == 0){
                break;
            }
        }
        return ans;
    }
}
