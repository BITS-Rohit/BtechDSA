package Btech.class_java.example;

public class StringBuilder {
    static String a = " Rohit ";
    static String b = "Rohit";
    static boolean isPalindrome(String s){
        if (s == null) return true;
        for (int i = 1; i <= s.toLowerCase().length()/2 ; i++) {
            char Start = s.charAt(i);
            char End = s.charAt(s.length()-1-i);

            if ( Start!=End)return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(a.equals(b));
        System.out.println(a.charAt(0));
        String s = "Radhe";
        String sq = "ABcdcBA";
//        System.out.println(STR."Palindrome ? :-> \{isPalindrome(sq)}");

        StringBuilder sb  = new StringBuilder();

    }
}