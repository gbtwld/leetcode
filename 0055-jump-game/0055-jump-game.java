class Solution {
    public boolean checkJump(int idx, int[] nums) {
        if (idx == 0) return true;
        
        for (int i = idx - 1; i >= 0; i--) {
            if (nums[i] + i >= idx) {
                return checkJump(i, nums);
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;

        return checkJump(n - 1, nums);
    }
}