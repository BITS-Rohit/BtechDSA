package Btech.JAVA.Threads;

public class thread extends Thread{
    public void run(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("value of i : " + i);
            System.out.println("Timing ~~~ 3 sec delay in printing values ");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void main(String[] args){
        thread  t = new thread();
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName()+" :-> ");
        t.start();

    }
}

