package btech.Structures;

import java.util.*;

public class Trees {
    static class Node{
        int val ;
        Node next ;
        Node left;
        Node right ;
        Node(int val){
            this.val=val;
            this.next = null;
            this.left=null;
            this.right=null;
        }
    }
    // Interative preorder
    List<Integer> IterativePreorder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root== null )return list;
        Stack<Node> stacks  = new Stack<>(); // generic type Node class
        stacks.push(root);
        while(!stacks.isEmpty()){
            Node node = stacks.pop();
            list.add(node.val);
            if(node.right!=null)stacks.push(node.right);
            if(node.left!=null)stacks.push(node.left);
        }
        return list;
    }

    List<Integer> IterativeInOrder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root == null )return list;

        Stack<Node> stacks = new Stack<>();
        Node node = root;

        while ( node !=null ||!stacks.isEmpty()){
            while(node!=null){
                stacks.push(node);
                node=node.left;
            }
            node = stacks.pop();
            list.add(node.val);
            node=node.right;
        }
        return list;
    }

    List<Integer> IterativePostOrder(Node root){
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;

        Stack<Node> stacks = new Stack<>();

        return list;
    }

    boolean isCycleDFS(List<List<Integer>> adj){
        int n = adj.size();
        boolean[] visited = new boolean[n];

        for(int i =0  ; i < n ; i++){
            if(!visited[i]){
                if(DFS(i , -1 , visited, adj))return true;
            }
        }
        return false;
    }

    boolean DFS(int src , int parent , boolean[] visited , List<List<Integer>> adj){
        visited[src]=true;
        for(int neighbour : adj.get(src)){
            if(neighbour== parent)continue;
            else if (visited[neighbour])return true;
            else if(DFS(neighbour, src, visited, adj))return true;
        }

        return false ;
    }

    boolean isCycleBFS(List<List<Integer>> adj){
        int n = adj.size();
        boolean[] visited = new boolean[n];

        for(int i =0 ;i < n ; i ++){
            if(!visited[i]){
                if(BFS(i  , visited,adj))return true;
            }
        }

        return false;
    }
    boolean BFS(int src , boolean[] visited , List<List<Integer>> adj){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src,-1});
        visited[src]=true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0] , parent=pair[1];
            for(int nb : adj.get(node)){
                if(nb==parent)continue;
                else if ( visited[nb])return true;
                else {
                    queue.offer(new int[]{nb,node});
                    visited[nb]=true;
                }
            }
        }
        return false;
    }

    boolean dfs_isCycleinDAG(List<List<Integer>> adj ){
        // DFS approach , we will just use an extra array for the backtracking of the not visited nodes at that time
        int n = adj.size();
        boolean[] visited = new boolean[n];
        boolean[] backtrack = new boolean[n];

        for(int i =0 ; i< n ; i++){
            if(!visited[i] && dfs(i , visited, backtrack,adj)) return true;
        }
        return false;
    }

    boolean dfs( int src , boolean[] visited , boolean[] backtrack , List<List<Integer>>adj){
        visited[src]=true;
        backtrack[src]=true; // we are marking it right now true as if we found this again visited means we have found a cycle in directed graph

        for(int nb : adj.get(src)){
            if(!visited[nb] && dfs(nb,visited,backtrack,adj))return true;
            else if (backtrack[nb])return true;
        }
        backtrack[src]=false;
        return false;
    }

    boolean bfs_isCyclicInDAG(List<List<Integer>> adj){
        // we can use topo sort , if we found all nodes in the answer list then there is no cycle exists , else exists!
        // we have already given an adjancy list
        int n = adj.size();
        int[] degree = new int[n];

        // In-Degree creation
        for (List<Integer> integers : adj) {  // o(v+e)
            for (int nb : integers) {
                degree[nb]++;  // Counting the edge on each node
            }
        }

//        List<Integer> list = new ArrayList<>();
        int count =0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i =0 ; i < n ; i++){ // o(n)
            if(degree[i]==0)queue.offer(i); // if we find any node with In-Degree 0 we will add the node to the queue!
        }

        // Basic Graph Based Queue code
        while (!queue.isEmpty()){ // o(v+e)
            int node = queue.poll();
//            list.add(node);
            count++;
            for(int  nb : adj.get(node)){
                degree[nb]--; // breaking the edge hypothetically
                if(degree[nb]==0)queue.offer(nb); // if any node edges becomes 0 , add in queue
            }
        }
        // Total Time complexity = o(n)

//        return list.size()==n;
        return count!=n;  //  basically if we counted all the nodes and it got equal to the total nodes then no cycle , else cycle exists!
    }

    static class iPair{
        int first , second ;
        iPair(int f , int s ){
            first=f;
            second=s;
        }
    }

    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        ArrayList<Integer>  list = new ArrayList<>(Collections.nCopies(adj.size(),Integer.MAX_VALUE));
        list.set(src,0) ;

        Queue<iPair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        queue.offer(new iPair(src , 0));

        while(!queue.isEmpty()){
            iPair pair = queue.poll();
            int node = pair.first;// node with current distance
            int distance = pair.second; // node distance till now calculated
            for(iPair edges : adj.get(node)){
                // adj.get(node) is also a arraylist of ipair
                int nb = edges.first; // neighbour
                int nbdis =edges.second+distance;// W , neighbour distance
                if(nbdis<list.get(nb)){
                    list.set(nb,nbdis);
                    queue.offer(new iPair(nb,nbdis));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Trees t = new Trees();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(t.IterativePreorder(root));
        System.out.println(t.IterativeInOrder(root));
    }
}
