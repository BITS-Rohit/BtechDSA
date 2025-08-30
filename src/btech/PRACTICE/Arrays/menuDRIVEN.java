package JAVA.PRACTICE.Arrays;
//Write a menu-driven program to do following operation on two-dimensional array A of size m x n.
// You should use user-defined methods which accept 2-D array A, and its size m and n as arguments. The options are:

    //To input elements into matrix of size m x n        ✔ ️
    //To display elements of matrix of size m x n        ✔ ️
    //Sum of all elements of matrix of size m x n        ✔ ️
    //To display row-wise sum of matrix of size m x n    ✔ ️
    //To display column-wise sum of matrix of size m x n ✔ ️
    //To create transpose of matrix of size n x m        ✔   ️

    ////////////////////////////////////////////////////////
    //TO print sin x value      ✔
    //TO print cos x value      ✔
    //TO print tan x value      ✔
    //TO print cosec x value    ✔
    //TO print sec x value      ✔
    //TO print cot x value      ✔

    ////////////////////////////////////////////////////////
    // TO print inverse sin x value      ✔
    // TO print inverse cos x value      ✔
    // TO print inverse tan x value      ✔
    // TO print inverse cosec x value    ✔
    // TO print inverse sec x value      ✔
    // TO print inverse cot x value      ✔

///////////////////////////////////////////////////////////// (unused methods)
    //Power function
    //Square function
    //log10
    //log
    //log1

import java.util.Scanner;

public  class menuDRIVEN {
    ////////////////.........Java Console Colouring starts here.............. ///////////////////////
    public static final String RESET = "\u001B[0m";
    public static final String Green = "\u001B[32m";
    public static final String YELLOW ="\u001B[33m";
    public static final String PURPLE ="\u001B[35m";
    public static final String CYAN  = "\u001B[36m";
    ////////////////.........Java Console Colouring ends here.............. ///////////////////////

    ///////////////..........Some Public variables Declaration............. ///////////////////////
    public static int Menu_Choice;
    public static int row;
    public static int column;
    public static int[][] array;
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
    /////////////////////////////////////////////////////////////
    // ~~~~~~~~~~~~~~~~~Trigonometry~~~~~~~~~~~~~~~~~~~
    /////////////////////////////////////////////////////////////
static void sine(){                                               //Sin X value calculator method
    Scanner sc = new Scanner(System.in);
    System.out.println(Green+"Enter X value for calculating sin(X)  value : "+RESET);
    double x= sc.nextDouble();
    double sineValue = Math.sin(Math.toRadians(x));
    System.out.println(Green+"sin(" + x + ") in Degrees is "+RESET + sineValue);
    System.out.println(Green+"~~~~~~~~~~~"+RESET);
    System.out.println(Green+"sin(" + x + ") in Radian is "+RESET + Math.sin(x));
}
    /////////////////////////////////////////////////////////////
static void cosine(){                                               //Cos X value calculator method
    Scanner sc = new Scanner(System.in);
    System.out.println(Green+"Enter X value for calculating cos(X) value : "+RESET);
    double x= sc.nextDouble();
    double CosineValue = Math.cos(Math.toRadians(x));
    System.out.println(Green+"cos(" + x + ") in Degrees is "+RESET + CosineValue);
    System.out.println(Green+"~~~~~~~~~~~"+RESET);
    System.out.println(Green+"sin(" + x + ") in Radian is " +RESET+ Math.cos(x));
}
    /////////////////////////////////////////////////////////////
static void tan(){                                                  //Tan X value calculator method
    Scanner sc = new Scanner(System.in);
    System.out.println(Green+"Enter X value for calculating tan(X) value : "+RESET);
    double x= sc.nextDouble();
    double tanValue = Math.tan(Math.toRadians(x));
    System.out.println(Green+"tan(" + x + ") in Degrees is " +RESET+ tanValue);
    System.out.println(Green+"~~~~~~~~~~~"+RESET);
    System.out.println(Green+"sin(" + x + ") in Radian is "+RESET + Math.tan(x));
}
/////////////////////////////////////////////////////////////
static void cosec(){                                                  //Tan X value calculator method
    Scanner sc = new Scanner(System.in);
    System.out.println(Green+"Enter X value for calculating Cosec(X) value : "+RESET);
    double x= sc.nextDouble();
    double cosecValue = (1/Math.tan(Math.toRadians(x)));
    System.out.println(Green+"Cosec(" + x + ") in Degrees is "+RESET + cosecValue);
    System.out.println(Green+"~~~~~~~~~~~"+RESET);
    System.out.println(Green+"Cosec(" + x + ") in Radian is "+RESET + (1/Math.tan(x)));
}
    static void sec(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"Enter X value for calculating Sec(X) value : "+RESET);
        double x= sc.nextDouble();
        double secValue = (1/Math.cos(Math.toRadians(x)));
        System.out.println(Green+"Sec(" + x + ") in Degrees is " +RESET+ secValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Sec(" + x + ") in Radian is " +RESET+ (1/Math.cos(x)));
    }
    /////////////////////////////////////////////////////////////
    static void cot(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"Enter X value for calculating Cot(X) value : "+RESET);
        double x= sc.nextDouble();
        double cotValue = (1/Math.tan(Math.toRadians(x)));
        System.out.println(Green+"Cot(" + x + ") in Degrees is " +RESET+ cotValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Cot(" + x + ") in Radian is "+RESET + (1/Math.tan(x)));
    }
    /////////////////////////////////////////////////////////////
    // ~~~~~~~~~~~~~~Inverse Trigonometry~~~~~~~~~~~~~
    /////////////////////////////////////////////////////////////
    static void In_sine(){                                               //Sin X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain is [–1, 1] and the range is [–π2,π2]."+RESET);
        System.out.println(Green+"Enter X value for calculating Inverse of sin(X)  value : "+RESET);
        double x= sc.nextDouble();
        double sineValue = Math.asin(Math.toRadians(x));
        System.out.println(Green+"Inverse of sin(" + x + ") in Degrees is "+RESET + sineValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Inverse of sin(" + x + ") in Radian is "+RESET + Math.asin(x));
    }
    /////////////////////////////////////////////////////////////
    static void In_cosine(){                                               //Cos X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain is [–1, 1] and the range is [0, π]."+RESET);
        System.out.println(Green+"Enter X value for calculating Inverse of cos(X) value : "+RESET);
        double x= sc.nextDouble();
        double CosineValue = Math.acos(Math.toRadians(x));
        System.out.println(Green+"Inverse of cos(" + x + ") in Degrees is "+RESET + CosineValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Inverse of cos(" + x + ") in Radian is "+RESET + Math.acos(x));
    }
    /////////////////////////////////////////////////////////////
    static void In_tan(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain of the inverse tan function is (−∞,∞) and the range is (−π2,π2)."+RESET);
        System.out.println(Green+"Enter X value for calculating Inverse of tan(X) value : "+RESET);
        double x= sc.nextDouble();
        double tanValue = Math.atan(Math.toRadians(x));
        System.out.println(Green+"Inverse of tan(" + x + ") in Degrees is "+RESET + tanValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Inverse of tan(" + x + ") in Radian is "+RESET + Math.atan(x));
    }
    /////////////////////////////////////////////////////////////
    static void In_cosec(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain of the inverse Cosec function is (x<=-1 or x>1) and the range is [−π2,π2]-{0}."+RESET);
        System.out.println(Green+"Enter X value for calculating Inverse of Cosec(X) value : "+RESET);
        double x= sc.nextDouble();
        double cosecValue = (1/Math.asin(Math.toRadians(x)));
        System.out.println(Green+"Inverse of Cosec(" + x + ") in Degrees is "+RESET + cosecValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Inverse of Cosec(" + x + ") in Radian is "+RESET + (1/Math.asin(x)));
    }
    /////////////////////////////////////////////////////////////
    static void In_sec(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain of the inverse Sec function is (x<=-1 or x>1) and the range is [0,π/2)U(π/2,π]."+RESET);
        System.out.println(Green+"Enter X value for calculating Inverse of Sec(X) value : "+RESET);
        double x= sc.nextDouble();
        double secValue = (1/Math.acos(Math.toRadians(x)));
        System.out.println(Green+"Inverse of Sec(" + x + ") in Degrees is " +RESET+ secValue);
        System.out.println(Green+"~~~~~~~~~~~");
        System.out.println(Green+"Inverse of Sec(" + x + ") in Radian is " +RESET+ (1/Math.acos(x)));
    }
    /////////////////////////////////////////////////////////////
    static void In_cot(){                                                  //Tan X value calculator method
        Scanner sc = new Scanner(System.in);
        System.out.println(Green+"The domain of the inverse Cot function is (−∞,∞) and the range is (0,π)."+RESET);
        System.out.println(Green+"Enter X value for calculating Cot(X) value : "+RESET);
        double x= sc.nextDouble();
        double cotValue = (1/Math.atan(Math.toRadians(x)));
        System.out.println(Green+"Inverse of Cot(" + x + ") in Degrees is "+RESET + cotValue);
        System.out.println(Green+"~~~~~~~~~~~"+RESET);
        System.out.println(Green+"Inverse of Cot(" + x + ") in Radian is "+RESET + (1/Math.atan(x)));
    }
    /////////////////////////////////////////////////////////////
//    ~~~~~~~~~~~~~~Other Mathematics Functions ~~~~~~~~~~~~~~~~
    /////////////////////////////////////////////////////////////
    static void power(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base number : "); int base =sc.nextInt();
        System.out.print("Enter power number : "); int pow= sc.nextInt();
        System.out.print(pow + "to the "+ base+" is : "+Math.pow(base,pow));
    }
    /////////////////////////////////////////////////////////////
    static void square() {
        Scanner sc = new Scanner(System.in);
        System.out.print(Green+" Enter number : ");
        System.out.print("Square : "+Math.sqrt(sc.nextDouble())+RESET);
    }
    /////////////////////////////////////////////////////////////
    static void log(){           // Returns natural log
        Scanner sc = new Scanner(System.in);
        System.out.println("If the argument is NaN or less than zero, then the result is NaN.");
        System.out.println("If the argument is positive infinity, then the result is positive infinity.");
        System.out.println("If the argument is positive zero or negative zero, then the result is negative infinity.");

        System.out.print(Green+" Enter number : ");
        System.out.print("Logarithm :" +RESET+Math.log(sc.nextDouble()));
    }
    static void log10(){
        Scanner sc = new Scanner(System.in);
        System.out.print(Green+" Enter number : ");
        System.out.print("Logarithm :" +RESET+Math.log10(sc.nextDouble()));
    }
    static void log1(){
        Scanner sc = new Scanner(System.in);
        System.out.print(Green+" Enter number : ");
        System.out.print("Logarithm :" +RESET+Math.log1p(sc.nextDouble()));
    }
    /////////////////////////////////////////////////////////////
//    ~~~~~~~~~~~~~~~~Console printing Classes ~~~~~~~~~~~~~~~~
    /////////////////////////////////////////////////////////////

static void Interface(){

    Scanner sc = new Scanner(System.in);
    do {
        System.out.println("\n \n \n \n");
        System.out.println(PURPLE+"⟦⁜⟧ Matrix Calculation ...(Press 1)");
        System.out.println("⟦⁜⟧ Trigonometric Function 's value calculator ...(Press 2");
        System.out.println("⟦⁜⟧ Inverse Trigonometric Value Calculator ...(press 3");
//        System.out.println("⟦⁜⟧ Simple Calculator {^_^} ...(Press 4)");
        System.out.println("⟦⁜⟧ Press (4)  Any for Exit "+RESET);
        System.out.print(Green+"\n Enter Choice --->>  "+RESET);
        Menu_Choice=sc.nextInt();
        if      (Menu_Choice ==1) Matrix();
        else if (Menu_Choice ==2) Trigonometry();
        else if (Menu_Choice ==3) Inverse_Trigonometry();
    }while(Menu_Choice!=4);
}
    /////////////////////////////////////////////////////////////
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
    /////////////////////////////////////////////////////////////
static void Trigonometry(){

    Scanner sc = new Scanner(System.in);
    int c;           //Trigonometric inside choice
    do
    {
        System.out.println(YELLOW+"-->  Sin(X)  (press 1) : ");
        System.out.println("-->  Cos(X)  (press 2) ");
        System.out.println("-->  Tan(X)  (press 3) ");
        System.out.println("-->  Cosec(X)(press 4) ");
        System.out.println("-->  Sec(X)  (press 5) ");
        System.out.println("-->  Cot(X)  (press 6) ");
        System.out.println("For go to the Main menu.      (press 7)");
        System.out.println("For Direct Exit.              (press 8)"+RESET);
        System.out.print(CYAN+"\n          Enter choice ->   "+RESET);
        c=sc.nextInt();

        if      ( c ==1 ) sine();
        else if ( c ==2 ) cosine();
        else if ( c ==3 ) tan();
        else if ( c ==4 ) cosec();
        else if ( c ==5 ) sec();
        else if ( c ==6 ) cot();
        else if ( c ==7 ) Interface();
    } while (c!=8);
}
    /////////////////////////////////////////////////////////////
static void Inverse_Trigonometry(){

    Scanner sc = new Scanner(System.in);
    int c;             //Trigonometric inside choice
    do
    {
        System.out.println(YELLOW+"--> Inverse of Sin(X)   (press 1) : ");
        System.out.println("--> Inverse of Cos(X)   (press 2) ");
        System.out.println("--> Inverse of Tan(X)   (press 3) ");
        System.out.println("--> Inverse of Cosec(X) (press 4) ");
        System.out.println("--> Inverse of Sec(X)   (press 5) ");
        System.out.println("--> Inverse of Cot(X)   (press 6) ");
        System.out.println("For go to the Main menu.(press 7");
        System.out.println("For Direct Exit.        (press 8"+RESET);
        System.out.print(CYAN+"\n          Enter choice ->   "+RESET);
        c=sc.nextInt();

        if      ( c ==1 ) In_sine();
        else if ( c ==2 ) In_cosine();
        else if ( c ==3 ) In_tan();
        else if ( c ==4 ) In_cosec();
        else if ( c ==5 ) In_sec();
        else if ( c ==6 ) In_cot();
        else if ( c ==7 ) Interface();
    } while (c!=8);
}
    ///////////////////////////////////////////////////////////////////////////////////////////////
    //               ~~~~~~~~~~~~~~~~~~~~~~~~ Main ~~~~~~~~~~~~~~~~~~~~
    //////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args)
    {
        System.out.println(CYAN+"           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          ");
        System.out.println     ("                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                  ");
        System.out.println     ("               Welcome :D  .It is a java program for Simple Mathematics .... LETs see WHat we Got here.                    ");
        System.out.println     ("                           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                  ");
        System.out.println     ("                                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                  ");
        System.out.println     ("                                     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                  "+RESET);
        Interface();
    }
}