package edu.grinnell.zahidmuh17.csc207.assignment4;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtils
{

  public static void main(String[] args)
  {

    System.out.print(Arrays.toString(splitAt("a:", ':')));

  }

  public static String[] splitAt(String stringWithSomeChar, char someChar)
  {

    int tracker = 0;

    ArrayList<String> arrayList = new ArrayList<String>();

    for (int index = 0; index < stringWithSomeChar.length(); index++)
      {

        if (stringWithSomeChar.charAt(index) == someChar)
          {
            arrayList.add(stringWithSomeChar.substring(tracker, index));
            tracker = index + 1;
          }
        else if (index == stringWithSomeChar.length() - 1)
          {
            arrayList.add(stringWithSomeChar.substring(tracker));
          }

      }

    String[] stringArray = new String[arrayList.size()];

    for (int indexArr = 0; indexArr < arrayList.size(); indexArr++)
      {

        stringArray[indexArr] = arrayList.get(indexArr);

      }

    return stringArray;
  }
}
