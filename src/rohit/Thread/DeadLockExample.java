package rohit.Thread;

class Pen{

    public synchronized void penUsing(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is uing pen "+this+"and trying for paper");
        paper.paperUsed();
    }
    public synchronized void penUsed(){
        System.out.println(Thread.currentThread().getName()+" is done using pen "+this);
    }
}

class Paper{

    public synchronized void paperUsing(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is uing paper "+this+"and trying pen");
        pen.penUsed();
    }
    public synchronized void paperUsed(){
        System.out.println(Thread.currentThread().getName()+" is done using paper "+this);
    }
}

class Task1 implements Runnable {

    private final Pen pen;
    private final Paper paper;

    Task1(Pen pen , Paper paoer){
        this.pen=pen;
        this.paper=paoer;
    }

    @Override
    public void run() {
        synchronized (paper){
            pen.penUsing(paper);
        }
    }
}

class Task2 implements Runnable{

    private final Pen pen;
    private final Paper paper;

    Task2(Pen pen , Paper paoer){
        this.pen=pen;
        this.paper=paoer;
    }

    @Override
    public void run() {
        synchronized (pen){
            paper.paperUsing(pen);
        }
    }
}

public class DeadLockExample {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread A = new Thread(new Task1(pen,paper),"A");
        Thread B = new Thread(new Task2(pen,paper),"B");

        A.start();
        B.start();

        System.out.println("Finished");
    }
}