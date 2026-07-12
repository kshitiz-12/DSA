class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxarea = 0;

        for(int i=0;i<heights.length;i++){
            int start = i;

            while(!stack.isEmpty()&&stack.peek()[1]>heights[i]){
                int [] curr = stack.pop();
                int index = curr[0];
                int height = curr[1];

                maxarea = Math.max(maxarea,height*(i-index));
                start = index;

            }
            stack.push(new int[]{start,heights[i]});
        }
        while(!stack.isEmpty()){
            int [] curr = stack.pop();
            int index = curr[0];
            int height = curr[1];

            maxarea = Math.max(maxarea,height*(heights.length-index));
        }
        return maxarea;
    }
}
