package dictionary;
import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Scanner;

public class DictionaryCommandline {
  public void showAllWords(Dictionary dictionary){
        // sắp xếp các từ theo alphabet
        Collections.sort(dictionary.getWords(), new Comparator<Word>()) {
            public int compare(Word no1, Word no2) {
                return no1.getEnglish().compareTo(no2.getEnglish());
            }
        };
        System.out.println("No | English | Vietnamese");
        for(int i = 0; i < dictionary.getWords().size(); i++) {
            Word word = dictionary.getWords().get(i);
            System.out.println((i+1) + " | " + word.getEnglish() + " | " + word.getVietnamese());
        }
    }

    public void insertFromCommandline(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng muốn thêm: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n ;i ++) {
            System.out.println("Nhập từ vựng tiếng anh: ");
            String english = sc.nextLine();
            System.out.println("Nhập nghĩa tiếng việt: ");
            String vietnamese = sc.nextLine();
            Word word = new Word(english, vietnamese); //tạo đối tượng word
            dictionary.addWord(word); // thêm word vào dictionary
        }
    }
    public void dictionaryBasic(Dictionary dictionary) {
        insertFromCommandline(dictionary); // nhập dữ liệu từ vựng
        showAllWords(dictionary); // in danh sách từ vựng theo alphabet
    }
    public void dictionarySearcher(String input) {
        ArrayList<String> wordList = getWordList(); // Lấy danh sách word từ từ điển
        ArrayList<String> resultList = new ArrayList<>(); // Tạo ds rỗng để chứa từ nối
        for (String word : wordList) { // Vòng lặp từng từ trong danh sách từ
            if (word.startsWith(input)) { // Kiểm tra xem từ đó có bắt đầu bằng từ nhập vào không
                resultList.add(word); //Thêm từ vào danh sách kết quả
            }
        }
        // Print the result list In ra ds kết quả
        System.out.println("Các từ cần tìm " + input + " : ");
        for (String word : resultList) {
            System.out.println(word);
        }
    }

    public void dictionaryAdvanced() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false; 
        while (!exit) { 
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");
            System.out.print("Your action: ");
            int action = sc.nextInt();
            if (action == 0) { 
                exit = true;
                System.out.println("Cảm ơn đã dùng ứng dụng từ điển");
            } else if (action == 1) { 
                addWord();
            } else if (action == 2) { 
                removeWord();
            } else if (action == 3) { 
                updateWord();
            } else if (action == 4) { 
                displayWordList();
            } else if (action == 5) { 
                lookupWord();
            } else if (action == 6) { 
                searchWord();
            } else if (action == 7) { 
                playGame();
            } else if (action == 8) { 
                importFromFile();
            } else if (action == 9) { 
                exportToFile();
            } else { 
                System.out.println("Action not supported");
            }
        }
        sc.close(); // Close the scanner object
    }
}

