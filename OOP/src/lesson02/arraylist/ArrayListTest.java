package lesson02.arraylist;

import java.util.*; // List, ArrayList を使うため

public class ArrayListTest extends Object {
    public static void main(String[] argv) {
        ArrayList<String> aList; // List 型の変数
        aList = new ArrayList<String>(); // ArrayList のインスタンス生成、要素は String 型
        Iterator<String> anIterator; // 繰り返し用の変数

        System.out.println("要素の追加...");
        aList.add("one"); // 要素の追加
        aList.add("two"); // 要素の追加
        aList.add("three"); // 要素の追加
        aList.add("four"); // 要素の追加

        System.out.println("要素の出力");
        anIterator = aList.iterator(); // イテレータを得る
        while(anIterator.hasNext()) { // 次の要素があるか?
            System.out.println(anIterator.next()); // その要素を取り出して表示
        }

    }
}
