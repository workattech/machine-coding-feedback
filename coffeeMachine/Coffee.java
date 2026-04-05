package coffeeMachine;

class Coffee {
    private int waterRequired;
    private int milkRequired;
    private int coffeeBeansRequired;

    private Coffee(CoffeeBuilder builder) {
        this.waterRequired = builder.waterRequired;
        this.milkRequired = builder.milkRequired;
        this.coffeeBeansRequired = builder.coffeeBeansRequired;
    }

    public int getWaterRequired() {
        return waterRequired;
    }

    public int getMilkRequired() {
        return milkRequired;
    }

    public int getCoffeeBeansRequired() {
        return coffeeBeansRequired;
    }

    public static class CoffeeBuilder {
        private int waterRequired;
        private int milkRequired;
        private int coffeeBeansRequired;

        public CoffeeBuilder setWaterRequired(int waterRequired) {
            this.waterRequired = waterRequired;
            return this;
        }

        public CoffeeBuilder setMilkRequired(int milkRequired) {
            this.milkRequired = milkRequired;
            return this;
        }

        public CoffeeBuilder setCoffeeBeansRequired(int coffeeBeansRequired) {
            this.coffeeBeansRequired = coffeeBeansRequired;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }
}
