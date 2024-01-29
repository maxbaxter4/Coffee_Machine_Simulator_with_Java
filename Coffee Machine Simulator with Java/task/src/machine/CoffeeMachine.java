package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

      //  /Users/maxbaxter/IdeaProjects/Coffee Machine Simulator with Java/Storage.txt
        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine();
        String input;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = scanner.nextLine();
            machine.processing(input);

        } while (!input.equals("exit"));

    }
}
