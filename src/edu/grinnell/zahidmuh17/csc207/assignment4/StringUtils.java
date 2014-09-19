package edu.grinnell.csc207.zahidmuh17.hw4;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtils {

	public static void main(String[] args) {

		System.out.print(Arrays.toString(splitAt("a:", ':')));

	}

	public static String[] splitAt(String stringWithSomeChar, char someChar) {

		//Buffer to help us build strings
		StringBuffer buffer = new StringBuffer("");
		//Need a dynamic list to add elements
		ArrayList<String> arrayList = new ArrayList<String>();
		
		//This keeps track of when c occurs in the string
		int tracker = 0;
		
		
		//Loop through all characters
		for (int index = 0; index < stringWithSomeChar.length(); index++){
			
			//Reference the currentchar since we reference it multiple times
			char currentChar = stringWithSomeChar.charAt(index);
			if (currentChar == someChar){
				
				arrayList.add(stringWithSomeChar.substring(tracker, index));
				//Update tracker, since substrings are inclusive of the bottom index
				tracker = index + 1;
			}//if
			
			//Special case for our last substring
			if (index == stringWithSomeChar.length() - 1){
				arrayList.add(stringWithSomeChar.substring(tracker));
				
			}//if
				
		}//for
		
		//Transform to a String[]
		return transferFromArrayList(arrayList);
		
	}//splitAt(String stringWithSomeChar, char someChar)

	public static String[] splitCSV(String input) {

		boolean inQuote = false;
		// Use arrayList since we need a dynamic list
		ArrayList<String> arrayList = new ArrayList<String>();
		// Buffer to build our string elements
		StringBuffer buffer = new StringBuffer("");

		for (int index = 0; index < input.length(); index++) {

			char currentChar = input.charAt(index);
			System.out.println(currentChar);

			// When we actually use the comma as a separator and when aren't in
			// a quote
			if ((currentChar == ',') && !inQuote) {
				arrayList.add(buffer.toString());
				buffer = new StringBuffer("");
			}//if
			// Special case: Last element
			else if (index == input.length() - 1) {

				buffer.append(currentChar);
				arrayList.add(buffer.toString());
				buffer = new StringBuffer("");

			}//else if
			// Special case for two consecutive double quotes
			else if (currentChar == '\"' && input.charAt(index + 1) == '\"') {

				index++;
				buffer.append(currentChar);

			}//else if
			// Case when there's a single quote, indicating we're either
				// starting or ending a quote
			else if (currentChar == '\"') {
				// Toggle the boolean
				inQuote = (inQuote) ? false : true;

			}//else if
			else {
				buffer.append(currentChar);

			}//else

		}//for

		return transferFromArrayList(arrayList);
	}//splitCSV(String input)

	// Helper method to transfer data from an arrayList to a String[]
	public static String[] transferFromArrayList(ArrayList<String> stringArray) {

		String[] result = new String[stringArray.size()];

		for (int indexArr = 0; indexArr < stringArray.size(); indexArr++) {

			result[indexArr] = stringArray.get(indexArr);

		}//for

		return result;

	}//transferFromArrayList(ArrayList<String> stringArray)

}
