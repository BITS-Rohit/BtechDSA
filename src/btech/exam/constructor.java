package JAVA.exam;
public class constructor{
    int id ;String str ;int age ;
    constructor(int i , String st ){
         id = i;
         str = st;
    }
    constructor(int i , String k, int a){
        id = i;
        str = k;
        age =  a ;
    }
    void display(){System.out.println(id + " "+ str + " "+ age );}
    public static void main(String[] args) {
        constructor s1 = new constructor(1,"OPERATION");
        constructor s2 = new constructor(2, "OPERATION",12);
        s1.display();
        s2.display();
    }
}
