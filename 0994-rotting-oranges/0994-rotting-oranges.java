class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();

        int fresh = 0;
        int minutes= 0;

        for(int i = 0 ; i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int [] {i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        while(!queue.isEmpty()&&fresh>0){
            int size = queue.size();

            for(int k = 0 ; k<size;k++){
                int [] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if(row+1<grid.length&&grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    fresh--;
                    queue.offer(new int []{row+1,col});
                }
                if(row-1>=0&&grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    fresh--;
                    queue.offer(new int []{row-1,col});
                }
                if(col+1<grid[0].length&&grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    fresh--;
                    queue.offer(new int []{row,col+1});
                }
                if(col-1>=0&&grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    fresh--;
                    queue.offer(new int []{row,col-1});
                }
            }
            minutes++;
        }
        return fresh==0?minutes:-1;
    }
}