class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums3 = new int[n + m];
        int index = 0;
        int i = 0, j = 0;

        while(i < n && j < m){
            if(nums1[i] <= nums2[j]){
                nums3[index++] = nums1[i++];
            }else{
                nums3[index++] = nums2[j++];
            }
        }

        while(i < n) nums3[index++] = nums1[i++];
        while(j < m) nums3[index++] = nums2[j++];

        int k = m + n;
        if(nums3.length % 2 != 0){
            return (double) nums3[k / 2];
        }

        return (double)(nums3[k/2] + nums3[(k/2) - 1]) / 2;



    }
}
