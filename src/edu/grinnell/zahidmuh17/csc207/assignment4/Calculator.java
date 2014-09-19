package edu.grinnell.csc207.zahidmuh17.hw4;

import java.math.BigInteger;
import java.util.Arrays;

public class Calculator
{

  public static BigInteger eval0(String input)
    throws Exception
  {

    // Split string with whitespace chars being regixes. The + quantifier
    // means one or more whitespace
    String[] data = input.split("\\s+");
    System.out.println(Arrays.toString(data));
    // Array of all existing numbers in string
    BigInteger intermediate;
    // Starting number in math processing and handle base case when given an
    // empty string
    if (data[0].matches("-?.*\\d.*"))
      {
        intermediate = new BigInteger(data[0]);
      }// ends if 
    else
      {
        return new BigInteger("0");
      }//ends else

    // Process the data i.e numbers and operations we have parsed
    for (int index = 1; index < data.length; index++)
      {

        String intermediateResult, applicand;
        char operation;
        intermediateResult = intermediate.toString(); // The intermediatemediate result
        applicand = data[index + 1]; // The number on which the
        // operation will be applied with
        // intermediateResult
        operation = data[index].charAt(0);// Operation

        intermediate =
            processMath(intermediateResult, applicand, operation, intermediate);

        // Since our calculations conform to a repeating pattern, we want to
        // break
        // when we have the last two elements remeaining (which would be
        // operation, number)
        if (index > data.length - 3)
          {
            break;
          }//ends if
      }// ends for

    return intermediate;

  }//eval0(String input)

  public static Fraction eval1(String input)
    throws Exception
  {

    // Split string with whitespace chars being regixes. The + quantifier
    // means one or more whitespace
    String[] data = input.split("\\s+");
    System.out.println(Arrays.toString(data));
    // Array of all existing numbers in string

    // Starting number in math processing and handle base case when given an
    // empty string

    Fraction intermediate;
    if (data[0].matches("-?.*\\d.*"))
      {
        intermediate = new Fraction(data[0]);
      }
    else
      {
        return new Fraction("0/1");
      }

    // Process the data i.e numbers and operations we have parsed
    for (int index = 1; index < data.length; index++)
      {

        String intermediateResult, applicand;
        char operation;
        intermediateResult = intermediate.toString(); // The intermediatemediate result
        applicand = data[index + 1]; // The number on which the
        // operation will be applied with
        // intermediateResult
        operation = data[index].charAt(0);// Operation

        intermediate =
            processMathFrac(intermediateResult, applicand, operation,
                            intermediate);

        // Since our calculations conform to a repeating pattern, we want to
        // break
        // when we have the last two elements remeaining (which would be
        // operation, number)
        if (index > data.length - 3)
          {
            break;
          }// if
      }// for

    System.out.println(intermediate.toString());
    return intermediate;

  }// eval1(String input)

  // Helper method to parse an operation and return a Big Integer as the
  // result of that operation and two other parsed String numbers

  public static BigInteger processMath(String num1, String num2,
                                       char operation, BigInteger currentRes)
    throws Exception
  {

    // The "-?\\d+" regix expalined:
    // The -? means there might be either one or no negative signs
    // the \\d+ means there should be either one or more digits in the
    // string

    if (num1.matches("-?\\d+") && num2.matches("-?\\d+"))
      {

        BigInteger number1, number2;
        number1 = new BigInteger(num1);
        number2 = new BigInteger(num2);

        switch (operation)
          {
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
          }// ends switch

      }// if

    return currentRes;

  }// processMath(String num1, String num2,char operation, BigInteger currentRes)

  public static Fraction processMathFrac(String num1, String num2,
                                         char operation, Fraction currentRes)
    throws Exception
  {

    // -?.*\\d.* is a Java regular expression to see whether a string has at
    // least
    // one instance of a digit
    if (num1.matches("-?.*\\d.*") && num2.matches("-?.*\\d.*"))
      {

        Fraction number1, number2;
        number1 = new Fraction(num1);
        number2 = new Fraction(num2);

        // Handle all different operations

        switch (operation)
          {
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

  }// processMathFrac(String num1, String num2,char operation, Fraction currentRes)

}// Calculator
