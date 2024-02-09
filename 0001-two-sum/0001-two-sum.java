class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 인덱스를 포함한 이차원 배열에 저장
        int[][] arrWithIdx = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arrWithIdx[i][0] = nums[i];
            arrWithIdx[i][1] = i;
        }

        // 배열 오름차순으로 정렬
        Arrays.sort(arrWithIdx, Comparator.comparingInt(arr -> arr[0]));

        // Two Pointer 선언
        int left = 0, right = arrWithIdx.length - 1;

        // Two Pointer 실행
        while (left < right) {
            int sum = arrWithIdx[left][0] + arrWithIdx[right][0];
            
            if (sum == target) {
                return new int[]{arrWithIdx[left][1], arrWithIdx[right][1]};
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }
        return new int[]{};
    }
}