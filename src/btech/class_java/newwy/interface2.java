package Btech.class_java.newwy;
////////////////~    ~Q12~   ~/////////////////

interface  walking{ void walk();}
interface  running{ void run();}
class interface1 implements walking,running{
    @Override
    public void walk() {
        System.out.println("~    Walking    ~");
    }
    @Override
    public void run() {
        System.out.println("~    Running    ~");
    }
}
class interface2 extends interface1{
    public static void main(String[] args) {
        interface2 in = new interface2();
        in.run();
        in.walk();
    }
}
