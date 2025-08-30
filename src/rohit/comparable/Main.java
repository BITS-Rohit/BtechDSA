package rohit.comparable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentComparable student1 = new StudentComparable(23,12.08F);
        StudentComparable student2 = new StudentComparable(3,1222F);
        StudentComparable student3 = new StudentComparable(2,122F);
        StudentComparable student4 = new StudentComparable(232,124F);
        StudentComparable student5 = new StudentComparable(213,11.2F);
        StudentComparable student6 = new StudentComparable(273,123.F);
//        List<StudentComparable> students = new ArrayList<>();
//
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);
//        students.add(student6);
//
//        System.out.println(Arrays.toString(new List[]{students}));
//        System.out.println();
//        Arrays.sort(new List[]{students});

        StudentComparable[] student = {student1,student2,student3,student4,student5,student6};

        System.out.println(Arrays.toString(student));
        System.out.println();
        Arrays.sort(student);
        System.out.println();
        System.out.println(Arrays.toString(student));

//         comparing by compareto method
        if (student1.compareTo(student2)<0) System.out.println("Student wins 🏆🏆");
        else if (student1.compareTo(student2)==0) System.out.println("DRAW 🏆🏆");
        else System.out.println("Student 2 wins 🏆🏆");
    }

}
