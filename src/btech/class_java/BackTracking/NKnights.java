package Btech.class_java.BackTracking;

public class NKnights {
    static void Knight(boolean[][] board, int row , int column , int knights ){
        if (knights == 0){
            display(board);
            System.out.println();
            return ;
        }

        if (row == board.length-1 && column == board.length) return ;if (column==board.length){
            Knight(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board,row,column,knights)){
            board[row][column]=true;
            Knight(board,row,column+1,knights-1);
            board[row][column]=false;
        }
        Knight(board,row,column+1,knights);

    }
    private static boolean isSafe(boolean[][] board, int row, int column, int knights) {
        if (isValid(board, row-2,column-1)){
            if (board[row-2][column-1]){
                    return false;
            }
        }
        if (isValid(board, row-2,column+1)){
            if (board[row-2][column+1]){
                return false;
            }
        }
        if (isValid(board, row+2,column-1)){
            if (board[row+2][column-1]){
                    return false;
            }
        }
        if (isValid(board, row+2,column+1)){
            if (board[row+2][column+1]){
                    return false;
            }
        }
        return true;
    }
    static boolean isValid(boolean[][] board, int row , int column){
        if ( row >=0 && row < board.length &&  column>=0 && column< board.length){
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for ( boolean[] row : board){
            System.out.print("[||:  ");
            for(boolean element : row){
                if (element) System.out.print("K ");
                else System.out.print("X ");
            }
            System.out.print(" :||]");
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n = 4;
         boolean[][] board = new boolean[n][n];
        Knight(board,0,0,4);
    }
}
