class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            // i가 이전 값과 같은 값을 가리키면 패스
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                }
                
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
            }
        }

        return result;
    }
}