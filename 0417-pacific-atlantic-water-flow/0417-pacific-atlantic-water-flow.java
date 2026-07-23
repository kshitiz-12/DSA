class Solution {

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific DFS
        for(int i=0;i<m;i++){
            dfs(heights,pacific,i,0);      // Left boundary
            dfs(heights,atlantic,i,n-1);   // Right boundary
        }

        // Atlantic DFS
        for(int j=0;j<n;j++){
            dfs(heights,pacific,0,j);
            dfs(heights,atlantic,m-1,j);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j){

        visited[i][j]=true;

        for(int[] dir : directions){

            int r=i+dir[0];
            int c=j+dir[1];

            if(r<0 || c<0 || r>=heights.length || c>=heights[0].length)
                continue;

            if(visited[r][c])
                continue;

            if(heights[r][c] < heights[i][j])
                continue;

            dfs(heights,visited,r,c);
        }
    }
}