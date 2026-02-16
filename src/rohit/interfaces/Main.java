package rohit.interfaces;



public class Main {
    private final Engine engine;

    public Main(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }

    public static void main(String[] args) {
        Main m1 = new Main(new CAR());
        m1.startEngine();

        Main m2 = new Main(new powerEngine());
        m2.startEngine();
    }
}
