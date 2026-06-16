class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int res = 0;

        // for(int i = 0; i<s.length(); i++){
        //     Set<Character> str = new HashSet<>();
        //     for(int j = i; j<s.length(); j++){
        //         if(str.contains(s.charAt(j))){
        //             break;
        //         }
        //         str.add(s.charAt(j));
        //     }
        //     res = Math.max(res,str.size());
        // }
        // return res;

        HashMap<Character, Integer> map = new HashMap<>();

        int len = 0;
        int left = 0;
        int right = 0;

        int n = s.length();
        while(right < n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}
