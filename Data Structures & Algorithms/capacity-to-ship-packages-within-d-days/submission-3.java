class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight : weights){
            low = Math.max(low,weight);
            high +=weight;

        }
        while(low<high){
            int mid = low+(high-low)/2;
            int currentweight = 0;
            int requiredDays=1;
            for(int weight:weights){
                if(currentweight+weight>mid){
                    requiredDays++;
                    currentweight=0;
                }
                currentweight+=weight;
            }

            if(requiredDays<=days){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}