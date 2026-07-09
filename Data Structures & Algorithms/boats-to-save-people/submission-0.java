class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        Arrays.sort(people);

        int left = 0, right = n-1;
        int cnt = 0;

        while(left <= right){
            if(people[left] + people[right] > limit){
                cnt++;
                right--;
            }else{
                cnt++;
                left++;
                right--;
            }
        }

        return cnt;
    }
}