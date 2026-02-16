package rohit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FlashcardApp {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<FLASHCARD> flashcards = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println();



flashcards.add(new FLASHCARD("あの", "(ano)", "um...; that . . . (over there)"));
flashcards.add(new FLASHCARD("いま", "(ima)", "now"));
flashcards.add(new FLASHCARD("えいご", "(eigo)", "English (language)"));
flashcards.add(new FLASHCARD("ええ", "(ee)", "yes"));
flashcards.add(new FLASHCARD("がくせい", "(gakusei)", "student"));
flashcards.add(new FLASHCARD("～ご", "(go)", "...language (e.g., Japanese language)"));
flashcards.add(new FLASHCARD("こうこう", "(koukou)", "high school"));
flashcards.add(new FLASHCARD("ごご", "(gogo)", "P.M."));
flashcards.add(new FLASHCARD("ごぜん", "(gozen)", "A.M."));
flashcards.add(new FLASHCARD("～さい", "(sai)", "...years old"));
flashcards.add(new FLASHCARD("～さん", "(san)", "Mr./Ms."));
flashcards.add(new FLASHCARD("～じ", "(ji)", "o'clock (e.g. one o'clock)"));
flashcards.add(new FLASHCARD("～じん", "(jin)", "...people (e.g., Japanese people)"));
flashcards.add(new FLASHCARD("せんこう", "(senkou)", "major"));
flashcards.add(new FLASHCARD("せんせい", "(sensei)", "teacher; Professor"));
flashcards.add(new FLASHCARD("そうです", "(soo desu)", "That's right."));
flashcards.add(new FLASHCARD("そうですか", "(soo desu ka)", "I see; Is that so?"));
flashcards.add(new FLASHCARD("だいがく", "(daigaku)", "college; university"));
flashcards.add(new FLASHCARD("でんわ", "(denwa)", "telephone"));
flashcards.add(new FLASHCARD("ともだち", "(tomodachi)", "friend"));
flashcards.add(new FLASHCARD("なまえ", "(namae)", "name"));
flashcards.add(new FLASHCARD("なん/なに", "(nan/nani)", "what"));
flashcards.add(new FLASHCARD("にほん", "(Nihon)", "Japan"));
flashcards.add(new FLASHCARD("～ねんせい", "(nensei)", "...year student (e.g., first-year student)"));
flashcards.add(new FLASHCARD("はい", "(hai)", "yes"));
flashcards.add(new FLASHCARD("はん", "(han)", "half (e.g., half past two)"));
flashcards.add(new FLASHCARD("ばんごう", "(bangoo)", "number"));
flashcards.add(new FLASHCARD("りゅうがくせい", "(ryuugakusei)", "international student"));
flashcards.add(new FLASHCARD("わたし", "(watashi)", "I"));

// Countries
flashcards.add(new FLASHCARD("アメリカ", "(Amerika)", "U.S.A."));
flashcards.add(new FLASHCARD("イギリス", "(Igirisu)", "Britain"));
flashcards.add(new FLASHCARD("オーストラリア", "(Oosutoraria)", "Australia"));
flashcards.add(new FLASHCARD("かんこく", "(Kankoku)", "Korea"));
flashcards.add(new FLASHCARD("スウェーデン", "(Suweeden)", "Sweden"));
flashcards.add(new FLASHCARD("ちゅうごく", "(Chuugoku)", "China"));

// Majors
flashcards.add(new FLASHCARD("かがく", "(kagaku)", "science"));
flashcards.add(new FLASHCARD("アジアけんきゅう", "(ajia kenkyuu)", "Asian studies"));
flashcards.add(new FLASHCARD("けいざい", "(keizai)", "economics"));
flashcards.add(new FLASHCARD("こくさいかんけい", "(kokusai kankei)", "international relations"));
flashcards.add(new FLASHCARD("コンピューター", "(konpyuutaa)", "computer"));
flashcards.add(new FLASHCARD("じんるいがく", "(jinruigaku)", "anthropology"));
flashcards.add(new FLASHCARD("せいじ", "(seiji)", "politics"));
flashcards.add(new FLASHCARD("ビジネス", "(bijinesu)", "business"));
flashcards.add(new FLASHCARD("ぶんがく", "(bungaku)", "literature"));
flashcards.add(new FLASHCARD("れきし", "(rekishi)", "history"));

// Occupations
flashcards.add(new FLASHCARD("しごと", "(shigoto)", "job; work; occupation"));
flashcards.add(new FLASHCARD("いしゃ", "(isha)", "doctor"));
flashcards.add(new FLASHCARD("かいしゃいん", "(kaishain)", "office worker"));
flashcards.add(new FLASHCARD("こうこうせい", "(koukousei)", "high school student"));
flashcards.add(new FLASHCARD("しゅふ", "(shufu)", "housewife"));
flashcards.add(new FLASHCARD("だいがくいんせい", "(daigakuinsei)", "graduate student"));
flashcards.add(new FLASHCARD("だいがくせい", "(daigakusei)", "college student"));
flashcards.add(new FLASHCARD("べんごし", "(bengoshi)", "lawyer"));

// Family
flashcards.add(new FLASHCARD("おかあさん", "(okaasan)", "mother"));
flashcards.add(new FLASHCARD("おとうさん", "(otoosan)", "father"));
flashcards.add(new FLASHCARD("おねえさん", "(oneesan)", "older sister"));
flashcards.add(new FLASHCARD("おにいさん", "(oniisan)", "older brother"));
flashcards.add(new FLASHCARD("いもうと", "(imooto)", "younger sister"));
flashcards.add(new FLASHCARD("おとうと", "(otooto)", "younger brother"));

// Additional vocabulary
flashcards.add(new FLASHCARD("これ", "(kore)", "this one"));
flashcards.add(new FLASHCARD("それ", "(sore)", "that one"));
flashcards.add(new FLASHCARD("あれ", "(are)", "that one (over there)"));
flashcards.add(new FLASHCARD("どれ", "(dore)", "which one"));
flashcards.add(new FLASHCARD("この", "(kono)", "this . . ."));
flashcards.add(new FLASHCARD("その", "(sono)", "that . . ."));
flashcards.add(new FLASHCARD("どの", "(dono)", "which . . ."));
flashcards.add(new FLASHCARD("ここ", "(koko)", "here"));
flashcards.add(new FLASHCARD("そこ", "(soko)", "there"));
flashcards.add(new FLASHCARD("あそこ", "(asoko)", "over there"));
flashcards.add(new FLASHCARD("どこ", "(doko)", "where"));
flashcards.add(new FLASHCARD("だれ", "(dare)", "who"));
flashcards.add(new FLASHCARD("おいしい", "(oishii)", "delicious"));
flashcards.add(new FLASHCARD("さかな", "(sakana)", "fish"));
flashcards.add(new FLASHCARD("とんかつ", "(tonkatsu)", "pork cutlet"));
flashcards.add(new FLASHCARD("にく", "(niku)", "meat"));
flashcards.add(new FLASHCARD("メニュー", "(menyuu)", "menu"));
flashcards.add(new FLASHCARD("やさい", "(yasai)", "vegetable"));
flashcards.add(new FLASHCARD("えんぴつ", "(enpitsu)", "pencil"));
flashcards.add(new FLASHCARD("かさ", "(kasa)", "umbrella"));
flashcards.add(new FLASHCARD("かばん", "(kaban)", "bag"));
flashcards.add(new FLASHCARD("くつ", "(kutsu)", "shoes"));
flashcards.add(new FLASHCARD("さいふ", "(saifu)", "wallet"));
flashcards.add(new FLASHCARD("ジーンズ", "(jiinzu)", "jeans"));
flashcards.add(new FLASHCARD("じしょ", "(jisho)", "dictionary"));
flashcards.add(new FLASHCARD("じてんしゃ", "(jitensha)", "bicycle"));
flashcards.add(new FLASHCARD("しんぶん", "(shinbun)", "newspaper"));
flashcards.add(new FLASHCARD("Tシャツ", "(tiishatsu)", "T-shirt"));
flashcards.add(new FLASHCARD("とけい", "(tokei)", "watch; clock"));
flashcards.add(new FLASHCARD("きっさてん", "(kissaten)", "cafe"));
flashcards.add(new FLASHCARD("ぎんこう", "(ginkoo)", "bank"));
flashcards.add(new FLASHCARD("トイレ", "(toire)", "toilet; restroom"));
flashcards.add(new FLASHCARD("としょかん", "(toshokan)", "library"));
flashcards.add(new FLASHCARD("ゆうびんきょく", "(yuubinkyoku)", "post office"));
flashcards.add(new FLASHCARD("さくら", "(sakura)", "cherry blossom"));
flashcards.add(new FLASHCARD("きもの", "(kimono)", "traditional garment"));
flashcards.add(new FLASHCARD("すし", "(sushi)", "vinegared rice dish"));
flashcards.add(new FLASHCARD("りんご", "(ringo)", "apple"));
flashcards.add(new FLASHCARD("ノート", "(nooto)", "notebook"));
flashcards.add(new FLASHCARD("ペン", "(pen)", "pen"));
flashcards.add(new FLASHCARD("ぼうし", "(boushi)", "hat; cap"));
flashcards.add(new FLASHCARD("ほん", "(hon)", "book"));
flashcards.add(new FLASHCARD("いくら", "(ikura)", "how much"));
flashcards.add(new FLASHCARD("〜えん", "(en)", "yen"));
flashcards.add(new FLASHCARD("たかい", "(takai)", "expensive; high"));
flashcards.add(new FLASHCARD("いらっしゃいませ", "(irasshaimase)", "Welcome (to our store)."));
flashcards.add(new FLASHCARD("〜をおねがいします", "(onegai shimasu)", "..., please."));
flashcards.add(new FLASHCARD("〜をください", "(kudasai)", "Please give me ..."));
flashcards.add(new FLASHCARD("じゃあ", "(jaa)", "well then . . . ; if that is the case, . . ."));
flashcards.add(new FLASHCARD("どうぞ", "(douzo)", "Please.; Here it is.; go ahead"));
flashcards.add(new FLASHCARD("どうも", "(doumo)", "Thank you."));
flashcards.add(new FLASHCARD("こんや", "(konya)", "Tonight."));
flashcards.add(new FLASHCARD("もどって", "(modotte)", "Return."));
flashcards.add(new FLASHCARD("わかりましたか", "(Wakarimashita ka)", "Do you understand?"));
flashcards.add(new FLASHCARD("わかりました", "(Wakarimashita)", "I understand./I understood."));
flashcards.add(new FLASHCARD("わかりません", "(Wakarimasen)", "I don’t understand./I don’t know."));
flashcards.add(new FLASHCARD("ゆっくりいってください", "(Yukkuri itte kudasai)", "Please say it slowly."));
flashcards.add(new FLASHCARD("もういちどいってください", "(Moo ichido itte kudasai)", "Please say it again."));
flashcards.add(new FLASHCARD("ちょっとまってください", "(Chotto matte kudasai)", "Please wait."));
flashcards.add(new FLASHCARD("きいてください", "(Kiite kudasai)", "Please listen./Please ask."));
flashcards.add(new FLASHCARD("10ページをみてください", "(Juppeeji o mite kudasai)", "Please look at page 10."));
flashcards.add(new FLASHCARD("えいが", "(eiga)", "Movie"));
flashcards.add(new FLASHCARD("おんがく", "(ongaku)", "Music"));
flashcards.add(new FLASHCARD("ざっし", "(zasshi)", "Magazine"));
flashcards.add(new FLASHCARD("スポーツ", "(supootsu)", "Sports"));
flashcards.add(new FLASHCARD("デート", "(deeto)", "Date (romantic, not calendar)"));
flashcards.add(new FLASHCARD("テニス", "(tenisu)", "Tennis"));
flashcards.add(new FLASHCARD("テレビ", "(terebi)", "TV"));
flashcards.add(new FLASHCARD("つき", "(tsuki)", "Moon"));

flashcards.add(new FLASHCARD("アイスクリーム", "(aisukuriimu)", "Ice cream"));
flashcards.add(new FLASHCARD("あさごはん", "(asagohan)", "Breakfast"));
flashcards.add(new FLASHCARD("おさけ", "(osake)", "Sake; alcohol"));
flashcards.add(new FLASHCARD("おちゃ", "(ocha)", "Green tea"));
flashcards.add(new FLASHCARD("コーヒー", "(koohii)", "Coffee"));
flashcards.add(new FLASHCARD("ばんごはん", "(bangohan)", "Dinner"));
flashcards.add(new FLASHCARD("ハンバーガー", "(hanbaagaa)", "Hamburger"));
flashcards.add(new FLASHCARD("ひるごはん", "(hirugohan)", "Lunch"));
flashcards.add(new FLASHCARD("みず", "(mizu)", "Water"));

flashcards.add(new FLASHCARD("いえ", "(ie)", "Home; house; No"));
flashcards.add(new FLASHCARD("うち", "(uchi)", "Home; house; my place"));
flashcards.add(new FLASHCARD("がっこう", "(gakkou)", "School"));

flashcards.add(new FLASHCARD("あさ", "(asa)", "Morning"));
flashcards.add(new FLASHCARD("あした", "(ashita)", "Tomorrow"));
flashcards.add(new FLASHCARD("いつ", "(itsu)", "When"));
flashcards.add(new FLASHCARD("きょう", "(kyou)", "Today"));
flashcards.add(new FLASHCARD("～ごろ", "(~goro)", "At about..."));
flashcards.add(new FLASHCARD("こんばん", "(konban)", "Evening; Tonight"));
flashcards.add(new FLASHCARD("しゅうまつ", "(shuumatsu)", "Weekend"));
flashcards.add(new FLASHCARD("どようび", "(doyoubi)", "Saturday"));

// U-Verbs
flashcards.add(new FLASHCARD("いく", "(iku)", "To go (destination に/へ)"));
flashcards.add(new FLASHCARD("かえる", "(kaeru)", "To go back; to return (destination に/へ)"));
flashcards.add(new FLASHCARD("きく", "(kiku)", "To listen; to hear (~を)"));
flashcards.add(new FLASHCARD("のむ", "(nomu)", "To drink (~を)"));
flashcards.add(new FLASHCARD("はなす", "(hanasu)", "To speak; to talk (language をして)"));
flashcards.add(new FLASHCARD("よむ", "(yomu)", "To read (~を)"));

// Ru-Verbs
flashcards.add(new FLASHCARD("おきる", "(okiru)", "To get up"));
flashcards.add(new FLASHCARD("たべる", "(taberu)", "To eat (~を)"));
flashcards.add(new FLASHCARD("ねる", "(neru)", "To sleep; to go to sleep"));
flashcards.add(new FLASHCARD("みる", "(miru)", "To see; to look at; to watch (~を)"));

// Irregular Verbs
flashcards.add(new FLASHCARD("くる", "(kuru)", "To come (destination に/へ)"));
flashcards.add(new FLASHCARD("する", "(suru)", "To do (~を)"));
flashcards.add(new FLASHCARD("べんきょうする", "(benkyou suru)", "To study (~を)"));

// Adjectives
flashcards.add(new FLASHCARD("いい", "(ii)", "Good"));
flashcards.add(new FLASHCARD("はやい", "(hayai)", "Early"));

// Adverbs
flashcards.add(new FLASHCARD("あまり + negative", "(amari + negative)", "Not much"));
flashcards.add(new FLASHCARD("ぜんぜん + negative", "(zenzen + negative)", "Not at all"));
flashcards.add(new FLASHCARD("たいてい", "(taitei)", "Usually"));
flashcards.add(new FLASHCARD("ちょっと", "(chotto)", "A little"));
flashcards.add(new FLASHCARD("ときどき", "(tokidoki)", "Sometimes"));
flashcards.add(new FLASHCARD("よく", "(yoku)", "Often; much"));

// Expressions
flashcards.add(new FLASHCARD("そうですね", "(sou desu ne)", "That's right; Let me see."));
flashcards.add(new FLASHCARD("でも", "(demo)", "But"));
flashcards.add(new FLASHCARD("どうですか", "(dou desu ka)", "How about ...?; How is ...?"));

// New Add-ons
flashcards.add(new FLASHCARD("お疲れ様です", "(otsukaresama desu)", "Thank you for your hard work"));
flashcards.add(new FLASHCARD("すごい", "(sugoi)", "Amazing / Wow"));
flashcards.add(new FLASHCARD("どうやって？", "(dou yatte?)", "How do I do it?"));
flashcards.add(new FLASHCARD("いただきます", "(itadakimasu)", "A phrase said before eating (like 'Let’s eat')"));
flashcards.add(new FLASHCARD("ごちそうさまでした", "(gochisousama deshita)", "A phrase said after eating (like 'Thank you for the meal')"));
flashcards.add(new FLASHCARD("やっほー", "(yahho)", "Hey! (informal greeting among close friends)"));
flashcards.add(new FLASHCARD("行こう", "(ikou)", "Let’s go!")); // Expression for making plans
flashcards.add(new FLASHCARD("マジで？", "(maji de?)", "Really? / Seriously?"));
flashcards.add(new FLASHCARD("ウケる", "(ukeru)", "That’s funny / Hilarious"));
flashcards.add(new FLASHCARD("だるい", "(darui)", "I feel lazy / I don’t feel like it"));
flashcards.add(new FLASHCARD("いいね", "(ii ne)", "Sounds good / That’s nice"));
flashcards.add(new FLASHCARD("やばい", "(yabai)", "OMG! / That’s crazy (positive/negative context)"));
flashcards.add(new FLASHCARD("そうなんだ", "(sou nanda)", "Oh, I see!"));
flashcards.add(new FLASHCARD("うそ！", "(uso!)", "No way! / You’re kidding!"));
flashcards.add(new FLASHCARD("まじか！", "(maji ka!)", "Seriously? (informal)"));
flashcards.add(new FLASHCARD("いいじゃん", "(ii jan)", "That’s good, isn’t it?"));
flashcards.add(new FLASHCARD("ノート見せて", "(nooto misete)", "Can I see your notes?"));
flashcards.add(new FLASHCARD("どこ行く？", "(doko iku?)", "Where are we going?")); // Expression for making plans
flashcards.add(new FLASHCARD("じゃあね", "(jaa ne)", "See you / Later"));
flashcards.add(new FLASHCARD("またね", "(mata ne)", "See you again / See you later"));
flashcards.add(new FLASHCARD("バイバイ", "(bai bai)", "Bye-bye (common among friends)"));
flashcards.add(new FLASHCARD("カラオケ行こう", "(karaoke ikou)", "Let’s go to karaoke!")); // Expression for making plans

// Expressions
flashcards.add(new FLASHCARD("そうですね", "(sou desu ne)", "That's right; Let me see."));
flashcards.add(new FLASHCARD("でも", "(demo)", "But"));
flashcards.add(new FLASHCARD("ひとり", "(hitori)", "One person , alone"));
flashcards.add(new FLASHCARD("おてら", "(otera)", "Temple"));
flashcards.add(new FLASHCARD("だから", "(dakara)", "that's why"));
flashcards.add(new FLASHCARD("どうですか", "(dou desu ka)", "How about ...?; How is ...?"));
flashcards.add(new FLASHCARD("おかいけい おねがいします", "(okaikei onegaishimasu)", "The bill, please"));
flashcards.add(new FLASHCARD("ほうかご なに する？", "(houkago nani suru?)", "What are we doing after school?")); // Expression for making plans
flashcards.add(new FLASHCARD("おつかれさま です", "(otsukaresama desu)", "Thank you for your hard work"));
flashcards.add(new FLASHCARD("だいじょうぶ", "(daijoubu)", "It's okay / I'm fine / Are you okay?"));
flashcards.add(new FLASHCARD("ひさしぶり", "(hisashiburi)", "Long time no see!"));
flashcards.add(new FLASHCARD("めんどうくさい", "(mendokusai)", "That’s a hassle / What a pain"));
flashcards.add(new FLASHCARD("ほんとうに？", "(hontou ni?)", "Really?"));
flashcards.add(new FLASHCARD("ほんとう ですか？", "(hontou desu ka?)", "Really? / Is that true?"));
flashcards.add(new FLASHCARD("おしえて", "(oshiete)", "Teach me / Tell me (used to ask for help)"));
flashcards.add(new FLASHCARD("テスト たいへん だった", "(tesuto taihen datta)", "The test was tough."));
flashcards.add(new FLASHCARD("ひま だな", "(hima dana)", "I’m bored."));
flashcards.add(new FLASHCARD("げんき？", "(genki?)", "How are you? / You good?"));
flashcards.add(new FLASHCARD("しゅくだい やった？", "(shukudai yatta?)", "Did you do the homework?"));
flashcards.add(new FLASHCARD("あそぼう", "(asobou)", "Let’s hang out / Let’s play")); // Expression for making plans
flashcards.add(new FLASHCARD("ちょう かわいい", "(chou kawaii)", "Super cute!"));



//////////////////////------------------/////////////////////////////////////////

        Collections.shuffle(flashcards);
        System.out.println("1. Regular type Flashcards!     (Jap to Eng)");
        System.out.println("2. Specific type Flashcards!    (Eng to Jap)");
        System.out.print(" [||]=>");
        UI(sc,flashcards);
    }
    static void UI(Scanner sc,ArrayList<FLASHCARD> flashcards){
        int choice = sc.nextInt();
        Scanner scanner = new Scanner(System.in);
        if (choice==1){
            System.out.println("\nWelcome to Flashcard Practice! Type 'flip' ot 'f' to flip a card \n 'exit' to quit. (rotation 1 )\n");
            int index = 0;
            int rotator=1;
            while (true) {
                FLASHCARD card = flashcards.get(index);
                System.out.print(index+1+" Flashcard: " + card.getQuestion());
                String command;
                command = scanner.nextLine().trim();
                if (command.equalsIgnoreCase("r")){
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");
                    System.out.println("Romanji : "+ card.getRomaji());
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");
                        System.out.println("Answer: " + card.getAnswer());
                    System.out.println();
                    index++;
                    if (index+1> flashcards.size()){            // Loop through flashcards
                        rotator++;
                        System.out.println("Flashcard data limit reached , now restarting ...(rotation "+rotator+")\n");
                        Collections.shuffle(flashcards);
                        index=0;
                    }
                    }
                else if (command.equalsIgnoreCase("flip")||
                        command.equalsIgnoreCase("f")||
                        command.equalsIgnoreCase("")) {
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");

                    System.out.println("Answer: " + card.getAnswer());
                    System.out.println();
                    index++;
                    if (index+1> flashcards.size()){            // Loop through flashcards
                        rotator++;
                        System.out.println("Flashcard data limit reached , now restarting ...(rotation "+rotator+")\n");
                        Collections.shuffle(flashcards);
                        index=0;
                    }
                } else if (command.equalsIgnoreCase("exit")) break;
                else {
                    System.out.println("Invalid command. Type 'flip' to flip the card, 'exit' to quit.");
                }
            }
            scanner.close();
            System.out.println("Thank you for practicing!");
        }
        else if (choice==2) {
            System.out.println("\nWelcome to Flashcard Practice! Type 'flip' ot 'f' to flip a card \n 'exit' to quit. (rotation 1 )\n");
            int index = 0;
            int rotator=1;
            while (true) {
                FLASHCARD card = flashcards.get(index);
                System.out.print(index+1+" Flashcard: " + card.getRevQuestion());
                String command;
                command = scanner.nextLine().trim();
                if (command.equalsIgnoreCase("r")){
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");
                    System.out.println("Romanji : "+ card.getRomaji());
                    /////////////
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");
                        System.out.println("Answer: " + card.getRevAnswer());
                    System.out.println();
                    index++;
                    if (index+1> flashcards.size()){            // Loop through flashcards
                        rotator++;
                        System.out.println("Flashcard data limit reached , now restarting ...(rotation "+rotator+")\n");
                        Collections.shuffle(flashcards);
                        index=0;
                    }
                }
                else if (command.equalsIgnoreCase("flip")||
                        command.equalsIgnoreCase("f")||
                        command.equalsIgnoreCase("")) {
                    if (index<10) System.out.print("   ");
                    else if (index<100) System.out.print("     ");
                    else if (index<1000)System.out.print("       ");
                    else if (index<10000)System.out.print("         ");
                    else System.out.print("           ");
                    if (command.equalsIgnoreCase("r")){
                        System.out.println("Romanji : "+ card.getRomaji());
                    }
                    System.out.println("Answer: " + card.getRevAnswer());
                    System.out.println();
                    index++;
                    if (index+1> flashcards.size()){            // Loop through flashcards
                        rotator++;
                        System.out.println("Flashcard data limit reached , now restarting ...(rotation "+rotator+")\n");
                        Collections.shuffle(flashcards);
                        index=(index+1)% flashcards.size();
                    }
                } else if (command.equalsIgnoreCase("exit")) break;
                else {
                    System.out.println("Invalid command. Type 'flip' to flip the card, 'exit' to quit.");
                }
            }
            scanner.close();
            System.out.println("Thank you for practicing!");
        }
        else {
            System.out.println("That chocie does not exist . \n Try again ");
            System.out.print(" [||]=>");
            // Re-call the method
            UI(sc,flashcards);
        }
        sc.close();
    }
}
class FLASHCARD {
    private final String question;
    private final String romaji;
    private final String answer;
    private int count;

    public FLASHCARD(String question, String romaji, String answer) {
        this.question = question;
        this.romaji = romaji;
        this.answer = answer;
        this.count++;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getRevQuestion(){return answer;}

    public String getRevAnswer() {return question;}

    public String getRomaji(){return romaji;}

    @Override
    public String toString() {
        return "Q: " + question + " | A: " + answer;
    }
}
//(otsukaresama desu)
//