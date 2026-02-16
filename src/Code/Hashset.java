package Code;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Hashset {
    static void RemDup(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list.size());
        set.addAll(list);
        System.out.println("Ater Remove: " + set);
    }

    static Set<Integer> intersection(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> set = new HashSet<>(s1.size());
        set.addAll(s1);
        set.retainAll(s2);
        return set;
    }

    static Set<Integer> union(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> set = new HashSet<>(s1.size() + s2.size());
        set.addAll(s1);
        set.addAll(s2);
        return set;
    }

    static boolean isSubset(Set<Integer> s1, Set<Integer> s2) {
        return s2.containsAll(s1);
    }

    static Set<Integer> symentricdifference(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> set = union(s1, s2);
        set.removeAll(intersection(s1, s2));
        return set;
    }

    public static void main(String[] args) {
        System.out.println();
        Set<Integer> s1 = new HashSet<>(5);
        Set<Integer> s2 = new HashSet<>(5);
        Set<Integer> s3 = new LinkedHashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);
        s1.add(5);
        s2.add(4);
        s2.add(5);
        s2.add(6);
        s2.add(7);
        s2.add(8);
//        System.out.println(symentricdifference(s1,s2));
//        System.out.println(isSubset(s1,s2));
//        union(s1,s2);
//        intersection(s1,s2);
//        List<Integer> input = new ArrayList<>();
//        input.add(1);input.add(2);input.add(1);input.add(2);
//        RemDup(input);
    }
}
