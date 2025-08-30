package Btech.class_java.newwy;
/////////////~      ~Q11~      ~//////////////
class person {
    int id;String name ;
    person(int id,String name)
    {
        this.id =id;
        this.name=name;
    }
}
class inherit1 extends person{
    float salary ;
    inherit1(int id ,String name ,float salary)
    {
        super(id, name);
        this.salary = salary;
    }
    void display (){
        System.out.println("Emp ID : "+id+", Name : "+ name +", Salary : "+salary);
    }
}
class inheritance {
    public static void main(String[] args){
        inherit1 in = new inherit1(12,"Rohit",500000);
        in.display();
    }
}
