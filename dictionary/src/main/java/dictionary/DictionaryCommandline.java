package dictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
     public void showAllWords(Dictionary dsachtuvung) {
        sortWord(dsachtuvung.getWords()); // sắp xếp danh sách từ vựng theo alphabet
        System.out.println("No     | English     | Vietnamese ");// duyệt danh sách và in ra từ vựng
        for (int i = 0; i < dsachtuvung.getWords().size(); i++) {
            String no = Integer.toString(i + 1);
            String tmp1 = "       ".substring(no.length());
            no += tmp1;
            Word word = dsachtuvung.getWords().get(i);
            String tmp2 = "           ".substring(word.getWord_target().length());
            word.getWord_target() += tmp2;
            System.out.println(no + "| " + word.getWord_target() + "| " + word.getWord_explain());
        }
    }
    // Hàm sortWord() để sắp xếp danh sách từ vựng theo thứ tự alphabet
    public void sortWord(ArrayList<Word> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).getWord_target().compareTo(words.get(minIndex).getWord_target()) < 0) {
                    minIndex = j;
                }
            }
            Word temp = words.get(i);
            words.set(i, words.get(minIndex));
            words.set(minIndex, temp);
        }
    }

    // public void insertFromCommandline(Dictionary dictionary) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Nhập số lượng từ vựng muốn thêm: ");
    //     int n = sc.nextInt();
    //     sc.nextLine();
    //     for(int i = 0; i < n ;i ++) {
    //         System.out.println("Nhập từ vựng tiếng anh: ");
    //         String english = sc.nextLine();
    //         System.out.println("Nhập nghĩa tiếng việt: ");
    //         String vietnamese = sc.nextLine();
    //         Word word = new Word(english, vietnamese); //tạo đối tượng word
    //         dictionary.addWord(word); // thêm word vào dictionary
    //     }
    // }
    // public void dictionaryBasic(Dictionary dictionary) {
    //     insertFromCommandline(dictionary); // nhập dữ liệu từ vựng
    //     showAllWords(dictionary); // in danh sách từ vựng theo alphabet
    // }
    public void dictionarySearcher(Dictionary dictionary) {
        System.out.print("Nhap tu khoa: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        ArrayList<Word> words = dictionary.getWords(); // Lấy danh sách word từ từ điển
        ArrayList<String> resultList = new ArrayList<>(); // Tạo ds rỗng để chứa từ nối
        for (Word word : words) { // Vòng lặp từng từ trong danh sách từ
            if (word.getWord_target().startsWith(inputString)) { // Kiểm tra xem từ đó có bắt đầu bằng từ nhập vào không
                resultList.add(word.getWord_target()); //Thêm từ vào danh sách kết quả
            }
        }
        // Print the result list In ra ds kết quả
        System.out.println("Các từ cần tìm " + inputString + " : ");
        for (String word : resultList) {
            System.out.println(word);
        }
    }

    public void dictionaryAdvanced(Dictionary dictionary) throws IOException {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
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
                dictionaryManagement.addWord(dictionary);
            } else if (action == 2) { 
                dictionaryManagement.removeWord(dictionary);
            } else if (action == 3) { 
                dictionaryManagement.updateWord(dictionary);
            } else if (action == 4) { 
                showAllWords(dictionary);
            } else if (action == 5) { 
                dictionaryManagement.dictionaryLookup(dictionary);
            } else if (action == 6) { 
                dictionarySearcher(dictionary);
            } else if (action == 7) { 
                // playGame();
            } else if (action == 8) { 
                dictionaryManagement.insertFromFile(dictionary);
            } else if (action == 9) { 
                dictionaryManagement.dictionaryExportToFile(dictionary);
            } else { 
                System.out.println("Action not supported");
            }
        }
        sc.close(); // Close the scanner object
    }
}

