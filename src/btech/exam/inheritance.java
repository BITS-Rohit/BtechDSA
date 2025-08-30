package JAVA.exam;

class in {
    //int  cost  = 12 ;
    //float  discount = 12f;
    void dis1(int cost , float  discount){System.out.println("Cost :"+ cost);
        System.out.println("Discount : "+ discount);}

}


// Normal inheritance ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//class inherit extends inheritance{
//    public static void main(String[] args){
//        inherit in = new inherit();
//        System.out.println("Inherited cost : "+ in.cost);
//        System.out.println("Inherited discount : "+ in.discount);
//    }
//}



// Single level inheritance ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//class single extends in {
//    void sin(){System.out.println("Single ");}
//}
//public class inheritance{
//    public static void main(String[] args){
//        single s = new  single();
//        s.sin();
//        s.dis1(12,34);
//    }
//}



// Multilevel inheritance~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//class in1 extends in{
//    void dis2(){System.out.println("SINGLE LEVEL INHERITANCE IN btech.JAVA");}}
//class in3 extends in1{
//    void dis3() {System.out.println("Multilevel : ");}}
//class inheritance {
//    public static void main(String[] args) {
//        in3 i = new in3();
//        i.dis1(12,345);
//        i.dis2();
//        i.dis3();
//    }
//}

//Hierarchy inheritance ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class Dog extends in {
    void dis2(){System.out.println("BARKING !!!!!!");}
}
class CAT extends Dog{
    void dis3(){System.out.println("MEOW!~~~");}
}
class inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.dis2();
        d.dis1(12,23);
        //  Can't print dis3 cuz CAT class don't have any objects in main method
    }
}

