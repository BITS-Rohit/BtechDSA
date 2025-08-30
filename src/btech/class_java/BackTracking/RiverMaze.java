package Btech.class_java.BackTracking;

public class RiverMaze {
    static int  MazeCount(int row , int column, int F_Row,int F_Column ){
        if(row ==1||column==1){
            return 1;
        }
        int count=0;
        if (row ==F_Row && column ==F_Column){
            return 0;
        }
        else {
            count+= MazeCount(row,column-1,F_Row,F_Column);
            count+= MazeCount(row-1,column,F_Row,F_Column);
        }
        return  count;
    }

    static void PathMaze(String p , int row , int column ,int F_Row,int F_Column  ){
        if (row==1 && column ==1){
            System.out.println(p);
            return;
        }
        if (row ==F_Row && column ==F_Column){
            return;}
        if ( row >1 ){
            PathMaze(p+'V',row-1,column,F_Row,F_Column);
        }
        if ( column>1){
            PathMaze(p+'H',row,column-1,F_Row,F_Column);
        }
    }

    static  void Path2(String p ,boolean[][] board , int row , int column ){

        if (row==board.length-1 && column ==board[0].length-1){
            System.out.println(p);
            return;
        }

        if (!board[row][column]){
            return;
        }
        if (row< board.length-1){
            Path2(p+'V',board,row+1,column);
        }
        if ( column<board[0].length-1){
            Path2(p+'H',board,row,column+1);
        }
    }

    public static void main(String[] args){
//        System.out.println
//                ("Maze Count :- > "+MazeCount(3,3,2,2));
//
//        PathMaze("",3,3,2,2);
//        System.out.println();
//        System.out.println();
//        System.out.println();

        boolean[][] board = {
                {true,true,true} ,
                {true,false ,true},
                {true,true,true}
        };
        Path2("",board,0,0);
    }
}
