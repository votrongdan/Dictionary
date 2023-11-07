package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getWords();

        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so luong tu: ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Nhap tu vung tieng Anh: ");
            String target = input.nextLine();
            System.out.print("Nhap nghia tieng Viet: ")
            String explain = input.nextLine();

            Word newWord = new Word();
            newWord.setWord_target(target);
            newWord.setWord_explain(explain);

            words.add(newWord);

        }

        dictionary.setWords(words);
        
    }

    public void insertFromFile(Dictionary dictionary) throws IOException {

        ArrayList<Word> words = dictionary.getWords();
        
        File file = new File("dictionary/src/main/java/dictionary/dictionary.txt");
        Scanner text = new Scanner(file);
        
        while (text.hasNextLine()) {
            Word newWord = new Word();
            String line = text.nextLine();
            String temp[] = line.split("    ");
            newWord.setWord_target(temp[0]);
            newWord.setWord_explain(temp[1]);
            words.add(newWord);
        }
        
    }

    public void dictionaryExportToFile(Dictionary dictionary) throws IOException {

        ArrayList<Word> words = dictionary.getWords();
        
        FileWriter writer = new FileWriter("dictionary/src/main/java/dictionary/dictionary.txt");
        
        for (int i = 0; i < words.size(); i++) {
            writer.write(words.get(i).getWord_target());
            writer.write("    ");
            writer.write(words.get(i).getWord_explain());
            writer.write("\n");
        }
        writer.close();
    }

    public void addWord(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getWords();

        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tu vung tieng Anh: ");
        String target = input.nextLine();
        System.out.print("Nhap nghia tieng Viet: ")
        String explain = input.nextLine();

        for (int i = 0; i < words.size(); i++) {
            if (target.equals(words.get(i).getWord_target()) && explain.equals(words.get(i).getWord_explain())) {
                System.out.println("Tu nay da co trong tu dien.");
                return;
            }
        }

        Word newWord = new Word();
        newWord.setWord_target(target);
        newWord.setWord_explain(explain);
        words.add(newWord);   
        
        dictionary.setWords(words);

    }

    public void dictionaryLookup(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getWords();

        System.out.print("Nhap tu can tra cuu: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        for (int i = 0; i < words.size(); i++) {
            String target = words.get(i).getWord_target();
            if (inputString.equals(target)) {
                System.out.print(words.get(i).getWord_target());
                System.out.print("    ");
                System.out.println(words.get(i).getWord_explain());
                return;
            }
        }
        System.out.println("Khong co tu can tra cuu trong tu dien.");
    }

    public void updateWord(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getWords();

        System.out.print("Nhap tu can sua: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        for (int i = 0; i < words.size(); i++) {
            if (inputString.equals(words.get(i).getWord_target())) {
                System.out.print("Nhap tu vung tieng Anh: ");
                String target = input.nextLine();
                System.out.print("Nhap nghia tieng Viet: ");
                String explain = input.nextLine();
                words.add(new Word(target, explain));
                words.remove(i);
                return;
            }
        }

    }

    public void deleteWord(Dictionary dictionary) {

        ArrayList<Word> words = dictionary.getWords();

        System.out.print("Nhap tu can xoa: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();

        for (int i = 0; i < words.size(); i++) {
            if (inputString.equals(words.get(i).getWord_target())) {
                words.remove(i);
                dictionary.setWords(words);
                return;
            }
        }
        System.out.println("Khong co tu can xoa trong tu dien.");
        input.close();
    }
}
