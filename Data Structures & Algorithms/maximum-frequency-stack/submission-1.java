class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);

        int curFreq = freq.get(val);

        if(curFreq > maxFreq) maxFreq = curFreq;

        group.putIfAbsent(curFreq, new Stack<>());
        group.get(curFreq).push(val);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();

        freq.put(val, freq.getOrDefault(val, 0) - 1);

        if(group.get(maxFreq).isEmpty()) maxFreq--;

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */