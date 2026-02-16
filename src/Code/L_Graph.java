package Code;

import java.util.*;

public class L_Graph {

    public int findCenter(int[][] edges) {
        //--------------Brute Force(Degree)----------------
//        int[] arr = new int[edges.length+2];
//        int max =0;
//
//        for(int[] a : edges){
//            int u = a[0];
//            int v = a[1];
//
//            arr[u]++;
//            arr[v]++;
//        }
//        for(int i =0; i<arr.length; i++)if(arr[max]<arr[i])max=i;
//        return  max;

        //-------------------optmised-----------------
        if (edges[0][0] == edges[1][0]) return edges[1][0];
        else if (edges[0][0] == edges[1][1]) return edges[1][1];
        else if (edges[0][1] == edges[1][0]) return edges[1][0];
        else return edges[1][1];
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] bool = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!bool[i]) dfs(i, bool, adj, list);
        }
        return list;
    }

    void dfs(int i, boolean[] bool, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list) {
        bool[i] = true;
        list.add(i);

        for (int a : adj.get(i)) {
            if (!bool[a]) dfs(a, bool, adj, list);
        }
    }


    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] bool = new boolean[adj.size()];

        bool[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            list.add(n);
            for (int a : adj.get(n)) {
                if (!bool[a]) {
                    bool[a] = true;
                    queue.add(a);
                }
            }
        }
        return list;
    }


    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] bool = new boolean[row][col];
        int c=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                if(grid[i][j]=='1' && !bool[i][j]){
                    DFSlands(grid,i,j,bool);
                    c++;
                }
            }
        }
        return c;
    }

    private void DFSlands(char[][] grid, int i, int j, boolean[][] bool) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == '0' || bool[i][j]) return;

        bool[i][j] = true;

        DFSlands(grid, i - 1, j, bool); // Up
        DFSlands(grid, i + 1, j, bool); // Down
        DFSlands(grid, i, j - 1, bool); // Left
        DFSlands(grid, i, j + 1, bool); // Right
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        List<List<String >> ans  = new ArrayList<>();
        if (!words.contains(endWord)) return ans;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 1;

        int min =Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String > list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                list.add(node);
                if (node.equals(endWord)) {
                    min=Math.min(min,level);
                    ans.add(new ArrayList<>(list));
                    list=new ArrayList<>();
                }
                for (String neighbor : getneighbour(node)) {
                    if (words.contains(neighbor)) {
                        queue.add(neighbor);
                        words.remove(neighbor);
                    }
                }
            }
            level++;
        }
        for(List<String> x : ans){
            if(x.size()>min)ans.remove(x);
        }
        return ans;
    }

    private List<String> getneighbour(String node) {
        List<String> neighbors = new ArrayList<>();
        char[] arr = node.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char originalChar = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                arr[i] = c;
                neighbors.add(new String(arr)); // No need to check wordSet here
            }
            arr[i] = originalChar;
        }
        return neighbors;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String ,Double>> map = new HashMap<>();

        for(int i =0 ; i<equations.size();i++){

            String divident = equations.get(i).get(0);
            String divsor = equations.get(i).get(1);
            double res = values[i];

            if(!map.containsKey(divident))map.put(divident, new HashMap<>());
            if(!map.containsKey(divsor))map.put(divsor, new HashMap<>());

            map.get(divident).put(divsor,res);
            map.get(divsor).put(divident,1/res);
        }
        double[] res = new double[queries.size()];
        int  i=0;
        for(List<String> query : queries){
            String divident = query.get(0);
            String divsor = query.get(1);

            if(map.containsKey(divident) && map.containsKey(divsor)){
                if(divident.equals(divsor))res[i++]=1.0;
                else {
                    HashSet<String > visited = new HashSet<>();
                    res[i++]=dfsdivide(divident,divsor,1,visited,map);
                }
            }
            else res[i++]=-1.000;
        }
        return res;
    }

    private double dfsdivide(String src, String target, double product, HashSet<String> visited, HashMap<String, HashMap<String, Double>> map) {
        if (map.get(src).containsKey(target)) return product * map.get(src).get(target);
        visited.add(src);

        for (String neighbor : map.get(src).keySet()) {
            if (!visited.contains(neighbor)) {
                double result = dfsdivide(neighbor, target, product * map.get(src).get(neighbor), visited, map);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        L_Graph lg = new L_Graph();
        System.out.println(lg.findCenter(new int[][]{{1, 2}, {2, 3}, {4, 2}}));
    }
}
