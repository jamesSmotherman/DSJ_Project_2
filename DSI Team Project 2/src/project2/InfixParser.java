package project2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InfixParser {

	/**
	 * Ensures the infix question is in correct readable form
	 * @param inputFile: FileInputStream type. file should contain
	 */
	public static String readExpression(FileInputStream inputFile) {
		Scanner scnr = new Scanner(inputFile);
		String expression = scnr.nextLine();
		StringBuilder trueInfix = new StringBuilder();
		expression = expression.replaceAll("\\s", "");
		for (int i = 0; i < expression.length(); i++) {
			trueInfix.append(expression.charAt(i));
			if (i == expression.length() - 1) { break;}
			if (Character.isDigit(expression.charAt(i)) && Character.isDigit(expression.charAt(i + 1))) { continue; }
			if ((expression.charAt(i) == '>' && expression.charAt(i + 1) == '=') ||
					(expression.charAt(i) == '<' && expression.charAt(i + 1) == '=')) { continue; }
			trueInfix.append(" ");
		}
		
		// Close the scanner
		scnr.close();
		return trueInfix.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream inputFile = new FileInputStream("input.txt");
		String test = readExpression(inputFile);
		System.out.println(test);
	}

}
