package Btech.JAVA;

import java.util.Arrays;

public class STRINGMETHDs {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println("char at 2 in a string method : "+str.charAt(1));

        System.out.println("unicode at 2 char : "+str.codePointAt(1));
        System.out.println("Code point before  string method is : "+str.codePointBefore(2));
        System.out.println("the number of Unicode values found in a string: "+str.codePointCount(0,str.length()));

        System.out.println(" lexicographically : "+str.compareTo("hell"));
        System.out.println("lexicographically with ignored case differences : "+ str.compareToIgnoreCase("hell"));

        System.out.println("join of 2 strings : "+str.concat(" world"));
        System.out.println("check character : "+str.contains("l") );
        System.out.println("Contains equals : "+str.contentEquals("hell"));
        System.out.println("Contains equals : "+str.contentEquals("hello"));

        String e= "The java";
        String f = String.copyValueOf(e.toCharArray(),0,e.length());
        System.out.println("copy value of : "+f);
        System.out.println("Char array : "+ Arrays.toString(e.toCharArray()));

        System.out.println("Ends with : "+str.endsWith("o"));
        System.out.println("Equals : "+e.equals(f));


        boolean my_b = true ;
        char my_c = 'a';
        String my_s = "hello";
        int my_int = 10;
        double my_d = 10.0;
        System.out.printf("%d yup %c  yup %s yup  %b yup  %f yup", my_int, my_c, my_s,my_b,my_d);

        System.out.println("\n get bytes :" + str.getBytes());
        System.out.println("Get bytes with array to string : "+ Arrays.toString(str.getBytes()));
        System.out.println("unicode  : "+ str.codePoints());
        char[] c = new char[10];
        /*System.out.println("unicode with to string: "+ str.codePoints().toString());
        System.out.println("unicode to array : "+ str.codePoints().toArray());*/
        str.getChars(0,str.length(),c ,0);
        System.out.println("get chars : "+ Arrays.toString(c));

        System.out.println("hash code : "+str.hashCode());
        System.out.println("index of : "+str.indexOf("l"));

        String s2= "";
        System.out.println("Intern : "+str.intern());
        System.out.println("Empty : "+s2.isEmpty());

        System.out.println("last index of : "+str.lastIndexOf("l"));
        
    }
}
