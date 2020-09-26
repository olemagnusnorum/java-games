package invader;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public interface SaveLoad {
	

	public default void save(String filename, int score) {
		try {
			PrintWriter writer = new PrintWriter(filename);
			
			String filetext = String.format("%d", score);
			writer.print(filetext);
			writer.flush();
			writer.close();
		} catch (Exception e) {
		}
		
	}

	public default int load(String filename)  {
		try {
			Scanner scanner = new Scanner(new File(filename));
			
			String[] score = scanner.nextLine().split(",");
			int numb = Integer.parseInt(score[0]);
			scanner.close();
			return numb;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
