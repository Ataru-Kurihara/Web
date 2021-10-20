package ex13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintDic {
	public static void main(String[] args) {
		String filename = "dic.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] list = line.split(",");
				System.out.println("英単語["+list[0]+"]"+"は、"+"日本語の["+list[1]+"]という意味です。");
			}
			reader.close();
		}catch (IOException e) {
			System.out.println(e);
		}
	}
}
