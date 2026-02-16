package btech.CODE;

import java.util.HashMap;
import java.util.Map;

public class DesignNeighborSumService {

}
class NeighborSum {
    private int n;
    public int[][] grid = new int[n][n];
    int V = 0 ; int H = 0;
    int m ;
    int val = m;
    public NeighborSum(int[][] grid) {
        this.grid = grid; // Use the provided grid
        this.n = grid.length;

    }

    public  int adjacentSum(int value) {
        this.val=value;
        m = valum(value);
        int up =0 ; int down =0 ; int left =0 ; int right =0 ;
        if (V>0)up = grid[V-1][H];// Up direction
        if (V<n-1) down=grid[V+1][H];// Down direction
        if(H>0 )left = grid[V][H-1];// left direction
        if(H <n-1) right = grid[V][H+1];//right direction

        return up+down+left+right;

    }

    private int valum(int value) {
        return value;
    }

    public int diagonalSum(int value) {
        int TL = 0 ; int TR = 0; int DL = 0 ; int DR = 0;

        if (V > 0 &&H >0) TL=grid[V-1][H-1];
        if (V >0 && H < n-1) TR=grid[V-1][H+1];
        if (V <n-1 && H >0) DL=grid[V+1][H-1];
        if (V <n-1 && H < n-1) DR=grid[V+1][H+1];

        return TL+TR+DL+DR;
        //format is : top:left,right ; Down : left,right
    }
}
class neighborSum {

    private int[][] grid;
    private Map<Integer, int[]> m;

    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.m = new HashMap<>();
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                m.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        int[] coord = m.get(value);
        int r = coord[0];
        int c = coord[1];
        int sum = 0;
        if (inBound(r-1, c)) {
            sum += grid[r-1][c];
        }
        if (inBound(r+1, c)) {
            sum += grid[r+1][c];
        }
        if (inBound(r, c-1)) {
            sum += grid[r][c-1];
        }
        if (inBound(r, c+1)) {
            sum += grid[r][c+1];
        }
        return sum;
    }

    public int diagonalSum(int value) {
        int[] coord = m.get(value);
        int r = coord[0];
        int c = coord[1];
        int sum = 0;
        if (inBound(r-1, c-1)) {
            sum += grid[r-1][c-1];
        }
        if (inBound(r+1, c+1)) {
            sum += grid[r+1][c+1];
        }
        if (inBound(r-1, c+1)) {
            sum += grid[r-1][c+1];
        }
        if (inBound(r+1, c-1)) {
            sum += grid[r+1][c-1];
        }
        return sum;
    }

    private boolean inBound(int r, int c) {
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length);
    }
}

