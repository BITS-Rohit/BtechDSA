package rohit.OO5;



public class son extends Parent{
    @Override
    void Goal(){
        System.out.println("I am in Goal in son class");
    }
    @Override
    void career(){
        System.out.println("I am in Career in son class");
    }
    @Override
    String partner(String name, int age ){
        return name+" "+age;
    }

    public son(int age) {
        super(age);
    }
}
