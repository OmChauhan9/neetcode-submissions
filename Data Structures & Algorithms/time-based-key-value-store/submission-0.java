class TimeMap {

    private Map<String,TreeMap<Integer,String>> mp;

    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> treemp = mp.get(key);
        if(treemp == null){
            return "";
        }
        Map.Entry<Integer,String> entry = treemp.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
