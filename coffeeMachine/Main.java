package coffeeMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = CoffeeMachine.getInstance();

        CoffeeMachineInvoker invoker = new CoffeeMachineInvoker();

        // User selects Espresso
        invoker.setCommand(new MakeCoffeeCommand(machine, CoffeeType.ESPRESSO));
        invoker.processCommand();

        // User selects Latte
        invoker.setCommand(new MakeCoffeeCommand(machine, CoffeeType.LATTE));
        invoker.processCommand();

        // User selects Cappuccino
        invoker.setCommand(new MakeCoffeeCommand(machine, CoffeeType.CAPPUCCINO));
        invoker.processCommand();
    }
}
