package rohit.Thread;

public class Counter {

    private  int count = 0;
    void increment() {
        synchronized (this){
            count++;
        }
    }
    int getcount(){
        return count;
    }
}
