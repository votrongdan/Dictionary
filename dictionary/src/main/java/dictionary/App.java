package dictionary;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dictionaryAdvanced(dictionary);
    }
}
