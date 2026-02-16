package rohit.comparable;

import org.jetbrains.annotations.NotNull;

public class StudentComparable
        implements Comparable<StudentComparable>
{
    int rollno;
    float marks;

    public StudentComparable(int rollno,float marks) {
        this.rollno     =    rollno;
        this.marks      =    marks;
    }

    @Override
    public int compareTo(@NotNull StudentComparable o) {
        return this.rollno -o.rollno;
    }

    @Override
    public String toString() {
        return rollno+" ";
    }
}
