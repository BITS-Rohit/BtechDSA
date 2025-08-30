package JAVA.PRACTICE.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) {
//        MapsUsingHash maphash = new MapsUsingHash();
//        maphash.put("Rohit", 100);
//        maphash.put("Jas", 99);
//        maphash.put("None", 98);
//
//        System.out.println(maphash.get("Rohit"));
//        System.out.println(maphash.containsKey("Rohit"));
//        System.out.println(maphash.getOrDefault("Rohit",200));
//        System.out.println();
//        maphash.valueSet();
//        System.out.println();
//        maphash.keySet();
//        System.out.println();
//        maphash.entrySet();
        int[] nums = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        Main m = new Main();
        m.distinctEleCount(nums,k);
    }
    public void distinctEleCount(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        distinctEleCount(nums, k, map, list, 0);
        System.out.println(list);
    }
    private void distinctEleCount(
            int[] nums, int k,
            HashMap<Integer, Integer> map,
            List<Integer> list, int start)
    {
        if (start + k > nums.length) {
            return; // End of array
        }

        // Initialize the map for the first window
        if (start == 0) {
            for (int i = 0; i < k; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            list.add(map.size());
        } else {
            // Slide the window
            int outElement = nums[start - 1];
            int inElement = nums[start + k - 1];

            // Remove the outgoing element
            if (map.get(outElement) == 1) {
                map.remove(outElement);
            } else {
                map.put(outElement, map.get(outElement) - 1);
            }

            // Add the incoming element
            map.put(inElement, map.getOrDefault(inElement, 0) + 1);

            // Add the count of distinct elements for the current window
            list.add(map.size());
        }

        // Recursive call to process the next window
        distinctEleCount(nums, k, map, list, start + 1);
    }

}
