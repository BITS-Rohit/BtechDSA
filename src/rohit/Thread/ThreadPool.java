package rohit.Thread;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    static synchronized BigInteger fac(BigInteger n) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 50; i++) {
            int finalI = i;
            executor.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });

        }
        executor.shutdown();
        try {
            while (!executor.awaitTermination(1, TimeUnit.SECONDS)){}
        System.out.println("Total time " + ((System.currentTimeMillis() - startTime))/1000.0);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        executor.close();
    }

    private static long factorial(int n) {
    try {Thread.sleep(1000);}
    catch (InterruptedException e) {Thread.currentThread().interrupt();}
    long result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
    }
}

//    public static void main(String[] args) {
//        AtomicLong size = new AtomicLong();
//        AtomicLong Active = new AtomicLong();
//        long startTime = System.currentTimeMillis();
//        int n = 99 + 1;
//        ExecutorService exe = Executors.newCachedThreadPool();
//        ThreadPoolExecutor pool = (ThreadPoolExecutor) exe;
//
//        // Submit tasks
//        for (int i = 1; i <= n; i++) {
//            BigInteger finalI = BigInteger.valueOf(i);
//            exe.submit(() -> {
//                for (int j = 1; j <= n; j++) {
//                    System.out.println(fac(finalI));
//                    size.set(((ThreadPoolExecutor) exe).getPoolSize());
//                    Active.set(((ThreadPoolExecutor) exe).getActiveCount());
//                }
//            });
//
//        }
//
//        // Shutdown and wait for termination
//        exe.shutdown();
//        try {
//            if (!exe.awaitTermination(1, TimeUnit.MINUTES)) {
//                System.out.println("Timed out waiting for thread pool to terminate");
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        // Print thread pool statistics
//        System.out.println("Active Threads : " + Active);
//        System.out.println("Pool size : " + size);
//        System.out.println("Core Pool Size : " + pool.getCorePoolSize());
//        System.out.println("Maximum Pool Size : " + pool.getMaximumPoolSize());
//        System.out.println("Completed Task Count : " + pool.getCompletedTaskCount());
//        System.out.println("Time Taken in Sec : " + (System.currentTimeMillis() - startTime) / 1000.0);
//        exe.close();
//    }

