package rohit.Thread.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TP {
    private  static final int max = 100;
    private static int counter=1;
    final Object lock  = new Object();
    final int n = 0 ;

    void Even() throws InterruptedException {
        synchronized (lock) {
            while (counter <= max) {
                if (counter % 2 == 0) {
                    System.out.println("Even: " + counter);
                    counter++;
                    lock.notifyAll();
                } else {
                    lock.wait();

                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false; // 0 and 1 are not prime numbers
        if (number == 2) return true;  // 2 is the only even prime number
        if (number % 2 == 0) return false;

        // Check divisibility from 3 to sqrt(number)
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false; // Number is divisible by i
        }

        return true; // Number is prime
    }
    void ODD() throws InterruptedException {
        synchronized (lock) {
            while (counter <= max) {
                if (counter % 2 != 0) {
                    System.out.println("Odd: " + counter);
                    counter++;
                    lock.notifyAll();
                } else {
                    lock.wait();
                }
            }
        }
    }
    private static final ArrayList<Integer> array=new ArrayList<>();
    private static final ArrayList<Integer> array2=new ArrayList<>();
    static void FixedRange(int s , int e ){
        for (int i = s; i <=e ; i++) {
            if (isPrime(i)) {
                array.add(i);
                array2.add(i);
//                System.out.println("Prine: %d from Thread %s".formatted(i,Thread.currentThread().getName()));
            }
        }
    }

    static void arraysummer(ArrayList<Integer>aray){
        int sum =0;
        for (Integer integer : aray) {
            sum += integer;
        }
        System.out.printf("Sum: %d from %s%n", sum,Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 2;
        int range =  500/n;
        ExecutorService exe = Executors.newFixedThreadPool(n);
        int start = range ;
        int end = range*2 ;
        for (int i = 0; i < n; i++) {
            if (i ==0){
                start=0;
                end=range;
            }
            else {
                start += range;
                end += range ;
            }

//            System.out.println("Start = "+start);
//            System.out.println("end = "+end);
            int Threadstart = start;
            int Threadend = end;

            exe.submit(() -> FixedRange(Threadstart,Threadend));
        }
        array.add(34);
        array.add(64);
        array.add(32424);
        array.add(344);
        array.add(34034);
        List<ArrayList<Integer>> list = new ArrayList<>();
        list.add(array);
        list.add(array2);
        long Start = System.currentTimeMillis();

        for (ArrayList<Integer> fi : list) {
            exe.submit(() -> arraysummer(fi));
        }


        exe.shutdown();
        exe.awaitTermination(1,TimeUnit.MINUTES);
//        System.out.println("total Counts of array 1 : "+array.size());
//        System.out.println("total Counts of array 2 : "+array2.size());

        System.out.println("Execution time: "+(System.currentTimeMillis()-Start)/1000.0);

    }

//    public static void main(String[] args) throws InterruptedException {
//        Thread timer = new Thread(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(1000);
//                    Thread.ofPlatform().name("Thread - A");
//                    Thread s = Thread.currentThread();
//                    s.setName("Thread - A");
//                    System.out.println(s.getName()+" (-_-) "+s.getState());
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        });
//        timer.start();
//        timer.join();
//        System.out.println("Time's Up");
//    }

//    public static void main(String[] args)  {
//        TP tp = new TP();
//        Thread Even = new Thread(()->{
//            try {
//                tp.Even();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//        Thread Odd = new Thread(()->{
//            try {
//                tp.ODD();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//
//        Even.start();
//        Odd.start();
//}
//    }
//    public static void main(String[] args) {
//        System.out.println("\n Enter n : ");
//        int n = new Scanner(in).nextInt();
//        String[] str  = {"A","B","C","D","E"};
//        Thread[] threads  = new Thread[n];
//        for (int i = 0; i < n; i++) {
//            String fs = str[i];
//            threads[i]=new Thread(()-> {
//                System.out.println("Hello from Thread "+Thread.currentThread().getName());
//                },fs);
//            threads[i].start();
//        }
//        new Scanner(in).close();
//    }

}
