class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int row=0;row<9;row++){
            for(int col = 0 ;col<9;col++){
                char num = board[row][col];
                if(num=='.'){
                    continue;
                }

                String rowKey = num + "rowkey" + row;
                String colKey = num + "colKey" + col;
                String box = num + "boxkey" + (row/3)+"-"+(col/3);

                if(set.contains(rowKey)||set.contains(colKey)||set.contains(box)){
                    return false;
                }
                set.add(rowKey);
                set.add(colKey);
                set.add(box);
            }
        }
        return true;
        
    }
}
