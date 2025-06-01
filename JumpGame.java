package interviewQA.GreedyAlgorithms;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i <= nums.length-1; i++){
            if(maxIndex >= i){
                maxIndex = Math.max(maxIndex,nums[i]+i);
            }
        }
        if(maxIndex >= nums.length-1){
            return true;
        }
        return false;
    }
}
