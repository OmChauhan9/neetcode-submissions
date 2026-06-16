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
        if(node == null) return null;
        HashMap<Node,Node> mp = new HashMap<>(); // old node , new node
        return cloning(node,mp);        
    }

    public Node cloning(Node node, HashMap<Node,Node> mp){
        if(mp.containsKey(node)) return mp.get(node);  // alreay cloned

        Node newNode = new Node(node.val); // clone the node
        mp.put(node, newNode); // marking visited and store in the map, so we know the address of clone node.

        for(Node n : node.neighbors){
            newNode.neighbors.add(cloning(n,mp)); // clone neighbors and add edges
        }

        return newNode;
    }
}