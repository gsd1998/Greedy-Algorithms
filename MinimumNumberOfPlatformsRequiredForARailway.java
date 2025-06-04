package interviewQA.GreedyAlgorithms;

import java.util.Arrays;

public class MinimumNumberOfPlatformsRequiredForARailway {

    public static void main (String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        int totalCount=countPlatforms(n,arr,dep);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }

    private static int countPlatforms(int n, int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int maxNoOfPlatforms = 0;
        int noOfTrains = 0;
        while(i < n) {
            if(arr[i] <= dep[j]){
                noOfTrains++;
                i++;
            }else{
                noOfTrains--;
                j++;
            }
            maxNoOfPlatforms = Math.max(maxNoOfPlatforms, noOfTrains);
        }
        return maxNoOfPlatforms;
    }
}
