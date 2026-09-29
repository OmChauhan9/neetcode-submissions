class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0, r = n - 1;
        int area = 0;

        while(l < r){
            if(heights[l] <= heights[r]){
                area = Math.max(area, heights[l] * (r - l));
                l++;
            }else{
                area = Math.max(area, heights[r] * (r - l));
                r--;
            }
        }

        return area;
    }
}
