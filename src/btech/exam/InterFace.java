package JAVA.exam;
interface  shop{
    void cost();
}
interface Restaurant{
    void salary();
}
 class InterFace implements shop,Restaurant {
    public void cost(){System.out.println("$100");}
     public void salary(){System.out.println("$500");}

     public static void main(String[] args) {
        InterFace in = new InterFace();
        in.cost();
        in.salary();
     }
}
