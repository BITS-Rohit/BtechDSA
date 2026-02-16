package rohit.Thread.Practice;

//public class Test1 {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService execute = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 5; i++) {
//            int finalI = i;
//            execute.submit(() -> {
//                try {
//                    Thread.sleep(2000);
//                    System.out.println("Task %d Completed %s".formatted(finalI,Thread.currentThread().getName()));
//                } catch (InterruptedException | RejectedExecutionException e) {
//                    System.out.println("Interrupted");
//                    Thread.currentThread().interrupt();
//                }
//            });
//        }
//        execute.shutdown();
//        execute.awaitTermination(3, TimeUnit.SECONDS);
//    }
//}

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//class Test1{
//    static void Squaring(int value ){
//        System.out.printf("From %s is: %d"
//                , Thread.currentThread().getName()
//                ,value*value);
//        System.out.println();
//    }
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService execute = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 10; i++) {
//            int finali = i;
//            execute.submit(()-> Squaring(finali));
//        }
//        Thread.sleep(50);
//        // Additional tasks to see thread reuse
//        for (int i = 11; i <= 20; i++) {
//            int finali = i;
//            execute.submit(() -> {
//                System.out.println("New");
//                Squaring(finali);
//            });
//        }
//        execute.shutdown();
////        execute.shutdownNow();
//       // execute.awaitTermination(1, TimeUnit.SECONDS);
//        System.out.println("Done ");
//    }
//}
//class Test1{
//    static void reverse(String str){
//        StringBuilder string= new StringBuilder();
//        for (int i = str.length(); i >0 ; i--) {
//            string.append(str.charAt(i - 1));
//        }
//        System.out.printf("Reverse String: %s from %s \n"
//                , string
//                ,Thread.currentThread().getName());
//    }
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println();
//        ExecutorService execute = Executors.newCachedThreadPool();
//        String[] strings={"ima","Sugoi","modotte"};
//        long starttime = System.nanoTime();
//        for (String str : strings) {
//            execute.submit(() -> reverse(str));
//        }
//        execute.shutdown();
//        execute.awaitTermination(1, TimeUnit.SECONDS);
//        System.out.println(execute.isTerminated());
//    }
//}
class Test1{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
            () -> { Thread.sleep(1000); return "Task 1"; },
            () -> { Thread.sleep(1000); return "Task 2"; },
            () -> { Thread.sleep(1000); return "Task 3"; }
        );

        String result = executor.invokeAny(tasks);

//        System.out.println("First completed task result: " + result);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        CountDownLatch latch= new CountDownLatch(3);
        // Single Delay Scheduling

//        scheduler.schedule(() -> {
//            System.out.println("Single Delay Task executed at: " + System.currentTimeMillis());
//        }, 4, TimeUnit.SECONDS);
//        for (int i = 1; i <= 4; i++) {
//            Thread.sleep(900);
//            System.out.println(i);
//        }
        // Fixed-Rate Scheduling
//        scheduler.scheduleAtFixedRate(() -> {
//            System.out.println("Fixed-Rate Task executed at: " + System.currentTimeMillis());
//        }, 1, 5, TimeUnit.SECONDS);

//         Fixed-Delay Scheduling
        scheduler.scheduleWithFixedDelay(() -> {
            System.out.println("Fixed-Delay Task executed at: " + System.currentTimeMillis());
        }, 2, 3, TimeUnit.SECONDS);
//        System.out.println(executor.isShutdown());
        executor.shutdown();
//        System.out.println(executor.isShutdown());

    }
}