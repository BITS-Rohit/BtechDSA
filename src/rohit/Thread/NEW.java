package rohit.Thread;


import java.util.concurrent.*;
import java.util.logging.Logger;

public class NEW {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Logger logger = Logger.getLogger(NEW.class.getName());
        ExecutorService exe = Executors.newFixedThreadPool(3);

        System.out.println("-------------------------------");

        Future<?> submit1 = exe.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("print : " + i);
            }
        },"Succes");
//        exe.shutdownNow();
        submit1.get();
        System.out.println("Get Released ..");
        Future<?> submit = exe.submit(() -> "Hello");

        // Check if the task is cancelled
        if (!submit.isCancelled()) {
            System.out.println("Cancelled: " + submit.cancel(true));
        } else {
            System.out.println("Not cancelled ");
        }

        // Check if the task is done
        if (submit.isDone()) {
            System.out.println("IS DONE? " + submit.isDone());
            // Try to get the result if done
            try {
                System.out.println("Result: " + submit.get());
            } catch (CancellationException e) {
                System.out.println("Task was cancelled.");
            } catch (ExecutionException e) {
                System.out.println("Task encountered an exception: " + e.getCause());
            }
            finally {
                exe.close();
            }
        }



//        exe.shutdown();
//        try {
//            if (!exe.awaitTermination(1, TimeUnit.NANOSECONDS)) {
//                System.out.println("Timed out waiting for executor service to terminate");
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }

    }
}
