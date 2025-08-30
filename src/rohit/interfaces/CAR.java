package rohit.interfaces;

public class CAR implements Engine ,Brake{
    @Override
    public void brake() {
        System.out.println("Brake Function for the car ");
    }

    @Override
    public void print() {
        brake();
    }

    @Override
    public void start() {
        System.out.println(
                "Start function for the car"
        );
    }

    @Override
    public void stop() {
        System.out.println(
                "Stop function for the car"
        );
    }

    @Override
    public void ACC() {
        System.out.println(
                "Acc function for the car"
        );
    }

}
