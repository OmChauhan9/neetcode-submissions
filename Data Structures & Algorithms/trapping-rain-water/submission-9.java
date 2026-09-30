class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0, r = n - 1;
        int maxArea = 0;
        int leftMax = -1, rightMax = -1;

        while(l < r){
            if(height[l] <= height[r]){
                leftMax = Math.max(leftMax, height[l]);
                maxArea += leftMax - height[l] ;
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
