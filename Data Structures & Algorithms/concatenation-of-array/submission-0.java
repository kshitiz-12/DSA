class Solution {
    public int[] getConcatenation(int[] nums) {
        int size=2*nums.length;
        int [] ans = new int [size];
        int i=0;
        while(i<size){
            ans[i]=nums[i%nums.length];
            i++;
        }
        return ans;
        
    }
}