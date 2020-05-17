import java.util.ArrayList;
import java.util.HashMap;

public class Writer {

    private HashMap<String, ArrayList<String>> markovEntry;

    public Writer(){
        markovEntry = new HashMap<String, ArrayList<String>>();
    }

    public void addWord(String currentWord, String nextWord){

        System.out.println("passed two words are:" + currentWord + nextWord);
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

//    public void setUpTest() {
//
//        markovEntry = new HashMap<String, ArrayList<String>>();
//        ArrayList<String> followers = new ArrayList<String>();
//        followers.add("one");
//        followers.add("two");
//        followers.add("red");
//        followers.add("blue");
//        markovEntry.put("fish", followers);
//
//    }

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
}
