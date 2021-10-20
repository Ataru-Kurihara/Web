package ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerReadLine {
   public static void main(String[] args) {
      ArrayList<String> lines = new ArrayList<String>();
      Scanner scanner = new Scanner(System.in);
      System.out.println("複数行の文章を入力してください。");
      while (scanner.hasNext()) {
         String line = scanner.nextLine();
         lines.add(line);
      }
      System.out.println("入力された行は、");
      for (String line: lines) {
         System.out.println(line);
      }
      scanner.close();
   }
}