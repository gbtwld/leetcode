class Solution {
    public int binary(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        
        int mid = (low + high) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binary(nums, mid + 1, high, target);
        } else if (nums[mid] > target) {
            return binary(nums, low, mid - 1, target);
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }
}