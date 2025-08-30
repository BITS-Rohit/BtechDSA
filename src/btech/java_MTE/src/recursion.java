

public class recursion {
    public static void main(String[] args) {
        int n = 7;
//        System.out.println(fac(n));
        int a = 0 ;
        int b =1 ;
        fib(a,b, n);

    }
    public  static int fac (int n){
        if (n ==1|| n ==0){
            return 1;
        }
      int f =  fac(n-1);
        return n* f;
    }
    public static void fib(int a, int b , int n){
        int c = a + b ;
        if (n==0){return;}
        System.out.println(c);
        fib(b,c,n-1);
    }
}
