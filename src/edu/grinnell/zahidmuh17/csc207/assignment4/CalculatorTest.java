package edu.grinnell.csc207.zahidmuh17.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest
{

  @Test
  public void test()
  {
    try
      {
        assertEquals(BigInteger.valueOf(0), Calculator.eval0("0"));
        assertEquals(BigInteger.valueOf(2), Calculator.eval0("1 + 1"));
        assertEquals(BigInteger.valueOf(4), Calculator.eval0("1 + 2 + 1"));
        assertEquals(BigInteger.valueOf(9), Calculator.eval0("1 + 2 * 3"));
        assertEquals(new Fraction("3/4"), Calculator.eval1("1/2 + 1/4"));
        assertEquals(new Fraction("1/8"), Calculator.eval1("-1/2 ^ 3"));
      } // ends try
    catch (Exception e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
        System.out.println("Incorrent format supplied!");
      }// ends catch
  }// test

}// CalculatorTest
