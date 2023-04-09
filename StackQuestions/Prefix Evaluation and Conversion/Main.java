import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    valueOfExpression(str);
  }

  public static String reverse(String str) {
    String s = "";
    for (int i = 0; i < str.length(); i++) {
      s = str.charAt(i) + s;
    }
    return s;
  }

  public static int eval(int v1, int v2, char o) {
    if (o == '+') {
      return v1 + v2;
    } else if (o == '-') {
      return v1 - v2;
    } else if (o == '*') {
      return v1 * v2;
    } else if (o == '/') {
      return v1 / v2;
    }
    return -1;
  }

  public static void solve(String str) {
    Stack<Character> opr = new Stack<>();
    Stack<Integer> opd = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch) == true) {
        opd.push(ch - '0');
      }
    }
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch) == true) {
        opd.push(ch - '0');
      }
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        opr.push(ch);
        while (opr.size() > 0) {
          char o = opr.pop();
          int v1 = opd.pop();
          int v2 = opd.pop();
          int ans = eval(v1, v2, o);
          opd.push(ans);
        }
      }
    }
    System.out.println(opd.peek());
  }

  public static void convert(String str) {
    Stack<Character> opr = new Stack<>();
    Stack<String> infix = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch) == true) {
        infix.push(ch + "");
      }
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        opr.push(ch);
        while (opr.size() > 0) {
          char o = opr.pop();
          String v1 = infix.pop();
          String v2 = infix.pop();
          String ans = "(" + v1 + o + v2 + ")";
          infix.push(ans);
        }
      }
    }
    System.out.println(infix.peek());
  }

  public static void convert1(String str) {
    Stack<Character> opr = new Stack<>();
    Stack<String> postfix = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isDigit(ch) == true) {
        postfix.push(ch + "");
      }
      if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        opr.push(ch);
        while (opr.size() > 0) {
          char o = opr.pop();
          String v1 = postfix.pop();
          String v2 = postfix.pop();
          String ans = v1 + v2 + o;
          postfix.push(ans);
        }
      }
    }
    System.out.println(postfix.peek());
  }

  public static void valueOfExpression(String str) {
    // your code here
    String str1 = reverse(str);
    solve(str1);
    convert(str1);
    convert1(str1);
  }
}
