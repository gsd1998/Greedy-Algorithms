package interviewQA.GreedyAlgorithms;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int[] markArr = new int[n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(s[i] >= g[j] && markArr[j] == 0){
                    count++;
                    markArr[j] = 1;
                    break;
                }
            }
            if(count == n){
                break;
            }
        }
        return count;
    }

}
