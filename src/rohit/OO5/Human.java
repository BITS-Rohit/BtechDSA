package rohit.OO5;

public class Human {
    int age ;
    String name;
    long salary ;
    boolean marriage ;
    static int population;

    Human(int age , String name , long salary , boolean marriage){
        this.age=age;
        this.name=name;
        this.salary=salary;
        this.marriage= marriage;
        population+=1;
    }
}
class box{
    private double l ;
    protected double w ;
    double h ;

    box(double l , double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    public box() {
        super();
    }
}
