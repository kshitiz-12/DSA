class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robhelper(nums,0,nums.length-2),robhelper(nums,1,nums.length-1));
    }
    public int robhelper(int [] nums , int start , int end){
        int prev2=0;
        int prev1=0;
        for(int i=start;i<=end;i++){
            int current = Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}