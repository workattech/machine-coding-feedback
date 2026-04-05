package coffeeMachine;

class CoffeeMachine {
    private static CoffeeMachine instance;

    private int water = 1000;
    private int milk = 500;
    private int coffeeBeans = 200;

    private MachineState currentState;

    private CoffeeMachine() {
        this.currentState = new ReadyState();
    }

    public static CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    public void setState(MachineState state) {
        this.currentState = state;
    }

    public void processState() {
        currentState.handleRequest(this);
    }

    public boolean hasEnoughIngredients(Coffee coffee) {
        return water >= coffee.getWaterRequired() &&
                milk >= coffee.getMilkRequired() &&
                coffeeBeans >= coffee.getCoffeeBeansRequired();
    }

    public void makeCoffee(CoffeeType coffeeType) {
        Coffee coffee = CoffeeFactory.createCoffee(coffeeType);
        if (hasEnoughIngredients(coffee)) {
            setState(new BrewingState());
            processState();
            water -= coffee.getWaterRequired();
            milk -= coffee.getMilkRequired();
            coffeeBeans -= coffee.getCoffeeBeansRequired();
            System.out.println("Your " + coffeeType.name() + " is ready!");
            setState(new ReadyState());
        } else {
            setState(new OutOfStockState());
            processState();
        }
    }
}
