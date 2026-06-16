class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        // for(int i = 0; i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int width = j-i;
        //         int h = Math.min(heights[i],heights[j]);
        //         int area = h * width; 
        //         maxArea = Math.max(maxArea,area);  
        //     }
        // } 
        // return maxArea;
        int l = 0;
        int r = n-1;
        while(l<r){
            int w = r-l;
            int h = Math.min(heights[l],heights[r]);
            int area = h * w;
            maxArea = Math.max(maxArea,area);
            if(heights[l]>heights[r]){
                r--;
            }
            else{
                l++;
            }
        }
        return maxArea;
    }
}
