package JAVA.exam;
class parent{
    int s = 12;
    int v = 23;
    void dis1 (){System.out.println("parent : "+ s + "/n" + v);}
}
class parent2 extends parent{
    void d(){System.out.println("hi");}
    void dis1(){System.out.println(" super : "+ super.v);}// method overriding
}
public class overriding_method {
    public static void main(String[] args){
        System.out.println("Method overriding ");
        parent2 p = new parent2();
        p.dis1();
    }
}


