class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for(int num : nums){
            if(set.contains(num)){
                ans = num;
            }
            else{
                set.add(num);
            }
        }
        return ans;
    }
}
