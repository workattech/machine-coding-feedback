package coffeeMachine;

class MakeCoffeeCommand implements CoffeeCommand {
    private CoffeeMachine machine;
    private CoffeeType coffeeType;

    public MakeCoffeeCommand(CoffeeMachine machine, CoffeeType coffeeType) {
        this.machine = machine;
        this.coffeeType = coffeeType;
    }

    @Override
    public void execute() {
        machine.makeCoffee(coffeeType);
    }
}