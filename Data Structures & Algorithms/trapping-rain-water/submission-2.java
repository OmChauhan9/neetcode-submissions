class Solution {
    public int trap(int[] height) {
        int n = height.length;
        // int maxArea = 0;
        // for(int i=0;i<n;i++){
        //     int leftMax = height[i];
        //     int rightMax = height[i];
        //     for(int j=0;j<i;j++){
        //         leftMax = Math.max(leftMax,height[j]);
        //     }
        //     for(int j=i+1;j<n;j++){
        //         rightMax = Math.max(rightMax,height[j]);
        //     }

        //     maxArea += Math.min(leftMax,rightMax) - height[i];
        // }
        // return maxArea;
        int l = 0;
        int r = n-1;
        int leftM = 0;
        int rightM = 0;
        int res = 0;

        while(l<=r){
            if(height[l] <= height[r]){
                // if(height[l] > leftM){
                //     leftM = height[l];
                // } else {
                //     res += leftM - height[l];
                // }
                leftM = Math.max(leftM, height[l]);
                res += leftM - height[l];
                l++;
            }
            else{
                // if(height[r] > rightM){
                //     rightM = height[r];
                // } else {
                //     res += rightM - height[r];
                // }
                rightM = Math.max(rightM,height[r]);
                res += rightM - height[r];
                r--;
            }
        }
        return res;
    }
}
