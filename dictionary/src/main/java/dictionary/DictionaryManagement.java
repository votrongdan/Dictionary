package dictionary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getDictionary();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {

            String target = input.nextLine();
            String explain = input.nextLine();

            Word newWord = new Word();
            newWord.setWord_target(target);
            newWord.setWord_explain(explain);

            words.add(newWord);

        }

        dictionary.setDictionary(words);
        
    }

    public void insertFromFile(Dictionary dictionary) throws IOException {

        ArrayList<Word> wordList = dictionary.getDictionary();
        
        File myObj = new File("C:\\Users\\trong\\OneDrive - MSFT\\A\\Homework\\OOP\\DictionaryProject\\dictionary\\src\\main\\java\\dictionary\\dictionary.txt");
        Scanner text = new Scanner(myObj);

        while (text.hasNextLine()) {
            Word newWord = new Word();
            String line = text.nextLine();
            String temp[] = line.split("    ");
            newWord.setWord_target(temp[0]);
            newWord.setWord_explain(temp[1]);
            wordList.add(newWord);
        }
        
    }

    public void addWord(Dictionary dictionary) {

        ArrayList<Word> wordList = dictionary.getDictionary();

        Scanner input = new Scanner(System.in);

        String target = input.nextLine();
        String explain = input.nextLine();

        for (int i = 0; i < wordList.size(); i++) {
            if (target.equals(wordList.get(i).getWord_target()) && explain.equals(wordList.get(i).getWord_explain())) {
                System.out.println("Tu nay da ton tai.");
                return;
            }
        }

        Word newWord = new Word();
        newWord.setWord_target(target);
        newWord.setWord_explain(explain);
        wordList.add(newWord);   
        
        dictionary.setDictionary(wordList);

    }

    public String dictionaryLookup(Dictionary dictionary) {

        ArrayList<Word> wordlList = dictionary.getDictionary();

        Scanner input = new Scanner(System.in);

        String inputString = input.nextLine();

        for (int i = 0; i < wordlList.size(); i++) {
            String target = wordlList.get(i).getWord_target();
            
            if (inputString.equals(target)) {
                
                return wordlList.get(i).getWord_explain();
            }
        }
        return "";
    }

    public void deleteWord(Dictionary dictionary) {

        ArrayList<Word> wordList = dictionary.getDictionary();

        Scanner input = new Scanner(System.in);

        String inputString = input.nextLine();

        for (int i = 0; i < wordList.size(); i++) {
            if (inputString.equals(wordList.get(i).getWord_target())) {
                wordList.remove(i);
                dictionary.setDictionary(wordList);
                return;
            }
        }
        System.out.println("Khong ton tai tu can xoa.");
        input.close();
    }
}
