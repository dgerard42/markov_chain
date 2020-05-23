import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BetterMarkovGenerator {

    private HashMap<ArrayList<String>, ArrayList<String>> markovEntry;

    public BetterMarkovGenerator(){
        markovEntry = new HashMap<ArrayList<String>, ArrayList<String>>();
    }

    public void addWord(ArrayList<String> currentWords, String nextWord){

        ArrayList<String> followingWords = null;
        if (markovEntry.get(currentWords) == null){
            followingWords = new ArrayList<String>();
            followingWords.add(nextWord);
        } else {
            followingWords = markovEntry.get(currentWords);
            followingWords.add(nextWord);
        }
        markovEntry.put(currentWords, followingWords);
    }

    public void printContents() {

        for (ArrayList<String> leadingWords : markovEntry.keySet()) {
            System.out.print(leadingWords.get(0) + " " + leadingWords.get(1));
            ArrayList<String> results = markovEntry.get(leadingWords);
            for (String word : results) {
                System.out.print(word);
            }
            System.out.println("\n");
        }
    }

    public ArrayList<String> returnRandomListKey(){

        List<ArrayList<String>> getOneKey = new ArrayList<ArrayList<String>>(markovEntry.keySet()); //make an arrayList of all elements in hashmap
        return getOneKey.get(ThreadLocalRandom.current().nextInt(0, getOneKey.size())); //return a random key from the array list
    }

    public String generateText(int numberOfWords , String firstWord){

        String newText = new String("");
        ArrayList <String> nextWords  = returnRandomListKey();
        ArrayList <String> currentWordList;
        newText = newText + nextWords.get(0) + " " + nextWords.get(1);
        for (int wordNumber = 0; wordNumber < numberOfWords; wordNumber++) {
            ArrayList <String> lastWords = nextWords;
            currentWordList = markovEntry.get(lastWords);
            nextWords = new ArrayList<String>();
            nextWords.add(lastWords.get(1));
            if (currentWordList == null) {
                nextWords.add(firstWord);
            } else {
                nextWords.add(currentWordList.get(ThreadLocalRandom.current().nextInt(0, currentWordList.size())));
            }
            newText = newText + " " + nextWords.get(1);
        }
        return newText;
    }

}
