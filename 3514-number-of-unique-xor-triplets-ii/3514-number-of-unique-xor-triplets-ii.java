class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] dp1 = new boolean[MAX];
        boolean[] dp2 = new boolean[MAX];
        boolean[] dp3 = new boolean[MAX];

        for (int num : nums) {
            boolean[] ndp3 = dp3.clone();
            boolean[] ndp2 = dp2.clone();
            boolean[] ndp1 = dp1.clone();

            // Extend length 2 -> 3
            for (int x = 0; x < MAX; x++) {
                if (dp2[x]) {
                    ndp3[x ^ num] = true;
                }
            }

            // Extend length 1 -> 2
            for (int x = 0; x < MAX; x++) {
                if (dp1[x]) {
                    ndp2[x ^ num] = true;
                }
            }

            // Single element
            ndp1[num] = true;

            dp1 = ndp1;
            dp2 = ndp2;
            dp3 = ndp3;
        }

        // Handle repeated indices (i = j or j = k)
        for (int num : nums) {
            dp2[0] = true;          // num ^ num = 0
            dp3[num] = true;        // num ^ num ^ num = num

            for (int x = 0; x < MAX; x++) {
                if (dp1[x]) dp3[x] = true; // x ^ num ^ num = x
            }
        }

        int ans = 0;
        for (boolean b : dp3) {
            if (b) ans++;
        }

        return ans;
    }
}