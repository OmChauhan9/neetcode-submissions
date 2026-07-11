class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while(right - left >= k){
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                right--;
            }else{
                left++;
            }
        }

        List<Integer> ls = new ArrayList<>();
        for(int i=left; i<=right; i++){
            ls.add(arr[i]);
        }

        return ls;
    }
}