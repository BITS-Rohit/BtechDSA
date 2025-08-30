package JAVA.PRACTICE.Recusion;
import java.util.ArrayList;
import java.util.Scanner;

public class Flashcards {
    public static void main(String[] args) {
        ArrayList<String[]> vocabulary = new ArrayList<>();
        vocabulary.add(new String[]{"あいさつ", "Greeting"});
        vocabulary.add(new String[]{"あう", "To meet"});
        vocabulary.add(new String[]{"あお", "Blue"});
        vocabulary.add(new String[]{"あかい", "Red"});

        Scanner scanner = new Scanner(System.in);
        for (String[] word : vocabulary) {
            System.out.println("What is the meaning of: " + word[0]);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase(word[1])) System.out.println("Correct");
            else System.out.println("No , Correct answer: " + word[1]);
        }
        scanner.close();
    }
}
