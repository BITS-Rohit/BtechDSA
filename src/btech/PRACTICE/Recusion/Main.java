package btech.PRACTICE.Recusion;

public class Main {

    public static void main(String[] args) {
        JAVA.PRACTICE.Recusion.Recursive rec = new JAVA.PRACTICE.Recusion.Recursive();
//        rec.sp(new int[]{2,4,8,16},32);

        JAVA.PRACTICE.Recusion.Recursion2 rec2 = new JAVA.PRACTICE.Recusion.Recursion2();
        int[] array = {1,6,5,11};
        rec2.mindiffsubset(array);
//        Queue<Integer> q = new LinkedBlockingQueue<>();
        rec2.mindiffsubset(array);

    }
}
