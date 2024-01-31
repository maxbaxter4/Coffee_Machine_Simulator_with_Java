package machine;

import java.util.Locale;
import java.util.Scanner;

public class CoffeeMachine {
    private  int water = 400;
    private  int milk = 540;
    private  int coffee = 120;
    private  int cups = 9;
    private  int money = 550;
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        new CoffeeMachine().processing();
    }

    public void processing() {

        String input;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            input = SCANNER.nextLine();
            switch (input.toLowerCase(Locale.ROOT)) {
                case "buy" -> buyCoffee();

                case "fill" -> fillMachine();

                case "remaining" -> print();

                case "take" -> takeMoney();
            }
        } while (!input.equals("exit"));
    }

    private void buyCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int choice = 0;
        try {
            choice = Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }
        switch(choice){
            case 1 -> new Coffee().make("espresso");
            case 2 -> new Coffee().make("latte");
            case 3 -> new Coffee().make("cappuccino");
        }
    }

    private void fillMachine() {
        Worker worker = new Service();
        worker.fill();
    }

    private void takeMoney(){
        Worker worker = new Service();
        worker.collect();
        }
    private void print(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffee);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
    }

    private enum Recipe{
        ESPRESSO(250, 0, 16, 1, 4),
        LATTE(350, 75, 20, 1, 7),
        CAPPUCCINO(200, 100, 12, 1, 6);
        final int water, milk, coffeeBeans, cups, money;

        Recipe(int water, int milk, int coffeeBeans, int cups, int money) {
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.cups = cups;
            this.money = money;
        }

    }
    private class Coffee {
        public void make(String coffeeType) {

            var drink = Recipe.valueOf(coffeeType.toUpperCase());

            if (water >= drink.water
                    && milk >= drink.milk
                    && coffee >= drink.coffeeBeans) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= drink.water;
                milk -= drink.milk;
                coffee -= drink.coffeeBeans;
                cups -= drink.cups;
                money += drink.money;
            } else if (water < drink.water) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < drink.milk) {
                System.out.println("Sorry, not enough milk!");
            }else {
                System.out.println("Sorry, not enough coffee!");
            }
        }
    }

    private class Service implements Worker{
        @Override
        public void collect() {
            money = 0;
        }
        @Override
        public void fill() {
            System.out.println("Write how many ml of water you want to add: ");
            int waterToAdd = Integer.parseInt(SCANNER.nextLine());
            water += waterToAdd;
            System.out.println("Write how many ml of milk you want to add: ");
            int milkToAdd = Integer.parseInt(SCANNER.nextLine());
            milk += milkToAdd;
            System.out.println("Write how many grams of coffee beans you want to add:");
            int coffeeToAdd = Integer.parseInt(SCANNER.nextLine());
            coffee += coffeeToAdd;
            System.out.println("Write how many disposable cups you want to add:");
            int cupsToAdd = Integer.parseInt(SCANNER.nextLine());
            cups += cupsToAdd;
        }
    }
}



