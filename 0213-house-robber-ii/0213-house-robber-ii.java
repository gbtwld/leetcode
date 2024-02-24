class Solution {
    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        
        for (int i = start; i <= end; i++) {
            if (i == start) {
                dp[start] = nums[start];
                continue;
            }
            if (i == start + 1) {
                dp[start + 1] = Math.max(nums[start], nums[start + 1]);
                continue;
            }
            
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[end];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 0번집, n-1번집 같이 못털음
        // 0번집 털 때 (0 ~ n - 2)
        int a = rob(nums, 0, nums.length - 2);
        // n-1번집 털 때 (1 ~ n - 1)
        int b = rob(nums, 1, nums.length - 1);

        return Math.max(a, b);
    }
}