class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int l = 0, r = n-1;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int area = 0;
        
        while(l < r){
            if(height[l] <= height[r]){
                leftMax = Math.max(leftMax, height[l]);
                area += leftMax - height[l];
                l++;
            }else{
                rightMax = Math.max(rightMax, height[r]);
                area += rightMax - height[r];
                r--;
            }
        }

        return area;
    }
}
