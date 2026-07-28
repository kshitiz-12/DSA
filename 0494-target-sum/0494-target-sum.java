class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for(int num : nums)
            sum += num;

        if(sum < Math.abs(target))
            return 0;

        if((sum + target) % 2 != 0)
            return 0;

        int subset = (sum + target) / 2;

        int n = nums.length;

        int[][] dp = new int[n+1][subset+1];

        dp[0][0] = 1;

        for(int i=1;i<=n;i++){

            dp[i][0]=1;

            for(int j=0;j<=subset;j++){

                if(nums[i-1] > j){

                    dp[i][j]=dp[i-1][j];

                }

                else{

                    dp[i][j]=
                    dp[i-1][j]
                    +
                    dp[i-1][j-nums[i-1]];

                }
            }
        }

        return dp[n][subset];
    }
}