import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class answer {
  public static void main(String[] args) {
  boolean flag;
  flag = isUniqueChars2("");
  if(flag)
    System.out.println("No duplicate");
  }


public static boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            } else {
                checker |= (1 << val);
                System.out.println(checker);
            }
        }
        return true;
}
}
