class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      int n = edges.length;
      int [] parent = new int [n+1];

      for(int i =1;i<n;i++){
        parent[i]=i;
      }  
      for(int[] edge:edges){
        int u = edge[0];
        int v = edge[1];
      
        if(find(parent,u)==find(parent,v)){
            return edge;
        }
        union(parent,u,v);
      }
      return new int[0];


    }
    public int find(int [] parent , int x){
        if(parent[x]!=x){
            parent[x]=find(parent,parent[x]);
        }
        return parent[x];
    }
    public void union(int[] parent , int x , int y ){
        int rootx = find(parent,x);
        int rooty = find(parent,y);

        parent[rooty]=rootx;
    }
}