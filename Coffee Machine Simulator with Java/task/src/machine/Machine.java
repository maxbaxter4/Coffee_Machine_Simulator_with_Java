package machine;

import java.util.Locale;
import java.util.Scanner;

public class Machine {
    protected int water;
    protected int milk;
    protected int coffee;
    protected int cups;
    protected int money;
    private final static Scanner SCANNER = new Scanner(System.in);

    public Machine() {
        this.water = Resources.WATER.getValue();
        this.milk = Resources.MILK.getValue();
        this.coffee = Resources.COFFEE.getValue();
        this.cups = Resources.CUPS.getValue();
        this.money = Resources.MONEY.getValue();
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getCups() {
        return cups;
    }

    public int getMoney() {
        return money;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    public void processing(String input) {

        switch (input.toLowerCase(Locale.ROOT)) {
            case "buy" -> buyCoffee();

            case "fill" -> fillMachine();

            case "remaining" -> print();

            case "take" -> takeMoney();
        }
    }
    private void print(){

        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", coffee);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);

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
        System.out.println("Write how many ml of water you want to add: ");
        var waterToAdd = Integer.parseInt(SCANNER.nextLine());
        water += waterToAdd;
        System.out.println("Write how many ml of milk you want to add: ");
        var milkToAdd = Integer.parseInt(SCANNER.nextLine());
        milk += milkToAdd;
        System.out.println("Write how many grams of coffee beans you want to add:");
        var coffeeToAdd = Integer.parseInt(SCANNER.nextLine());
        coffee += coffeeToAdd;
        System.out.println("Write how many disposable cups you want to add:");
        var cupsToAdd = Integer.parseInt(SCANNER.nextLine());
        cups += cupsToAdd;
    }

    private void takeMoney(){
        System.out.printf("I gave you $%d\n", money);
        money -= money;
    }

    private void buyEspresso(){

        Customer customer = new Espresso();
        customer.buy(this);
  }

    private void buyLatte(){
        Customer customer = new Latte();
        customer.buy(this);

    }
    private void buyCappuccino(){
        Customer customer = new Cappuccino();
        customer.buy(this);

    }

}



