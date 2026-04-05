package coffeeMachine;

class OutOfStockState implements MachineState {
    @Override
    public void handleRequest(CoffeeMachine machine) {
        System.out.println("Machine is out of stock. Please refill ingredients.");
    }
}