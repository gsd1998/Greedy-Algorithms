package interviewQA.GreedyAlgorithms;

public class JumpGameII {
    public int jump(int[] nums) {
        return jumpTillDeath(0,0,nums);
    }

    public int jumpTillDeath(int index, int jumps, int[] nums) {
        int minJump = Integer.MAX_VALUE;
        if(index >= nums.length-1){
            return jumps;
        }
        for(int i = 1; i <= nums[index]; i++){
            minJump = Math.min(minJump, jumpTillDeath(index + i,jumps+1,nums));
        }
        return minJump;
    }


    //This is the optimised solution using the concept of ranges
    public int optimalJump(int[] nums) {
        int l = 0;
        int r = 0;
        int jumps = 0;
        while(r < nums.length-1){
            int maxIndex = -1;
            for(int i = l; i <= r; i++){
                maxIndex = Math.max(maxIndex, nums[i]+ i);
            }
            l = r+1;
            r = maxIndex;
            jumps++;
        }
        return jumps;
    }
}
