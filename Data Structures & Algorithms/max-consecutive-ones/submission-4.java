class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1){
            if(nums[0]==0){
                return 0;
            }
            return 1;
        }
        int left=0;
        int count=0;
        for(int right =0;right<nums.length;right++){
            if(nums[right]==0){
                left=right+1;
            }
            count=Math.max(count,right-left+1);

        }
        return count;
    }
}