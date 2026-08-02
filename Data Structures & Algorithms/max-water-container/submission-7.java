class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int l = 0; 
        int r = n - 1;
        int max = 0;

        while(l < r){
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int area = height * width;
            max = Math.max(max, area);
            if(heights[l] > heights[r]) r--;
            else l++;
        }

        return max;
    }
}
