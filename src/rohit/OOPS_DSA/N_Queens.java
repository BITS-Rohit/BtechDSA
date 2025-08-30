package rohit.OOPS_DSA;

public class N_Queens {
    public static void main(String[] args) {
        int n =14;
        boolean[][] board= new boolean[n][n];
        System.out.println(queens(board,0));
    }
    static int queens(boolean[][] board, int row){
        if (row==board.length){
//            display(board);
            return 1;
        }
        int count=0;
        // placing the queen and checking for every row and column
        for (int col = 0; col<board.length;col++){
            // place the queen if it is safe
            if (isSafe(board,row,col)){
                board[row][col]=true;
                count+=queens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }

    static private boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical rows
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
        int left_diagonal= Math.min(row,col);
        for (int i = 1; i <=left_diagonal; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        int right_diagonal=   Math.min(row,board.length-col-1);
        for (int i = 1; i <=right_diagonal; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    static private void display(boolean[][] board) {
        for (boolean[] row : board){
            for (boolean element : row){
                if (element) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
