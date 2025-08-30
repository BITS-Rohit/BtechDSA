package btech.PRACTICE.StackNQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class stack {
    public static void main(String[] args){
        Queue<Integer> q = new PriorityQueue<>();
        Stack<Integer> s = new Stack<>();
        s.push(34);
        s.push(5);
        s.push(31);
        s.push(2);
        s.push(4);
        s.push(76);
        s.push(45);
        System.out.println("popped item -> "+s.pop());
        System.out.println("Peeked at : "+s.peek());
        System.out.println(s.add(4));
        System.out.println("Empty showcase : "+s.empty());
        System.out.println("Capacity : "+s.capacity());
        System.out.println(s.search(45));
        System.out.println(s.contains(45));
        System.out.println("index at 0 "+s.elementAt(0));
        System.out.println("index at 1 "+s.elementAt(1));
    }
}
