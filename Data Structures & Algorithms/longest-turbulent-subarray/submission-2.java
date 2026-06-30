class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = 1;
        int res = 1; 
        String prev = "";

        while(r < n){
            if(arr[r-1] > arr[r] && !prev.equals(">")){
                res = Math.max(res, r-l+1);
                r++;
                prev = ">";
            }else if(arr[r-1] < arr[r] && !prev.equals("<")){
                res = Math.max(res, r-l+1);
                r++;
                prev = "<";
            }else{
                if(arr[r-1] == arr[r]) r++;
                l = r-1;
                prev = "";
            }
        }

        return res;
    }
}