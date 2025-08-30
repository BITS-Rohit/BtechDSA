package Btech.class_java.newwy;

class MyException extends Exception{
    public MyException(String s){
        super(s);
    }
}

public class user_exception {
    public static void main(String[] args)
    {
        try
        {
           throw new MyException("JAVA");
        }
        catch (MyException e)
        {
            System.out.println("Exception in Catch ");
        }
        System.out.println("HEHE HEHE");
    }
}
