import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    private File file = null;
    private Scanner scanner = null;

    public Reader(){}

    public boolean openFile(String fileName){

        file = new File(fileName);
        if (file.exists() && file.isFile() && file.canRead()) {
            return true;
        } else{
            System.out.println("could not open file as directed!!");
            return false;
        }
    }

    public void openScanner(){

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException notFound) {
            notFound.printStackTrace();
            System.out.println("file was not found! try again");
        }
    }

    public String readWord(){

        String nextWord = "ERROR";
        if (scanner.hasNext())
            nextWord = scanner.next();
        return nextWord;
    }

    public void closeScanner(){

        if (scanner != null) {
            scanner.close();
        }
    }
}
