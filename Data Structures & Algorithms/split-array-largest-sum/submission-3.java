class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int num : nums){
            low = Math.max(low,num);
            high+=num;
        }
        while(low<high){
            int mid = low+(high-low)/2;
            int curr=0;
            int subarr=1;
           

            for(int num:nums){
                if(curr+num>mid){
                    subarr++;
                    curr=0;
                }
                curr+=num;
                
            }
            if(subarr<=k){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}