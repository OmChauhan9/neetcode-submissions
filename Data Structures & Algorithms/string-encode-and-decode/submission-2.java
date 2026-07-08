class Solution {

    public String encode(List<String> strs) {
        StringBuilder string = new StringBuilder();
        
        for(String s : strs){
            string.append(s.length()).append('#').append(s);
        }

        return string.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        int n = str.length();
        List<String> ans = new ArrayList<>();

        while(i<n){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            } 

            int length = Integer.parseInt(str.substring(i, j));
            String decode = str.substring(j + 1, j + length + 1);
            ans.add(decode);

            j = j + length + 1;
            i = j;
            
        }

        return ans;
    }
}
