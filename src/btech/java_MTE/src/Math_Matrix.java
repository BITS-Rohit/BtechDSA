import java.util.Scanner;

public class Math_Matrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] a1 = new int[2][2];
        int[][] b1 = new int[2][2];
        int[][] c1 = new int[2][2];

        // storing values in 1st matrix
        System.out.println("Enter element for 1st matrix :");
         for (int i=0;i<2; i++){
             for (int j =0;j<2;j++){
                 a1[i][j] = sc.nextInt();
             }
         }
         //storing values in sec matrix
        System.out.println("Enter element for 2nd matrix :");
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                b1[i][j] = sc.nextInt();
            }
        }
        //printing "a1" matrix
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                System.out.println(a1[i][j]);
            }
        }
        //printing "b1" matrix
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                System.out.println(b1[i][j]);
            }
        }
        //Sum:-~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("Sum :");
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                c1[i][j] = a1[i][j] + b1[i][j];
                System.out.println(c1[i][j] + " ");
            }System.out.println("\n");
        }
        //Subtraction:-~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("Subtraction :");
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                c1[i][j] = a1[i][j] - b1[i][j];
                System.out.println(c1[i][j] + " ");
            }
        }System.out.println("\n");
        //Multiplication:-~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("Multiplication :");
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                c1[i][j] = a1[i][j] * b1[i][j];
                System.out.println(c1[i][j] + " ");
            }
        }System.out.println("\n");
        //Division:-~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        System.out.print("Division :");
        for (int i=0;i<2; i++){
            for (int j =0;j<2;j++){
                c1[i][j] = a1[i][j] / b1[i][j];
                System.out.println(c1[i][j] + " ");
            }
        }
    }
}
