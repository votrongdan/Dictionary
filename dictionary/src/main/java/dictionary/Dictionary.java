package dictionary;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> dictionary = new ArrayList<Word>();

    public void setDictionary(ArrayList<Word> dictionary) {
        this.dictionary = dictionary;
    }

    public ArrayList<Word> getDictionary() {
        return dictionary;
    }
}
