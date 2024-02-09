class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int l = 0, h = nums.length - 1, targetIdx = -1, lowIdx, highIdx;
        
        while (l <= h) {
            int m = (l + h) / 2;
            
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                h = m - 1;
            } else {
                targetIdx = m;
                break;
            }
        }
        
        if (targetIdx != -1) {
            lowIdx = targetIdx;
            highIdx = targetIdx;
            
            while (nums[lowIdx] == target) {
                if (lowIdx == 0 || nums[lowIdx - 1] != target) {
                    break;
                }
                lowIdx--;
            }
            while (nums[highIdx] == target) {
                if (highIdx == nums.length - 1 || nums[highIdx + 1] != target) {
                    break;
                }
                highIdx++;
            }
            
            result[0] = lowIdx;
            result[1] = highIdx;
        }
        
        return result;
    }
}