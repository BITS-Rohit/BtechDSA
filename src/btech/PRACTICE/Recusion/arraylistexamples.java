package JAVA.PRACTICE.Recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class arraylistexamples {
    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        s.add(1);
        s.add(0);
        s.add(4);
        List<Integer> se = new ArrayList<>();
        se.add(1);
        se.add(20);
        se.add(4);
        se.add(40);
//        System.out.println(se.retainAll(s));
//        System.out.println(se);
        Object[] array = se.toArray();
        System.out.println(Arrays.toString(array));
        List<String> st = new ArrayList<>();
        st.add("lalatina");
        st.add("darkness");
        String[] sn = st.toArray(new String[0]);
        System.out.println(Arrays.toString(sn));



        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
