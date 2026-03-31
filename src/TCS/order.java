package TCS;

import javax.xml.transform.Source;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        sc.nextLine(); // skip "shuffled"
        String[] shuffled = new String[N];
        for (int i = 0; i < N; i++) shuffled[i] = sc.nextLine().trim();
        sc.nextLine(); // skip "original"
        String[] original = new String[N];
        for (int i = 0; i < N; i++) original[i] = sc.nextLine().trim();

        // Map each original instruction to its index
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < N; i++) indexMap.put(original[i], i);

        // Convert shuffled to index mapping
        int[] order = new int[N];
        for (int i = 0; i < N; i++) order[i] = indexMap.get(shuffled[i]);

        // Find longest contiguous increasing subsequence
        int longest = 1, cur = 1;
        for (int i = 1; i < N; i++) {
            if (order[i] > order[i - 1]) cur++;
            else cur = 1;
            longest = Math.max(longest, cur);
        }

        System.out.println(N - longest);
    }
}

class TCS_NQT_2025 {
    void q1(String s) {

        if (s.isEmpty()) {
            System.out.println("Invalid Input");
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        char first = ' ';
        char most = ' ';
        char firstRepeating = ' ';
        int cnt = 0;

        int maxCount = Collections.max(map.values());
        int maxFreqCount = 0;

        for (int v : map.values()) {
            if (v == maxCount) maxFreqCount++;
        }

        boolean rev = maxFreqCount > 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int res = map.get(c);

            if (res > 1 && firstRepeating == ' ') firstRepeating = c;

            if (res == 1 && first == ' ') first = c;
            if (res > cnt) { // Also ensures only if the greater value comes then change, else hold the index priority
                most = c;
                cnt = res;
            }
        }

        // None case
        if (first == ' ') {
            System.out.println("None " + firstRepeating);
            return;
        }

        if (rev) {
            System.out.println("First Non-Repeating Character : " + first);
            System.out.println("Most Frequent Character : " + most);
        } else {
            System.out.println("Most Frequent Character : " + most);
            System.out.println("First Non-Repeating Character : " + first);
        }
    }

    void q2() {

        Scanner sc = new Scanner(System.in);
        var map = new HashMap<String, Integer>();
        var real_name = new HashMap<String, String>();

        int totalincome = 0 , totalexpenditure = 0;
        while(true){
            System.out.println("Enter the Income: ");
            String  income = sc.nextLine();

            if (income.equalsIgnoreCase("done")) break;

            System.out.println("Enter type of material : ");
            String mats = sc.nextLine();

            System.out.println("Enter expenditure on "+mats+": ");
            int expenditure = sc.nextInt();

            sc.nextLine();

            totalexpenditure += expenditure;
            totalincome += Integer.parseInt(income);

            String lower  = mats.toLowerCase();
            if (map.containsKey(lower))map.put(lower, map.get(lower)+expenditure);
            else {
                real_name.put(lower, mats); // updates with the latest name entered for that lower case same name
                map.put(lower, expenditure);
            }
        }
        sc.close();
        System.out.println("Total Income: "+totalincome);
        System.out.println("Total Savings: "+(totalincome-totalexpenditure));
        for (var entry : map.entrySet())
            System.out.println(real_name.get(entry.getKey()) + " : " + entry.getValue());
    }
}
