package interviewQA.GreedyAlgorithms;

import java.util.Arrays;

public class ShortestJobFirstCPUScheduling {
    public static void main(String[] args) {
        int[] jobs = {4, 3, 7, 1, 2};
        float ans = shortestJobFirst(jobs);
        System.out.println("Average waiting time: " + ans);//4.0
    }

    private static float shortestJobFirst(int[] jobs) {
        Arrays.sort(jobs);
        float total = 0;
        float waitDuration = 0;
        for(int i = 0; i <= jobs.length-1; i++){
            waitDuration = total + waitDuration;
            total = total + jobs[i];
        }
        return (waitDuration/jobs.length);
    }
}
