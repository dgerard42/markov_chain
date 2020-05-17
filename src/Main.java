public class Main {

    private static final String FILENAME = "text_src/short_test.txt";

    public static void main(String args[]){

        Reader reader = new Reader();
        Writer writer = new Writer();
        if (reader.openFile(FILENAME)) {
            reader.openScanner();
            String nextWord = "BEGIN";
            String currentWord = "BEGIN";
            while (!(nextWord.equals("ERROR"))) {
                currentWord = nextWord;
                nextWord = reader.readWord();
//                System.out.println(nextWord);
                writer.addWord(currentWord, nextWord);
//                writer.setUpTest();
            }
            writer.printContents();
        }
        reader.closeScanner();
    }
}
