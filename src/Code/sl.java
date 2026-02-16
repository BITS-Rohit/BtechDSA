package Code;

public class sl {

    public static void main(String[] args) {

    }
}

//////////////////////////////////////////////////////////////////////////////////////
//Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        Book b = new Book();
//        b.givetitle(s);
abstract class book {
    String title;
    abstract void givetitle(String s);
}

class Book extends book {
    @Override
    void givetitle(String s) {
        System.out.println("The title is: " + s);
    }
}
//////////////////////////////////////////////////////////////////////////////////////
//Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        AA a = new AA();
//        System.out.println("I implemented: AdvancedArithmetic");
//        System.out.println(a.divisorSum(n));
interface AdvancedArithmetic{
    int divisorSum(int n );
}
class AA implements AdvancedArithmetic{
    @Override
    public int divisorSum(int n){
        int sum = 0 ;
        for (int i = 1; i <= n; i++) {
            if (n%i==0)sum+=i;
        }
        return sum;
    }
}
//////////////////////////////////////////////////////////////////////////////////////
//        Sports s = new Sports();
//        Sports sp = new Soccer();
//        System.out.println(s.getName());
//        s.getNumberOfTeamMembers();
//        System.out.println(sp.getName());
//        sp.getNumberOfTeamMembers();
class Sports{
    String getName(){
        return "Generic Sports";
    }
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has n players in " + getName() );
    }
}
class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer Class";
    }
    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has 11 players in " + getName() );
    }
}
//////////////////////////////////////////////////////////////////////////////////////
//Ancestor a = new Ancestor();
//        a.print();
class Cycle {
    String getcycle(){
        return "I am a cycle with an engine.";
    }
}
class Motorcycle extends Cycle{
    String  getmotor(){
        return "Hello I am a motorcycle, "+super.getcycle();
    }
}
class Ancestor extends Motorcycle{
    void print(){
        System.out.println(super.getmotor());
        System.out.println("My ancestor is a cycle who is a vehicle with pedals.");
    }
}