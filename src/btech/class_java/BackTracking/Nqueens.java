package JAVA.class_java.BackTracking;

public class Nqueens {
    public static void main(String[] args){

        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
    }

    static int queens(boolean[][] board, int row){
        if(row==board.length){
            display(board);
            return 1;
        }
        int count =0;
        for (int column = 0; column < board.length; column++) {
            //  If it is safe then print the board
            if (isSafe(board,row,column)){
                board[row][column]=true;
                count+=queens(board,row+1);
                board[row][column]=false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int column) {
        for (int i = 0; i <row ; i++) {
            if (board[i][column]) return false;
        }

        int Left = Math.min(row,column);
        for (int i = 1; i <= Left; i++) {
            if ( board[row-i][column-i]) return false;
        }


        int Right = Math.min(row,board.length-column-1);
        for (int i = 1; i <= Right; i++) {
            if ( board[row-i][column+i]) return false;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board){
            System.out.print("[ ");
            for (boolean element : row){
                if ( element) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }
}
