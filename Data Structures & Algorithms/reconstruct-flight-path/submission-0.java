class Solution {
    // List<String>
    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();

        HashMap<String, List<String>> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!mp.containsKey(tickets.get(i).get(0))){
                mp.put(tickets.get(i).get(0), new ArrayList<>());
            }
            mp.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            Collections.sort(entry.getValue());
        }

        return dfs("JFK", new ArrayList<>(), n, mp);
    }

    public List<String> dfs(String origin, List<String> path, int n, HashMap<String, List<String>> mp){
        path.add(origin);

        if(path.size() == n + 1){
            return path;
        }

        List<String> dests = mp.get(origin);
        if(dests != null){
            for(int i=0; i<dests.size(); i++){
                String nVisited = dests.get(i);
                dests.remove(nVisited);
                List<String> result = dfs(nVisited, path, n, mp);
                if(result != null) return result;
                dests.add(i, nVisited);
            }
        }

        path.remove(path.size()-1);
        return null;
    }
}
