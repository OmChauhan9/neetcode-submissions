class Solution {
    public int maxArea(int[] heights) {
    //     int maxWater = 0;

    //     for(int i = 0; i<heights.length; i++){
    //         for(int j = i+1; j<heights.length; j++){
    //             int width = j - i;
    //             int ht = Math.min(heights[i], heights[j]);
    //             int aerea = width * ht;
    //             maxWater = Math.max(maxWater,aerea);
    //         }
    //     }
    //    return maxWater;

    int left = 0;
    int right = heights.length - 1;
    int maxWater = 0;

    while(left < right){
        int width = right - left;
        int ht = Math.min(heights[right], heights[left]);
        int area = width * ht;
        maxWater = Math.max(area, maxWater);

        if(heights[left] > heights[right]){
            right--;
        } 
        else{
            left++;
        }
        // int ans = (heights[left] > heights[right]) ? right-- : left++;
    }
    return maxWater;
    }
}

