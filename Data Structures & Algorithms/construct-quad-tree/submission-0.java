/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    public Node solve(int[][] grid, int x, int y, int n){
        if(isSame(grid, x, y, n)){
            return new Node(grid[x][y] == 1, true);
        }else{
            Node newNode = new Node(grid[x][y] == 1, false);
            newNode.topLeft = solve(grid, x, y, n/2);
            newNode.topRight = solve(grid, x, y + (n/2), n/2);
            newNode.bottomLeft = solve(grid, x + (n/2), y, n/2);
            newNode.bottomRight = solve(grid, x + (n/2), y + (n/2), n/2);

            return newNode;
        }
    }

    public boolean isSame(int[][] grid, int x, int y, int n){
        int val = grid[x][y];

        for(int i=x; i<x + n; i++){
            for(int j=y; j<y + n; j++){
                if(grid[i][j] != val) return false;
            }
        }

        return true;
    }
}
