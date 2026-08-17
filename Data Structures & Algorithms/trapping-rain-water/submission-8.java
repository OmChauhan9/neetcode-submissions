class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0, r = n - 1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int maxArea = 0;

        while(l < r){
            if(height[l] <= height[r]){
                leftMax = Math.max(leftMax, height[l]);
                maxArea += leftMax - height[l];
                l++;
            }else{
                rightMax = Math.max(rightMax, height[r]);
                maxArea += rightMax - height[r];
                r--;
            }
        }

        return maxArea;
    }
}
