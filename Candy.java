package interviewQA.GreedyAlgorithms;

public class Candy {

    public int candyBruteApproach(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        int sum = 0;
        for(int i = 1; i <= n-1; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = 1;
            }
        }
        for(int i = 0; i <= n-1; i++){
            sum = sum + Math.max(left[i],right[i]);
        }
        return sum;
    }

    public int candyBetterApproach(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int right = 1;
        int curr = 1;

        left[0] = 1;
        int sum = 0;
        for(int i = 1; i <= n-1; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
        }
        sum = sum + Math.max(left[n-1],1);
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                curr = right+1;
            }else{
                curr = 1;
            }
            right = curr;

            sum = sum + Math.max(left[i],curr);
        }
        return sum;
    }

}
