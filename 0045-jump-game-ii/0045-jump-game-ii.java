class Solution {
    public int searchMinIdx(int idx, int[] nums) {
        if (idx == 0) {
            return 0;
        }
        int minIdx = idx;
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] + i >= idx) {
                minIdx = Math.min(minIdx, i);
            }
        }
        return searchMinIdx(minIdx, nums) + 1;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        return searchMinIdx(n - 1, nums);
    }
}