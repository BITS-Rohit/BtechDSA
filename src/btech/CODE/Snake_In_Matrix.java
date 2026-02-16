package btech.CODE;


import java.util.List;

public class Snake_In_Matrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] nums = new int[n][n];
        int fill = 0 ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[i][j]=fill++;              // 1st inster value then increament
            }
        }
        // content of num array is full now
        int startIndex_V = 0 ;        // Snake Index path  Vertical
        int startIndex_H = 0 ;        // Snake Index path  Horizontal

        for( String word : commands){
            if (word.equalsIgnoreCase("down")){
                startIndex_V++;
            }
            if (word.equalsIgnoreCase("up")){
                if (startIndex_V!=0) startIndex_V--;
            }
            if (word.equalsIgnoreCase("right")){
                startIndex_H++;
            }
            if (word.equalsIgnoreCase("left")){
                if (startIndex_H!=0) startIndex_H--;
            }
        }
        return nums[startIndex_V][startIndex_H];
    }
}
