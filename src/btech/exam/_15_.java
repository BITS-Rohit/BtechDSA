package JAVA.exam;//Design a class named Circle. Construct three circle objects with radius 3.0, 3.2 4.1
//and display the radius and area of each. A no-arg constructor set the default value of
//radius to 1. A getArea() function us used to return the area of circle. Now implement
//the class

public class _15_ {
    public static void main(String[] args){
        float c1 = 3.0F;
        float c2 = 3.2F;
        float c3 = 4.1F;
        System.out.println(getclass((int) c1, (int) c2, (int) c3));
    }
    public static float getclass(int c1 ,int c2 , int c3) {
        int A1 =  (22/7 *(c1*c1));
        int A2 =  (22/7 *(c2*c2));
        int A3 =  (22/7 *(c3*c3));
        System.out.println("1st Area : "+A1);
        System.out.println("2nd Area : "+A2);
        System.out.println("3rd Area : "+A3);
        return 0;
    }
}
