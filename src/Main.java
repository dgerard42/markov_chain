import java.io.File;

public class Main {

    private static final String FILENAME = "text_src/kropotkin.txt";

    public static void main(String args[]){

        Reader reader = new Reader();
        //Writer writer = new Writer();
        if (reader.openFile(FILENAME)) {
            reader.openScanner();
            String nextWord = "BEGIN READING";
            while (!(nextWord.equals("ERROR"))) {
                nextWord = reader.readWord();
//                System.out.println(nextWord);

            }
            reader.closeScanner();
        }
    }
}
