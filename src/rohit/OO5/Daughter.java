package rohit.OO5;



public class Daughter extends Parent{
    @Override
    void Goal(){
        System.out.println("I am in Daughter in son class");
    }
    @Override
    void career(){
        System.out.println("I am in Career in Daughter class");
    }

    @Override
    String partner(String name, int age) {
        return " No one bruh ";
    }

    public Daughter(int age) {
        super(age);
    }
//    abstract String partner(String name, int age );
}
