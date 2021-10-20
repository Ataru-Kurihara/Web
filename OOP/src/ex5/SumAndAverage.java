package ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class SumAndAverage {
	public static void main(String[] args) {
		int total = 0;
		int ave = 0;
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Integer> num = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("整数値を入力してください");
		while (scanner.hasNext()) {
			int i = scanner.nextInt();
			num.add(i);
		}
		for (int i: num) {
			System.out.println("あなたが入力した整数は" + i + "です");
		}
		for (int j=0; j<num.size(); j++) {
			total += num.get(j).intValue();
			ave = total/num.size();
		}
		System.out.println("あなたが入力した整数の合計は" + total + "です");
		System.out.println("あなたが入力した整数の平均は" + ave + "です");
		scanner.close();
	}
}
