package JAVA.class_java.BackTracking;

import java.util.Arrays;

public class AllPaths {
    static  void allPaths(String p , boolean[][] board , int row , int column ){

        if (row==board.length-1 && column ==board[0].length-1){
            System.out.println(p);
            return;
        }

        if (!board[row][column]){
            return;
        }
        board[row][column] =false;
        if (row< board.length-1){
            allPaths(p+'D',board,row+1,column);
        }
        if ( column<board[0].length-1){
            allPaths(p+'R',board,row,column+1);
        }
        if (row>0){
            allPaths(p+'U',board,row-1,column);
        }
        if ( column>0){
            allPaths(p+'L',board,row,column-1);
        }
        board[row][column] =true;
    }

    static  void allPathsPrint(String p , boolean[][] board , int row , int column ,int[][] path, int count){

        if (row==board.length-1 && column ==board[0].length-1){
            path[row][column]=count;
            System.out.println(p);

            for (int[] arr : path){
                System.out.println(Arrays.toString(arr ));
            }
            System.out.println();
            System.out.println();
            return;
        }
        if (!board[row][column]){
            return;
        }
        board[row][column] =false;
        path[row][column]= count;

        if (row< board.length-1){
            allPathsPrint(p+'D',board,row+1,column,path,count+1);
        }
        if ( column<board[0].length-1){
            allPathsPrint(p+'R',board,row,column+1,path,count+1);
        }
        if (row>0){
            allPathsPrint(p+'U',board,row-1,column,path,count+1);
        }
        if ( column>0){
            allPathsPrint(p+'L',board,row,column-1,path,count+1);
        }
        board[row][column] =true;
        path[row][column]= 0;
    }

    public static void main(String[] args){
        boolean[][] board = {
                {true,true,true,} ,
                {true,true ,true},
                {true,true,true,}
        };
        int[][] path = new int[board.length][board[0].length];
        allPathsPrint("",board,0,0,path,1);
    }
}
