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

      String[] index = input.split(" ");
      if (index.length != 3) {
        System.out.println("Invalid expression!!!");
        continue;
      }

      float num1, num2;
      if (index[0].equals("$last")) {
        num1 = lastResult;
      } else {
        num1 = Float.parseFloat(index[0]);
      }
      if (index[2].equals("$last")) {
        num2 = lastResult;
      } else {
        num2 = Float.parseFloat(index[2]);
      }
      char operator = index[1].charAt(0);

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
          System.out.println("Invalid operator!!!");
          continue;
      }

      lastResult = result;
      System.out.println(result);
    }

    scanner.close();
  }
}
