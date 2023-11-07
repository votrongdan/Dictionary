package dictionary;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<Word>();

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Word> getWords() {
        return words;
    }
}
