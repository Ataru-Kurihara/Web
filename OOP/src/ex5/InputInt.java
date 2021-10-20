package ex5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInt {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("整数値を入力してください。");
      try {
         int i = scanner.nextInt();
         System.out.println("あなたが入力した値は、" + i + "ですね。");
      } catch (InputMismatchException e){
         System.out.println("型が違います: " + e);
      }
      scanner.close();
   }
}