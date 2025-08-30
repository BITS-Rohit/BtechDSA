package  btech;

import java.io.*;
import java.util.*;

public class FlashcardApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Flashcard> flashcards = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Load flashcards from a file if persistence is enabled
        System.out.println("Enable persistence (load/save flashcards)? (y/n)");
        boolean persistenceEnabled = sc.nextLine().equalsIgnoreCase("y");
        if (persistenceEnabled) {
            flashcards = loadFlashcards();
        } else {
            initializeFlashcards(flashcards);
        }

        // Allow user to add custom flashcards
        System.out.println("Add custom flashcards? (y/n)");
        boolean customFlashcardsEnabled = sc.nextLine().equalsIgnoreCase("y");
        if (customFlashcardsEnabled) {
            addCustomFlashcards(flashcards, sc);
        }

        // Flashcard mode menu
        System.out.println("Choose a mode:");
        System.out.println("1. Regular Flashcards (Jap to Eng)");
        System.out.println("2. Reverse Flashcards (Eng to Jap)");
        System.out.println("3. Hiragana Chart");
        System.out.println("4. Katakana Chart");
        System.out.println("5. Timed Practice Mode");
        System.out.print("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                flashcardPractice(flashcards, false, sc, false);
                break;
            case 2:
                flashcardPractice(flashcards, true, sc, false);
                break;
            case 3:
                printHiragana();
                break;
            case 4:
                printKatakana();
                break;
            case 5:
                flashcardPractice(flashcards, false, sc, true);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
        }

        // Save flashcards if persistence is enabled
        if (persistenceEnabled) {
            saveFlashcards(flashcards);
        }

        sc.close();
    }

    static void initializeFlashcards(ArrayList<Flashcard> flashcards) {
        // Initialize flashcards with default data
        flashcards.add(new Flashcard("あの (ano)", "um...; that . . . (over there)"));
        flashcards.add(new Flashcard("いま (ima)", "now"));
        flashcards.add(new Flashcard("えいご (eigo)", "English (language)"));
        flashcards.add(new Flashcard("ええ (ee)", "yes"));
        // Add more flashcards as needed
    }

    static void flashcardPractice(ArrayList<Flashcard> flashcards, boolean reverse, Scanner sc, boolean timed) {
        System.out.println("\nFlashcard Practice! Type 'flip' to see the answer, 'exit' to quit.\n");

        int index = 0;
        Collections.shuffle(flashcards); // Shuffle for variety
        while (true) {
            Flashcard card = flashcards.get(index);
            System.out.print("Flashcard: " + (reverse ? card.getRevQuestion() : card.question()));

            long startTime = System.currentTimeMillis();
            String command = sc.nextLine().trim();
            long elapsedTime = System.currentTimeMillis() - startTime;

            if (command.equalsIgnoreCase("flip") || command.equalsIgnoreCase("f") || command.isEmpty()) {
                System.out.println("Answer: " + (reverse ? card.getRevAnswer() : card.answer()));
                System.out.println();
                index++;
                if (index >= flashcards.size()) {
                    System.out.println("You've gone through all the flashcards. Restarting...");
                    Collections.shuffle(flashcards);
                    index = 0;
                }
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting practice mode.");
                break;
            } else {
                System.out.println("Invalid command. Type 'flip' or 'exit'.");
            }

            if (timed && elapsedTime > 5000) { // 5-second timer for timed mode
                System.out.println("Time's up! Moving to the next flashcard.");
                index++;
            }
        }
    }

    static void addCustomFlashcards(ArrayList<Flashcard> flashcards, Scanner sc) {
        System.out.println("Add your custom flashcards. Type 'done' to finish.");
        while (true) {
            System.out.print("Enter Japanese word/phrase: ");
            String question = sc.nextLine();
            if (question.equalsIgnoreCase("done")) break;

            System.out.print("Enter English meaning: ");
            String answer = sc.nextLine();
            flashcards.add(new Flashcard(question, answer));
        }
        System.out.println("Custom flashcards added.");
    }

    static void saveFlashcards(ArrayList<Flashcard> flashcards) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flashcards.dat"))) {
            oos.writeObject(flashcards);
            System.out.println("Flashcards saved successfully.");
        }
    }

    @SuppressWarnings("unchecked")
    static ArrayList<Flashcard> loadFlashcards() throws IOException, ClassNotFoundException {
        File file = new File("flashcards.dat");
        if (!file.exists()) {
            System.out.println("No saved flashcards found. Starting fresh.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Flashcards loaded successfully.");
            return (ArrayList<Flashcard>) ois.readObject();
        }
    }

    static void printHiragana() {
        System.out.println("Hiragana Chart:");
        System.out.println("あ (a) い (i) う (u) え (e) お (o)");
        System.out.println("か (ka) き (ki) く (ku) け (ke) こ (ko)");
        // Add the complete chart
    }

    static void printKatakana() {
        System.out.println("Katakana Chart:");
        System.out.println("ア (a) イ (i) ウ (u) エ (e) オ (o)");
        System.out.println("カ (ka) キ (ki) ク (ku) ケ (ke) コ (ko)");
        // Add the complete chart
    }
}

record Flashcard(String question, String answer) implements Serializable {

    public String getRevQuestion() {
        return answer;
    }

    public String getRevAnswer() {
        return question;
    }
}


//               flashcards.add(new Flashcard("あの (ano)", "um...;that . . . (over there)"));
//        flashcards.add(new Flashcard("いま (ima)", "now"));
//        flashcards.add(new Flashcard("えいご (eigo)", "English (language)"));
//        flashcards.add(new Flashcard("ええ (ee)", "yes"));
//        flashcards.add(new Flashcard("がくせい (gakusei)", "student"));
//        flashcards.add(new Flashcard("～ご (go)", "...language (e.g., Japanese language)"));
//        flashcards.add(new Flashcard("こうこう (koukou)", "high school"));
//        flashcards.add(new Flashcard("ごご (gogo)", "P.M."));
//        flashcards.add(new Flashcard("ごぜん (gozen)", "A.M."));
//        flashcards.add(new Flashcard("～さい (sai)", "...years old"));
//        flashcards.add(new Flashcard("～さん (san)", "Mr./Ms."));
//        flashcards.add(new Flashcard("～じ (ji)", "o'clock (e.g.one o'clock)"));
//        flashcards.add(new Flashcard("～じん (jin)", "...people (e.g.,  Japanese people)"));
//        flashcards.add(new Flashcard("せんこう (senkou)", "major"));
//        flashcards.add(new Flashcard("せんせい (sensei)", "teacher; Professor"));
//        flashcards.add(new Flashcard("そうです (soo desu)", "That's right."));
//        flashcards.add(new Flashcard("そうですか (soo desu ka)", "I see; Is that so?"));
//        flashcards.add(new Flashcard("だいがく (daigaku)", "college; university"));
//        flashcards.add(new Flashcard("でんわ (denwa)", "telephone"));
//        flashcards.add(new Flashcard("ともだち (tomodachi)", "friend"));
//        flashcards.add(new Flashcard("なまえ (namae)", "name"));
//        flashcards.add(new Flashcard("なん/なに (nan/nani)", "what"));
//        flashcards.add(new Flashcard("にほん (Nihon)", "Japan"));
//        flashcards.add(new Flashcard("～ねんせい (nensei)", "...year student (e.g.,  first-year student)"));
//        flashcards.add(new Flashcard("はい (hai)", "yes"));
//        flashcards.add(new Flashcard("はん (han)", "half (e.g.,  half past two)"));
//        flashcards.add(new Flashcard("ばんごう (bangoo)", "number"));
//        flashcards.add(new Flashcard("りゅうがくせい (ryuugakusei)", "international student"));
//        flashcards.add(new Flashcard("わたし (watashi)", "I"));
//
//        // Countries
//        flashcards.add(new Flashcard("アメリカ (Amerika)", "U.S.A."));
//        flashcards.add(new Flashcard("イギリス (Igirisu)", "Britain"));
//        flashcards.add(new Flashcard("オーストラリア (Oosutoraria)", "Australia"));
//        flashcards.add(new Flashcard("かんこく (Kankoku)", "Korea"));
//        flashcards.add(new Flashcard("スウェーデン (Suweeden)", "Sweden"));
//        flashcards.add(new Flashcard("ちゅうごく (Chuugoku)", "China"));
//
//        // Majors
//        flashcards.add(new Flashcard("かがく (kagaku)", "science"));
//        flashcards.add(new Flashcard("アジアけんきゅう (ajia kenkyuu)", "Asian studies"));
//        flashcards.add(new Flashcard("けいざい (keizai)", "economics"));
//        flashcards.add(new Flashcard("こくさいかんけい (kokusai kankei)", "international relations"));
//        flashcards.add(new Flashcard("コンピューター (konpyuutaa)", "computer"));
//        flashcards.add(new Flashcard("じんるいがく (jinruigaku)", "anthropology"));
//        flashcards.add(new Flashcard("せいじ (seiji)", "politics"));
//        flashcards.add(new Flashcard("ビジネス (bijinesu)", "business"));
//        flashcards.add(new Flashcard("ぶんがく (bungaku)", "literature"));
//        flashcards.add(new Flashcard("れきし (rekishi)", "history"));
//
//        // Occupations
//        flashcards.add(new Flashcard("しごと (shigoto)", "job; work; occupation"));
//        flashcards.add(new Flashcard("いしゃ (isha)", "doctor"));
//        flashcards.add(new Flashcard("かいしゃいん (kaishain)", "office worker"));
//        flashcards.add(new Flashcard("こうこうせい (koukousei)", "high school student"));
//        flashcards.add(new Flashcard("しゅふ (shufu)", "housewife"));
//        flashcards.add(new Flashcard("だいがくいんせい (daigakuinsei)", "graduate student"));
//        flashcards.add(new Flashcard("だいがくせい (daigakusei)", "college student"));
//        flashcards.add(new Flashcard("べんごし (bengoshi)", "lawyer"));
//
//        // Family
//        flashcards.add(new Flashcard("おかあさん (okaasan)", "mother"));
//        flashcards.add(new Flashcard("おとうさん (otoosan)", "father"));
//        flashcards.add(new Flashcard("おねえさん (oneesan)", "older sister"));
//        flashcards.add(new Flashcard("おにいさん (oniisan)", "older brother"));
//        flashcards.add(new Flashcard("いもうと (imooto)", "younger sister"));
//        flashcards.add(new Flashcard("おとうと (otooto)", "younger brother"));
//
//        ///////////////////////////////////----59 ---- /////////////////////////////////
//        flashcards.add(new Flashcard("これ (kore)", "this one"));
//        flashcards.add(new Flashcard("それ (sore)", "that one"));
//        flashcards.add(new Flashcard("あれ (are)", "that one (over there)"));
//    flashcards.add(new Flashcard("どれ (dore)", "which one"));
//    flashcards.add(new Flashcard("この (kono)", "this . . ."));
//    flashcards.add(new Flashcard("その (sono)", "that . . ."));
//    flashcards.add(new Flashcard("どの (dono)", "which . . ."));
//    flashcards.add(new Flashcard("ここ (koko)", "here"));
//    flashcards.add(new Flashcard("そこ (soko)", "there"));
//    flashcards.add(new Flashcard("あそこ (asoko)", "over there"));
//    flashcards.add(new Flashcard("どこ (doko)", "where"));
//    flashcards.add(new Flashcard("だれ (dare)", "who"));
//    flashcards.add(new Flashcard("おいしい (oishii)", "delicious"));
//    flashcards.add(new Flashcard("さかな (sakana)", "fish"));
//    flashcards.add(new Flashcard("とんかつ (tonkatsu)", "pork cutlet"));
//    flashcards.add(new Flashcard("にく (niku)", "meat"));
//    flashcards.add(new Flashcard("メニュー (menyuu)", "menu"));
//flashcards.add(new Flashcard("やさい (yasai)", "vegetable"));
//flashcards.add(new Flashcard("えんぴつ (enpitsu)", "pencil"));
//flashcards.add(new Flashcard("かさ (kasa)", "umbrella"));
//flashcards.add(new Flashcard("かばん (kaban)", "bag"));
//flashcards.add(new Flashcard("くつ (kutsu)", "shoes"));
//flashcards.add(new Flashcard("さいふ (saifu)", "wallet"));
//flashcards.add(new Flashcard("ジーンズ (jiinzu)", "jeans"));
//flashcards.add(new Flashcard("じしょ (jisho)", "dictionary"));
//flashcards.add(new Flashcard("じてんしゃ (jitensha)", "bicycle"));
//flashcards.add(new Flashcard("しんぶん (shinbun)", "newspaper"));
//flashcards.add(new Flashcard("Tシャツ (tiishatsu)", "T-shirt"));
//flashcards.add(new Flashcard("とけい (tokei)", "watch; clock"));
//flashcards.add(new Flashcard("きっさてん (kissaten)", "cafe"));
//flashcards.add(new Flashcard("ぎんこう (ginkoo)", "bank"));
//flashcards.add(new Flashcard("トイレ (toire)", "toilet; restroom"));
//flashcards.add(new Flashcard("としょかん (toshokan)", "library"));
//flashcards.add(new Flashcard("ゆうびんきょく (yuubinkyoku)", "post office"));
//flashcards.add(new Flashcard("さくら (sakura)", "cherry blossom"));
//flashcards.add(new Flashcard("きもの (kimono)", "traditional garment"));
//flashcards.add(new Flashcard("すし (sushi)", "vinegared rice dish"));
//flashcards.add(new Flashcard("りんご (ringo)", "apple"));
//flashcards.add(new Flashcard("ノート (nooto)", "notebook"));
//flashcards.add(new Flashcard("ペン (pen)", "pen"));
//flashcards.add(new Flashcard("ぼうし (boushi)", "hat; cap"));
//flashcards.add(new Flashcard("ほん (hon)", "book"));
//flashcards.add(new Flashcard("いくら (ikura)", "how much"));
//flashcards.add(new Flashcard("〜えん (en)", "yen"));
//flashcards.add(new Flashcard("たかい (takai)", "expensive; high"));
//flashcards.add(new Flashcard("いらっしゃいませ (irasshaimase)", "Welcome (to our store)."));
//flashcards.add(new Flashcard("〜をおねがいします (onegai shimasu)", "..., please."));
//flashcards.add(new Flashcard("〜をください (kudasai)", "Please give me ..."));
//flashcards.add(new Flashcard("じゃあ (jaa)", "well then . . . ; if that is the case, . . ."));
//flashcards.add(new Flashcard("どうぞ (douzo)", "Please.; Here it is.;go ahead"));
//flashcards.add(new Flashcard("どうも (doumo)", "Thank you."));
