package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/construct-quad-tree/description/
 *
 */
public class QuadTree {

    public Node construct(int[][] grid) {
        return buildQuad(grid, 0, 0, grid.length);
    }

    private Node buildQuad(int[][] grid, int i, int j, int w) {

        if(allSame(grid, i, j, w)) {
            return new Node(grid[i][j] == 1, true);
        }

        int h =  w/2;

        return new Node(false, false,
                buildQuad(grid, i, j, h),
                buildQuad(grid, i, j + h, h),
                buildQuad(grid, i + h, j, h),
                buildQuad(grid, i + h, j + h, h));
    }

    private boolean allSame(int[][] grid, int x, int y, int h) {
        for(int i = x; i < x + h; i ++) {
            for(int j = y; j < y + h; j++) {
                if(grid[i][j] != grid[x][y]) return false;
            }
        }
        return true;
    }


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

}
