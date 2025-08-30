package Btech.class_java.newwy;
/////////~      ~Q10~     ~///////////
class poly1 { void message (){System.out.println("Its 1st overriding method");}}
class poly2 extends poly1 { void message(){
    System.out.println("Its 2nd overriding method");
}}

class polymorphism  extends poly2
{
    int  square() {return 5 * 5;}
    double square(double x){ return x*x;}
    void message() { System.out.println("Its 3rd overriding method ");}
    public static void main(String[] args){
        polymorphism p = new polymorphism();
        System.out.println
                ("overloading Square 1st (5) :"+ p.square());
        System.out.println("overloading Square 1st (5.0) :"+ p.square(5.0));
        poly1 p1 = new poly1();
        p1.message();
        poly2 p2 = new poly2();
        p2.message();
        p.message();
    }
}
