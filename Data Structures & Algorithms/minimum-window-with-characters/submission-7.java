class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        HashMap<Character, Integer> count = new HashMap<>();

        for(char c : t.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int sIndex = -1;
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        while(right < n){
            if(count.getOrDefault(s.charAt(right), 0) > 0){
                cnt++;
                count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) - 1);
            }else{
                count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) - 1);
            }


            while(cnt == m){
                if(right - left + 1 < min){
                    sIndex = left;
                    min = right - left + 1;
                }

                count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) + 1);

                if(count.getOrDefault(s.charAt(left), 0) > 0){
                    cnt--;
                    // count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) + 1);
                }
                // min = Math.min(min, right - left + 1);
                left++;
            }

            right++;
        }

        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + min);
    }
}
