package Btech.class_java.example;

public class recursion {
    static String rec1(String string, int times){
        if (string == null) return null;
        if (times==0) return "End";
        System.out.println(string);
        return rec1(string,times-1);
    }

    //  "num = 12354" and ans sh = 1+2+3+5+4

    static int sum(int n){
        if ( n ==0) return n;
        return (n%10)+sum(n/10);
    }
    static void fun(int n){
        if ( n==-1)return;
        System.out.println(n);
        fun(--n);
    }
    static int sum =0;
    static int reverse(int n){
        if ( n ==0) return n;
        int result =0;
        result+=(n%10);
        sum=sum*10+result;
        return  reverse(n/10);
    }
     static boolean isPalindrome(int num ){
        if (num == 0)  return true;
        reverse(num);
        return num == sum;
     }

     static int count=0;
     static int countZero(int n){
        if ( n==0)return 0;
        int rem = n%10;
        if (rem==0) {
            count++;
        }
        return countZero(n/10);
     }

     //To count number of steps to reduce a num to zero ...
    // if the num is even ; divide by 2 otherwise subtract -1 from the number ....
    static int steps;
    static void countSteps(int num ){
        if ( num ==0) {
            return ;
        }
        if ( num%2==0){
            steps++;
            countSteps(num/2);
        }
        if (num%2!=0){
            steps++;
           countSteps(num-1);
        }
    }

    ////// have to remove a from string //////

    static void remove(String ans,String str){
        str = str.toLowerCase();
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch == 'a'){
            remove(ans,str.substring(1));
        }
        else {
            remove(ans+ch,str.substring(1));
        }
    }

    public static void main(String[] args){

//        System.out.println(isPalindrome(12321));
//        countZero(100001);
//        System.out.println(count);

//        countSteps(14);
//        System.out.println("Steps : "+steps);


        remove( "","Adam");

    }
}
