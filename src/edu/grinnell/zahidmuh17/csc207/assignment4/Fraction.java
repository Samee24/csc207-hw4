package edu.grinnell.csc207.zahidmuh17.hw4;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samee Zahid
 * @author Larry Asante Boateng
 * Used Sam Rebelsky's skeleton
 */
public class Fraction
{

  public static void main(String[] args)
  {
    System.out.println("Hello, World");
    Fraction f = new Fraction("0/3");
    f = f.pow(2);
    System.out.println(f.num);
    System.out.println(f.denom);
  }//main

  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom)
  {
    BigInteger gcd = num.gcd(denom);
    this.num = num.divide(gcd);
    this.denom = denom.divide(gcd);
  } // Fraction(BigInteger, BigInteger)

  public Fraction(String num)
  {

    if (num.indexOf("/") == -1)
      {

        this.num = new BigInteger(num);
        this.denom = new BigInteger("1");

      }// end if
    else
      {

        String[] strng = num.split("/");
        this.num = BigInteger.valueOf(Integer.valueOf(strng[0]));
        this.denom = BigInteger.valueOf(Integer.valueOf(strng[1]));

      }// close else
  } // Fraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom)
  {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * Add the fraction other to this fraction.
   */
  public Fraction add(Fraction addMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Subtract the fraction from the other fraction.
   */
  public Fraction subtract(Fraction subMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(subMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  public Fraction multiply(Fraction multMe)
  {

    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.multiply(multMe.num);
    resultDenominator = this.denom.multiply(multMe.denom);

    return new Fraction(resultNumerator, resultDenominator);

  }//multiply(Fraction multMe)

  public Fraction pow(int exp)
  {

    BigInteger resultNumerator;
    BigInteger resultDenominator;

    //Just take the BigInteger method of exp and apply it to both the num and denom
    resultNumerator = this.num.pow(exp);
    resultDenominator = this.denom.pow(exp);

    return new Fraction(resultNumerator, resultDenominator);

  }//pow(int exp)

  public Fraction divide(Fraction divideMe)
  {

    BigInteger resultNumerator;
    BigInteger resultDenominator;

    //Division is just multiplication flipped
    resultNumerator = this.num.multiply(divideMe.denom);
    resultDenominator = this.denom.multiply(divideMe.num);

    return new Fraction(resultNumerator, resultDenominator);

  }//divide(Fraction divideMe)

  public Fraction negate()
  {

    return this.multiply(new Fraction("-1"));

  }//negate()
} // class Fraction
