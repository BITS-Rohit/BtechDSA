package JAVA.exam;

public class _temperatureConversion {
    public static void main(String[] args){
        float c = 98.6F;
        float f = 209.1F;

        System.out.println("Fahrenheit :"+Fahrenheit(c));
        System.out.println("Celsius :"+Celsius(f));
    }
    public static float Fahrenheit (float c){return c*((float) 9 /5) + 32;}
    public static float Celsius(float f){return f*((float) 5 /9) - 32;}
}
