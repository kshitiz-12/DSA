class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
            low=Math.max(low,weight);
            high+=weight;
        }
        while(low<high){
            int mid = low+(high-low)/2;
           
            int requiredDay=1;
             int currweigh=0;
           

            for(int weight:weights){
                if(currweigh+weight>mid){
                    requiredDay++;
                    currweigh=0;
                }
                
                currweigh+=weight;
                
                
            }
            if(requiredDay<=days){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}