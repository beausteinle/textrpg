package textrpg.utils;

import java.util.Arrays;

public class Utils {

  public static String getBorderString(String word) {
    char[] arr = new char[word.length()];
    Arrays.fill(arr, '-');
    return new String(arr);
  }
}
