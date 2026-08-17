class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        System.out.println("sb :: " + sb);

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int n = str.length();

        int i=0;
        int j = i;
        while(i < n){

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j+1, j + length + 1);

            res.add(s);

            j = j + length + 1;
            i = j;
        }

        return res;

  
    }
}
