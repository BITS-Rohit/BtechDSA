package btech.JAVA_AWT.Project_MAths_java.MAtrix;

import java.util.Scanner;

import static btech.JAVA_AWT.Project_MAths_java.code.Interface;

public class Main1 {
    public static int row;
    public static int column;
    public static int[][] array;
    public static final String RESET = "\u001B[0m";
    public static final String Green = "\u001B[32m";
    public static final String PURPLE ="\u001B[35m";
    public static final String YELLOW ="\u001B[33m";
    public static final String CYAN  = "\u001B[36m";
    /////////////////////////////////////////////////////////////
    //~~~~~~~~~~~~~~~~~~~~~~~~Matrix~~~~~~~~~~~~~~~~~~~~~~~~~
    /////////////////////////////////////////////////////////////
    static  void create (){     // to create array method
        Scanner sc = new Scanner(System.in);
        System.out.print(PURPLE+"Enter row size for matrix (m) : "+RESET);
        row  = sc.nextInt();                //Public value row initialised
        System.out.print(PURPLE+"Enter column size for matrix (n) : "+RESET);
        column = sc.nextInt();              //Public value column initialised
        array=new int[row][column];        //Array initialised
        for (int i = 0; i<row; i++){
            System.out.println(Green+"Enter "+(i+1)+" row's"+RESET);
            for (int j = 0; j<column; j++){
                System.out.print(Green+" Element :"+RESET);
                array[i][j]=sc.nextInt();
            }
        }
    }
    /////////////////////////////////////////////////////////////
    static void display (int[][] array){    // TO display the contents of created Array
        System.out.println(Green+"Array  : "+RESET);

        for (int[] in : array) {
            for (int anInt : in) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    /////////////////////////////////////////////////////////////
    static void Sum(int[][] array,int row , int column ){   //sum of elements method
        int sum=0 ;
        for (int i=0;i<row ; i++){
            for (int j =0;j<column ;j++){
                sum+=array[i][j];
            }
        }
        System.out.println(Green+"Sum is : "+RESET+ sum);
    }
    /////////////////////////////////////////////////////////////
    static void row_wise(int[][] array , int row,int column){      // row wise sum method

        for (int i=0; i<row; i++) {
            int sum=0 ;
            System.out.print(Green+"Sum of "+(i+1)+" row is : "+RESET);
            for (int j =0;  j<column;   j++) sum+=array[i][j];
            System.out.println(sum);
        }
    }
    /////////////////////////////////////////////////////////////
    static void column_wise(int[][] array , int row , int column){     // column wise sum method
        for (int i=0;   i<column;  i++){
            int sum =0 ;
            for (int j =0;  j<row;  j++) sum+=array[j][i];
            System.out.println(Green+"Sum of "+(i+1)+" column is : "+RESET+sum);
        }
    }
    /////////////////////////////////////////////////////////////
    static void transpose (int[][] array, int row, int column){      // to transpose an array method
        int[][] Arr= new int[column][row];
        for (int i=0; i<column; i++){
            for (int j =0;j<row ;j++) Arr[j][i]=array[i][j];
        }
        display(Arr);
    }
    static  void Matrix() {
        Scanner sc = new Scanner(System.in);
        int c;           //Matrix inside Choice variable
        do
        {
            System.out.println(YELLOW+"-->  TO Input element in matrix    (press 1)  ");
            System.out.println("-->  To display elements of matrix        (press 2)  ");
            System.out.println("-->  To Sum of all elements of matrix     (press 3)  ");
            System.out.println("-->  To display row-wise sum of matrix    (press 4)  ");
            System.out.println("-->  To display column-wise sum of matrix (press 5)  ");
            System.out.println("-->  To create transpose of matrix        (press 6)  ");
            System.out.println("For go to the Main menu                   (press 7   ");
            System.out.println("For Direct Exit                           (press 8"+RESET);
            System.out.print(CYAN+"\n          Enter your choice -->>>   "+RESET);
            c=sc.nextInt();

            if ( c ==1 ) create();
            else if ( c ==2 ) display(array);
            else if ( c ==3 ) Sum(array,row,column);
            else if ( c ==4 ) row_wise(array,row,column);
            else if ( c ==5 ) column_wise(array,row,column);
            else if ( c ==6 ) transpose(array,row,column);
            else if ( c ==7 ) Interface();
        } while (c!=8);
    }
    public static void main(String[] args){
    Matrix();
    }
}
