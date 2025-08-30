package rohit.OO5;

public abstract class Parent {
    abstract void Goal();
    abstract void career();
    abstract String partner(String name, int age );


    public int getAge() {
        return age;
    }

    final private int age ;

    Parent(int age) {
        this.age = age;
    }
    final static private String Gender = "M";

}
