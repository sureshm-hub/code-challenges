package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/redundant-connection/description
 *
 */
public class RedundantConnection {

    class UnionFind {

        int[] parent;
        int[] rank;// or size

        UnionFind(int n) {
            parent =  new int[n + 1];
            rank = new int[n + 1];
            for(int i = 1; i < n + 1; i++) parent[i] = i;
        }

        int find(int x) {
            if(parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if(ra == rb) return false; // cycle

            // Union by Rank
            if(rank[ra] < rank[rb]) parent[ra] = rb;
            else if(rank[rb] < rank[ra]) parent[rb] = ra;
            else {
                parent[rb] = ra;
                rank[ra]++;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] e : edges) {
            int u = e[0], v = e[1];
            if(!uf.union(u, v)) return e; // union failed
        }

        return new int[0];// should never happen
    }
}
