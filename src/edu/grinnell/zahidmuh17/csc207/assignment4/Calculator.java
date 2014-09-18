package edu.grinnell.csc207.zahidmuh17.hw4;

import java.math.BigInteger;
import java.util.Arrays;

public class Calculator {

	public static void main(String[] args) {
		try {
			System.out.println(eval1("1/2 + 1/4"));
			System.out.println(new Fraction("3/4"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Please format your input correctly!");
		}
	}

	public static BigInteger eval0(String input) throws Exception {

		// Split string with whitespace chars being regixes. The + quantifier
		// means one or more whitespace
		String[] data = input.split("\\s+");
		System.out.println(Arrays.toString(data));
		// Array of all existing numbers in string
		BigInteger inter;
		// Starting number in math processing and handle base case when given an
		// empty string
		if (data[0].matches("-?.*\\d.*")) {
			inter = new BigInteger(data[0]);
		} else {
			return new BigInteger("0");
		}

		// Process the data i.e numbers and operations we have parsed
		for (int index = 1; index < data.length; index++) {

			String interResult, applicand;
			char operation;
			interResult = inter.toString(); // The intermediate result
			applicand = data[index + 1]; // The number on which the
											// operation will be applied with
											// interResult
			operation = data[index].charAt(0);// Operation

			inter = processMath(interResult, applicand, operation, inter);

			// Since our calculations conform to a repeating pattern, we want to
			// break
			// when we have the last two elements remeaining (which would be
			// operation, number)
			if (index > data.length - 3) {
				break;
			}// if
		}// for

		return inter;

	}

	public static Fraction eval1(String input) throws Exception {

		// Split string with whitespace chars being regixes. The + quantifier
		// means one or more whitespace
		String[] data = input.split("\\s+");
		System.out.println(Arrays.toString(data));
		// Array of all existing numbers in string

		// Starting number in math processing and handle base case when given an
		// empty string

		Fraction inter;
		if (data[0].matches("-?.*\\d.*")) {
			inter = new Fraction(data[0]);
		} else {
			return new Fraction("0/1");
		}

		// Process the data i.e numbers and operations we have parsed
		for (int index = 1; index < data.length; index++) {

			String interResult, applicand;
			char operation;
			interResult = inter.toString(); // The intermediate result
			applicand = data[index + 1]; // The number on which the
											// operation will be applied with
											// interResult
			operation = data[index].charAt(0);// Operation

			inter = processMathFrac(interResult, applicand, operation, inter);

			// Since our calculations conform to a repeating pattern, we want to
			// break
			// when we have the last two elements remeaining (which would be
			// operation, number)
			if (index > data.length - 3) {
				break;
			}// if
		}// for

		System.out.println(inter.toString());
		return inter;

	}

	// Helper method to parse an operation and return a Big Integer as the
	// result of that operation and two other parsed String numbers

	public static BigInteger processMath(String num1, String num2,
			char operation, BigInteger currentRes) throws Exception {

		// The "-?\\d+" regix expalined:
		// The -? means there might be either one or no negative signs
		// the \\d+ means there should be either one or more digits in the
		// string

		if (num1.matches("-?\\d+") && num2.matches("-?\\d+")) {

			BigInteger number1, number2;
			number1 = new BigInteger(num1);
			number2 = new BigInteger(num2);

			switch (operation) {
			case '+':
				return number1.add(number2);
			case '-':
				return number1.subtract(number2);
			case '*':
				return number1.multiply(number2);
			case '/':
				return number1.divide(number2);
			case '^':
				return number1.pow(Integer.valueOf(number2.toString()));
			default:
				System.out.println("Please format your input correctly!");
				break;
			}// switch

		}// if

		return currentRes;

	}// processMath

	public static Fraction processMathFrac(String num1, String num2,
			char operation, Fraction currentRes) throws Exception {

		// -?.*\\d.* is a Java regular expression to see whether a string has at
		// least
		// one instance of a digit
		if (num1.matches("-?.*\\d.*") && num2.matches("-?.*\\d.*")) {

			Fraction number1, number2;
			number1 = new Fraction(num1);
			number2 = new Fraction(num2);

			// Handle all different operations

			switch (operation) {
			case '+':
				return number1.add(number2);
			case '-':
				return number1.subtract(number2);
			case '*':
				return number1.multiply(number2);
			case '/':
				return number1.divide(number2);
			case '^':
				return number1.pow(Integer.valueOf(number2.num.toString()));
			default:
				System.out.println("Please format your input correctly!");
				break;
			}// switch

		}// if

		return currentRes;

	}// processMath

}
