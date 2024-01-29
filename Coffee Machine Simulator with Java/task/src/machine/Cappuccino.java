package machine;

public class Cappuccino extends Machine implements Customer{
    @Override
    public void buy(Machine machine) {
        int water = machine.getWater();
        int coffee = machine.getCoffee();
        int milk = machine.getMilk();
        int cups = machine.getCups();
        int money = machine.getMoney();

        if (water >= 200 && milk >= 100 && coffee >= 12) {
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(water - 200);
            machine.setMilk(milk - 100);
            machine.setCoffee(coffee - 12);
            machine.setCups(cups - 1);
            machine.setMoney(money + 6);
        } else if (water < 200) {
            System.out.println("Sorry, not enough water!");
        }else if (milk < 100) {
            System.out.println("Sorry, not enough milk!");
        } else {
            System.out.println("Sorry, not enough coffee!");
        }
    }
}
