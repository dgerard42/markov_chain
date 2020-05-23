import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MarkovGenerator {

    private HashMap<String, ArrayList<String>> markovEntry;

    public MarkovGenerator(){
        markovEntry = new HashMap<String, ArrayList<String>>();
    }

    public void addWord(String currentWord, String nextWord){

        ArrayList<String> followingWords = null;
        if (markovEntry.get(currentWord) == null){
            followingWords = new ArrayList<String>();
            followingWords.add(nextWord);
        } else {
            followingWords = markovEntry.get(currentWord);
            followingWords.add(nextWord);
        }
        markovEntry.put(currentWord, followingWords);
    }

    public void printContents() {

        for (String leadingWord : markovEntry.keySet()) {
            System.out.print(leadingWord);
            ArrayList<String> results = markovEntry.get(leadingWord);
            for (String word : results) {
                System.out.print(word);
            }
            System.out.println("\n");
        }
    }

    public String returnRandomListKey(){

        List<String> getOneKey = new ArrayList<String>(markovEntry.keySet()); //make an arrayList of all elements in hashmap
        return getOneKey.get(ThreadLocalRandom.current().nextInt(0, getOneKey.size())); //return a random key from the array list
    }

    public String generateText(int numberOfWords, String firstWord){

        String newText = new String("");
        String nextWord  = returnRandomListKey();
        ArrayList<String> currentWordList;
        for (int wordNumber = 0; wordNumber < numberOfWords; wordNumber++) {
            String lastWord = nextWord;
            currentWordList = markovEntry.get(lastWord);
            if (currentWordList == null)
                nextWord = firstWord;
            else
                nextWord = currentWordList.get(ThreadLocalRandom.current().nextInt(0, currentWordList.size()));
            newText = newText + lastWord + " ";
        }
        return newText;
    }

}
