package machine;

import java.util.Scanner;

public class Service implements Worker{
    @Override
    public void collect(Machine machine) {
        machine.setMoney(0);
    }

    @Override
    public void fill(Machine machine) {
        Scanner scanner = new Scanner(System.in);

        int water = machine.getWater();
        int milk = machine.getMilk();
        int coffee = machine.getCoffee();
        int cups = machine.getCups();

        System.out.println("Write how many ml of water you want to add: ");
        int waterToAdd = Integer.parseInt(scanner.nextLine());
        machine.setWater(water + waterToAdd);
        System.out.println("Write how many ml of milk you want to add: ");
        int milkToAdd = Integer.parseInt(scanner.nextLine());
        machine.setMilk(milk + milkToAdd);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeToAdd = Integer.parseInt(scanner.nextLine());
        machine.setCoffee(coffee + coffeeToAdd);
        System.out.println("Write how many disposable cups you want to add:");
        int cupsToAdd = Integer.parseInt(scanner.nextLine());
        machine.setCups(cups + cupsToAdd);

    }
}
