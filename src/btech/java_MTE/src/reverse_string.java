public class reverse_string {
    public static String reverseString(String str) {
        // Check if the string is empty or null
        if (str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }
    public static void main(String[] args) {
        String str = "Code copy karke aukat dikha di!";
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverseString(str));
    }
}
