package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Machine machine = new Machine(400, 540, 120, 9, 550);
        String input;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = scanner.nextLine();
            machine.processing(input);

        } while (!input.equals("exit"));

    }
}
