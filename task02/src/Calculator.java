import java.util.Scanner;

public class Calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome.");
    float lastResult = 0;

    while (true) {
      System.out.print("> ");
      String input = scanner.nextLine();

      if (input.equals("exit")) {
        break;
      }

      String[] tokens = input.split(" ");
      if (tokens.length != 3) {
        System.out.println("Error: invalid expression");
        continue;
      }

      float num1, num2;
      if (tokens[0].equals("$last")) {
        num1 = lastResult;
      } else {
        num1 = Float.parseFloat(tokens[0]);
      }
      if (tokens[2].equals("$last")) {
        num2 = lastResult;
      } else {
        num2 = Float.parseFloat(tokens[2]);
      }
      char operator = tokens[1].charAt(0);

      float result = 0;
      switch (operator) {
        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          result = num1 / num2;
          break;
        default:
          System.out.println("Error: invalid operator");
          continue;
      }

      lastResult = result;
      System.out.println(result);
    }

    scanner.close();
  }
}
