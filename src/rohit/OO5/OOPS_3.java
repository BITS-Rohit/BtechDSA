package rohit.OO5;

public class OOPS_3 {
    public static void main(String[] args) {
        Boxweight b = new Boxweight(1,2,3,4);
        System.out.println(b.h +" "+ b.w+ " "+ b.h+ " "+b.weight);

        polymorphism p = new override();
        System.out.println(polymorphism.sum(2,3));
        box b1 = new box();
        int n = (int) b1.w;
//        box b1 = new Boxweight(1,23,5,4);
//        System.out.println(b1.w);
    }
}
class Boxweight extends box{
    protected double weight;
    Boxweight(){
        super();
        this.weight=0;

    }
    Boxweight(double l, double w, double h,double weight) {
        super(l, w, h);
        this.weight= weight;
    }
}
//class LL extends Boxweight {
////    static class LinkedList{
////        int head;
////        LinkedList next;
////        int data;
////        LinkedList(int data){
////            this.head=data;
////            this.next=null;
////        }
////    }
//
//    int l ;
//    int w ;
//    int h ;
//    int weight ;
//    LL(int l,int w,int h,int weight){
//        this.l=l;
//        this.w=w;
//        this.h = h;
//        this.weight=weight;
//    }
//}
