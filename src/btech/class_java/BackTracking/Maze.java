package JAVA.class_java.BackTracking;

import java.util.ArrayList;

public class Maze {

    static int countMaze(int row , int column){
        if ( row ==1 || column ==1){
            return 1;
        }
        int left = countMaze(row-1,column);
        int right = countMaze(row,column-1);
        return left+right;
    }

    static void MazePath(String p , int row , int column){
        if (row ==1 && column==1){
            System.out.println(p);
            return;
        }
        if  ( row >1){
            MazePath(p+'D',row-1,column);
        }
        if ( column>1){
            MazePath(p+'R',row,column-1);
        }
    }

    static ArrayList<String> PathList(String p , int row ,int column){
        ArrayList<String> list = new ArrayList<>();
        if (row==1 && column==1){
            list.add(p);
            return list;
        }
        ArrayList<String> ans =new ArrayList<>();
        if ( row> 1){
            ans.addAll(PathList(p+'D',row-1,column));;
        }
        if ( column > 1){
            ans.addAll(PathList(p+'R',row, column -1));
        }
        return ans;
    }
 static ArrayList<String> PathListDiagonally(String p , int row ,int column){
        ArrayList<String> list = new ArrayList<>();
        if (row==1 && column==1){
            list.add(p);
            return list;
        }

        ArrayList<String> ans =new ArrayList<>();

        if ( row> 1){
            ans.addAll(PathListDiagonally(p+'V',row-1,column));;
        }
        if ( column > 1){
            ans.addAll(PathListDiagonally(p+'H',row, column -1));
        }
        if (column>1 && row > 1){
            ans.addAll(PathListDiagonally(p+'D',row-1,column-1));
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println("Maze Count :-> "+countMaze(3,3));
//        MazePath("",3,3);
//        System.out.println(PathList("",3,3));
        System.out.println(PathListDiagonally("",3,3));
    }
}
