package rohit.lamdaFunctions;

import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Consumer;

public class lambda_function extends Vector<Integer>
//        implements SUM<Integer>
{
    public static void main(String[] args)  throws InterruptedException  {
        ArrayList<Integer> list =  new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(2*i +1);
        }
//        list.forEach(integer -> {
//            System.out.println(" "+integer*2);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
        Consumer<Integer> check = (integer) -> {
            System.out.println(2*integer+5);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        list.forEach(check);
//        lambda_function l = new lambda_function();
        SUM sum = Integer::sum;
        System.out.println(" sum of 1 and 1 ? "+sum);
}
//int sum(int a , int b ){
//        return a+b;
//}

//    @Override
//    public Integer sum(Integer a, Integer b) {
//        return a+b;
//    }

}
interface SUM{
    int sum(int a , int b);
}