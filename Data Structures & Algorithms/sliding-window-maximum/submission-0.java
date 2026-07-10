class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Start recording answers once the first window is formed
            if (i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}