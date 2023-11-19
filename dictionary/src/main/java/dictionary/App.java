package dictionary;

import java.io.IOException;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner input = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        // DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        // dictionaryCommandline.dictionaryAdvanced(dictionary, input);
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        dictionaryManagement.importFromDatabase(dictionary);
        dictionaryManagement.dictionaryLookup(dictionary, input);
        input.close();
    }

}
