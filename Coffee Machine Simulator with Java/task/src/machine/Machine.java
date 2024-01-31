package machine;

import java.util.Locale;
import java.util.Scanner;

public class Machine {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;
    private final static Scanner SCANNER = new Scanner(System.in);

    public Machine() {
        this.water = Resources.WATER.getValue();
        this.milk = Resources.MILK.getValue();
        this.coffee = Resources.COFFEE.getValue();
        this.cups = Resources.CUPS.getValue();
        this.money = Resources.MONEY.getValue();
    }

    public void processing(String input) {

        switch (input.toLowerCase(Locale.ROOT)) {
            case "buy" -> buyCoffee();

            case "fill" -> fillMachine();

            case "remaining" -> print();

            case "take" -> takeMoney();
        }
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
            case 1 -> buyEspresso();
            case 2 -> buyLatte();
            case 3 -> buyCappuccino();
        }
    }
 
    private void fillMachine() {
    Worker service = new Service();
    service.fill();
    }

    private void takeMoney(){
        Worker service = new Service();
        service.collect();
        }

    private void buyEspresso(){
        Customer customer = new Espresso();
        customer.buy();
  }

    private void buyLatte(){
        Customer customer = new Latte();
        customer.buy();
    }
    private void buyCappuccino(){
        Customer customer = new Cappuccino();
        customer.buy();
    }
    private void print(){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffee);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
    }
    private class Espresso implements Customer{
        @Override
        public void buy() {

            if (water >= 250 && coffee >= 16) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 250;
                coffee -= 16;
                cups -= 1;
                money += 4;
            } else if (water < 250) {
                System.out.println("Sorry, not enough water!");
            } else {
                System.out.println("Sorry, not enough coffee!");
            }

        }
    }
    private class Latte implements Customer{

        @Override
        public void buy() {

            if (water >= 350 && milk >= 75 && coffee >= 20) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 350;
                milk -= 75;
                coffee -= 20;
                cups -= 1;
                money += 7;
            } else if (water < 350) {
                System.out.println("Sorry, not enough water!");
            }else if (milk < 75) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("Sorry, not enough coffee!");
            }
        }
    }
    private class Cappuccino implements Customer{
        @Override
        public void buy() {

            if (water >= 200 && milk >= 100 && coffee >= 12) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= 200;
                milk -= 100;
                coffee -= 12;
                cups -= 1;
                money += 6;
            } else if (water < 200) {
                System.out.println("Sorry, not enough water!");
            }else if (milk < 100) {
                System.out.println("Sorry, not enough milk!");
            } else {
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
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water you want to add: ");
            int waterToAdd = Integer.parseInt(scanner.nextLine());
            water += waterToAdd;
            System.out.println("Write how many ml of milk you want to add: ");
            int milkToAdd = Integer.parseInt(scanner.nextLine());
            milk += milkToAdd;
            System.out.println("Write how many grams of coffee beans you want to add:");
            int coffeeToAdd = Integer.parseInt(scanner.nextLine());
            coffee += coffeeToAdd;
            System.out.println("Write how many disposable cups you want to add:");
            int cupsToAdd = Integer.parseInt(scanner.nextLine());
            cups += cupsToAdd;
        }
    }

}



