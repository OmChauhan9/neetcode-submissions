/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node, Node> mp = new HashMap<>();
        Node cloneN = new Node(node.val);
        mp.put(node, cloneN);
        dfs(node, cloneN, mp);
        return cloneN;
    }

    public void dfs(Node node, Node cloneN, HashMap<Node, Node> mp){
        for(Node ne : node.neighbors){
            if(!mp.containsKey(ne)){
                Node clone = new Node(ne.val);
                mp.put(ne, clone);
                cloneN.neighbors.add(clone);
                dfs(ne, clone, mp);
            }else{
                cloneN.neighbors.add(mp.get(ne));
            }
        }
    }
}