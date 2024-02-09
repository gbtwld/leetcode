class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1, idx = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && cnt < 2) {
                cnt++;
                nums[idx] = nums[i];
                idx++;
            } else if (nums[i] != nums[i - 1]) {
                cnt = 1;
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}