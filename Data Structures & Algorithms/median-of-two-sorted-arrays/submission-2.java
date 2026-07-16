class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] nums3 = new int[n + m];
        int i = 0, j = 0;
        int index = 0;

        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                nums3[index++] = nums1[i];
                i++; 
            }else{
                nums3[index++] = nums2[j];
                j++;
            }
        }

        while(i < n){
            nums3[index++] = nums1[i];
            i++;
        }

        while(j < m){
            nums3[index++] = nums2[j];
            j++;
        }

        int k = nums3.length;

        if (k % 2 != 0) {
            return nums3[k / 2];
        } else {
            return (nums3[(k / 2) - 1] + nums3[k / 2]) / 2.0;
        }
    }
}
