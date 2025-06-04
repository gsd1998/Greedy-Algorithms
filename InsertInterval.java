package interviewQA.GreedyAlgorithms;

import java.util.ArrayList;

public class InsertInterval {

    public static void main(String[] args) {

        //int[][] intervals = {{1,3},{3,5},{6,7},{8,10},{12,16}};
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        ArrayList<Datax> datax= insert(intervals,newInterval);
        for(Datax d :  datax){
            System.out.print("[" + d.start + "," + d.end + "] ");
        }


    }

    public static ArrayList<Datax> insert(int[][] intervals, int[] newInterval) {

        int startIndex = -1;
        int endIndex = -1;
        ArrayList<Datax> data = new ArrayList<>();
        int startTimeInt  = newInterval[0];
        int endTimeInt  = newInterval[1];
        boolean flag = false;
        for(int i = 0; i <= intervals.length-1; i++){

            if(startIndex == -1 && startTimeInt <= intervals[i][1]){
                startIndex = intervals[i][0];
            }

            if(endIndex == -1 && endTimeInt <= intervals[i][1]){
                endIndex = intervals[i][1];
            }

            if(startIndex != -1 && endIndex != -1 && flag == false){
                data.add(new Datax(startIndex, endIndex));
                System.out.println(startIndex + " - " + i +  " -xxx- " + endIndex);
                flag = true;
            }

            if((intervals[i][0] < startTimeInt && intervals[i][1] < startTimeInt) ||
                    (intervals[i][0] > endTimeInt && intervals[i][0] > endTimeInt)){
                data.add(new Datax(intervals[i][0], intervals[i][1]));
                System.out.println(intervals[i][0] + " - " + i + " -- " + intervals[i][1]);
            }
        }
        return data;
    }
}
class Datax{
    int start;
    int end;

    Datax (int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}

