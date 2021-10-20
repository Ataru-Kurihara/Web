package ex13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StdInToFile {
	public static void main(String[] args) {
		String filename = "text.txt";
		Scanner scanner = new Scanner(System.in);
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                writer.println(line);
             }
            scanner.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}