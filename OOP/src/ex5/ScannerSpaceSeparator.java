package ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerSpaceSeparator {
   public static void main(String[] args) {
      ArrayList<String> words = new ArrayList<String>();
      Scanner scanner = new Scanner(System.in);
      System.out.println("英文を入力してください。");
      while (scanner.hasNext()) {
         String word = scanner.next();
         words.add(word);
      }
      System.out.println("入力された語は、");
      for (String word: words) {
         System.out.println(word);
      }
      scanner.close();
   }
}