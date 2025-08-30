package rohit.interfaces;

public interface Brake  extends Engine  {
    void brake();
    default void print(){
        this.brake();
    }
}
