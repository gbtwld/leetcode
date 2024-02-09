class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int idx1 = 0, idx2 = 0;
        
        for (int i = 0; i < m + n; i++) {
            if (n == 0 || idx2 == n || nums1[idx1] <= nums2[idx2] && idx1 != m) {
                result[i] = nums1[idx1];
                idx1++;
            } else if (m == 0 || idx1 == m || nums1[idx1] > nums2[idx2] && idx2 != n) {
                result[i] = nums2[idx2];
                idx2++;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}