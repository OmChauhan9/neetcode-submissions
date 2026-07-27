class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            String cur = strs.get(i);
            sb.append(cur.length()).append('#').append(cur);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            int j = i + 1;

            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            String sb = str.substring(j+1, j + len + 1);
            ans.add(sb);

            j = j + len;
            i = j;
        }

        return ans;

    }
}
