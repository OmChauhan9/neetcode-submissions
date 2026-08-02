class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0;
        int r = n-1;
        int area = 0;
        int leftM = 0;
        int rightM = 0;
        // int max = 0;

        while(l < r){
            if(height[l] <= height[r]){
                leftM = Math.max(height[l], leftM);
                area += leftM - height[l];
                l++;
            }else{
                rightM = Math.max(height[r], rightM);
                area += rightM - height[r];
                r--;
            }

            // max = Math.max(max, area);
        }

        return area;
    }
}
