import java.util.ArrayList;

public class RunMarkovs {

    private static final String FILENAME = "text_src/emma.txt";
    private static final int OUTPUT_SIZE = 20;

    public void runMarkov(){

        Reader reader = new Reader();
        MarkovGenerator markov = new MarkovGenerator();
        if (reader.openFile(FILENAME)) {
            reader.openScanner();
            String nextWord = "BEGIN";
            String currentWord = "BEGIN";
            String firstWord = "NOTREAD";
            while (!(nextWord.equals("ERROR"))) {
                currentWord = nextWord;
                nextWord = reader.readWord();
                if (firstWord.equals("NOTREAD"))
                    firstWord = nextWord;
                if (!(currentWord.equals("BEGIN")) && !(nextWord.equals("ERROR")))
                    markov.addWord(currentWord, nextWord);
            }
            System.out.println(markov.generateText(OUTPUT_SIZE, firstWord));
        }
        reader.closeScanner();
    }

    public void runBetterMarkov(){
        Reader reader = new Reader();
        BetterMarkovGenerator betterMarkov = new BetterMarkovGenerator();
        if (reader.openFile(FILENAME)) {
            reader.openScanner();
            String nextWord = "BEGIN";
            String currentWordFirst = "BEGIN";
            String currentWordSecond = "BEGIN";
            String firstWord = "NOTREAD";
            while (!(nextWord.equals("ERROR"))) {
                currentWordFirst = currentWordSecond;
                currentWordSecond = nextWord;
                nextWord = reader.readWord();
                if(firstWord.equals("NOTREAD"))
                    firstWord = nextWord;
                if (!(currentWordFirst.equals("BEGIN")) && !(nextWord.equals("ERROR")) && !(currentWordSecond.equals("BEGIN"))) {
                    ArrayList<String> currentWords = new ArrayList<String>();
                    currentWords.add(currentWordFirst);
                    currentWords.add(currentWordSecond);
                    betterMarkov.addWord(currentWords, nextWord);
                }
            }
            System.out.println(betterMarkov.generateText(OUTPUT_SIZE, firstWord));
        }
        reader.closeScanner();
    }

    public static void main(String args[]){

       RunMarkovs runMarkovs = new RunMarkovs();
       runMarkovs.runMarkov();
       runMarkovs.runBetterMarkov();
    }
}
