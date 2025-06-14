class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[]  parent = new int[edges.length+1];
        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v= edge[1];

            int rootU = find(u, parent);
            int rootV = find(v, parent);
            if( rootU == rootV){
                return edge;
            }
            parent[rootU] = rootV;
        }
        return new int[0]; 
    }
    public int find( int x, int[] parent){

        while(x != parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}