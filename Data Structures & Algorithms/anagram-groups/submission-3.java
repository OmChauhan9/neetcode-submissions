// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         HashMap<String, List<String>> mp = new HashMap<>();

//         for(int i=0; i<strs.length;i++){
//             String s = strs[i];
//             System.out.println("s ::: " + s);
//             char[] sArray = s.toCharArray();

//             int[] cnt = new int[26];

//             for(int j = 0; j<sArray.length; j++){
//                 System.out.println("cnt :::" + cnt.toString());
//                 cnt[sArray[i] - 'a']++;
//             }
//             String s1 = Arrays.toString(cnt);
//             mp.putIfAbsent(s1,new ArrayList<>());
//             mp.get(s1).add(s);
//         }
//         return new ArrayList<>();
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = getStringNumbers(strs[i]);
            List<String> ls;
            if (!map.containsKey(s)) {
                ls = new ArrayList<>();
                ls.add(strs[i]);
                map.put(s, ls);
            }
            else {
                ls = map.get(s);
                ls.add(strs[i]);
                map.put(s, ls);
            }
        }
        List<List<String>> ls = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            ls.add(entry.getValue());
        }
        return ls;
    }

    private static String getStringNumbers(String s) {
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
