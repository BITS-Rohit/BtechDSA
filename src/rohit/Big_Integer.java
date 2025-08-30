package rohit;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;

public class Big_Integer {
    public boolean checkInclusion(String p , String s2){
        int[] frequency = new int[26];
        for(char ch : p.toCharArray()){
            frequency[ch-'a']++;
        }
        int left = 0 , right = 0 , idx = p.length();
        while(right<s2.length()){
            if (frequency[s2.charAt(right)-'a']>0) idx--;
            frequency[s2.charAt(right)-'a']--;
            right++;
            if (idx==0) return true;
            if (right-left==p.length()) {
                if (frequency[s2.charAt(left)-'a']>=0){
                    idx++;
                }
                frequency[s2.charAt(left)-'a']++;
                left++;
            }
            right++;
        }
        return false;
    }
    public static void main(String[] args) {
//        BigInteger bigA = new BigInteger("40000000000000000000000000000334542352352522353252300");
//        BigInteger bigB = new BigInteger("300");
//        if (bigA.compareTo(bigB) < 0) {
//            System.out.println(bigA + " is less than " + bigB);
//        } else if (bigA.compareTo(bigB) > 0) {
//            System.out.println(bigA + " is greater than " + bigB);
//        } else {
//            System.out.println(bigA + " is equal to " + bigB);
//        }

//        BigInteger primeCheck = new BigInteger("1923");
//        boolean isPrime = primeCheck.isProbablePrime(10);
//        System.out.println("Is 19 prime? " + isPrime);

//        BigInteger m = new BigInteger("344",34);
//        String s  = m.toString();
//        int k = m.intValue();
//        float f = m.floatValue();
//        BigInteger n = m .flipBit(9);
//        System.out.println(n);

//        Random random = new Random();
//        BigInteger biggy = new BigInteger(20,random);
//        System.out.println(biggy);
////////////////////////////////////Basic////////////////////////////

        String s = getString();
        System.out.println(s);

        BigInteger b1 = new BigInteger("123456789123456789123456789123456789");
        BigInteger b2 = new BigInteger("987654321987654321987654321987654321");
        System.out.println("B1 : "+b1+"\n"+"B2 : "+b2);
        System.out.println("Adding : "+b1.add(b2));
        System.out.println("Subs : "+b1.subtract(b2));
        System.out.println("Bit Length of b1 : "+b1.bitLength());
        System.out.println("Bit count  of b1 : "+b1.bitCount());
        System.out.println("Mul : "+b1.multiply(b2));
        System.out.println("Div : "+b1.divide(b2));
        System.out.println("Div 2 : "+b2.divide(b1));
        System.out.println("Div and Rem : "+b1.divideAndRemainder(b2)[1]);

//////////////////////////////Intermediate////////////////////////////////

        BigInteger base = new BigInteger("5");
        BigInteger modes = new BigInteger("100");

        BigInteger m = new BigInteger("987654321987654321987654321987654321");
        BigInteger n = new BigInteger("123456789123456789123456789123456789");

        System.out.println("GCD : "+m.gcd(n));
        System.out.println("get class : "+m.getClass());
        System.out.println("power : "+base.pow(Integer.parseInt("20")));
        System.out.println("Pow & Mod : "+base.modPow(BigInteger.valueOf(Long.parseLong("20")),modes));
        System.out.println("Fibo : "+fibo(1000));
        System.out.println("Signum of Zero valued BigInteger : "+BigInteger.ZERO.signum());
        System.out.println("Signum of B1 : "+b1.signum());
        System.out.println("Negate of B1 : "+b1.negate());
        System.out.println("Signum of B1 now : "+ b1.negate().signum());
    }

    static  BigInteger fac(int num ){
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            factorial=factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    static boolean checkprine(int n){
        return BigInteger.valueOf(n).isProbablePrime(20);
    }

    static BigInteger fibo(int n){
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            BigInteger temp = a.add(b);
            a=b;
            b=temp;
        }
        return b;
    }

    private static @NotNull String getString() {
        BigInteger biggy = new BigInteger("1010",2);
        String s = biggy.toString(10);
        return s;
    }
}

