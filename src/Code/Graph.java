package Code;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    static class Pair {
        int nodes;
        int weight;

        Pair(int n, int w) {
            nodes = n;
            weight = w;
        }

        @Override
        public String toString() {
            return "(" + nodes + ", " + weight + ")";
        }
    }

    private int[][] adMatrix;
    private List<List<Integer>> list;
    private List<List<Pair>> weightedList;

    Graph(int nodes) {
        adMatrix = new int[nodes][nodes];
        list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) list.add(new ArrayList<>());
        weightedList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) weightedList.add(new ArrayList<>());
    }

    void clearM() {
        adMatrix = new int[adMatrix.length][adMatrix.length];
    }

    void clearL() {
        list = new ArrayList<>();
    }

    void clearWL() {
        weightedList = new ArrayList<>();
    }

    void AddEdges(int[][] edges, boolean isdirected) {
        // [ [0,1] [0,2] [2,3] ]
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            //Directed
            if (isdirected) adMatrix[u][v] = 1;

                //Un-Directed
            else {
                adMatrix[u][v] = 1;
                adMatrix[v][u] = 1;
            }
        }
    }

    void AddEdgesList(int[][] edges, boolean isdirected) {
        // [ [0,1] [0,2] [2,3] ]
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            //Directed
            if (isdirected) list.get(u).add(v);

                //Un-Directed
            else {
                list.get(u).add(v);
                list.get(v).add(u);
            }
        }
    }


    void AddEdgesWightList(int[][] edges, boolean isdirected) {
        // [ [0,1] [0,2] [2,3] ]
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            //Directed
            Pair p = new Pair(v, w);
            if (isdirected) weightedList.get(u).add(p);

                //Un-Directed
            else {
                weightedList.get(u).add(p);
                weightedList.get(v).add(new Pair(u, w));
            }
        }
    }


    void AddEdgesWeights(int[][] edges, boolean isdirected) {
        // [ [0,1,10] [0,2,20] [2,3,30] ]
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];

            //Directed
            if (isdirected) adMatrix[u][v] = w;

                //Un-Directed
            else {
                adMatrix[u][v] = w;
                adMatrix[v][u] = w;
            }
        }
    }


    void DisplayGraph() {
        int i = 0;
        for (int[] arr : adMatrix) {
            System.out.print("row =" + i + "  | ");
            for (int ar : arr) System.out.print(ar + " | ");
            System.out.println();
            i++;
        }
    }


    void DisplayList() {
        int i = 0;
        for (List<Integer> l : list) {
            System.out.println(i + "-> " + l);
            i++;
        }
    }


    void DisplayWeightedList() {
        int i = 0;
        for (List<Pair> pair : weightedList) {
            System.out.println(i + "-> " + pair);
            i++;
        }
    }

    void getDegreeList(int[][] edges, boolean isdirected) {

        List<Integer> indegree = null;
        List<Integer> outdegree = null;
        List<Integer> degree = null;

        if (isdirected) {
            indegree = new ArrayList<>();
            outdegree = new ArrayList<>();

        }
        else degree = new ArrayList<>();

        for(int i = 0 ; i<=3; i++){
            if(isdirected){
                indegree.add(0);
                outdegree.add(0);
            }
            else degree.add(0);
        }

        for (int[] arr : edges) {
            int start = arr[0];
            int end = arr[1];

            if (isdirected) {
                indegree.set(end, indegree.get(end) + 1);
                outdegree.set(start, outdegree.get(start) + 1);
            } else {
                degree.set(start, degree.get(start) + 1);
                degree.set(end, degree.get(end) + 1);
            }
        }

        if(isdirected){
            for (int i = 0; i <=list.size() ; i++) {
                System.out.println("Node "+i+"= indegree : "+indegree.get(i) + " outdegree: "+outdegree.get(i));
            }
        }
        else {
            for(int i = 0 ; i<degree.size(); i++){
                System.out.println("Node = "+i+" degree: "+degree.get(i));
            }
        }
    }

}

class CheckGraphs {
    public static void main(String[] args) {
//        Graph g = new Graph(4);
////        g.DisplayGraph();
//        g.AddEdges(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, true);
//        System.out.println();
//        g.DisplayGraph();
//
//        System.out.println(" New Graph ");
//        Graph g2 = new Graph(4);
////        g2.DisplayGraph();
//        g2.AddEdgesWeights(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, false);
//        System.out.println();
//        g2.DisplayGraph();

//        Graph g = new Graph(4);
////        g.DisplayGraph();
//        g.AddEdgesList(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, false);
//        System.out.println();
//        g.DisplayList();

//        System.out.println(" New Graph ");
//        Graph g2 = new Graph(4);
//        g2.DisplayGraph();
//        g2.AddEdgesWeights(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, false);
//        System.out.println();
//        g2.DisplayGraph();

//        Graph g = new Graph(4);
////        g.DisplayGraph();
//        System.out.print("Undirected");
//        g.AddEdgesWightList(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, false);
//        System.out.println();
//        g.DisplayWeightedList();
//        System.out.println();
//
//        System.out.println("New graph");
//        System.out.println();
//
//        Graph g2 = new Graph(4);
////        g.DisplayGraph();
//        System.out.print("directed");
//        g2.AddEdgesWightList(new int[][]{{0, 2, 20}, {0, 1, 10}, {2, 3, 30}}, true);
//        System.out.println();
//        g2.DisplayWeightedList();


        Graph g2 = new Graph(3);
        System.out.println("Directed");
        g2.getDegreeList(new int[][]{{0, 2}, {0, 1}, {1, 3}}, true);

        System.out.println("\n Undirected");
        g2.getDegreeList(new int[][]{{0, 2}, {0, 1}, {1, 3}}, false);
    }
}
