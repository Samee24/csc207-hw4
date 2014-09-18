package edu.grinnell.zahidmuh17.csc207.assignment4;

import java.math.BigInteger;

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author YOUR NAME HERE
 * @author CSC152 2005S
 * @version 1.0 of February 2005
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
  }
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
  public Fraction (BigInteger num, BigInteger denom) 
  {
    BigInteger gcd = num.gcd(denom);
    this.num = num.divide(gcd);
    this.denom= denom.divide(gcd);
  } // Fraction(BigInteger, BigInteger)
  
  public Fraction (String num) 
  {    
    
//    String[] strng = num.split(".");
//    String tempNum = strng[0];
//    String tempDenom = strng[1];
//    
//    int len = tempDenom.length();
//    BigInteger expt = new BigInteger("10").pow(len);
//    BigInteger tempDenomBig = new BigInteger(tempDenom);
//    
//    BigInteger bigLeft = new BigInteger(tempNum);
//    BigInteger bigRight = new BigInteger(val);
//    
//    
//    this.num ;
//    this.denom =     
//     add(new Fraction(bigLeft, new BigInteger("1"))
//    new Fraction(tempDenomBig, expt));
    
       
    if (num.indexOf("/") == -1){
      
      this.num = new BigInteger(num);
      this.denom = new BigInteger("1");
      
    } else {
    
      String[] strng = num.split("/");
      this.num = BigInteger.valueOf(Integer.valueOf(strng[0]));
      this.denom = BigInteger.valueOf(Integer.valueOf(strng[1]));
      
    }
  } // Fraction(BigInteger, BigInteger)

  
  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction (int num, int denom) 
  {
    this.num = BigInteger.valueOf (num);
    this.denom = BigInteger.valueOf (denom);
  } // Fraction(int, int)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double
    doubleValue ()
  {
    return this.num.doubleValue () / this.denom.doubleValue ();
  } // doubleValue()

  public Fraction fractional()
  {
    Fraction toReturn=new Fraction(this.num,this.denom);

    while(toReturn.denom.compareTo(toReturn.num)==1)
      {
        toReturn.num=toReturn.num.subtract(toReturn.denom);
      }
    return toReturn;
  }
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
    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

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
    resultNumerator = (this.num.multiply(subMe.denom)).subtract(subMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String
    toString ()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
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

  }
  
  public Fraction pow(int exp)
  {

    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.pow(exp);
    resultDenominator = this.denom.pow(exp);

    return new Fraction(resultNumerator, resultDenominator);

  }
  
  public Fraction divide(Fraction divMe)
  {

    BigInteger resultNumerator;
    BigInteger resultDenominator;

    resultNumerator = this.num.multiply(divMe.denom);
    resultDenominator = this.denom.multiply(divMe.num);

    return new Fraction(resultNumerator, resultDenominator);

  }
  
  public Fraction negate(){
    
    return this.multiply(new Fraction("-1"));
    
  }
} // class Fraction