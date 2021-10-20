package ex13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddressBook {
	private ArrayList<Address> book; 

    public AddressBook() {
        book = new ArrayList<Address>();
    }

    public void add(Address address) {
        book.add(address);

    }

    public void showAddress() {
        for(int i = 0; i < book.size(); i++) {
            System.out.println(book.get(i).toString());
        }
    }
    
    public void open(String filename) {
    	filename = "address.txt";
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(filename));
    		String line;
    		while ((line = reader.readLine()) != null) {
    			String[] name = line.split(",");
    			Address address = new Address(name[0],name[1],name[2],name[3]);
    			book.add(address);
    		}
    		reader.close();
    	}catch (FileNotFoundException e) {
    		System.out.println(filename + "が見つかりません");
    	} catch (IOException e) {
    		System.out.println(e);
    	}
    }
    public void save(String filename) {
	try {
    	PrintWriter  writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
    	for(Address address : book) {
    		writer.println(address);
    	}
    	writer.close();
    } catch (IOException e) {
    	System.out.println(e);
    }
}
    

    public static void main(String[] args) { // 使ってみる
        AddressBook book = new AddressBook();
        System.out.println("ファイルから読み込む。");
        book.open("address.txt");
        System.out.println("一覧の表示。");
        book.showAddress();
        System.out.println("新規データの追加。");
        Address taroAddress = new Address("電大太郎", "東京都千代田区", "03-5280-XXXX", "taro@dendai.ac.jp");
        book.add( taroAddress );
        System.out.println("一覧の表示。");
        book.showAddress();
        System.out.println("ファイルに書き出す。");
        book.save("address2.txt");
    }

}
