package btech.PRACTICE.Recusion;

public class Main {

    public static void main(String[] args) {
        Recursive rec = new Recursive();
//        rec.sp(new int[]{2,4,8,16},32);

        Recursion2 rec2 = new Recursion2();
        int[] array = {1,6,5,11};
        rec2.mindiffsubset(array);
//        Queue<Integer> q = new LinkedBlockingQueue<>();
        rec2.mindiffsubset(array);

    }
}
