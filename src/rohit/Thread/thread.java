package rohit.Thread;

public class thread extends Thread{
    private final Counter counter;

    thread(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 1000; i++){
                counter.increment();
//            System.out.println("Counter "+counter.getcount());
            }
    }
}
