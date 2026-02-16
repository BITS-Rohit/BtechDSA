package rohit.OO5;

public class polymorphism  {
    @Override
    public String toString() {
        return "polymorphism{}";
    }

    public static void main(String[] args) {
        polymorphism p = new polymorphism();
        System.out.println(p.sum(2,4));
        polymorphism p1 = new override();
        System.out.println(p1.sum(2,4));
        System.out.println(p1 +"\n"+p);

//        p.sum(2.3,2);
    }

    static double sum (double a , int b ){
        return Double.parseDouble(String.valueOf(a*b));
    }
//    int sum (int a , int b ){
//        return 0;
//    }
}
class override extends polymorphism{
//    @Override
    static double sum (double a , int b ){
        return 0;
    }
}
class overloadung extends override{
    void show (){
        System.out.println("The Lund game ");
    }
}