package interviewQA.GreedyAlgorithms;

import java.util.Arrays;

public class JobSequencingProblem {

    public static void main(String[] args) {
        Jobs[] arr = new Jobs[5];
        arr[0] = new Jobs(1,2,100);
        arr[1] = new Jobs(2,1,19);
        arr[2] = new Jobs(3,2,27);
        arr[3] = new Jobs(4,1,25);
        arr[4] = new Jobs(5,1,15);
        solve ob = new solve();
        int[] res = ob.JobScheduling(arr);
        System.out.println(res[0] + " " + res[1]);//2 127
    }
}

class solve {

    public int[] JobScheduling(Jobs[] jobs) {
        int maxDeadline = 0;
        int noOfJobs = 0;
        int maxProfit = 0;
        for (int i = 0; i <= jobs.length - 1; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i].deadline);
        }
        int[] hashArr = new int[maxDeadline];
        int[] op = new int[2];
        for (int i = 0; i <= hashArr.length - 1; i++) {
            hashArr[i] = -1;
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        for (int j = 0; j <= maxDeadline-1; j++) {
            int days = jobs[j].deadline - 1;
            while (days > -1) {
                if (hashArr[days] == -1) {
                    hashArr[days] = jobs[j].jobId;
                    noOfJobs++;
                    maxProfit = maxProfit + jobs[j].profit;
                    break;
                }
                days--;
            }
        }
        op[0] = noOfJobs;
        op[1] = maxProfit;
        return op;
    }
}

class Jobs{
    int jobId;
    int deadline;
    int profit;
    public Jobs(int jobId, int deadline, int profit){
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}
