package JAVA.exam;
abstract class bike{
    abstract void run();
}
class abstraction extends bike{
    void run(){
        System.out.println("YO its me abstraction");
    }
    void display(){System.out.println("Loyal");}
    public static void main(String[] args){
        System.out.println();
        bike b = new abstraction();
        b.run();
    }
}
