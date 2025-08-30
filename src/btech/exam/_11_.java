package JAVA.exam;

//Write a Java program to compare two strings lexicographically.
//Two strings are lexicographically equal if they are the same length and contain the
//same characters in the same positions.
public class _11_ {
    public static void main(String[] args){
        String[] s1 = {"a","b","c"};
        String[] s2 = {"a","b","c"};

        if (s1.length==s2.length) {
            System.out.println("Size is same.");
            for (int i=0;i< s1.length; i++){
                if (s1[i].equals(s2[i])){System.out.println("Element " +i+" Equal");}
            }
        }
        System.out.println("These two strings are lexicographically equal..");
    }

}
