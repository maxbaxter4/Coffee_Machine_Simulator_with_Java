package machine;

public class Espresso extends Machine implements Customer{
    @Override
    public void buy(Machine machine) {

        int water = machine.getWater();
        int coffee = machine.getCoffee();
        int cups = machine.getCups();
        int money = machine.getMoney();

        if (water >= 250 && coffee >= 16) {
            System.out.println("I have enough resources, making you a coffee!");
            machine.setWater(water - 250);
            machine.setCoffee(coffee - 16);
            machine.setCups(cups - 1);
            machine.setMoney(money + 4);
        } else if (water < 250) {
            System.out.println("Sorry, not enough water!");
        } else {
            System.out.println("Sorry, not enough coffee!");
        }

    }
}
