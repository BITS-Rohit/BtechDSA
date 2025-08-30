package Btech.class_java.example;

public class TriangularMatrix {
    // X-Y
    //X represents the sum of even numbers of odd rows
    // Y represents the Sum odd numbers of even columns

    // A*B
    // A is  the sum of the upper triangular matrix
    // B is the sum of lower triangular matrix




//////////  X && Y  ////////////////
    static int X(int[][] array,int row, int column ){
        int sum=0;
        for (int i = 0; i <row ; i++) {                     // odd rows
            if (i%2!=0){
                for (int j = 0; j < column; j++) {
                   if (array[i][j]%2==0){
                       sum+=array[i][j];                    // sum of even numbers
                   }
                }
            }
        }
        return sum;
    }
    static int Y(int[][] array , int row , int column){
        int sum=0;
        for (int i = 0; i < column; i++) {                    // even rows
            if (i%2==0){
                for (int j = 0; j <row; j++) {
                    if (array[j][i]%2!=0){
                        sum +=array[i][j];                     //sum of odd numbers
                    }
                }
            }
        }
        return sum;
    }

//////////// A && B //////////////

    static int A(int[][] array ,int row, int column){
        int sum=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <column; j++) {
                if ( i==j){
                    sum+=array[i][j];
                    for (int z = 0; z < j; z++) {
                        sum+=array[i][j];
                    }
                }
            }
        }
        return sum;
    }


    public static void main(String[] args){
        int[][] array = {
                {0,1,2}, // index row =0
                {3,4,5}, // index row =1    🔰🔰🔰 ODD rows
                {6,7,8} //  index row =2
        };

        System.out.println("X : "+X(array,3,3));
        System.out.println("Y : "+Y(array,3,3));

        System.out.println("A : "+A(array,3,3));

    }

}
