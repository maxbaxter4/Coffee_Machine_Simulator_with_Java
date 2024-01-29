package machine;

public class Latte extends Machine implements Customer{

    @Override
    public void buy(Machine machine) {
        int water = machine.getWater();
        int coffee = machine.getCoffee();
        int milk = machine.getMilk();
        int cups = machine.getCups();
        int money = machine.getMoney();

        if (water >= 350 && milk >= 75 && coffee >= 20) {
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(water - 350);
            machine.setMilk(milk - 75);
            machine.setCoffee(coffee - 20);
            machine.setCups(cups - 1);
            machine.setMoney(money + 7);
        } else if (water < 350) {
            System.out.println("Sorry, not enough water!");
        }else if (milk < 75) {
            System.out.println("Sorry, not enough milk!");
        } else {
            System.out.println("Sorry, not enough coffee!");
        }
    }
}
