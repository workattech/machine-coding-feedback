package coffeeMachine;

class CoffeeFactory {
    public static Coffee createCoffee(CoffeeType coffeeType) {
        return new Coffee.CoffeeBuilder()
                .setWaterRequired(coffeeType.waterRequired)
                .setMilkRequired(coffeeType.milkRequired)
                .setCoffeeBeansRequired(coffeeType.coffeeBeansRequired)
                .build();
    }
}
