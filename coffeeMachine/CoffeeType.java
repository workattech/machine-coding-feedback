package coffeeMachine;

enum CoffeeType {
    ESPRESSO(50, 0, 15),
    LATTE(50, 150, 20),
    CAPPUCCINO(50, 100, 20);

    int waterRequired;
    int milkRequired;
    int coffeeBeansRequired;

    CoffeeType(int waterRequired, int milkRequired, int coffeeBeansRequired) {
        this.waterRequired = waterRequired;
        this.milkRequired = milkRequired;
        this.coffeeBeansRequired = coffeeBeansRequired;
    }
}
