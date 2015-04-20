public class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashMap<Integer, Integer>> row_list = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> col_list = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> sub_board_list = new  ArrayList<HashMap<Integer, Integer>>();
        
        for(int i = 0; i < 9; i++) {
            HashMap<Integer, Integer> row_map = new HashMap<Integer, Integer>();
            row_list.add(row_map);
            HashMap<Integer, Integer> col_map = new HashMap<Integer, Integer>();
            col_list.add(col_map);
            HashMap<Integer, Integer> board_map = new HashMap<Integer, Integer>();
            sub_board_list.add(board_map);
        }
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                int value = board[i][j]-'0';
                if(row_list.get(i).containsKey(value))
                    return false;
                else
                    row_list.get(i).put(value, j);
                if(col_list.get(j).containsKey(value))
                    return false;
                else
                    col_list.get(j).put(value, i);
                
                int index = ((i/3)*3 + j/3);
                if(sub_board_list.get(index).containsKey(value))
                    return false;
                else
                    sub_board_list.get(index).put(value, i*3+j);
            }
        }
        
        return true;
    }
}