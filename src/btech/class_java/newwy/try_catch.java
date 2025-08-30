package Btech.class_java.newwy;
import java.util.Arrays;

public class try_catch {
    public static void main(String[] args){
        try {
            int[] arr =new int[5];
            arr[4]=12;
            System.out.println(Arrays.toString(arr));
        }
        catch (ArrayIndexOutOfBoundsException c){
            System.out.println(" Exception  occurred in catch ");
        }
        finally {
            System.out.println(" Finally block executed ");
        }
    }
}
