import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome.");
    float prevOutput = 0;

    while (true) {
      System.out.print("> ");
      String input = sc.nextLine();

      if (input.equals("exit")) {
        break;
      }

      String[] index = input.split(" ");
      if (index.length != 3) {
        System.out.println("Please input in this format e.g: a + b");
        continue;
      }

      float a, b;
      if (index[0].equals("$last")) {
        a = prevOutput;
      } else {
        a = Float.parseFloat(index[0]);
      }
      if (index[2].equals("$last")) {
        b = prevOutput;
      } else {
        b = Float.parseFloat(index[2]);
      }
      char operator = index[1].charAt(0);

      float output = 0;

      if (operator == '+') {
        output = a + b;
      }
      else if (operator == '-') {
        output = a - b;
      }
      else if (operator == '*') {
        output = a * b;
      }
      else if (operator == '/') {
        output = a / b;
      }
      else {
        System.out.println("Check operator!!!");
      }
      prevOutput = output;
      System.out.println(output);
    }

    sc.close();
  }
}
