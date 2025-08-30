package Code;

import java.util.*;

public class HCODE {
    ////////////////////////////////////////
    public static void main(String[] args) {

    }

    ////////////////////////////////////////////////
    public static int hourglassSum(List<List<Integer>> arr) {
        int Mcounter = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int startele = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) // Top row
                        + arr.get(i + 1).get(j + 1) // Middle element
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2); // Bottom row
                if (max < startele) max = startele;
            }
        }
        return max;
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());        //
        }
        int lastanswer = 0;
        List<Integer> res = new ArrayList<>();
        for (List<Integer> query : queries) {
            int qtype = query.get(0);           // Query Type
            int x = query.get(1);
            int y = query.get(2);

            int index = (x ^ lastanswer) % n;
            if (qtype == 1) {
                arr.get(index).add(y);
            }
            if (qtype == 2) {
                int size = arr.get(index).size();
                int m = y % size;
                lastanswer = arr.get(index).get(m);
                res.add(lastanswer);
            }
        }
        return res;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> list = new ArrayList<>(arr.size());
        for (int i = d; i < arr.size(); i++) {
            list.add(arr.get(i));
        }
        for (int i = 0; i < d; i++) {
            list.add(arr.get(i));
        }
        return list;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (String s : stringList) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : queries) {
            int m = 0;
            ans.add(map.getOrDefault(s, m));
        }
        return ans;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // queries : [[1,5,3][4,8,7][6,9,1]]
        long[] array = new long[n];
        long max = Long.MIN_VALUE;

        for (List<Integer> query : queries) {
            int a = query.get(0);
            int b = query.get(1);
            array[a - 1] += query.get(2);
            if (b < n) array[b] -= query.get(2);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            max = Math.max(sum, max);
        }
        return max;
    }


    public static int poisonousPlants(List<Integer> p) {
        //p = [6 5 8 4 7 10 9]
        int days = 0;
        for (int i = 1; i <= p.size(); i++) {
            List<Integer> processed = getdays(p);
            System.out.println(processed);
            if (p.size() != processed.size()) {
                days++;
                p = processed;
            }
        }
        return days;
    }

    public static List<Integer> getdays(List<Integer> process) {
        List<Integer> inner = new ArrayList<>();

        // Add the first plant since it never dies
        inner.add(process.getFirst());

        // Traverse the list and filter out the dying plants
        for (int i = 1; i < process.size(); i++) {
            if (process.get(i) <= process.get(i - 1)) {
                inner.add(process.get(i));
            }
        }

        return inner;
    }

    public static List<Integer> getday(List<Integer> process) {
        List<Integer> inner = new ArrayList<>();
        boolean b = false;
        for (int i = 0; i < process.size() - 1; i++) {
            if (i == process.size() - 2) {
                if (process.get(i) > process.get(i + 1)) {
                    inner.add(process.get(i));
                    inner.add(process.getLast()); // Add the last element
                } else if (process.get(i) < process.get(i + 1)) {
                    b = true;
                    inner.add(process.get(i));
                } else inner.add(process.get(i));
                break; // Stop the loop after handling the last two elements.
            }

            if (process.get(i) > process.get(i + 1)) {
                inner.add(process.get(i));
            } else if (process.get(i) < process.get(i + 1)) {
                inner.add(process.get(i));
                i++; // Skip the next element since it "dies".
            }
        }

        // Ensure the last element is added if not already.
        int k = 0;
        while (k < 1) {
            if (!inner.isEmpty() && !inner.getLast().equals(process.getLast())) {
                if (b) {
                    break;
                }
                inner.add(process.getLast());
                k++;
            }
        }
        return inner;
    }

    public static int poisonousPlants(int[] plants) {
        Stack<int[]> stack = new Stack<>();
        int maxDays = 0;

        for (int plant : plants) {
            int days = 0;

            // Remove plants from the stack that have higher or equal pesticide
            while (!stack.isEmpty() && stack.peek()[0] >= plant) {
                days = Math.max(days, stack.pop()[1]);
            }

            // If the stack is not empty, it means the current plant is weaker than the previous plant
            if (!stack.isEmpty()) {
                days++;
            } else {
                // If the stack is empty, this plant is the new minimum for its group
                days = 0;
            }

            // Update the maxDays required
            maxDays = Math.max(maxDays, days);

            // Push the current plant and the days it will take to die onto the stack
            stack.push(new int[]{plant, days});
        }

        return maxDays;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>(2);
        int ap = 0;
        int bp = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.getFirst() > b.getFirst()) ap += 1;
            else if (a.getFirst() < b.getFirst()) bp += 1;
        }
        result.add(ap);
        result.add(bp);
        return result;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int l = 0;
        int r = 0;
        int idx = 0;
        int n = arr.size() - 1;
        for (int i = 0; i < arr.size(); i++) {
            l += arr.get(i).get(i);
            r += arr.get(idx).get(n);
            idx++;
            n--;
        }
        return Math.abs(l - r);
    }
    //There are elements, two positives, two negatives and one zero.
    // Their ratios are, and. Results are printed as:
    //
    //0.400000
    //0.400000
    //0.200000

    public static void plusMinus(List<Integer> arr) {
        double pcount = 0;
        double ncount = 0;
        double zcount = 0;
        for (Integer integer : arr) {
            if (integer > 0) pcount++;
            else if (integer < 0) ncount++;
            else zcount++;
        }
        System.out.println(pcount / arr.size() + "\n" + ncount / arr.size() + "\n" + zcount / arr.size() + "\n");
    }

    public static void staircase(int n) {
        int str = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < str; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - str; j++) {
                System.out.print("#");
            }
            str = str - 1;
            System.out.println();
        }
    }

    public static void miniMaxSum(List<Integer> arr) {
        //The minimum sum is and the maximum sum is. The function prints
        //ar = [1,3,5,7,9] min = 1+3+5+7; max = 1+3+5+7+9
        //16 24
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) {
                max += arr.get(i);
                System.out.print(min + " " + max);
            }
            min += arr.get(i);
            max += arr.get(i);
        }

    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        //Candles = [4,4,1,3]
        //The maximum height candles are 4 units high. There are 2 of them, so return 2
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int candle : candles) {
            max = Math.max(candle, max);
            map.put(candle, map.getOrDefault(candle, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> now : map.entrySet()) {
            if (now.getKey() == max) ans = now.getValue();
        }
        return ans;
    }

    public static String nimbleGame(List<Integer> s) {
        // [0,2,3,0,6]
        //[0,0,0,0]
        int c = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) / 2 != 0) c = c ^ i;
        }
        if (c == 0) return "Second";
        else return "First";
    }

    public static String timeConversion(String s) {
        // s = '12:01:00PM'      Return '12:01:00'.   size = 10
        // s = '12:01:00AM'      Return '00:01:00'.   size = 10
        StringBuilder ans = new StringBuilder();
        String[] strings = s.split("");
        String m = strings[0] + strings[1];
        if (m.equals("12")) {
            if (strings[8].equalsIgnoreCase("a")) {
                ans.append(m);
                int i = 0;
                for (String sm : strings) {
                    if (i > 1) ans.append(sm);
                    i++;
                }
                ans.deleteCharAt(9);
                ans.deleteCharAt(8);
            } else if (strings[8].equalsIgnoreCase("p")) {
                ans.append(s);
            }
        } else {
            if (strings[8].equalsIgnoreCase("p")) {
                int n = Integer.parseInt(m) + 12;
                ans.append(n);
            }
            int i = 0;
            for (String sm : strings) {
                if (i > 1) ans.append(sm);
                i++;
            }
            ans.deleteCharAt(9);
            ans.deleteCharAt(8);

        }
        return ans.toString();
    }

    public static String sillyGame(int n) {
        //1,2,5
        //Bob, Alice, Alice
        //The game starts with an integer, that's used to build of distinct integers in the inclusive range from to.
        //Alice always plays first, and the two players move in alternating turns.
        //During each move, the current player chooses a prime number from a set. The player then removes all of its multiples from.
        //The first player to be unable to make a move loses the game
        if (n <= 1) return "Bob";
        boolean[] bool = new boolean[n + 1];
        int m = 0;
        for (int i = 1; i <= n; i++) {
            if (!bool[i] && isprime(i)) {
                bool[i] = true;
                for (int j = i; j <= n; j++) {
                    if (isprime(j)) {
                        m++;
                        bool[j] = true;
                    }
                }
            }
        }
        return (m % 2 == 0) ? "Bob" : "Alice";
    }

    private static boolean isprime(int n) {
        if (n <= 1) return false;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // Iterate over all possible substrings of length k
        for (int i = 1; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);

            // Update smallest and largest if needed
            if (substring.compareTo(smallest) < 0) {
                smallest = substring;
            }
            if (substring.compareTo(largest) > 0) {
                largest = substring;
            }
        }

        return smallest + "\n" + largest;
    }

    static void nums(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (min > integer) min = integer;
            if (max < integer) max = integer;
        }
        System.out.println("Mininum : " + min);
        System.out.println("Maximum : " + max);
    }

    static int[] swap(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
//        System.out.println("Before : "+arr);

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> arr = new ArrayList<>(a.size());
        for (int i = a.size() - 1; i >= 0; i--) {
            int ar = a.get(i);
            arr.add(ar);
        }
        return arr;
    }

    static int[] newnums(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] == 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            start++;
            end--;
        }
        return arr;
    }

    static boolean isAnagrambyHashMap(String a, String b) {
        if (a.length() != b.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < a.length(); i++) {
            map.put
                    (a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        System.out.println(map);
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(b.charAt(i))) {
                if (map.get(b.charAt(i)) > 0) {
                    map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) - 1);
                } else return false;
            } else return false;
        }
        return true;
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();
        String s;
        for (int i = 0; i < a.length(); i++) {
            boolean found = false;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    s = b.substring(0, j) + b.substring(j);
                    b = s;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        //84 round to 85
        //if grade is less than 38, it is meaningless to round about
        //failing grade is less than 40
        List<Integer> list = new ArrayList<>();
        for (int num : grades) {
            if (num >= 38) {
                int multiple = (num - (num % 5)) + 5;
                if ((multiple - num) < 3) list.add(multiple);
                else list.add(num);
            } else list.add(num);
        }
        return list;
    }

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // a=[2,3,-4]   b = [3,-4,-4]
        for (int i = 0; i < apples.size(); i++) {  // a = 4 , b = 12
            apples.set(i, apples.get(i) + a);         // [ 6,7,0]
            oranges.set(i, oranges.get(i) + b);     //[15,-8,-8]
        }
        int countA = 0;        // count for apple falls on the house
        int countB = 0;        // count for orange falls on the house
        for (int i = 0; i < apples.size(); i++) {
            int x = apples.get(i);       // distance of every apple
            int y = oranges.get(i);   // distance of every orange
            if (x >= s && x <= t) countA++;    // s= 7 , t = 10
            if (y <= t && y >= s) countB++;
        }
        System.out.println(countA);
        System.out.println(countB);
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x2 > x1 && v2 > v1 ||
                x1 > x2 && v1 > v2 ||
                x1 == x2 && v1 > v2 ||
                x1 == x2 && v2 > v1 ||
                v2 == v1 && x2 > x1 ||
                v1 == v2 && x1 > x2) return "NO";
        int x = x1;
        int y = x2;
        int m = (x1 + v1) * (x2 + v2);
        for (int i = 0; i < m; i++) {
            if (x == y) {
                return "YES";
            } else {
                x += v1;
                y += v2;
            }
        }
        return "N0";
    }

    public static int birthday(List<Integer> s, int d, int m) {
        //create subsert of sum 5 with a pair of sizes 2
        // returns how ways may possible, {count ++}
        // d = birthdays, m = months
        int count = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (s.get(i) + s.get(j) == d) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) count++;
            }
        }
        return count;
    }

    public static int migratoryBirds(List<Integer> arr) {
//    migratory bird
        HashMap<Integer, Integer> map = new HashMap<>(5);     // as it is guranteed that the type of the bird is 1,2,3,4,5
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> now : map.entrySet()) {
            int birdsight = now.getKey();
            int fre = now.getValue();
            if (fre > max || fre == max && birdsight < ans) {
                max = fre;
                ans = birdsight;
            }
        }
        return ans;
    }

    private static boolean canWin(int leap, int[] game, int i) {
        // Base cases
        if (i >= game.length) {
            return true; // If we're beyond the array, we've won
        }
        if (i < 0 || game[i] == 1) {
            return false; // If we're out of bounds or on a blocked cell, we can't proceed
        }

        // Mark the current cell as visited
        game[i] = 1;

        // Try all possible moves: forward, leap forward, and backward
        return canWin(leap, game, i + leap) || canWin(leap, game, i + 1) || canWin(leap, game, i - 1);
    }

    private static void QueryProcess(List<List<Integer>> outer, List<Integer> query) {
        //41 77 74 22 44
        //1,3
        try {
            int selectList = query.get(0) - 1;
            int idx = query.get(1);
            System.out.println(outer.get(selectList).get(idx));
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}
/////////////////      1
//        List<Integer>s =new ArrayList<>();
//        s.add(1 );s.add(3 );s.add(2 );s.add(6 );s.add(1 );s.add(2 );
//        System.out.println(divisibleSumPairs(6,3,s));
////////////////            2
//Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] array = new int[n];
//        int count =0;
//        for ( int i = 0 ;i<n ; i++){
//            array[i]=sc.nextInt();
//            if (array[i]<0) count++;   // single digit -ve counted here
//        }
//        for (int i = 0 ; i <n;i++){
//            for(int j = i+1 ;j<n;j++){
//                int x = j;
//                int sum=0;
//                while(x>i+1){
//                    sum+=array[j];
//                    x--;
//                }
//                if (sum<0)count++;
//            }
//        }
//        System.out.println(count);
////////////////////        3
//Scanner sc = new Scanner(in);
//        int n = sc.nextInt();
//        List<List<Integer>> outer = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            int m =sc.nextInt();
//            if (m==0){
//                ArrayList<Integer> inner = new ArrayList<>(m);
//                outer.add(inner);
//            }
//            else {
//                ArrayList<Integer> inner = new ArrayList<>(m);
//            for (int j = 0; j < m; j++) {
//                inner.add(sc.nextInt());
//            }
//            outer.add(inner);
//            }
//        }
//        n= sc.nextInt();
//        List<List<Integer>> Query = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            List<Integer> set = new ArrayList<>(2);
//            set.add(sc.nextInt());
//            set.add(sc.nextInt());
//            Query.add(set);
//        }
////        System.out.println(outer);
////        System.out.println(query);
//        String ans = " ";
//        for(List<Integer> query : Query){
//            QueryProcess(outer,query);
//        }
////////////////////////////////     4
//Scanner sc = new Scanner(System.in);
//        int Nqueries = sc.nextInt();       // Number of Queries to be performed
//        for (int i = 0; i < Nqueries; i++) {
//            int n = sc.nextInt();          // Size of the game array
//            int leap = sc.nextInt();       // Leap value
//            int[] game = new int[n];
//            for (int j = 0; j < n; j++) {
//                game[j] = sc.nextInt();
//            }
//            // Check if we can win the game
//            if (canWin(leap, game, 0)) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//        sc.close();


//////////////              5
//Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt() ;
//        List<Integer> list = new ArrayList<>(size);
//        for (int i = 0; i <size; i++) {
//            list.set(i,sc.nextInt());
//        }
//        int q = sc.nextInt();
//        for (int i = 0; i <q; i++) {
//            String query = sc.next();
//            if (query.equals("Insert")){
//                int x  = sc.nextInt();
//                int y =  sc.nextInt();
//                if (x<size)list.set(x,y);
//            }
//            else if (query.equals("Delete")){
//                int del= sc.nextInt();
//                if (del>=0 && del<list.size()) list.remove(del);
//            }
//        }
//        for(int num : list) System.out.print(num+" ");