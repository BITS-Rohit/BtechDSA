package rohit.interfaces;

public class powerEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Start the powerEngine");
    }

    @Override
    public void stop() {
        System.out.println("Stop the powerEngine");
    }

    @Override
    public void ACC() {
        System.out.println("ACC the PowerEngine");
    }

    @Override
    public void brake() {
        System.out.println("Brake the powerEngine");
    }
}
