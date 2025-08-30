import java.util.*;

public class _FlashcardApp_ {

    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        FlashcardManager manager = new FlashcardManager();
        manager.addInitialFlashcards();
        manager.addInitialKanji();
        Scanner scanner = new Scanner(System.in);
        boolean running=true;
        while (running) {
            System.out.println("  Welcome to the Flashcard Practice App!");
            System.out.println("  Please choose an option:");
            System.out.println("    1.   Practice Kanji ("+manager.getKanjiCount()+")");
            System.out.println("    2.   Practice Vocabulary ("+manager.getFlashcardCount()+")");
            System.out.println("    3.   Exit");

            System.out.print("    :-> ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    manager.practiceKanji();
                    break;
                case 2:
//                    manager.addInitialFlashcards();
                    manager.practiceFlashcards();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye! Happy studying!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

class FlashcardManager {
    private final List<FlashCard> flashcards;
    private final List<FlashCard> kanjiCards;

    public FlashcardManager() {
        this.flashcards = new ArrayList<>();
        this.kanjiCards = new ArrayList<>();
    }

    public int getFlashcardCount() {
        return flashcards.size();
    }

    public int getKanjiCount() {
        return kanjiCards.size();
    }

    void practiceKanji() {
        System.out.println("This is where you can practice kanji.");
        System.out.println("This function is under development. Stay tuned!");
    }

    private void addFlashcard(String question, String answer) {
        flashcards.add(new FlashCard(question, answer));
    }

    private void addKanji(String kanji, String meaning) {
        kanjiCards.add(new FlashCard(kanji, meaning));
    }
    void addInitialKanji(){}
    void addInitialFlashcards() {
        addFlashcard("あの (ano)", "um...");
        addFlashcard("いま (ima)", "now");
        addFlashcard("えいご (eego)", "English (language)");
        addFlashcard("ええ (ee)", "yes");
        addFlashcard("がくせい (gakusei)", "student");
        addFlashcard("～ご (go)", "...language (e.g., にほんご (nihongo) Japanese language)");
        addFlashcard("こうこう (kookoo)", "high school");
        addFlashcard("ごご (gogo)", "P.M.");
        addFlashcard("ごぜん (gozen)", "A.M.");
        addFlashcard("～さい (sai)", "...years old");
        addFlashcard("～さん (san)", "Mr./Ms.");
        addFlashcard("～じ (ji)", "o'clock (e.g., いちじ (ichiji) one o'clock)");
        addFlashcard("～じん (jin)", "...people (e.g., にほんじん (nihonjin) Japanese people)");
        addFlashcard("せんこう (senkoo)", "major");
        addFlashcard("せんせい (sensei)", "teacher; Professor");
        addFlashcard("そうです (soo desu)", "That's right.");
        addFlashcard("そうですか (soo desu ka)", "I see; Is that so?");
        addFlashcard("だいがく (daigaku)", "college; university");
        addFlashcard("でんわ (denwa)", "telephone");
        addFlashcard("ともだち (tomodachi)", "friend");
        addFlashcard("なまえ (namae)", "name");
        addFlashcard("なん/なに (nan/nani)", "what");
        addFlashcard("にほん (Nihon)", "Japan");
        addFlashcard("～ねんせい (nensee)", "...year student (e.g., いちねんせい (ichinensee) first-year student)");
        addFlashcard("はい (hai)", "yes");
        addFlashcard("はん (han)", "half (e.g., にじはん (nijihan) half past two)");
        addFlashcard("ばんごう (bangoo)", "number");
        addFlashcard("りゅうがくせい (ryuugakusee)", "international student");
        addFlashcard("わたし (watashi)", "I");

// Countries
        addFlashcard("アメリカ (Amerika)", "U.S.A.");
        addFlashcard("イギリス (Igirisu)", "Britain");
        addFlashcard("オーストラリア (Oosutoraria)", "Australia");
        addFlashcard("かんこく (Kankoku)", "Korea");
        addFlashcard("スウェーデン (Suweeden)", "Sweden");
        addFlashcard("ちゅうごく (Chuugoku)", "China");

// Majors
        addFlashcard("かがく (kagaku)", "science");
        addFlashcard("アジアけんきゅう (ajia kenkyuu)", "Asian studies");
        addFlashcard("けいざい (keezai)", "economics");
        addFlashcard("こくさいかんけい (kokusai kankei)", "international relations");
        addFlashcard("コンピューター (konpyuutaa)", "computer");
        addFlashcard("じんるいがく (jinruigaku)", "anthropology");
        addFlashcard("せいじ (seeji)", "politics");
        addFlashcard("ビジネス (bijinesu)", "business");
        addFlashcard("ぶんがく (bungaku)", "literature");
        addFlashcard("れきし (rekishi)", "history");

// Occupations
        addFlashcard("しごと (shigoto)", "job; work; occupation");
        addFlashcard("いしゃ (isha)", "doctor");
        addFlashcard("かいしゃいん (kaishain)", "office worker");
        addFlashcard("こうこうせい (kookoosei)", "high school student");
        addFlashcard("しゅふ (shufu)", "housewife");
        addFlashcard("だいがくいんせい (daigakuinsei)", "graduate student");
        addFlashcard("だいがくせい (daigakusei)", "college student");
        addFlashcard("べんごし (bengoshi)", "lawyer");

// Family
        addFlashcard("おかあさん (okaasan)", "mother");
        addFlashcard("おとうさん (otoosan)", "father");
        addFlashcard("おねえさん (oneesan)", "older sister");
        addFlashcard("おにいさん (oniisan)", "older brother");
        addFlashcard("いもうと (imooto)", "younger sister");
        addFlashcard("おとうと (otooto)", "younger brother");

        // Places
        addFlashcard("いえ (ie)", "house; home");
        addFlashcard("うみ (umi)", "sea; ocean");
        addFlashcard("こうえん (kouen)", "park");
        addFlashcard("スーパー (suupaa)", "supermarket");
        addFlashcard("びょういん (byouin)", "hospital");
        addFlashcard("ほんや (honya)", "bookstore");
        addFlashcard("まち (machi)", "town; city");
        addFlashcard("みせ (mise)", "store; shop");
        addFlashcard("ゆうびんきょく (yuubinkyoku)", "post office");
        addFlashcard("えき (eki)", "station");

// Daily Activities
        addFlashcard("あう (au)", "to meet; to see (a person)");
        addFlashcard("あける (akeru)", "to open (something)");
        addFlashcard("ある (aru)", "to exist (inanimate)");
        addFlashcard("あるく (aruku)", "to walk");
        addFlashcard("いう (iu)", "to say");
        addFlashcard("おきる (okiru)", "to get up");
        addFlashcard("おしえる (oshieru)", "to teach; to instruct");
        addFlashcard("おわる (owaru)", "to finish");
        addFlashcard("かう (kau)", "to buy");
        addFlashcard("かく (kaku)", "to write");
        addFlashcard("きく (kiku)", "to listen; to ask");
        addFlashcard("ねる (neru)", "to sleep");
        addFlashcard("のむ (nomu)", "to drink");
        addFlashcard("はいる (hairu)", "to enter");
        addFlashcard("はしる (hashiru)", "to run");
        addFlashcard("べんきょうする (benkyou suru)", "to study");
        addFlashcard("みる (miru)", "to see; to watch");

// Adjectives
        addFlashcard("あかい (akai)", "#2AFF0000");
        addFlashcard("あおい (aoi)", "#50EE68FF");
        addFlashcard("あつい (atsui)", "hot (weather); thick");
        addFlashcard("あたらしい (atarashii)", "new");
        addFlashcard("いそがしい (isogashii)", "busy (people/days)");
        addFlashcard("おおきい (ookii)", "big");
        addFlashcard("おもしろい (omoshiroi)", "interesting; funny");
        addFlashcard("いい (ii)", "good");
        addFlashcard("かわいい (kawaii)", "cute");
        addFlashcard("さむい (samui)", "cold (weather)");
        addFlashcard("しろい (shiroi)", "White colour");
        addFlashcard("たかい (takai)", "expensive; tall; high");
        addFlashcard("ちいさい (chiisai)", "small");
        addFlashcard("つまらない (tsumaranai)", "boring");
        addFlashcard("ながい (nagai)", "long");
        addFlashcard("はやい (hayai)", "fast; early");
        addFlashcard("ふるい (furui)", "old (thing)");
        addFlashcard("やさしい (yasashii)", "easy (problem); kind (person)");

// Time Expressions
        addFlashcard("けさ (kesa)", "this morning");
        addFlashcard("こんばん (konban)", "tonight");
        addFlashcard("さっき (sakki)", "a little while ago");
        addFlashcard("しゅうまつ (shuumatsu)", "weekend");
        addFlashcard("らいしゅう (raishuu)", "next week");

// Numbers
        addFlashcard("ひとつ (hitotsu)", "one (thing)");
        addFlashcard("ふたつ (futatsu)", "two (things)");
        addFlashcard("みっつ (mittsu)", "three (things)");
        addFlashcard("よっつ (yottsu)", "four (things)");
        addFlashcard("いつつ (itsutsu)", "five (things)");
        addFlashcard("むっつ (muttsu)", "six (things)");
        addFlashcard("ななつ (nanatsu)", "seven (things)");
        addFlashcard("やっつ (yattsu)", "eight (things)");
        addFlashcard("ここのつ (kokonotsu)", "nine (things)");
        addFlashcard("とお (too)", "ten (things)");

// Other
        addFlashcard("あそこ (asoko)", "over there");
        addFlashcard("いくら (ikura)", "how much");
        addFlashcard("ここ (koko)", "here");
        addFlashcard("そこ (soko)", "there");
        addFlashcard("なんじ (nanji)", "what time");
        addFlashcard("なんにち (nannichi)", "what day");
        addFlashcard("わかる (wakaru)", "to understand");
        addFlashcard("いろ (iro)", "color");
        addFlashcard("くに (kuni)", "country");

        /////////////////////////////////////////--- 135 WORDS --- ///////////////////////////////////////////
        // Verbs (Cont.)
        addFlashcard("あそぶ (asobu)", "to play; to spend time pleasantly");
        addFlashcard("あらう (arau)", "to wash");
        addFlashcard("いる (iru)", "to exist (animate)");
        addFlashcard("うたう (utau)", "to sing");
        addFlashcard("およぐ (oyogu)", "to swim");
        addFlashcard("かす (kasu)", "to lend; to rent");
        addFlashcard("かりる (kariru)", "to borrow");
        addFlashcard("けす (kesu)", "to turn off; to erase");
        addFlashcard("しぬ (shinu)", "to die");
        addFlashcard("すう (suu)", "to smoke");
        addFlashcard("すわる (suwaru)", "to sit down");
        addFlashcard("たつ (tatsu)", "to stand up");
        addFlashcard("つかう (tsukau)", "to use");
        addFlashcard("つくる (tsukuru)", "to make");
        addFlashcard("つれてくる (tsuretekuru)", "to bring (a person)");
        addFlashcard("もつ (motsu)", "to carry; to hold");
        addFlashcard("わすれる (wasureru)", "to forget; to leave behind");
        addFlashcard("はなす (hanasu)", "to speak; to talk");
        addFlashcard("やすむ (yasumu)", "to be absent; to rest");

// Adjectives (Cont.)
        addFlashcard("あかるい (akarui)", "bright; cheerful");
        addFlashcard("あたたかい (atatakai)", "warm");
        addFlashcard("くらい (kurai)", "dark; gloomy");
        addFlashcard("すずしい (suzushii)", "cool (weather)");
        addFlashcard("あまい (amai)", "sweet");
        addFlashcard("いたい (itai)", "painful");
        addFlashcard("おいしい (oishii)", "delicious");
        addFlashcard("かなしい (kanashii)", "sad");
        addFlashcard("かわいい (kawaii)", "cute");
        addFlashcard("つよい (tsuyoi)", "strong");
        addFlashcard("よわい (yowai)", "weak");
        addFlashcard("やさしい (yasashii)", "easy; kind");
        addFlashcard("ひろい (hiroi)", "spacious; wide");
        addFlashcard("せまい (semai)", "narrow; cramped");

// Nouns (Cont.)
        addFlashcard("あき (aki)", "autumn; fall");
        addFlashcard("うち (uchi)", "home; house");
        addFlashcard("かさ (kasa)", "umbrella");
        addFlashcard("かみ (kami)", "paper");
        addFlashcard("き (ki)", "tree; wood");
        addFlashcard("きたない (kitanai)", "dirty; messy");
        addFlashcard("くるま (kuruma)", "car");
        addFlashcard("しろ (shiro)", "white (color)");
        addFlashcard("くろ (kuro)", "black (color)");
        addFlashcard("はる (haru)", "spring");
        addFlashcard("ふゆ (fuyu)", "winter");
        addFlashcard("ゆき (yuki)", "snow");
        addFlashcard("てんき (tenki)", "weather");
        addFlashcard("ひ (hi)", "day; sun");
        addFlashcard("そと (soto)", "outside");
        addFlashcard("うち (uchi)", "inside");
        addFlashcard("うみ (umi)", "sea; ocean");
        addFlashcard("やま (yama)", "mountain");
        addFlashcard("かわ (kawa)", "river");
        addFlashcard("はな (hana)", "flower");
        addFlashcard("て (te)", "hand");
        addFlashcard("あし (ashi)", "foot; leg");

// Particles
        addFlashcard("が (ga)", "subject marker");
        addFlashcard("で (de)", "location of action; means");
        addFlashcard("に (ni)", "time; direction; destination");
        addFlashcard("へ (e)", "direction; goal");
        addFlashcard("を (wo)", "direct object marker");
        addFlashcard("から (kara)", "from");
        addFlashcard("まで (made)", "until; to");
        addFlashcard("も (mo)", "also; too");
        addFlashcard("と (to)", "and; with");
        addFlashcard("や (ya)", "and others");

// Time Expressions (Cont.)
        addFlashcard("おととい (ototoi)", "the day before yesterday");
        addFlashcard("おととし (ototoshi)", "the year before last");
        addFlashcard("さらいしゅう (saraishuu)", "the week after next");
        addFlashcard("さらいねん (sarainen)", "the year after next");
        addFlashcard("せんげつ (sengetsu)", "last month");
        addFlashcard("せんしゅう (senshuu)", "last week");
        addFlashcard("らいげつ (raigetsu)", "next month");
        addFlashcard("にち (nichi)", "day");
        addFlashcard("つき (tsuki)", "month");
        addFlashcard("とし (toshi)", "year");
        addFlashcard("まいねん (mainen)", "every year");
        addFlashcard("まいとし (maitoshi)", "every year");

// Additional Nouns
        addFlashcard("あに (ani)", "older brother");
        addFlashcard("あね (ane)", "older sister");
        addFlashcard("おとうと (otouto)", "younger brother");
        addFlashcard("いもうと (imouto)", "younger sister");
        addFlashcard("おじいさん (ojiisan)", "grandfather");
        addFlashcard("おばあさん (obaasan)", "grandmother");
        addFlashcard("ちち (chichi)", "father");
        addFlashcard("はは (haha)", "mother");
        addFlashcard("おっと (otto)", "husband");
        addFlashcard("つま (tsuma)", "wife");
        addFlashcard("こども (kodomo)", "child; children");
        addFlashcard("そふ (sofu)", "grandfather (humble)");
        addFlashcard("そぼ (sobo)", "grandmother (humble)");
        addFlashcard("おとうさん (otousan)", "father");
        addFlashcard("おかあさん (okaasan)", "mother");

// Polite Expressions
        addFlashcard("ありがとうございます (arigatou gozaimasu)", "Thank you (polite)");
        addFlashcard("すみません (sumimasen)", "Excuse me; I'm sorry");
        addFlashcard("いいえ (iie)", "No; Not at all");
        addFlashcard("おはようございます (ohayou gozaimasu)", "Good morning (polite)");
        addFlashcard("こんにちは (konnichiwa)", "Good afternoon");
        addFlashcard("こんばんは (konbanwa)", "Good evening");
        addFlashcard("さようなら (sayounara)", "Goodbye");
        addFlashcard("じゃあ、また (jaa, mata)", "See you later");
        addFlashcard("おやすみなさい (oyasuminasai)", "Good night");
        addFlashcard("どういたしまして (dou itashimashite)", "You're welcome");
        addFlashcard("はじめまして (hajimemashite)", "Nice to meet you");

// Directions
        addFlashcard("みぎ (migi)", "right");
        addFlashcard("ひだり (hidari)", "left");
        addFlashcard("まえ (mae)", "in front");
        addFlashcard("うしろ (ushiro)", "behind");
        addFlashcard("なか (naka)", "inside");
        addFlashcard("そと (soto)", "outside");
        addFlashcard("うえ (ue)", "above; on top");
        addFlashcard("した (shita)", "below; under");
        addFlashcard("ちかく (chikaku)", "near; nearby");
        addFlashcard("とおく (tooku)", "far; distant");

// Numbers (Cont.)
        addFlashcard("ひゃく (hyaku)", "hundred");
        addFlashcard("せん (sen)", "thousand");
        addFlashcard("まん (man)", "ten thousand");
        addFlashcard("いちまん (ichiman)", "ten thousand");
        addFlashcard("じゅうまん (juuman)", "hundred thousand");
        addFlashcard("ひゃくまん (hyakuman)", "million");

// Adverbs
        addFlashcard("いつも (itsumo)", "always");
        addFlashcard("ときどき (tokidoki)", "sometimes");
        addFlashcard("よく (yoku)", "often; well");
        addFlashcard("たいてい (taitei)", "usually");
        addFlashcard("すぐ (sugu)", "immediately");
        addFlashcard("もう (mou)", "already");
        addFlashcard("まだ (mada)", "still; not yet");
        addFlashcard("とても (totemo)", "very");
        addFlashcard("ちょっと (chotto)", "a little");
        addFlashcard("たぶん (tabun)", "probably; maybe");
        addFlashcard("ぜんぜん (zenzen)", "not at all");
        addFlashcard("いっぱい (ippai)", "full; a lot");

// Question Words (Cont.)
        addFlashcard("いつ (itsu)", "when");
        addFlashcard("どこ (doko)", "where");
        addFlashcard("だれ (dare)", "who");
        addFlashcard("なに (nani)", "what");
        addFlashcard("なぜ (naze)", "why");

        addFlashcard("いくつ (ikutsu)", "how many; how old");
        addFlashcard("いくら (ikura)", "how much");

//////////////////////////////////---- 275 ------------//////////////////////////////////////////
        // Verbs (Cont.)
        addFlashcard("わかる (wakaru)", "to understand");
        addFlashcard("みる (miru)", "to see; to watch");
        addFlashcard("きく (kiku)", "to listen; to ask");
        addFlashcard("かく (kaku)", "to write");
        addFlashcard("のむ (nomu)", "to drink");
        addFlashcard("たべる (taberu)", "to eat");
        addFlashcard("はしる (hashiru)", "to run");
        addFlashcard("あるく (aruku)", "to walk");
        addFlashcard("ねる (neru)", "to sleep");
        addFlashcard("おきる (okiru)", "to wake up");

// Adjectives (Cont.)
        addFlashcard("さむい (samui)", "cold (weather)");
        addFlashcard("あつい (atsui)", "hot (weather)");
        addFlashcard("おおきい (ookii)", "big");
        addFlashcard("ちいさい (chiisai)", "small");
        addFlashcard("ながい (nagai)", "long");
        addFlashcard("みじかい (mijikai)", "short");
        addFlashcard("たかい (takai)", "expensive; high");
        addFlashcard("やすい (yasui)", "cheap; inexpensive");
        addFlashcard("おもしろい (omoshiroi)", "interesting; funny");
        addFlashcard("たいせつ (taisetsu)", "important");

// Nouns (Cont.)
        addFlashcard("くに (kuni)", "country");
        addFlashcard("ひと (hito)", "person");
        addFlashcard("もの (mono)", "thing");
        addFlashcard("ところ (tokoro)", "place");
        addFlashcard("まち (machi)", "town");
        addFlashcard("くうこう (kuukou)", "airport");
        addFlashcard("えき (eki)", "station");
        addFlashcard("びょういん (byouin)", "hospital");
        addFlashcard("こうえん (kouen)", "park");
        addFlashcard("みせ (mise)", "store; shop");

// Numbers (Cont.)
        addFlashcard("に (ni)", "two");
        addFlashcard("さん (san)", "three");
        addFlashcard("し (shi)", "four");
        addFlashcard("ご (go)", "five");
        addFlashcard("ろく (roku)", "six");
        addFlashcard("しち (shichi)", "seven");
        addFlashcard("はち (hachi)", "eight");
        addFlashcard("きゅう (kyuu)", "nine");
        addFlashcard("じゅう (juu)", "ten");
        addFlashcard("にじゅう (nijuu)", "twenty");

        //////////////////////--------320----------/////////////////////////////////////

        // Verbs (Cont.)
        addFlashcard("あう (au)", "to meet; to see (a person)");
        addFlashcard("かう (kau)", "to buy");
        addFlashcard("きる (kiru)", "to wear; to put on");
        addFlashcard("はいる (hairu)", "to enter");
        addFlashcard("でる (deru)", "to exit; to leave");
        addFlashcard("のる (noru)", "to ride; to board");
        addFlashcard("おりる (oriru)", "to get off");
        addFlashcard("つく (tsuku)", "to arrive");
        addFlashcard("かえる (kaeru)", "to return; to go back");
        addFlashcard("わたる (wataru)", "to cross");

// Adjectives (Cont.)
        addFlashcard("おおい (ooi)", "many; much");
        addFlashcard("すくない (sukunai)", "few; a little");
        addFlashcard("おそい (osoi)", "late; slow");
        addFlashcard("つめたい (tsumetai)", "cold (to the touch)");
        addFlashcard("あたらしい (atarashii)", "new");
        addFlashcard("ふるい (furui)", "old (not used for people)");
        addFlashcard("にぎやか (nigiyaka)", "lively");
        addFlashcard("しずか (shizuka)", "quiet");
        addFlashcard("べんり (benri)", "convenient");

// Nouns (Cont.)
        addFlashcard("がっこう (gakkou)", "school");
        addFlashcard("せんせい (sensei)", "teacher; professor");
        addFlashcard("いぬ (inu)", "dog");
        addFlashcard("ねこ (neko)", "cat");
        addFlashcard("うし (ushi)", "cow");
        addFlashcard("とり (tori)", "bird");
        addFlashcard("さかな (sakana)", "fish");
        addFlashcard("やさい (yasai)", "vegetable");
        addFlashcard("くだもの (kudamono)", "fruit");
        addFlashcard("ごはん (gohan)", "rice; meal");

// Time Expressions (Cont.)
        addFlashcard("あした (ashita)", "tomorrow");
        addFlashcard("きょう (kyou)", "today");
        addFlashcard("きのう (kinou)", "yesterday");
        addFlashcard("あさ (asa)", "morning");
        addFlashcard("ひる (hiru)", "noon");
        addFlashcard("ばん (ban)", "evening; night");
        addFlashcard("よる (yoru)", "night");
        addFlashcard("まいにち (mainichi)", "every day");

// Question Words (Cont.)
        addFlashcard("どれ (dore)", "which one");
        addFlashcard("どちら (dochira)", "which way; where (polite)");
        addFlashcard("どっち (docchi)", "which one (informal)");
        addFlashcard("どの (dono)", "which (used before a noun)");
        addFlashcard("どう (dou)", "how");
        addFlashcard("なに (nani)", "what");
        addFlashcard("なぜ (naze)", "why");
        addFlashcard("どうして (doushite)", "why");
        addFlashcard("どんな (donna)", "what kind of");
        addFlashcard("いくつ (ikutsu)", "how many; how old");


        //////////////////////--------375----------/////////////////////////////////////

        // Additional Words for JLPT N5

// Verbs
        addFlashcard("あつめる (atsumeru)", "to collect; to gather");
        addFlashcard("あらう (arau)", "to wash");
        addFlashcard("うる (uru)", "to sell");
        addFlashcard("おくる (okuru)", "to send");
        addFlashcard("かける (kakeru)", "to hang; to call (e.g., telephone)");
        addFlashcard("きる (kiru)", "to cut");
        addFlashcard("つかれる (tsukareru)", "to get tired");
        addFlashcard("とる (toru)", "to take");
        addFlashcard("もらう (morau)", "to receive");

// Adjectives
        addFlashcard("あたたかい (atatakai)", "warm");
        addFlashcard("おいしい (oishii)", "delicious");
        addFlashcard("こわい (kowai)", "scary");
        addFlashcard("すごい (sugoi)", "amazing; great");
        addFlashcard("つまらない (tsumaranai)", "boring");
        addFlashcard("ゆうめい (yuumei)", "famous");

// Nouns
        addFlashcard("あい (ai)", "love");
        addFlashcard("いす (isu)", "chair");
        addFlashcard("いぬ (inu)", "dog");
        addFlashcard("えいが (eiga)", "movie");
        addFlashcard("おみやげ (omiyage)", "souvenir");
        addFlashcard("かばん (kaban)", "bag");
        addFlashcard("きょうかしょ (kyoukasho)", "textbook");
        addFlashcard("くつ (kutsu)", "shoes");
        addFlashcard("さかな (sakana)", "fish");

// Adverbs
        addFlashcard("あまり (amari)", "not very (used with negatives)");
        addFlashcard("いっしょに (issho ni)", "together");
        addFlashcard("うまく (umaku)", "skillfully");
        addFlashcard("きっと (kitto)", "surely");
        addFlashcard("すぐに (sugu ni)", "immediately");
        addFlashcard("たくさん (takusan)", "a lot; many");

// Question Words
        addFlashcard("どの (dono)", "which (one)");
        addFlashcard("どれ (dore)", "which (one) of three or more");
        addFlashcard("なんで (nande)", "why; how");
        addFlashcard("いくら (ikura)", "how much");

// Time Expressions
        addFlashcard("まいあさ (maiasa)", "every morning");
        addFlashcard("まいばん (maiban)", "every night");
        addFlashcard("いちじかん (ichijikan)", "one hour");
        addFlashcard("いっしゅうかん (isshuukan)", "one week");
        addFlashcard("いちねん (ichinen)", "one year");

// Additional Nouns
        addFlashcard("えんぴつ (enpitsu)", "pencil");
        addFlashcard("くるま (kuruma)", "car");
        addFlashcard("さとう (satou)", "sugar");
        addFlashcard("しごと (shigoto)", "work; job");
        addFlashcard("すいか (suika)", "watermelon");
        addFlashcard("たいふう (taifuu)", "typhoon");

// Adjectives
        addFlashcard("うるさい (urusai)", "noisy");
        addFlashcard("おおきい (ookii)", "big");
        addFlashcard("さびしい (sabishii)", "lonely");
        addFlashcard("せまい (semai)", "narrow; cramped");
        addFlashcard("たいへん (taihen)", "tough; difficult");

// Verbs
        addFlashcard("あける (akeru)", "to open (something)");
        addFlashcard("うたう (utau)", "to sing");
        addFlashcard("おす (osu)", "to press");
        addFlashcard("けす (kesu)", "to erase");
        addFlashcard("しめる (shimeru)", "to close (something)");
        addFlashcard("とまる (tomaru)", "to stay (e.g., at a hotel)");

// Family
        addFlashcard("おじさん (ojisan)", "uncle; middle-aged man");
        addFlashcard("おばさん (obasan)", "aunt; middle-aged woman");
        addFlashcard("いとこ (itoko)", "cousin");
        addFlashcard("きょうだい (kyoudai)", "siblings");

// Particles
        addFlashcard("でも (demo)", "but; however");
        addFlashcard("の (no)", "possessive marker");
        addFlashcard("か (ka)", "question marker");

// Directions
        addFlashcard("まえ (mae)", "in front");
        addFlashcard("うしろ (ushiro)", "behind");
        addFlashcard("となり (tonari)", "next to");
        addFlashcard("むこう (mukou)", "over there; beyond");

        //////////////////////--------442----------/////////////////////////////////////

        // Randomize flashcards order
        Collections.shuffle(flashcards);
    }

    void practiceFlashcards()    // throws InterruptedException
            // enable this upper exception handling by removing "//" if u want to use 1,2,3 countdowns for showcase, code for that
            //also is downthere
    {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("\nWelcome to Flashcard Practice! Type 'flip' or 'f' to flip a card \n  'exit' or 'e'  to quit.\n");

        int index = 0;
        while (true) {
            FlashCard card = flashcards.get(index);
            System.out.print("Flashcard (%d): ".formatted(index)+ card.getQuestion());

            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("flip") || command.equalsIgnoreCase("f") || command.equalsIgnoreCase("")) {
                System.out.println("Answer: " + card.getAnswer());
                System.out.println();
                index ++;
                if (index+1 == flashcards.size()){
                    Collections.shuffle(flashcards);
                    index=0;
                    System.out.println("---------------------------------");
                    System.out.println("New rotation");
                    System.out.println("---------------------------------");
                }
            } else if (command.equalsIgnoreCase("exit") ||
                    command.equalsIgnoreCase("e")) {
                break;
            } else {
                System.out.println("Invalid command. Type 'flip' to flip the card, 'exit' to quit.");
            }
        }

        scanner.close();
        System.out.println("Thank you for practicing!");
    }
}
class FlashCard {
    private final String question;
    private final String answer;
//    private final String mid;
    private int count;

    public FlashCard(String question , String answer) {
        this.question = question;
        this.answer = answer;
//        this.mid =mid;
        this.count++;
    }



    public int size(){
        return count;
    }
    public String getQuestion() {return question;}

    public String getRevQuestion(){return answer;}

    public String getRevAnswer() {return question;}


    public String getAnswer() {return answer;}

    @Override
    public String toString() {
        return "Q: " + question + " | A: " + answer;
    }
}
