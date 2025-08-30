package JAVA.exam;

public class threads extends  Thread{
    public void run(){
        System.out.println("Running thread name is : "+ Thread.currentThread().getName());
        System.out.println("Running priority is : "+ Thread.currentThread().getPriority());
    }
    public static void main(String[] args){
        threads t = new threads();
        threads t2 = new threads();
        t.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t.start();
        t2.start();
    }
}
