class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                int oldIndex = i * cols + j;

                int newIndex = (oldIndex + k) % total;

                int newRow = newIndex / cols;

                int newCol = newIndex % cols;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}