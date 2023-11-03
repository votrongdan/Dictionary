package dictionary;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<String> dictionary = new ArrayList<String>();

    public void setDictionary(ArrayList<String> dictionary) {
        this.dictionary = dictionary;
    }

    public ArrayList<String> getDictionary() {
        return dictionary;
    }
}
