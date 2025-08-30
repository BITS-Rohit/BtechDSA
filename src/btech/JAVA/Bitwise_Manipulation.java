package JAVA.JAVA;

public class Bitwise_Manipulation {
//    (1)And ----  if both are true then it will be true
//                  a   |   b
//                  ----|-----
//                  0   |   1   =   0
//                  0   |   0   =   0
//                  1   |   1   =   1
//                  1   |   0   =   0

//    when we multiply 1 with any number digits remains the same
//                          1   1   1   0   0   1
//                          1   1   1   1   1   1
//                          ---------------------
//                          1   1   1   0   0   1
//                          ---------------------

//    (2) OR ----- if any one is true it will be true
//                  a   |   b
//                  ----|-----
//                  0   |   1   =   1
//                  0   |   0   =   0
//                  1   |   1   =   1
//                  1   |   0   =   1


//    (3) XOR ------ if and only if 1 is true then true otherwise false
//                  a   |   b
//                  ----|-----
//                  0   |   1   =   1
//                  0   |   0   =   0
//                  1   |   1   =   0
//                  1   |   0   =   1

//              Observations---------->>>>
//     **       a ^ 1 = not a
//     **       a ^ 0 = a
//     **       a ^ a = 0

//     (4)  Compliments --------------
//               -->           1   0   1   0   1   1
//                             ---------------------
//               -->           0   1   0   1   0   0

//    --------------________________+++++++++++++________________----------------
//                                =================
//                                  NUMBER SYSTEM
//                                =================
//    ______________----------------+++++++++++++----------------________________

//    1. DECIMAL => 0---9
//              EX -> 357 BASE 10
//    2. BINARY  => 0,1
//              EX -> 10 BASE 10 = (1010) BASE 2
//    3. OCTAL => 0---7 (BASE 8)
//    4. HEXADECIMAL => 0--9,A,B,C,D,E,F 
//
//     (5) Left Shift operator ----------------
//              (<<) === it shift the digits to left
//              ALso means = a << 2a
//              ALso means = a << b = a * 2^b
//
//     (6) Right shift operator
//              (>>) === if just shift the digits to the right
//              General Point = a >> b = a/2^b
//

    public static void main(String[] args) {
        int n = 67;
        System.out.println(EvenOdd(n));
        int[] arr = {1,2,3,6,2,1,3,6,7};
        System.out.println("\n "+dup_num(arr));
    }

    static boolean EvenOdd(int n ){
        return (n&1)==1;
    }

    static int dup_num(int[] arr ){
        int res = 0 ;
        for (int n : arr){
            res^=n;
        }
        return res;
    }

    static boolean ithFind(int n ){
        return false;
    }
}